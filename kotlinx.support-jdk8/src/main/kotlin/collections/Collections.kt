@file:Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN", "UNCHECKED_CAST", "NOTHING_TO_INLINE")
package kotlinx.support.jdk8.collections

import java.util.*
import java.util.function.*
import java.util.stream.Stream


//	forEach (Ljava/util/function/Consumer<-TT;>;)V

/**
 * Performs the given action for each element of the [Iterable].
 */
public inline fun <T> Iterable<T>.forEach(action: Consumer<in T>): Unit
        = (this as java.lang.Iterable<T>).forEach(action)

//  do not provide overload with function as we have inline Iterable.forEach implementation.



//  spliterator ()Ljava/util/Spliterator<TT;>;

/**
 * Creates a [Spliterator] over the elements described by this [Iterable].
 */
public inline fun <T> Iterable<T>.spliterator(): Spliterator<T>
        = (this as java.lang.Iterable<T>).spliterator()



//  forEachRemaining (Ljava/util/function/Consumer<-TE;>;)V

/**
 * Performs the given action for each remaining element returned by this [Iterator].
 */
public inline fun <T> Iterator<T>.forEachRemaining(action: Consumer<in T>): Unit
        = (this as java.util.Iterator<T>).forEachRemaining(action)

//  do not provide overload with function as we may provide inline implementation, like Iterable.forEach

///**
// * Performs the given action for each remaining element returned by this [Iterator].
// */
//public inline fun <T> Iterator<T>.forEachRemaining(crossinline action: (T) -> Unit): Unit
//        = (this as java.util.Iterator<T>).forEachRemaining { action(it) }








//  removeIf (Ljava/util/function/Predicate<-TE;>;)Z

/**
 * Removes all of the elements of this collection that satisfy the given [filter] predicate.
 */
public inline fun <T> MutableCollection<T>.removeIf(filter: Predicate<in T>): Boolean
        = (this as java.util.Collection<T>).removeIf(filter)

/**
 * Removes all of the elements of this collection that satisfy the given [filter] predicate.
 */
public inline fun <T> MutableCollection<T>.removeIf(crossinline filter: (T) -> Boolean): Boolean
        = (this as java.util.Collection<T>).removeIf { filter(it) }



//  stream ()Ljava/util/stream/Stream<TE;>;
/**
 * Returns a sequential [Stream] with this collection as its source.
 */
public inline fun <T> Collection<T>.stream(): Stream<T>
        = (this as java.util.Collection<T>).stream()



//  parallelStream ()Ljava/util/stream/Stream<TE;>;
/**
 * Returns a possibly parallel [Stream] with this collection as its source.
 */
public inline fun <T> Collection<T>.parallelStream(): Stream<T>
        = (this as java.util.Collection<T>).parallelStream()








//  replaceAll (Ljava/util/function/UnaryOperator<TE;>;)V

/**
 * Replaces each element of this list with the result of applying the
 * [operator] to that element.
 */
public inline fun <T> MutableList<T>.replaceAll(operator: UnaryOperator<T>): Unit
        = (this as java.util.List<T>).replaceAll(operator)

/**
 * Replaces each element of this list with the result of applying the
 * [operator] to that element.
 */
public inline fun <T> MutableList<T>.replaceAll(crossinline operator: (T) -> T): Unit
        = (this as java.util.List<T>).replaceAll { operator(it) }



//  sort (Ljava/util/Comparator<-TE;>;)V
//  ?
// public inline fun <T> MutableList<T>.sort(comparator: Comparator<in T>) = (this as java.util.List<T>).sort(comparator)







//  getOrDefault (Ljava/lang/Object;TV;)TV;

/**
 * Returns the value to which the specified key is mapped, or
 * [defaultValue] if this map contains no mapping for the key.
 */
@Suppress("INVISIBLE_REFERENCE", "INVISIBLE_MEMBER")
public inline fun <@kotlin.internal.OnlyInputTypes K, V> Map<out K, V>.getOrDefault(key: K, defaultValue: V): V
        = (this as java.util.Map<K, V>).getOrDefault(key, defaultValue)



//  forEach (Ljava/util/function/BiConsumer<-TK;-TV;>;)V
/**
 * Performs the given [action] for each entry in this map.
 */
public inline fun <K, V> Map<K, V>.forEach(action: BiConsumer<in K, in V>): Unit
        = (this as java.util.Map<K, V>).forEach(action)

// ?
/**
 * Performs the given [action] for each entry in this map.
 */
public inline fun <K, V> Map<K, V>.forEach(crossinline action: (K, V) -> Unit): Unit
        = (this as java.util.Map<K, V>).forEach { k, v -> action(k, v)}



//  replaceAll (Ljava/util/function/BiFunction<-TK;-TV;+TV;>;)V

/**
 * Replaces each entry's value with the result of invoking the given
 * [function] on that entry.
 */
public inline fun <K, V> MutableMap<K, V>.replaceAll(function: BiFunction<in K, in V, out V>): Unit
        = (this as java.util.Map<K, V>).replaceAll(function)

/**
 * Replaces each entry's value with the result of invoking the given
 * [function] on that entry.
 */
public inline fun <K, V> MutableMap<K, V>.replaceAll(crossinline function: (K, V) -> V): Unit
        = (this as java.util.Map<K, V>).replaceAll { k, v -> function(k, v) }



//  putIfAbsent (TK;TV;)TV;

