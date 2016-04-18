package kotlinx.support.jdk7

/**
 * Executes the given [block] function on this resource and then closes it down correctly whether an exception
 * is thrown or not.
 *
 * @param block a function to process this closable resource.
 * @return the result of [block] function on this closable resource.
 */
public inline fun <T : AutoCloseable, R> T.use(block: (T) -> R): R {
    val result = try {
        block(this)
    } catch (e: Throwable) {
        @Suppress("NON_PUBLIC_CALL_FROM_PUBLIC_INLINE")
        closeSuppressed(e)
        throw e
    }
    close()
    return result
}

/**
 * Closes this [AutoCloseable] suppressing possible exception or error thrown by [AutoCloseable.close] function.
 * The suppressed exception is added to the list of suppressed exceptions of [cause] exception.
 */
internal fun AutoCloseable.closeSuppressed(cause: Throwable) {
    try {
        close()
    } catch (closeException: Throwable) {
        cause.addSuppressed(closeException)
    }
}

/*
// seems to have marginal use cases
public fun AutoCloseable.closeQuietly(): Throwable? {
    return try {
        close()
        null
    }
    catch (e: Throwable) {
        e
    }
}
*/
