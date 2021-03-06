package strikt.api

/**
 * The basic state of an assertion result.
 */
internal sealed class Status {
  /**
   * The assertion was not evaluated or has not been evaluated yet.
   */
  object Pending : Status()

  /**
   * The assertion passed.
   */
  object Passed : Status()

  /**
   * The assertion failed.
   */
  data class Failed(
    val actual: Any? = null,
    val description: String? = null,
    val cause: Throwable? = null
  ) : Status() {
    fun describe(formatter: (Any?) -> Any?): String? =
      when (actual) {
        null -> description
        else -> description?.format(formatter(actual))
      }
  }
}
