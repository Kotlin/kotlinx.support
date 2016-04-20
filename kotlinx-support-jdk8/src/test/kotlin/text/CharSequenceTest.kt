package kotlinx.support.jdk8.text.test

import kotlinx.support.jdk8.text.*
import org.junit.Test
import java.util.stream.Collectors
import kotlin.test.*

class CharSequenceTest {
    @Test fun chars() {
        val string = "test"

        val chars = string.chars().boxed().collect(Collectors.mapping({ it.toChar()}, Collectors.toList<Char>()))

        assertEquals(string.toList(), chars)
    }


    @Test fun codePoints() {
        val dth54 = "\uD83C\uDC58" // domino tile horizontal 5-4
        val dth55 = "\uD83C\uDC59" // domino tile horizontal 5-5

        val seq = "$dth54$dth55" as CharSequence

        val codePoints = seq.codePoints().toArray()
        assertEquals(listOf(0x1F058, 0x1F059), codePoints.toList())
    }
}