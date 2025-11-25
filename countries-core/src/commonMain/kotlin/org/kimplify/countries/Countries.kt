package org.kimplify.countries

import org.kimplify.countries.data.CountriesData
import org.kimplify.countries.repository.CountriesRepository
import org.kimplify.countries.repository.InMemoryCountriesRepository

/**
 * Main entry point for the Countries library.
 *
 * Provides access to the default countries repository and library metadata.
 *
 * Example usage:
 * ```
 * // Get all countries
 * val allCountries = Countries.repository.getAll()
 *
 * // Find by code
 * val usa = Countries.repository.findByAlpha2(Alpha2Code("US"))
 *
 * // Search by name
 * val results = Countries.repository.searchByName("United")
 *
 * // DSL query
 * val country = Countries.repository.query {
 *     alpha2("GB")
 * }.firstOrNull()
 * ```
 */
object Countries {
    /**
     * Default repository instance providing access to all 249 countries.
     *
     * Lazy-initialized on first access for optimal startup performance.
     */
    val repository: CountriesRepository by lazy {
        InMemoryCountriesRepository(CountriesData.countries)
    }

    /**
     * Library version following semantic versioning (MAJOR.MINOR.PATCH).
     */
    const val VERSION = "1.0.0"

    /**
     * Total number of countries in the ISO 3166-1 dataset.
     */
    const val TOTAL_COUNTRIES = 249
}
