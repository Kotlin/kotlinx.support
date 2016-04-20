package kotlinx.support.jdk7.test

import kotlinx.support.jdk7.getSuppressed
import java.io.*
import org.junit.Test
import kotlin.test.*

import kotlinx.support.jdk7.use


class Resource(val faultyClose: Boolean = false) : Closeable {

    override fun close() {
        if (faultyClose)
            throw IOException("Close failed")
    }
}

class TryWithResourcesTest {
    @Test fun success() {
        val result = Resource().use { "ok" }
        assertEquals("ok", result)
    }

    @Test fun closeFails() {
        val e = assertFails {
            Resource(faultyClose = true).use { "" }
        }
        assertTrue(e is IOException)
    }

    @Test fun opFailsCloseSuccess() {
        val e = assertFails {
            Resource().use { error("op fail") }
        }
        assertTrue(e is IllegalStateException)
        assertTrue(e.getSuppressed().isEmpty())
    }

    @Test fun opFailsCloseFails() {
        val e = assertFails {
            Resource(faultyClose = true).use { error("op fail") }
        }
        assertTrue(e is IllegalStateException)
        assertTrue(e.getSuppressed().single() is IOException)
    }

    @Test fun opFailsCloseFailsTwice() {
        val e = assertFails {
            Resource(faultyClose = true).use { res1 ->
                Resource(faultyClose = true).use { res2 ->
                    error("op fail")
                }
            }
        }
        assertTrue(e is IllegalStateException)
        val suppressed = e.getSuppressed()
        assertEquals(2, suppressed.size)
        assertTrue(suppressed.all { it is IOException })
    }

}