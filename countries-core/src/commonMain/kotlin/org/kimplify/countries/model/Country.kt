package org.kimplify.countries.model

/**
 * Represents a country with ISO 3166-1 compliant codes and basic metadata.
 *
 * All country data follows the ISO 3166-1 standard for country codes and names.
 *
 * @property alpha2 ISO 3166-1 alpha-2 country code (2 letters).
 * @property alpha3 ISO 3166-1 alpha-3 country code (3 letters).
 * @property numeric ISO 3166-1 numeric country code (3 digits).
 * @property name Formal ISO 3166-1 English name.
 * @property flag Country flag emoji (Unicode regional indicator symbols).
 * @property displayName Optional user-friendly English name (e.g., "United States" instead of "United States of America (the)").
 * @property native Optional native language name (e.g., "Deutschland" for Germany, "日本" for Japan).
 */
data class Country(
    val alpha2: Alpha2Code,
    val alpha3: Alpha3Code,
    val numeric: NumericCode,
    val name: CountryName,
    val flag: FlagEmoji,
    val displayName: String? = null,
    val native: String? = null
)
