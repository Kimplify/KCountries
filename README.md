# KCountries

A lightweight, high-performance Kotlin Multiplatform library providing ISO 3166-1 country data with native names and multilingual support across Android, iOS, JVM, JavaScript and WebAssembly.

## Features

- **249 Countries**: Complete ISO 3166-1 dataset with codes, names, and flags
- **Rich Metadata**: Continent, region, calling code, currency, and timezone for every country
- **Native Names**: Authentic country names in local scripts (日本, Россия, مصر, etc.)
- **14 Languages**: Optional i18n module with ES, FR, DE, AR, ZH, RU, JA, PT, HI, KO, IT, TR, ID
- **User-Friendly Names**: Display names without formal ISO formatting
- **Type-Safe API**: Inline value classes for codes (zero runtime overhead)
- **Multiple Access Patterns**: Repository, DSL queries, and extension functions
- **Platform Support**: Android, iOS, JVM, JS, WASM
- **Minimal Size**: ~50KB core + ~100KB i18n (optional)
- **Fast Performance**: O(1) hash-indexed lookups

## Installation

```kotlin
dependencies {
    implementation("org.kimplify:countries-core:0.1.1")

    // Optional: Multilingual support (14 languages)
    implementation("org.kimplify:countries-i18n:0.1.1")
}
```

## Usage

### Repository Pattern

```kotlin
// Get all countries
val allCountries = Countries.repository.getAll()

// Find by code
val usa = Countries.repository.findByAlpha2(Alpha2Code("US"))
val uk = Countries.repository.findByAlpha3(Alpha3Code("GBR"))
val france = Countries.repository.findByNumeric(NumericCode("250"))

// Search by name (searches across display, native, and formal names)
val results = Countries.repository.searchByName("United")
```

### DSL Query Builder

```kotlin
// Single filter
val usa = Countries.repository.query {
    alpha2("US")
}.firstOrNull()

// Name search
val unitedCountries = Countries.repository.query {
    nameContains("United")
}.toList()

// OR logic
val northAmericans = Countries.repository.query {
    or {
        alpha2("US")
        alpha2("CA")
        alpha2("MX")
    }
}.toList()

// Filter by continent, region, calling code, currency, timezone
val europeanCountries = Countries.repository.query {
    continent(Continent.EUROPE)
}.toList()

val westernEurope = Countries.repository.query {
    region(Region.WESTERN_EUROPE)
}.toList()

// NOT logic
val nonEuropean = Countries.repository.query {
    not { continent(Continent.EUROPE) }
}.toList()

// Iterate directly (CountriesQueryResult implements Iterable)
for (country in Countries.repository.query { currency("EUR") }) {
    println("${country.getDisplayName()} uses EUR")
}
```

### Extension Functions

```kotlin
// Convert code to country
val usa = "US".toCountry()
val france = "FRA".toCountry()
val germany = "276".toCountry()

// Get properties
val flag = "US".flagEmoji            // "🇺🇸"
val displayName = "US".displayCountryName  // "United States"
val nativeName = "JP".nativeCountryName   // "日本"

// Convert between formats
val alpha3 = "US".toAlpha3  // "USA"
val alpha2 = "USA".toAlpha2  // "US"

// Access metadata via toCountry()
val country = "US".toCountry()!!
val code = country.callingCode    // CallingCode("+1")
val curr = country.currency       // CurrencyCode("USD")
val cont = country.continent      // Continent.NORTH_AMERICA
val reg = country.region           // Region.NORTHERN_AMERICA
val tz = country.timezone          // TimezoneId("America/New_York")
```

## Data Model

### Country

```kotlin
data class Country(
    val alpha2: Alpha2Code,        // ISO 3166-1 alpha-2 (e.g., "US")
    val alpha3: Alpha3Code,        // ISO 3166-1 alpha-3 (e.g., "USA")
    val numeric: NumericCode,      // ISO 3166-1 numeric (e.g., "840")
    val name: CountryName,         // Formal ISO name (e.g., "United States of America (the)")
    val flag: FlagEmoji,           // Flag emoji (e.g., "🇺🇸")
    val displayName: String?,      // User-friendly name (e.g., "United States")
    val native: String?,           // Native language name (e.g., "日本")
    val continent: Continent,      // Geographic continent (e.g., NORTH_AMERICA)
    val region: Region,            // UN geoscheme region (e.g., NORTHERN_AMERICA)
    val callingCode: CallingCode,  // E.164 calling code (e.g., "+1")
    val currency: CurrencyCode,    // ISO 4217 currency (e.g., "USD")
    val timezone: TimezoneId       // IANA timezone (e.g., "America/New_York")
)
```

```kotlin
// Extension functions for easy access
country.getDisplayName()  // Returns displayName or falls back to name
country.getNativeName()   // Returns native or falls back to displayName/name
```

### Value Classes (Type-Safe Wrappers)

All codes are wrapped in inline value classes for type safety with zero runtime overhead:

- `Alpha2Code`: 2-letter country code
- `Alpha3Code`: 3-letter country code
- `NumericCode`: 3-digit country code
- `CountryName`: Country name string
- `FlagEmoji`: Flag emoji (validated via Unicode codepoints)
- `CallingCode`: E.164 calling code (e.g., "+1", "+44")
- `CurrencyCode`: ISO 4217 currency code (e.g., "USD", "EUR")
- `TimezoneId`: IANA timezone identifier (e.g., "America/New_York")

