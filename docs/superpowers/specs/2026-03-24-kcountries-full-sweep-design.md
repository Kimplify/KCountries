# KCountries Full Sweep — Design Spec

**Date:** 2026-03-24
**Approach:** Fix → Extend → Polish (4 sprints)

---

## Sprint 1: Critical Bug Fixes & Stability

> Goal: Get the foundation solid — working CI, correct data, proper validation.

### 1.1 — Fix CI workflows (`build.yml` and `publish.yml`)

- Replace all `:deci:*` Gradle task references in `build.yml` with correct module paths:
  - `:countries-core:jvmTest`, `:countries-core:iosSimulatorArm64Test`, `:countries-core:jsTest`, `:countries-core:wasmJsTest`
  - `:countries-i18n:jvmTest`, `:countries-i18n:iosSimulatorArm64Test`, `:countries-i18n:jsTest`, `:countries-i18n:wasmJsTest`
- Standardize on `actions/checkout@v6` in **both** `build.yml` and `publish.yml` (both currently use v5)
- Fix artifact upload paths to reference the correct module build directories

### 1.2 — Build-generated `Countries.VERSION`

- Add a Gradle task in `countries-core/build.gradle.kts` that reads the version from `libs.versions.toml`
- Generate a `BuildKConfig.kt` (or similar) source file containing `const val VERSION`
- Remove the hardcoded `const val VERSION = "1.0.0"` from `Countries.kt`
- The generated file should be added to the `commonMain` source set so it's available on all platforms

### 1.3 — Fix `FlagEmoji` validation

- Use the already-declared `kotlin-codepoints` dependency to validate flag emojis properly
- Validate that the value consists of exactly 2 Unicode regional indicator codepoints (U+1F1E6..U+1F1FF)
- This rejects `"ABCD"` (4 ASCII chars, length=4) while accepting real flag emojis like `"🇺🇸"` (2 surrogate pairs, length=4)

### 1.4 — Fix Kosovo translation inconsistency

- Remove `"XK"` entries from all 6 translation maps (ES, FR, DE, AR, ZH, RU)
- Kosovo (XK) is a user-assigned code, not official ISO 3166-1 — translations should match the dataset

### 1.5 — Fix country data inaccuracies

| Country | Field | Current | Fixed |
|---------|-------|---------|-------|
| Turkey | `name` | `"Turkey"` | `"Türkiye"` |
| Turkey | `displayName` | not set | `"Türkiye"` |
| Belgium | `native` | `"Belgien"` | `"België / Belgique"` |
| Peru | `native` | `"Piruw"` | `"Perú"` |

### 1.6 — Fix `compileSdk` and `minSdk` mismatch

- Change `countries-core/build.gradle.kts` and `countries-i18n/build.gradle.kts` to use `libs.versions.android.compileSdk` (36) instead of hardcoded `35`
- Change both modules to use `libs.versions.android.minSdk` (24) instead of hardcoded `21`, matching the version catalog and sample app

### 1.7 — Verify `kotlin-codepoints` is used after 1.3

- After 1.3, the dependency should be actively used for `FlagEmoji` validation
- Verify the import is present and the dependency is not dead weight
- If for any reason it's not wired up, remove it from `build.gradle.kts`

### 1.8 — Fix `Locale` annotation inconsistency

- Change `@kotlin.jvm.JvmInline` in `Locale.kt` to use the import form `@JvmInline`, consistent with `CountryCodes.kt`

---

## Sprint 2: Extend the Country Model

> Goal: Add region, calling code, currency, and timezone data to every country.

### 2.1 — Add new value types

Create new value/enum types in `countries-core`:

```kotlin
enum class Continent {
    AFRICA, ANTARCTICA, ASIA, EUROPE, NORTH_AMERICA, OCEANIA, SOUTH_AMERICA
}

enum class Region {
    // ~22 values following UN geoscheme
    CARIBBEAN, CENTRAL_AMERICA, CENTRAL_ASIA, EASTERN_AFRICA, EASTERN_ASIA,
    EASTERN_EUROPE, MELANESIA, MICRONESIA, MIDDLE_AFRICA, NORTHERN_AFRICA,
    NORTHERN_AMERICA, NORTHERN_EUROPE, POLYNESIA, SOUTH_AMERICA, SOUTHEASTERN_ASIA,
    SOUTHERN_AFRICA, SOUTHERN_ASIA, SOUTHERN_EUROPE, WESTERN_AFRICA, WESTERN_ASIA,
    WESTERN_EUROPE, AUSTRALIA_AND_NEW_ZEALAND, ANTARCTICA
}

@JvmInline
value class CallingCode(val value: String) {
    init { require(value.matches(PATTERN)) { "Calling code must be '+' followed by 1-4 digits (base E.164 code, e.g. \"+1\")" } }
    companion object {
        private val PATTERN = Regex("^\\+\\d{1,4}$")
    }
}

@JvmInline
value class CurrencyCode(val value: String) {
    init { require(value.matches(PATTERN)) { "Currency code must be 3 uppercase letters (ISO 4217)" } }
    companion object {
        private val PATTERN = Regex("^[A-Z]{3}$")
    }
}

@JvmInline
value class TimezoneId(val value: String) {
    init { require(value.contains("/") || value == "UTC") { "Timezone must be IANA format (e.g. \"America/New_York\") or \"UTC\"" } }
}
```

