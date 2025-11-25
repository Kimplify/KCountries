package org.kimplify.countries.model

/**
 * Represents a country with ISO 3166-1 compliant codes and basic metadata.
 *
 * All country data follows the ISO 3166-1 standard for country codes and names.
 *
 * @property alpha2 ISO 3166-1 alpha-2 country code (2 letters).
 * @property alpha3 ISO 3166-1 alpha-3 country code (3 letters).
 * @property numeric ISO 3166-1 numeric country code (3 digits).
 * @property name Country name in English.
 * @property flag Country flag emoji (Unicode regional indicator symbols).
 */
data class Country(
    val alpha2: Alpha2Code,
    val alpha3: Alpha3Code,
    val numeric: NumericCode,
    val name: CountryName,
    val flag: FlagEmoji,
)