### Enums

- `Continent`: 7 continents (AFRICA, ANTARCTICA, ASIA, EUROPE, NORTH_AMERICA, OCEANIA, SOUTH_AMERICA)
- `Region`: 23 UN geoscheme regions (CARIBBEAN, EASTERN_EUROPE, SOUTHEASTERN_ASIA, etc.)

## API Reference

### Countries Singleton

```kotlin
object Countries {
    val repository: CountriesRepository  // Main data access point
    val VERSION: String                  // Library version (auto-generated from catalog)
    const val TOTAL_COUNTRIES: Int       // Total countries (249)
}
```

### CountriesRepository Interface

```kotlin
interface CountriesRepository {
    fun getAll(): List<Country>
    fun findByAlpha2(code: Alpha2Code): Country?
    fun findByAlpha3(code: Alpha3Code): Country?
    fun findByNumeric(code: NumericCode): Country?
    fun searchByName(query: String): List<Country>
    fun getByContinent(continent: Continent): List<Country>
    fun getByRegion(region: Region): List<Country>
    fun getByCallingCode(callingCode: CallingCode): List<Country>
    fun getByCurrency(currencyCode: CurrencyCode): List<Country>
    fun query(block: CountriesQuery.() -> Unit): CountriesQueryResult
}
```

### DSL Query Builder

```kotlin
@CountriesDsl
class CountriesQuery {
    fun alpha2(code: String)
    fun alpha3(code: String)
    fun numeric(code: String)
    fun nameContains(text: String)
    fun nameEquals(name: String)
    fun nameStartsWith(prefix: String)
    fun continent(continent: Continent)
    fun region(region: Region)
    fun callingCode(code: String)
    fun currency(code: String)
    fun timezone(id: String)
    fun or(block: CountriesQuery.() -> Unit)
    fun not(block: CountriesQuery.() -> Unit)
}

class CountriesQueryResult : Iterable<Country> {
    fun firstOrNull(): Country?
    fun first(): Country
    fun toList(): List<Country>
    fun count(): Int
    fun isEmpty(): Boolean
    fun isNotEmpty(): Boolean
}
```

## Performance

- **Core library**: ~80KB (249 countries with native names + metadata)
- **I18n module**: ~100KB (13 languages × 249 translations)
- **Initialization**: <10ms (lazy)
- **Lookups**: O(1) hash-indexed, <1ms
- **Translations**: O(1) map lookup

## Architecture

Country data is embedded as Kotlin code for maximum performance:
- **Instant access**: No parsing, no I/O
- **Type-safe**: Compile-time validation
- **Multiplatform**: Single implementation for all targets
- **Offline-first**: No network dependencies

### Platform Support

Single implementation works on all platforms:
- ✅ Android (SDK 24+)
- ✅ iOS (arm64, simulator)
- ✅ JVM Desktop
- ✅ JavaScript (Browser)
- ✅ WebAssembly

No platform-specific code needed!

## Versioning

Semantic versioning: `MAJOR.MINOR.PATCH`
- **Current**: 0.1.1
- **Data updates**: MINOR bump
- **API changes**: MAJOR bump

## Internationalization (countries-i18n)

Optional module providing country name translations in 13 languages (+ English fallback).

```kotlin
val country = Countries.repository.findByAlpha2(Alpha2Code("JP"))!!

country.getLocalizedName(Locale.EN)  // "Japan"
country.getLocalizedName(Locale.ES)  // "Japón"
country.getLocalizedName(Locale.FR)  // "Japon"
country.getLocalizedName(Locale.DE)  // "Japan"
country.getLocalizedName(Locale.AR)  // "اليابان"
country.getLocalizedName(Locale.ZH)  // "日本"
country.getLocalizedName(Locale.RU)  // "Япония"
country.getLocalizedName(Locale.JA)  // "日本"
country.getLocalizedName(Locale.PT)  // "Japão"
country.getLocalizedName(Locale.KO)  // "일본"
country.getLocalizedName(Locale.IT)  // "Giappone"
country.getLocalizedName(Locale.TR)  // "Japonya"
country.getLocalizedName(Locale.HI)  // "जापान"
country.getLocalizedName(Locale.ID)  // "Jepang"

// Locale strings are normalized automatically
country.getLocalizedName("es-MX")  // "Japón" (extracts "es")
country.getLocalizedName("PT_BR")  // "Japão" (extracts "pt")
```

**Supported Languages:**
- English (en), Spanish (es), French (fr), German (de), Italian (it)
- Arabic (ar) with RTL support, Turkish (tr), Indonesian (id)
- Chinese (zh), Japanese (ja), Korean (ko), Hindi (hi)
- Russian (ru), Portuguese (pt)

See [countries-i18n/README.md](countries-i18n/README.md) for full documentation.

## License

[Add your license here]

## Contributing

[Add contribution guidelines]

## Data Source

- **Standard**: ISO 3166-1:2020
- **Total Entries**: 249 territories
- **Includes**: 193 UN member states + 56 dependencies/special areas
- **Metadata Sources**: UN M49 (regions), ITU-T E.164 (calling codes), ISO 4217 (currencies), IANA (timezones)
- **Last Updated**: 2025-01-26