### 2.2 — Extend `Country` data class

Add new fields to the `Country` data class. Update KDoc with `@property` entries for all new fields.

**Breaking change note:** This adds 5 non-optional fields, which is a binary-breaking change for consumers constructing `Country` directly. Acceptable at version 0.x — document in release notes.

```kotlin
data class Country(
    val alpha2: Alpha2Code,
    val alpha3: Alpha3Code,
    val numeric: NumericCode,
    val name: CountryName,
    val flag: FlagEmoji,
    val displayName: String? = null,
    val native: String? = null,
    // New fields:
    val continent: Continent,
    val region: Region,
    val callingCode: CallingCode,
    val currency: CurrencyCode,
    val timezone: TimezoneId
)
```

### 2.3 — Populate `CountriesData` with new fields

- Update all 249 country entries in `CountriesData.kt` with correct continent, region, calling code, currency, and primary timezone data
- Data sources: ISO 4217 (currencies), ITU-T E.164 (calling codes), UN M49 (regions), IANA (timezones)
- **Note:** This is the largest single task (~1,245 data points). Work by continent for manageable chunks and cross-reference against authoritative sources.
- Calling codes use the base E.164 country code with `+` prefix (e.g., `"+1"` for US/Canada, not `"+1-684"` for territories)

### 2.4 — Add repository query support for new fields

Add to `CountriesRepository` interface:

```kotlin
fun getByContinent(continent: Continent): List<Country>
fun getByRegion(region: Region): List<Country>
fun getByCallingCode(callingCode: CallingCode): List<Country>
fun getByCurrency(currencyCode: CurrencyCode): List<Country>
```

Add lazy index maps in `InMemoryCountriesRepository` (which is `internal`) for O(1) lookups. This follows the same pattern as existing `findByAlpha2(Alpha2Code)` — using value types for type safety.

### 2.5 — Add DSL query predicates for new fields

Add to `CountriesQuery`:

```kotlin
fun continent(continent: Continent)
fun region(region: Region)
fun callingCode(code: String)
fun currency(code: String)
fun timezone(id: String)
```

### 2.6 — Add extension functions for new fields

Add `String` extensions for quick access:

```kotlin
val String.callingCode: String?       // alpha2 → calling code
val String.currencyCode: String?      // alpha2 → currency code
val String.continent: Continent?      // alpha2 → continent
val String.region: Region?            // alpha2 → region
val String.timezone: String?          // alpha2 → primary timezone
```

### 2.7 — Update `Countries.TOTAL_COUNTRIES` and tests

- Verify `TOTAL_COUNTRIES` is still 249
- Update `TestCountries` fixture with new fields
- Add tests for all new repository methods, DSL predicates, and extension functions

---

## Sprint 3: Complete i18n

> Goal: Fill in all missing translations, add new languages, fix locale handling.

### 3.1 — Complete Chinese (ZH) translations

- After Step 1.4 removes the orphaned XK entry, the file will have 244 valid entries
- Add the 5 missing country translations: CN, HK, MO, SG, TW
- Bring the count from 244 to 249 (matching the full dataset)

### 3.2 — Add Japanese (JA) translations

- Create `JapaneseTranslations.kt` with all 249 country name translations
- `Locale.JA` constant already exists in `Locale.kt` — verify it's present
- Register in `CountryTranslations` map

### 3.3 — Add Portuguese (PT) translations

- Create `PortugueseTranslations.kt` with all 249 country name translations
- `Locale.PT` constant already exists in `Locale.kt` — verify it's present
- Register in `CountryTranslations` map

### 3.4 — Add Hindi (HI) translations

- Create `HindiTranslations.kt` with all 249 country name translations
- `Locale.HI` constant already exists in `Locale.kt` — verify it's present
- Register in `CountryTranslations` map

### 3.5 — Add Korean (KO) translations

- Create `KoreanTranslations.kt` with all 249 country name translations
- Add `Locale.KO` constant
- Register in `CountryTranslations` map

### 3.6 — Add Italian (IT) translations

- Create `ItalianTranslations.kt` with all 249 country name translations
- Add `Locale.IT` constant
- Register in `CountryTranslations` map

### 3.7 — Add Turkish (TR) translations