/**
 * If the specified key is not already associated with a value (or is mapped
 * to `null`) associates it with the given value and returns
 * `null`, else returns the current value.
 */
public inline fun <K, V> MutableMap<K, V>.putIfAbsent(key: K, value: V): V?
        = (this as java.util.Map<K, V>).putIfAbsent(key, value)



//  remove (Ljava/lang/Object;Ljava/lang/Object;)Z

/**
 * Removes the entry for the specified key only if it is currently
 * mapped to the specified value.
 */
@Suppress("INVISIBLE_REFERENCE", "INVISIBLE_MEMBER")
public inline fun <@kotlin.internal.OnlyInputTypes K, @kotlin.internal.OnlyInputTypes V> MutableMap<out K, out V>.remove(key: K, value: V): Boolean
        = (this as java.util.Map<K, V>).remove(key, value)



//  replace (TK;TV;TV;)Z
//  ? out K

/**
 * Replaces the entry for the specified key only if currently
 * mapped to the specified value.
 */
public inline fun <K, V> MutableMap<K, V>.replace(key: K, oldValue: V, newValue: V): Boolean
        = (this as java.util.Map<K, V>).replace(key, oldValue, newValue)



//  replace (TK;TV;)TV;

/**
 * Replaces the entry for the specified key only if it is
 * currently mapped to some value.
 */
public inline fun <K, V> MutableMap<K, V>.replace(key: K, value: V): V?
        = (this as java.util.Map<K, V>).replace(key, value)



//  computeIfAbsent (TK;Ljava/util/function/Function<-TK;+TV;>;)TV;

/**
 * If the specified key is not already associated with a value (or is mapped
 * to `null`), attempts to compute its value using the given mapping
 * function and enters it into this map unless `null`.
 */
public inline fun <K, V> MutableMap<K, V>.computeIfAbsent(key: K, mappingFunction: java.util.function.Function<in K, out V?>): V?
        = (this as java.util.Map<K, V>).computeIfAbsent(key, mappingFunction)

/**
 * If the specified key is not already associated with a value (or is mapped
 * to `null`), attempts to compute its value using the given mapping
 * function and enters it into this map unless `null`.
 */
public inline fun <K, V> MutableMap<K, V>.computeIfAbsent(key: K, crossinline mappingFunction: (K) -> V?): V?
        = (this as java.util.Map<K, V>).computeIfAbsent(key, java.util.function.Function { mappingFunction(it) })



//  computeIfPresent (TK;Ljava/util/function/BiFunction<-TK;-TV;+TV;>;)TV;
/**
 * If the value for the specified key is present and non-null, attempts to
 * compute a new mapping given the key and its current mapped value.
 */
public inline fun <K, V> MutableMap<K, V>.computeIfPresent(key: K, remappingFunction: BiFunction<in K, in V, out V?>): V?
        = (this as java.util.Map<K, V>).computeIfPresent(key, remappingFunction)

/**
 * If the value for the specified key is present and non-null, attempts to
 * compute a new mapping given the key and its current mapped value.
 */
public inline fun <K, V> MutableMap<K, V>.computeIfPresent(key: K, crossinline remappingFunction: (K, V) -> V?): V?
        = (this as java.util.Map<K, V>).computeIfPresent(key, BiFunction { k, v -> remappingFunction(k, v)})



//  compute (TK;Ljava/util/function/BiFunction<-TK;-TV;+TV;>;)TV;
/**
 * Attempts to compute a mapping for the specified key and its current
 * mapped value (or `null` if there is no current mapping).
 */
public inline fun <K, V> MutableMap<K, V>.compute(key: K, remappingFunction: BiFunction<in K, in V?, out V?>): V?
        = (this as java.util.Map<K, V>).compute(key, remappingFunction)

/**
 * Attempts to compute a mapping for the specified key and its current
 * mapped value (or `null` if there is no current mapping).
 */
public inline fun <K, V> MutableMap<K, V>.compute(key: K, crossinline remappingFunction: (K, V?) -> V?): V?
        = (this as java.util.Map<K, V>).compute(key, BiFunction { k, v -> remappingFunction(k, v) })


//  merge (TK;TV;Ljava/util/function/BiFunction<-TV;-TV;+TV;>;)TV;
//  ? value parameter and oldValue, newValue in remappingFunction must be V!! (non-null subtype of any V)
/**
 * If the specified key is not already associated with a value or is
 * associated with `null`, associates it with the given non-null value.
 * Otherwise, replaces the associated value with the results of the given
 * remapping function, or removes if the result is `null`. This
 * method may be of use when combining multiple mapped values for a key.
 */
public inline fun <K, V> MutableMap<K, V>.merge(key: K, value: V, remappingFunction: BiFunction<in V, in V, out V?>): V?
        = (this as java.util.Map<K, V>).merge(key, value, remappingFunction)

/**
 * If the specified key is not already associated with a value or is
 * associated with `null`, associates it with the given non-null value.
 * Otherwise, replaces the associated value with the results of the given
 * remapping function, or removes if the result is `null`. This
 * method may be of use when combining multiple mapped values for a key.
 */
public inline fun <K, V> MutableMap<K, V>.merge(key: K, value: V, crossinline remappingFunction: (V, V) -> V?): V?
        = (this as java.util.Map<K, V>).merge(key, value, BiFunction { oldValue, newValue -> remappingFunction(oldValue, newValue) })



