@file:Suppress("NOTHING_TO_INLINE")
package kotlinx.support.jdk7

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStream
import java.io.OutputStream
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets
import java.nio.file.*
import java.nio.file.attribute.FileTime
import java.nio.file.attribute.UserPrincipal
import java.util.*
import java.util.stream.Collectors

/** Converts a path string to a [Path]. */
inline fun String.toPath() = Paths.get(this)

/**
 * The following extensions implement syntactic sugar for path
 * construction.
 *
 * For example
 *
 *     root.resolve("foo").resolve("bar")
 *
 * can be constructed as
 *
 *     root / "foo" / "bar"
 */
operator fun Path.div(other: String) = div(other.toPath())
operator fun Path.div(other: Path) = resolve(other)
operator fun String.div(other: String) = div(other.toPath())
operator fun String.div(other: Path) = toPath() / other

/** Returns `false` if a file exists and `true` otherwise. */
val Path.notExists: Boolean get() = Files.notExists(this)

/** Returns `true` if a file exists and `false` otherwise. */
val Path.exists: Boolean get() = Files.exists(this)

/** Tests whether a file can be read. */
val Path.isReadable: Boolean get() = Files.isReadable(this)

/** Tests whether a file can be written to. */
val Path.isWritable: Boolean get() = Files.isWritable(this)

/** Tests whether a file can be executed. */
val Path.isExecutable: Boolean get() = Files.isExecutable(this)

/** Tests whether a path points to a directory. */
val Path.isDirectory: Boolean get() = Files.isDirectory(this)

/** Tests whether a path is a regular file. */
val Path.isRegularFile: Boolean get() = Files.isRegularFile(this)

/** Tests whether a path is a symbolic link. */
val Path.isSymbolicLink: Boolean get() = Files.isSymbolicLink(this)

/**
 * File size in bytes.
 */
val Path.size: Long get() = Files.size(this)

/**
 * Timestamp of the last modification.
 */
var Path.lastModifiedTime: FileTime
    get() = Files.getLastModifiedTime(this)
    set(value: FileTime) = ignore(Files.setLastModifiedTime(this, value))

/**
 * Owner of this path.
 */
var Path.owner: UserPrincipal
    get() = Files.getOwner(this)
    set(value: UserPrincipal) = ignore(Files.setOwner(this, value))

/**
 * Returns a list of entries from the directory corresponding to this path.
 *
 * Note that the return type is intentionally different from
 * [Files.list]. Wrapping each [list] call in a try-finally block is
 * too much of a burden.
 */
fun Path.list(): List<Path> {
    val s = Files.list(this)
    try {
        return s.collect(Collectors.toList<Path>())
    } finally {
        s.close()
    }
}

/** Walks a file tree starting from this path. */
fun Path.walkFileTree(walker: FileVisitor<Path>,
                      options: Set<FileVisitOption> = EnumSet.noneOf(FileVisitOption::class.java),
                      maxDepth: Int = Integer.MAX_VALUE) {
    Files.walkFileTree(this, options, maxDepth, walker)
}

/**
 * Opens this path for reading.
 *
 * See [Files.bufferedReader] for complete documentation.
 */
fun Path.bufferedReader(charset: Charset = StandardCharsets.UTF_8): BufferedReader {
    return Files.newBufferedReader(this, charset)
}

/**
 * Opens this path for writing.
 *
 * See [Files.bufferedWriter] for complete documentation.
 */
fun Path.bufferedWriter(charset: Charset = StandardCharsets.UTF_8,
                        vararg options: OpenOption): BufferedWriter {
    return Files.newBufferedWriter(this, charset, *options)
}

/**
 * Copies all bytes from this stream to a given path.
 *
 * See [Files.copy] for complete documentation.
 */
fun InputStream.copy(target: Path, vararg options: StandardCopyOption) {
    Files.copy(this, target, *options)
}

/**
 * Copies all bytes from a file to an output stream.
 *
 * See [Files.copy] for complete documentation.
 */
fun Path.copy(outputStream: OutputStream) = Files.copy(this, outputStream)

/**
 * Moves or renames a path to a [target] path.
 *
 * See [Files.move] for complete documentation.
 */
fun Path.move(target: Path, vararg options: StandardCopyOption): Path {
    return Files.move(this, target, *options)
}

/**
 * Copies a path to a [target] path.
 *
 * See [Files.copy] for complete documentation.
 */
fun Path.copy(target: Path, vararg options: StandardCopyOption): Path {
    return Files.copy(this, target, *options)
}

/** A function which simply ignores a given [_value]. */
@Suppress("UNUSED_PARAMETER")
private inline fun ignore(_value: Any?) {}