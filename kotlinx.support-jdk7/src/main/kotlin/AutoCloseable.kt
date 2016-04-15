package kotlinx.support.jdk7


public inline fun <T : AutoCloseable, R> T.use(block: (T) -> R): R {
    var cause: Exception? = null
    try {
        return block(this)
    } catch (e: Exception) {
        cause = e
        throw e
    } finally {
        @Suppress("NON_PUBLIC_CALL_FROM_PUBLIC_INLINE")
        closeQuietly(cause)
    }
}

internal fun AutoCloseable.closeQuietly(cause: Exception?) {
    try {
        close()
    } catch (closeException: Exception) {
        if (cause != null) {
            cause.addSuppressed(closeException)
        }
        else {
            throw closeException
        }
    }
}

