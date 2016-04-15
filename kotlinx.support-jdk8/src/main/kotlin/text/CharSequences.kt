@file:Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN", "NOTHING_TO_INLINE")
package kotlinx.support.jdk8.text

import java.util.stream.IntStream

/**
 * Returns an [IntStream] of UTF-16 character code values from this sequence.
 * Surrogate pairs are represented as pair of consecutive chars.
 */
inline fun CharSequence.chars(): IntStream = (this as java.lang.CharSequence).chars()

/**
 * Returns an [IntStream] of UTF code point values from this sequence.
 */
inline fun CharSequence.codePoints(): IntStream = (this as java.lang.CharSequence).codePoints()