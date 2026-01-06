# KCountries

A lightweight, high-performance Kotlin Multiplatform library providing ISO 3166-1 country data with native names and multilingual support across Android, iOS, JVM, JavaScript and WebAssembly.

## Features

- **249 Countries**: Complete ISO 3166-1 dataset with codes, names, and flags
- **Native Names**: Authentic country names in local scripts (日本, Россия, مصر, etc.)
- **7 Languages**: Optional i18n module with Spanish, French, German, Arabic, Chinese, Russian
- **User-Friendly Names**: Display names without formal ISO formatting
- **Type-Safe API**: Inline value classes for codes (zero runtime overhead)
- **Multiple Access Patterns**: Repository, DSL queries, and extension functions
- **Platform Support**: Android, iOS, JVM, JS, WASM
- **Minimal Size**: ~50KB core + ~50KB i18n (optional)
- **Fast Performance**: O(1) hash-indexed lookups

## Installation

```kotlin
dependencies {
    implementation("org.kimplify:countries-core:0.1.0")

    // Optional: Multilingual support
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

// Count results
val count = Countries.repository.query {
    nameStartsWith("United")
}.count()
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
    val displayName: String? = null,  // User-friendly name (e.g., "United States")
    val native: String? = null        // Native language name (e.g., "日本")
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
- `FlagEmoji`: Flag emoji string

## API Reference

### Countries Singleton

```kotlin
object Countries {
    val repository: CountriesRepository  // Main data access point
    const val VERSION: String            // Library version
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
    fun query(block: CountriesQuery.() -> Unit): CountriesQueryResult
}
```

### DSL Query Builder

```kotlin
class CountriesQuery {
    fun alpha2(code: String)
    fun alpha3(code: String)
    fun numeric(code: String)
    fun nameContains(text: String)
    fun nameEquals(name: String)
    fun nameStartsWith(prefix: String)
    fun or(block: CountriesQuery.() -> Unit)
}

class CountriesQueryResult {
    fun firstOrNull(): Country?
    fun first(): Country
    fun toList(): List<Country>
    fun count(): Int
    fun isEmpty(): Boolean
    fun isNotEmpty(): Boolean
}
```

## Performance

- **Core library**: ~50KB (249 countries with native names)
- **I18n module**: ~50KB (6 languages × 250 translations)
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
- **Current**: 1.0.0
- **Data updates**: MINOR bump (e.g., 1.1.0)
- **API changes**: MAJOR bump (e.g., 2.0.0)

## Internationalization (countries-i18n)

Optional module providing country name translations in 6 languages.

```kotlin
val country = Countries.repository.findByAlpha2(Alpha2Code("JP"))!!

country.getLocalizedName(Locale.EN)  // "Japan"
country.getLocalizedName(Locale.ES)  // "Japón"
country.getLocalizedName(Locale.FR)  // "Japon"
country.getLocalizedName(Locale.DE)  // "Japan"
country.getLocalizedName(Locale.AR)  // "اليابان"
country.getLocalizedName(Locale.ZH)  // "日本"
country.getLocalizedName(Locale.RU)  // "Япония"
```

**Supported Languages:**
- English (en), Spanish (es), French (fr), German (de)
- Arabic (ar) with RTL support
- Chinese (zh), Russian (ru)

See [countries-i18n/README.md](countries-i18n/README.md) for full documentation.

## License

[Add your license here]

## Contributing

[Add contribution guidelines]

## Data Source

- **Standard**: ISO 3166-1:2020
- **Total Entries**: 249 territories
- **Includes**: 193 UN member states + 56 dependencies/special areas
- **Last Updated**: 2025-01-26
