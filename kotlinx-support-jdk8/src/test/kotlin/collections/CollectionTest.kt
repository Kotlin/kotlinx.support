package kotlinx.support.jdk8.collections.test

import kotlinx.support.jdk8.collections.*
import kotlinx.support.jdk8.text.*
import org.junit.Test
import kotlin.test.*
import java.util.function.Predicate
import java.util.stream.Collectors
import java.util.stream.Stream

class CollectionTest {

    val data = listOf("abc", "fo", "baar")

    fun <T> Stream<T>.toList(): List<T> = collect(Collectors.toList<T>())

    @Test fun stream() {
        assertEquals(
                data.flatMap { it.asIterable() },
                data.stream()
                        .flatMap { it.chars().boxed().map { it.toChar() } }
                        .collect(Collectors.toList()))

        assertEquals(data, data.parallelStream().toList())
    }


    @Test fun removeIf() {
        val coll: MutableCollection<String> = data.toMutableList()
        assertTrue(coll.removeIf { it.length < 3 })
        assertEquals(listOf("abc", "baar"), coll as Collection<String>)
        assertFalse(coll.removeIf(Predicate { it.length > 4 }))
    }


}