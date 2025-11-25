package org.kimplify.countries.extensions

import org.kimplify.countries.Countries
import org.kimplify.countries.model.*

/**
 * Extension functions for convenient country lookups using strings.
 */

/**
 * Converts a country code string to a Country object.
 *
 * Automatically detects the code type based on length and format:
 * - 2 characters: Alpha-2 code (e.g., "US", "GB", "FR")
 * - 3 characters (digits): Numeric code (e.g., "840", "826", "250")
 * - 3 characters (letters): Alpha-3 code (e.g., "USA", "GBR", "FRA")
 *
 * The lookup is case-insensitive for letter codes.
 *
 * Example:
 * ```
 * val usa = "US".toCountry()
 * val uk = "GBR".toCountry()
 * val france = "250".toCountry()
 * ```
 *
 * @receiver The country code string.
 * @return The matching Country, or null if not found or invalid format.
 */
fun String.toCountry(): Country? {
    return when (length) {
        2 -> Countries.repository.findByAlpha2(Alpha2Code(this.uppercase()))
        3 -> when {
            all { it.isDigit() } -> Countries.repository.findByNumeric(NumericCode(this))
            else -> Countries.repository.findByAlpha3(Alpha3Code(this.uppercase()))
        }
        else -> null
    }
}

/**
 * Gets the flag emoji for a country code.
 *
 * Example:
 * ```
 * val flag = "US".flagEmoji  // Returns "🇺🇸"
 * ```
 *
 * @receiver The country code string (alpha-2, alpha-3, or numeric).
 * @return The flag emoji string, or null if country not found.
 */
val String.flagEmoji: String?
    get() = toCountry()?.flag?.value

/**
 * Gets the country name for a country code.
 *
 * Example:
 * ```
 * val name = "US".countryName  // Returns "United States of America (the)"
 * ```
 *
 * @receiver The country code string (alpha-2, alpha-3, or numeric).
 * @return The country name, or null if country not found.
 */
val String.countryName: String?
    get() = toCountry()?.name?.value

/**
 * Gets the alpha-2 code for any country code format.
 *
 * Example:
 * ```
 * val code = "USA".toAlpha2  // Returns "US"
 * val code = "840".toAlpha2  // Returns "US"
 * ```
 *
 * @receiver The country code string (alpha-2, alpha-3, or numeric).
 * @return The alpha-2 code, or null if country not found.
 */
val String.toAlpha2: String?
    get() = toCountry()?.alpha2?.value

/**
 * Gets the alpha-3 code for any country code format.
 *
 * Example:
 * ```
 * val code = "US".toAlpha3  // Returns "USA"
 * val code = "840".toAlpha3  // Returns "USA"
 * ```
 *
 * @receiver The country code string (alpha-2, alpha-3, or numeric).
 * @return The alpha-3 code, or null if country not found.
 */
val String.toAlpha3: String?
    get() = toCountry()?.alpha3?.value
