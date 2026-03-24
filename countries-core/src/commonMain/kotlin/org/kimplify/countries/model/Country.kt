package org.kimplify.countries.model

/**
 * Represents a country according to the ISO 3166-1 standard.
 *
 * @property alpha2 ISO 3166-1 alpha-2 code (e.g., "US")
 * @property alpha3 ISO 3166-1 alpha-3 code (e.g., "USA")
 * @property numeric ISO 3166-1 numeric code (e.g., "840")
 * @property name Official ISO English name
 * @property flag Unicode flag emoji
 * @property displayName Optional common/short English name
 * @property native Optional native language name
 * @property continent Geographic continent
 * @property region UN geoscheme region
 * @property callingCode International calling code (E.164)
 * @property currency Primary currency code (ISO 4217)
 * @property timezone Primary IANA timezone identifier
 */
data class Country(
    val alpha2: Alpha2Code,
    val alpha3: Alpha3Code,
    val numeric: NumericCode,
    val name: CountryName,
    val flag: FlagEmoji,
    val displayName: String? = null,
    val native: String? = null,
    val continent: Continent,
    val region: Region,
    val callingCode: CallingCode,
    val currency: CurrencyCode,
    val timezone: TimezoneId
)
