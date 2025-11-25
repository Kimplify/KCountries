# Countries-Core

A lightweight, high-performance Kotlin Multiplatform library providing ISO 3166-1 country data for Android, iOS, JVM Desktop, JavaScript, and WebAssembly platforms.

## Features

- **249 Countries**: Complete ISO 3166-1 dataset
- **Type-Safe API**: Inline value classes for codes (zero runtime overhead)
- **Multiple Access Patterns**: Repository pattern, DSL queries, and extension functions
- **Platform Support**: Android, iOS, JVM, JS, WASM
- **Minimal Size**: ~25KB embedded data
- **Fast Performance**: O(1) hash-indexed lookups, <10ms initialization

## Installation

Add the dependency to your `commonMain` source set:

```kotlin
kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project(":countries-core"))
        }
    }
}
```

## Usage

### Repository Pattern (Simple)

```kotlin
import org.kimplify.countries.Countries
import org.kimplify.countries.model.*

// Get all countries
val allCountries: List<Country> = Countries.repository.getAll()

// Find by alpha-2 code
val usa: Country? = Countries.repository.findByAlpha2(Alpha2Code("US"))

// Find by alpha-3 code
val uk: Country? = Countries.repository.findByAlpha3(Alpha3Code("GBR"))

// Find by numeric code
val france: Country? = Countries.repository.findByNumeric(NumericCode("250"))

// Search by name
val results: List<Country> = Countries.repository.searchByName("United")
```

### DSL Query Builder (Powerful)

```kotlin
import org.kimplify.countries.Countries

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

// Complex queries
val results = Countries.repository.query {
    nameStartsWith("United")
}.count()
```

### Extension Functions (Convenient)

```kotlin
import org.kimplify.countries.extensions.*

// Convert code to country
val usa = "US".toCountry()
val france = "FRA".toCountry()
val germany = "276".toCountry()

// Get properties directly
val flag = "US".flagEmoji  // "🇺🇸"
val name = "GB".countryName  // "United Kingdom of Great Britain and Northern Ireland (the)"

// Convert between code formats
val alpha3 = "US".toAlpha3  // "USA"
val alpha2 = "USA".toAlpha2  // "US"
```

## Data Model

### Country

```kotlin
data class Country(
    val alpha2: Alpha2Code,     // ISO 3166-1 alpha-2 (e.g., "US")
    val alpha3: Alpha3Code,     // ISO 3166-1 alpha-3 (e.g., "USA")
    val numeric: NumericCode,   // ISO 3166-1 numeric (e.g., "840")
    val name: CountryName,      // English name (e.g., "United States of America (the)")
    val flag: FlagEmoji,        // Flag emoji (e.g., "🇺🇸")
)
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

- **Memory footprint**: <50KB
- **Initialization**: <10ms (lazy)
- **Lookups by code**: <1ms (O(1) hash index)
- **Search by name**: <1ms (linear scan over 249 countries)
- **Binary size**: ~25KB increase

## Architecture

### Embedded Data Strategy

Country data is embedded as Kotlin code (not JSON/resources) for:
- **Best performance**: Instant access, no parsing
- **Smallest size**: ~25KB for 249 countries
- **Platform consistency**: Works identically on all 5 targets
- **Type safety**: Compile-time validation
- **No I/O**: No file loading or resource handling

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

## Future Extensions

The core library is designed to be extended by optional modules:

```kotlin
// Future: countries-i18n module
fun Country.localizedName(locale: Locale): String
val Country.nativeName: String

// Future: countries-phone module
val Country.dialCode: String
fun Country.formatPhoneNumber(number: String): String

// Future: countries-subdivisions module
val Country.subdivisions: List<Subdivision>
```

Core API remains stable across all extensions.

## License

[Add your license here]

## Contributing

[Add contribution guidelines]

## Data Source

- **Standard**: ISO 3166-1:2020
- **Total Entries**: 249 territories
- **Includes**: 193 UN member states + 56 dependencies/special areas
- **Last Updated**: 2025-01-26
