package kotlinx.support.jdk7

import org.junit.Test
import kotlin.test.assertEquals

class PathDivTest {
    @Test fun pathString() {
        assertEquals("foo/bar".toPath(), "foo".toPath() / "bar")
    }

    @Test fun pathPath() {
        assertEquals("foo/bar".toPath(), "foo".toPath() / "bar".toPath())
    }

    @Test fun stringString() {
        assertEquals("foo/bar".toPath(), "foo" / "bar")
    }

    @Test fun stringPath() {
        assertEquals("foo/bar".toPath(), "foo" / "bar".toPath())
    }
}