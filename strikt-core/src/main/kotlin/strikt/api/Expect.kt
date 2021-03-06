package strikt.api

import strikt.api.Assertion.Builder
import strikt.assertions.throws
import strikt.internal.AssertionBuilder
import strikt.internal.AssertionSubject
import strikt.internal.Mode.COLLECT
import strikt.internal.Mode.FAIL_FAST

/**
 * Start a chain of assertions over [subject].
 * This is the entry-point for the assertion API.
 *
 * @param subject the subject of the chain of assertions.
 * @return an assertion for [subject].
 */
fun <T> expect(subject: T): DescribeableBuilder<T> =
  AssertionBuilder(AssertionSubject(subject), FAIL_FAST)

/**
 * Evaluate a block of assertions over [subject].
 * This is the entry-point for the assertion API.
 *
 * @param subject the subject of the block of assertions.
 * @param block a closure that can perform multiple assertions that will all
 * be evaluated regardless of whether preceding ones pass or fail.
 * @return an assertion for [subject].
 */
fun <T> expect(
  subject: T,
  block: Builder<T>.() -> Unit
): DescribeableBuilder<T> =
  AssertionSubject(subject).let { context ->
    AssertionBuilder(context, COLLECT)
      .apply {
        block()
        context.toError()?.let { throw it }
      }
  }

/**
 * Asserts that [action] throws an exception of type [E] when executed.
 *
 * @return an assertion over the thrown exception, allowing further assertions
 * about messages, root causes, etc.
 */
inline fun <reified E : Throwable> throws(
  noinline action: () -> Unit
): Builder<E> =
  expect(action).throws()
