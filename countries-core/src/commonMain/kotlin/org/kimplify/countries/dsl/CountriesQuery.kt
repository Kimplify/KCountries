package org.kimplify.countries.dsl

import org.kimplify.countries.model.*
import org.kimplify.countries.repository.CountriesRepository

/**
 * DSL builder for querying countries with a fluent, declarative syntax.
 *
 * Supports multiple filter predicates that can be combined with AND logic by default.
 * Use the `or { }` block to combine predicates with OR logic.
 *
 * Example:
 * ```
 * // Find countries by alpha-2 code
 * val result = Countries.repository.query {
 *     alpha2("US")
 * }
 *
 * // Search by name
 * val result = Countries.repository.query {
 *     nameContains("United")
 * }
 *
 * // Combine with OR logic
 * val result = Countries.repository.query {
 *     alpha2("US")
 *     or {
 *         alpha2("GB")
 *         alpha2("FR")
 *     }
 * }
 * ```
 *
 * @property repository The repository to query against.
 */
class CountriesQuery internal constructor(
    private val repository: CountriesRepository
) {
    private val predicates = mutableListOf<(Country) -> Boolean>()

    /**
     * Filters countries by alpha-2 code (case-insensitive).
     *
     * Example:
     * ```
     * query {
     *     alpha2("US")  // or alpha2("us")
     * }
     * ```
     *
     * @param code The 2-letter country code.
     */
    fun alpha2(code: String) {
        val normalized = code.uppercase()
        predicates.add { it.alpha2.value == normalized }
    }

    /**
     * Filters countries by alpha-3 code (case-insensitive).
     *
     * Example:
     * ```
     * query {
     *     alpha3("USA")  // or alpha3("usa")
     * }
     * ```
     *
     * @param code The 3-letter country code.
     */
    fun alpha3(code: String) {
        val normalized = code.uppercase()
        predicates.add { it.alpha3.value == normalized }
    }

    /**
     * Filters countries by numeric code.
     *
     * Example:
     * ```
     * query {
     *     numeric("840")
     * }
     * ```
     *
     * @param code The 3-digit country code.
     */
    fun numeric(code: String) {
        predicates.add { it.numeric.value == code }
    }

    /**
     * Filters countries whose name contains the given text (case-insensitive).
     *
     * Example:
     * ```
     * query {
     *     nameContains("United")  // Matches "United States", "United Kingdom", etc.
     * }
     * ```
     *
     * @param text The text to search for in country names.
     */
    fun nameContains(text: String) {
        val normalized = text.lowercase()
        predicates.add { it.name.value.lowercase().contains(normalized) }
    }

    /**
     * Filters countries whose name exactly matches the given text (case-insensitive).
     *
     * Example:
     * ```
     * query {
     *     nameEquals("France")
     * }
     * ```
     *
     * @param name The exact country name to match.
     */
    fun nameEquals(name: String) {
        val normalized = name.lowercase()
        predicates.add { it.name.value.lowercase() == normalized }
    }

    /**
     * Filters countries whose name starts with the given text (case-insensitive).
     *
     * Example:
     * ```
     * query {
     *     nameStartsWith("United")  // Matches "United States", "United Kingdom"
     * }
     * ```
     *
     * @param prefix The prefix to match at the start of country names.
     */
    fun nameStartsWith(prefix: String) {
        val normalized = prefix.lowercase()
        predicates.add { it.name.value.lowercase().startsWith(normalized) }
    }

    /**
     * Combines multiple predicates with OR logic.
     *
     * Countries matching any of the predicates in the OR block will be included.
     *
     * Example:
     * ```
     * query {
     *     or {
     *         alpha2("US")
     *         alpha2("GB")
     *         alpha2("FR")
     *     }
     * }
     * ```
     *
     * @param block The DSL block containing predicates to combine with OR.
     */
    fun or(block: CountriesQuery.() -> Unit) {
        val subQuery = CountriesQuery(repository).apply(block)
        predicates.add { country ->
            subQuery.predicates.any { predicate -> predicate(country) }
        }
    }

    /**
     * Executes the query and returns the result.
     *
     * @return The query result containing matching countries.
     */
    internal fun execute(): CountriesQueryResult {
        val filtered = repository.getAll().filter { country ->
            predicates.all { it(country) }
        }
        return CountriesQueryResult(filtered)
    }
}

/**
 * Result of a country query operation.
 *
 * Provides various methods to access the matching countries.
 *
 * @property countries The list of countries matching the query.
 */
class CountriesQueryResult internal constructor(
    private val countries: List<Country>
) {
    /**
     * Returns the first matching country, or null if no matches.
     *
     * Example:
     * ```
     * val country = Countries.repository.query {
     *     alpha2("US")
     * }.firstOrNull()
     * ```
     *
     * @return The first matching country, or null.
     */
    fun firstOrNull(): Country? = countries.firstOrNull()

    /**
     * Returns the first matching country, or throws NoSuchElementException.
     *
     * Example:
     * ```
     * val country = Countries.repository.query {
     *     alpha2("US")
     * }.first()
     * ```
     *
     * @return The first matching country.
     * @throws NoSuchElementException if no countries match.
     */
    fun first(): Country = countries.first()

    /**
     * Returns all matching countries as a list.
     *
     * Example:
     * ```
     * val allMatches = Countries.repository.query {
     *     nameContains("United")
     * }.toList()
     * ```
     *
     * @return List of all matching countries.
     */
    fun toList(): List<Country> = countries

    /**
     * Returns the count of matching countries.
     *
     * Example:
     * ```
     * val count = Countries.repository.query {
     *     nameContains("United")
     * }.count()
     * ```
     *
     * @return The number of matching countries.
     */
    fun count(): Int = countries.size

    /**
     * Returns true if the query matched any countries.
     *
     * Example:
     * ```
     * val hasMatches = Countries.repository.query {
     *     nameContains("Atlantis")
     * }.isNotEmpty()
     * ```
     *
     * @return True if at least one country matched.
     */
    fun isNotEmpty(): Boolean = countries.isNotEmpty()

    /**
     * Returns true if the query matched no countries.
     *
     * Example:
     * ```
     * val noMatches = Countries.repository.query {
     *     nameContains("Atlantis")
     * }.isEmpty()
     * ```
     *
     * @return True if no countries matched.
     */
    fun isEmpty(): Boolean = countries.isEmpty()
}
