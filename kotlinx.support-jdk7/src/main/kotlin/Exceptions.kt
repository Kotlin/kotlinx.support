@file:Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN", "NOTHING_TO_INLINE")
package kotlinx.support.jdk7

/**
 * Appends the specified exception to the exceptions that were
 * suppressed in order to deliver this exception.
 */
public inline fun Throwable.addSuppressed(exception: Throwable) = (this as java.lang.Throwable).addSuppressed(exception)


/**
 * Returns an array containing all of the exceptions that were suppressed.
 */
public inline fun Throwable.getSuppressed(): Array<Throwable> = (this as java.lang.Throwable).getSuppressed()