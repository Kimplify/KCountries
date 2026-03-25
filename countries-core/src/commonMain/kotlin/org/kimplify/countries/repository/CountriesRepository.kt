package org.kimplify.countries.repository

import org.kimplify.countries.dsl.CountriesQuery
import org.kimplify.countries.dsl.CountriesQueryResult
import org.kimplify.countries.model.*
import org.kimplify.countries.model.CallingCode
import org.kimplify.countries.model.Continent
import org.kimplify.countries.model.CurrencyCode
import org.kimplify.countries.model.Region

/**
 * Repository for accessing country data with efficient indexed lookups.
 *
 * Provides multiple ways to query countries:
 * - By ISO codes (alpha-2, alpha-3, numeric)
 * - By name search (case-insensitive partial matching)
 * - Using DSL query builder for complex filtering
 */
interface CountriesRepository {
    /**
     * Returns all countries in the repository.
     *
     * @return List of all 249 countries from ISO 3166-1.
     */
    fun getAll(): List<Country>

    /**
     * Finds a country by its ISO 3166-1 alpha-2 code.
     *
     * @param code The 2-letter country code (e.g., Alpha2Code("US")).
     * @return The matching country, or null if not found.
     */
    fun findByAlpha2(code: Alpha2Code): Country?

    /**
     * Finds a country by its ISO 3166-1 alpha-3 code.
     *
     * @param code The 3-letter country code (e.g., Alpha3Code("USA")).
     * @return The matching country, or null if not found.
     */
    fun findByAlpha3(code: Alpha3Code): Country?

    /**
     * Finds a country by its ISO 3166-1 numeric code.
     *
     * @param code The 3-digit country code (e.g., NumericCode("840")).
     * @return The matching country, or null if not found.
     */
    fun findByNumeric(code: NumericCode): Country?

    /**
     * Searches countries by name using case-insensitive partial matching.
     *
     * Searches across formal ISO name, user-friendly display name, and native name.
     *
     * @param query The search query string.
     * @return List of countries whose names contain the query string.
     */
    fun searchByName(query: String): List<Country>

    /**
     * Returns all countries on the given continent.
     *
     * @param continent The continent to filter by.
     * @return List of countries on the continent.
     */
    fun getByContinent(continent: Continent): List<Country>

    /**
     * Returns all countries in the given region.
     *
     * @param region The region to filter by.
     * @return List of countries in the region.
     */
    fun getByRegion(region: Region): List<Country>

    /**
     * Returns all countries with the given international calling code.
     *
     * @param callingCode The calling code to filter by (e.g., CallingCode("+1")).
     * @return List of countries with that calling code.
     */
    fun getByCallingCode(callingCode: CallingCode): List<Country>

    /**
     * Returns all countries that use the given currency.
     *
     * @param currencyCode The ISO 4217 currency code to filter by.
     * @return List of countries using that currency.
     */
    fun getByCurrency(currencyCode: CurrencyCode): List<Country>

    /**
     * Creates a DSL query builder for complex filtering.
     *
     * Example:
     * ```
     * repository.query {
     *     alpha2("US")
     *     or {
     *         nameContains("United")
     *     }
     * }
     * ```
     *
     * @param block The DSL builder block.
     * @return Query result that can be executed.
     */
    fun query(block: CountriesQuery.() -> Unit): CountriesQueryResult
}

/**
 * Default in-memory implementation of CountriesRepository with hash-indexed lookups.
 *
 * Provides O(1) lookups by code using lazy-initialized hash maps.
 *
 * @property countries The list of countries to index and query.
 */
internal class InMemoryCountriesRepository(
    private val countries: List<Country>
) : CountriesRepository {

    private val alpha2Index: Map<Alpha2Code, Country> by lazy {
        countries.associateBy { it.alpha2 }
    }

    private val alpha3Index: Map<Alpha3Code, Country> by lazy {
        countries.associateBy { it.alpha3 }
    }

    private val numericIndex: Map<NumericCode, Country> by lazy {
        countries.associateBy { it.numeric }
    }

    private val continentIndex: Map<Continent, List<Country>> by lazy { countries.groupBy { it.continent } }
    private val regionIndex: Map<Region, List<Country>> by lazy { countries.groupBy { it.region } }
    private val callingCodeIndex: Map<CallingCode, List<Country>> by lazy { countries.groupBy { it.callingCode } }
    private val currencyIndex: Map<CurrencyCode, List<Country>> by lazy { countries.groupBy { it.currency } }

    override fun getAll(): List<Country> = countries

    override fun findByAlpha2(code: Alpha2Code): Country? =
        alpha2Index[code]

    override fun findByAlpha3(code: Alpha3Code): Country? =
        alpha3Index[code]

    override fun findByNumeric(code: NumericCode): Country? =
        numericIndex[code]

    override fun getByContinent(continent: Continent) = continentIndex[continent] ?: emptyList()
    override fun getByRegion(region: Region) = regionIndex[region] ?: emptyList()
    override fun getByCallingCode(callingCode: CallingCode) = callingCodeIndex[callingCode] ?: emptyList()
    override fun getByCurrency(currencyCode: CurrencyCode) = currencyIndex[currencyCode] ?: emptyList()

    override fun searchByName(query: String): List<Country> {
        if (query.isBlank()) return emptyList()

        val normalizedQuery = query.trim().lowercase()
        return countries.filter { country ->
            country.name.value.lowercase().contains(normalizedQuery) ||
            country.displayName?.lowercase()?.contains(normalizedQuery) == true ||
            country.native?.lowercase()?.contains(normalizedQuery) == true
        }
    }

    override fun query(block: CountriesQuery.() -> Unit): CountriesQueryResult {
        return CountriesQuery(this).apply(block).execute()
    }
}