- Create `TurkishTranslations.kt` with all 249 country name translations
- Add `Locale.TR` constant
- Register in `CountryTranslations` map

### 3.8 — Add Indonesian (ID) translations

- Create `IndonesianTranslations.kt` with all 249 country name translations
- Add `Locale.ID` constant
- Register in `CountryTranslations` map

### 3.9 — Fix locale string handling

- Keep `Locale` value class strict (exactly 2 lowercase letters)
- In `getLocalizedName(String)`: normalize input by extracting language part and lowercasing
  - `"en-US"` → `"en"`, `"EN"` → `"en"`, `"pt_BR"` → `"pt"`, `"english"` → reject gracefully (return fallback, not crash)
- Return `getDisplayName()` as fallback instead of throwing `IllegalArgumentException`

### 3.10 — Update translation tests

- Update the `translatedCount >= 245` assertion to be exact per locale
- Add tests for each new language
- Add test for locale string normalization edge cases
- Update sample app `InfoItem("Languages", "7")` to reflect actual count: 13 translation maps (ES, FR, DE, AR, ZH, RU + JA, PT, HI, KO, IT, TR, ID) plus EN fallback = 14 supported locales total

---

## Sprint 4: API Improvements & Polish

> Goal: Round out the API, fix inconsistencies, improve developer experience.

### 4.1 — Make `CountriesQueryResult` implement `Iterable<Country>`

```kotlin
class CountriesQueryResult internal constructor(
    private val countries: List<Country>
) : Iterable<Country> {
    override fun iterator() = countries.iterator()
    // ... existing methods
}
```

This enables `for (country in result)`, `.map {}`, `.filter {}`, etc.

### 4.2 — Add `@DslMarker` to query DSL

```kotlin
@DslMarker
annotation class CountriesDsl

@CountriesDsl
class CountriesQuery { ... }
```

Prevents accidentally calling outer-scope DSL functions from inside `or {}` blocks.

### 4.3 — Add `not {}` DSL combinator

Uses `!any` semantics — "none of these predicates match". This means `not { continent(ANTARCTICA); region(EASTERN_EUROPE) }` excludes countries matching Antarctica **or** Eastern Europe, which is the intuitive reading.

```kotlin
fun not(block: CountriesQuery.() -> Unit) {
    val subQuery = CountriesQuery(repository)
    subQuery.block()
    predicates.add { country ->
        !subQuery.predicates.any { it(country) }
    }
}
```

Enables queries like: `query { not { continent(ANTARCTICA) } }`

### 4.4 — Fix `searchByName("")` vs `nameContains("")` inconsistency

- `searchByName("")` returns empty list; `nameContains("")` matches all 249 countries. These should be consistent.
- Decision: `nameContains("")` should be a **no-op** — if the name is blank, skip adding the predicate entirely. This means "no filter applied", so all countries pass through (same as not calling `nameContains` at all).
- This differs from `searchByName("")` which returns empty. Update `searchByName` to also return all countries for blank input (consistent "no filter" semantics), or document the difference: `searchByName` is "search for X" (blank = no results), `nameContains` is "filter by X" (blank = no filter).
- Chosen approach: make `nameContains("")` a no-op. `searchByName("")` remains empty (it's a different API with "search" semantics). Document this distinction.

### 4.5 — Guard `or {}` empty block edge case

- If `or {}` is called with an empty block (no predicates), don't add the always-false predicate
- Add a guard: `if (subQuery.predicates.isEmpty()) return`
- Add a test for this edge case

### 4.6 — Update sample app

- Fix hardcoded `InfoItem("Languages", "7")` → `"14"` (13 translation maps + EN fallback)
- Add UI for new country fields (continent, calling code, currency, timezone)
- Add new languages to the language picker

### 4.7 — Final test pass

- Run all tests across all platforms (JVM, iOS, JS, WasmJS)
- Verify CI workflow runs successfully
- Verify all 249 countries have complete data for all new fields
- Verify all 13 translation locales have complete translations (249 entries each)

---

## Decisions Log

| Decision | Choice | Rationale |
|----------|--------|-----------|
| New data fields location | All in `Country` data class | Simple API, minimal size overhead, no module sprawl |
| Missing translations | Add all + new languages (KO, IT, TR, ID) | Deliver on promised locales, expand coverage |
| Region granularity | Continent + Region (UN geoscheme) | Good balance of utility vs. complexity |
| Multi-value fields (calling code, currency) | Primary only | Covers 95% of use cases, clean API |
| Locale string handling | Normalize in convenience API, keep `Locale` strict | Type safety preserved, string API forgiving |
| Version constant | Build-generated from `libs.versions.toml` | Zero maintenance, always in sync |
| Execution approach | Fix → Extend → Polish (4 sprints) | Bugs fixed first, new features build on solid base |
