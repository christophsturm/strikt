package strikt.assertions

import strikt.api.Assertion.Builder
import strikt.internal.reporting.formatValue

/**
 * Asserts that the subject map is empty.
 */
fun <T : Map<K, V>, K, V> Builder<T>.isEmpty() =
  passesIf("is empty") { it.isEmpty() }

/**
 * Maps this assertion to an assertion on the value indexed by [key] in the
 * subject list.
 *
 * @return An assertion on the value indexed by [key] or `null` if no such entry
 * exists in the subject map.
 */
operator fun <T : Map<K, V>, K, V> Builder<T>.get(key: K): Builder<V?> =
  map("entry [${formatValue(key)}]") { it[key] }

/**
 * Asserts that the subject map contains an entry indexed by [key]. Depending on
 * the map implementation the value associated with [key] may be `null`. This
 * assertion just tests for the existence of the key.
 */
fun <T : Map<K, V>, K, V> Builder<T>.containsKey(key: K): Builder<T> =
  passesIf("has an entry with the key %s", key) {
    it.containsKey(key)
  }

/**
 * Asserts that the subject map contains entries for all [keys].
 */
fun <T : Map<K, V>, K, V> Builder<T>.containsKeys(vararg keys: K): Builder<T> =
  compose("has entries with the keys %s", keys.toList()) {
    keys.forEach { containsKey(it) }
  } then {
    if (allPassed) pass() else fail()
  }

/**
 * Asserts that the subject map contains an entry indexed by [key] with a value
 * equal to [value].
 */
fun <T : Map<K, V>, K, V> Builder<T>.hasEntry(
  key: K,
  value: V
): Builder<T> =
  apply { containsKey(key)[key].isEqualTo(value) }
