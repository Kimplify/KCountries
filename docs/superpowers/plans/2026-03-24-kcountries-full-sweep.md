# KCountries Full Sweep Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Fix all bugs, extend the Country model with region/calling code/currency/timezone, complete i18n with 7 new languages, and polish the query API.

**Architecture:** 4-phase approach (Fix → Extend → i18n → Polish). All new data fields go directly in the `Country` data class. Translations are per-locale files in `countries-i18n`. Query DSL gains new predicates and combinators.

**Tech Stack:** Kotlin Multiplatform (Android, iOS, JVM, JS, WasmJS), Gradle with version catalogs, `de.cketti.unicode:kotlin-codepoints` for emoji validation.

**Spec:** `docs/superpowers/specs/2026-03-24-kcountries-full-sweep-design.md`

---

## Sprint 1: Critical Bug Fixes & Stability

### Task 1: Fix CI workflows

**Files:**
- Modify: `.github/workflows/build.yml`
- Modify: `.github/workflows/publish.yml`

- [ ] **Step 1: Fix `build.yml` — replace `:deci:*` with correct module paths**

Replace all occurrences of `:deci:` with the correct module names. The test job should run tests for both `:countries-core` and `:countries-i18n` across all platforms. The build job should build both modules. Fix `actions/checkout@v5` → `actions/checkout@v6`. Fix artifact upload paths from `deci/build/` to `countries-core/build/` and `countries-i18n/build/`.

- [ ] **Step 2: Fix `publish.yml` — update checkout action**

Change `actions/checkout@v5` to `actions/checkout@v6` at line 13.

- [ ] **Step 3: Commit**

```bash
git add .github/workflows/build.yml .github/workflows/publish.yml
git commit -m "fix: correct CI workflows — replace :deci: references, standardize checkout@v6"
```

---

### Task 2: Build-generated `Countries.VERSION`

**Files:**
- Modify: `countries-core/build.gradle.kts:10-54` (add version generation task)
- Modify: `countries-core/src/commonMain/kotlin/org/kimplify/countries/Countries.kt:42` (remove hardcoded VERSION)

- [ ] **Step 1: Add version generation in `countries-core/build.gradle.kts`**

After the `kotlin { ... }` block, add a Gradle task that generates a `BuildKConfig.kt` into a build directory and registers it as a `commonMain` source:

```kotlin
val generateVersionFile = tasks.register("generateVersionFile") {
    val version = libs.versions.kcountries.get()
    val outputDir = layout.buildDirectory.dir("generated/version/kotlin")
    outputs.dir(outputDir)
    doLast {
        val dir = outputDir.get().asFile.resolve("org/kimplify/countries")
        dir.mkdirs()
        dir.resolve("BuildKConfig.kt").writeText(
            """
            |package org.kimplify.countries
            |
            |internal object BuildKConfig {
            |    const val VERSION = "$version"
            |}
            """.trimMargin()
        )
    }
}

kotlin.sourceSets.commonMain {
    kotlin.srcDir(generateVersionFile.map { it.outputs.files.singleFile })
}
```

- [ ] **Step 2: Update `Countries.kt` to use generated version**

In `countries-core/src/commonMain/kotlin/org/kimplify/countries/Countries.kt`, change line 42 from:

```kotlin
const val VERSION = "1.0.0"
```

to:

```kotlin
val VERSION = BuildKConfig.VERSION
```

Note: This changes from `const val` to `val` since it now reads from a generated object. This is acceptable — the value is still a compile-time constant in the generated file.

- [ ] **Step 3: Run tests to verify nothing broke**

Run: `./gradlew :countries-core:jvmTest`
Expected: All tests pass.

- [ ] **Step 4: Commit**

```bash
git add countries-core/build.gradle.kts countries-core/src/commonMain/kotlin/org/kimplify/countries/Countries.kt
git commit -m "fix: generate Countries.VERSION from version catalog instead of hardcoding"
```

---

### Task 3: Fix `FlagEmoji` validation with `kotlin-codepoints`

**Files:**
- Modify: `countries-core/src/commonMain/kotlin/org/kimplify/countries/model/CountryCodes.kt:81-87`
- Modify: `countries-core/src/commonTest/kotlin/org/kimplify/countries/model/CountryCodesValidationTest.kt:61-72`

- [ ] **Step 1: Update the `FlagEmoji` validation test**

In `CountryCodesValidationTest.kt`, replace the existing `flagEmojiEnforcesValidLength` test (lines 61-72) with a more precise test:

```kotlin
@Test
fun flagEmojiRequiresExactlyTwoRegionalIndicatorCodepoints() {
    // Valid flag emojis (2 regional indicator symbols)
    FlagEmoji("🇺🇸") // US
    FlagEmoji("🇬🇧") // GB
    FlagEmoji("🇯🇵") // JP

    // Reject ASCII strings that happen to have length 4
    assertFailsWith<IllegalArgumentException> { FlagEmoji("ABCD") }
    // Reject single regional indicator
    assertFailsWith<IllegalArgumentException> { FlagEmoji("🇺") }
    // Reject empty
    assertFailsWith<IllegalArgumentException> { FlagEmoji("") }
    // Reject non-flag emoji
    assertFailsWith<IllegalArgumentException> { FlagEmoji("😀😀") }
}
```

- [ ] **Step 2: Run test to verify it fails**

Run: `./gradlew :countries-core:jvmTest --tests "*.CountryCodesValidationTest.flagEmojiRequiresExactlyTwoRegionalIndicatorCodepoints"`
Expected: FAIL — current validation accepts `"ABCD"`.

- [ ] **Step 3: Implement proper `FlagEmoji` validation**

In `CountryCodes.kt`, add the import at the top:

```kotlin
import de.cketti.unicode.codePointCount
import de.cketti.unicode.forEachCodePoint
```

Replace the `FlagEmoji` value class (lines 81-87) with:

```kotlin
@JvmInline
value class FlagEmoji(val value: String) {
    init {
        require(value.codePointCount() == 2) { "Flag emoji must consist of exactly 2 codepoints" }
        value.forEachCodePoint { codePoint ->
            require(codePoint in 0x1F1E6..0x1F1FF) {
                "Flag emoji must consist of regional indicator symbols (U+1F1E6..U+1F1FF)"
            }
        }
    }
}
```

- [ ] **Step 4: Run test to verify it passes**

Run: `./gradlew :countries-core:jvmTest --tests "*.CountryCodesValidationTest"`
Expected: All tests pass.

- [ ] **Step 5: Run full test suite to verify no regressions**

Run: `./gradlew :countries-core:jvmTest`
Expected: All tests pass (all 249 countries' flags pass the new validation).

- [ ] **Step 6: Commit**

```bash
git add countries-core/src/commonMain/kotlin/org/kimplify/countries/model/CountryCodes.kt countries-core/src/commonTest/kotlin/org/kimplify/countries/model/CountryCodesValidationTest.kt
git commit -m "fix: validate FlagEmoji using codepoints instead of string length"
```

---

### Task 4: Fix Kosovo translations, country data inaccuracies, SDK versions, and Locale annotation

**Files:**
- Modify: `countries-i18n/src/commonMain/kotlin/org/kimplify/countries/i18n/data/SpanishTranslations.kt` (remove XK)
- Modify: `countries-i18n/src/commonMain/kotlin/org/kimplify/countries/i18n/data/FrenchTranslations.kt` (remove XK)
- Modify: `countries-i18n/src/commonMain/kotlin/org/kimplify/countries/i18n/data/GermanTranslations.kt` (remove XK)
- Modify: `countries-i18n/src/commonMain/kotlin/org/kimplify/countries/i18n/data/ArabicTranslations.kt` (remove XK)
- Modify: `countries-i18n/src/commonMain/kotlin/org/kimplify/countries/i18n/data/ChineseTranslations.kt` (remove XK)
- Modify: `countries-i18n/src/commonMain/kotlin/org/kimplify/countries/i18n/data/RussianTranslations.kt` (remove XK)
- Modify: `countries-core/src/commonMain/kotlin/org/kimplify/countries/data/CountriesData.kt` (Turkey, Belgium, Peru)
- Modify: `countries-core/build.gradle.kts:56-63` (compileSdk, minSdk)
- Modify: `countries-i18n/build.gradle.kts:56-63` (compileSdk, minSdk)
- Modify: `countries-i18n/src/commonMain/kotlin/org/kimplify/countries/i18n/Locale.kt:3` (annotation)

- [ ] **Step 1: Remove `"XK"` from all 6 translation files**

In each translation file, find the line `"XK" to "..."` and delete it:
- `SpanishTranslations.kt`: remove `"XK" to "Kosovo"`
- `FrenchTranslations.kt`: remove `"XK" to "Kosovo"`
- `GermanTranslations.kt`: remove `"XK" to "Kosovo"`
- `ArabicTranslations.kt`: remove `"XK" to "كوسوفو"`
- `ChineseTranslations.kt`: remove `"XK" to "科索沃"`
- `RussianTranslations.kt`: remove the `"XK" to "..."` entry (value is `"Республика Косово"`)

- [ ] **Step 2: Fix Turkey in `CountriesData.kt`**

Find the Turkey entry (around line 1845) and change:
- `name = CountryName("Turkey")` → `name = CountryName("Türkiye")`
- Add `displayName = "Türkiye"` (currently not set)

- [ ] **Step 3: Fix Belgium in `CountriesData.kt`**

Find the Belgium entry (around line 173) and change:
- `native = "Belgien"` → `native = "België / Belgique"`

- [ ] **Step 4: Fix Peru in `CountriesData.kt`**

Find the Peru entry (around line 1431) and change:
- `native = "Piruw"` → `native = "Perú"`

- [ ] **Step 5: Fix `compileSdk` and `minSdk` in both library build files**

In `countries-core/build.gradle.kts` (lines 57-60), change:

```kotlin
compileSdk = 35
defaultConfig {
    minSdk = 21
}
```

to:

```kotlin
compileSdk = libs.versions.android.compileSdk.get().toInt()
defaultConfig {
    minSdk = libs.versions.android.minSdk.get().toInt()
}
```

Apply the same change in `countries-i18n/build.gradle.kts` (same lines).

- [ ] **Step 6: Fix `Locale` annotation**

In `countries-i18n/src/commonMain/kotlin/org/kimplify/countries/i18n/Locale.kt`, change line 3 from:

```kotlin
@kotlin.jvm.JvmInline
```

to:

```kotlin
import kotlin.jvm.JvmInline

@JvmInline
```

- [ ] **Step 7: Run all tests**

Run: `./gradlew :countries-core:jvmTest :countries-i18n:jvmTest`
Expected: All tests pass. (The translation count test uses `>= 245` so removing one entry per map won't break it.)

- [ ] **Step 8: Commit**

```bash
git add countries-core/src/commonMain/kotlin/org/kimplify/countries/data/CountriesData.kt \
       countries-core/build.gradle.kts countries-i18n/build.gradle.kts \
       countries-i18n/src/commonMain/kotlin/org/kimplify/countries/i18n/Locale.kt \
       countries-i18n/src/commonMain/kotlin/org/kimplify/countries/i18n/data/
git commit -m "fix: data inaccuracies (Turkey/Belgium/Peru), remove orphaned XK translations, fix SDK versions and Locale annotation"
```

---

## Sprint 2: Extend the Country Model

### Task 5: Add new value types (`Continent`, `Region`, `CallingCode`, `CurrencyCode`, `TimezoneId`)

**Files:**
- Create: `countries-core/src/commonMain/kotlin/org/kimplify/countries/model/Continent.kt`
- Create: `countries-core/src/commonMain/kotlin/org/kimplify/countries/model/Region.kt`
- Create: `countries-core/src/commonMain/kotlin/org/kimplify/countries/model/CountryMetadata.kt` (CallingCode, CurrencyCode, TimezoneId)
- Test: `countries-core/src/commonTest/kotlin/org/kimplify/countries/model/CountryMetadataValidationTest.kt`

- [ ] **Step 1: Write validation tests for new value types**

Create `CountryMetadataValidationTest.kt`:

```kotlin
package org.kimplify.countries.model

import kotlin.test.Test
import kotlin.test.assertFailsWith

class CountryMetadataValidationTest {

    @Test
    fun callingCodeRequiresPlusPrefixAndDigits() {
        CallingCode("+1")
        CallingCode("+44")
        CallingCode("+380")
        CallingCode("+1868")

        assertFailsWith<IllegalArgumentException> { CallingCode("1") }
        assertFailsWith<IllegalArgumentException> { CallingCode("+") }
        assertFailsWith<IllegalArgumentException> { CallingCode("+12345") }
        assertFailsWith<IllegalArgumentException> { CallingCode("") }
        assertFailsWith<IllegalArgumentException> { CallingCode("+abc") }
    }

    @Test
    fun currencyCodeRequiresThreeUppercaseLetters() {
        CurrencyCode("USD")
        CurrencyCode("EUR")
        CurrencyCode("JPY")

        assertFailsWith<IllegalArgumentException> { CurrencyCode("usd") }
        assertFailsWith<IllegalArgumentException> { CurrencyCode("US") }
        assertFailsWith<IllegalArgumentException> { CurrencyCode("USDX") }
        assertFailsWith<IllegalArgumentException> { CurrencyCode("") }
        assertFailsWith<IllegalArgumentException> { CurrencyCode("123") }
    }

    @Test
    fun timezoneIdRequiresIanaFormatOrUtc() {
        TimezoneId("America/New_York")
        TimezoneId("Europe/London")
        TimezoneId("UTC")
        TimezoneId("Asia/Tokyo")

        assertFailsWith<IllegalArgumentException> { TimezoneId("") }
        assertFailsWith<IllegalArgumentException> { TimezoneId("EST") }
        assertFailsWith<IllegalArgumentException> { TimezoneId("NewYork") }
    }
}
```

- [ ] **Step 2: Run test to verify it fails**

Run: `./gradlew :countries-core:jvmTest --tests "*.CountryMetadataValidationTest"`
Expected: FAIL — classes don't exist yet.

- [ ] **Step 3: Create `Continent.kt`**

```kotlin
package org.kimplify.countries.model

enum class Continent {
    AFRICA,
    ANTARCTICA,
    ASIA,
    EUROPE,
    NORTH_AMERICA,
    OCEANIA,
    SOUTH_AMERICA
}
```

- [ ] **Step 4: Create `Region.kt`**

```kotlin
package org.kimplify.countries.model

enum class Region {
    ANTARCTICA,
    AUSTRALIA_AND_NEW_ZEALAND,
    CARIBBEAN,
    CENTRAL_AMERICA,
    CENTRAL_ASIA,
    EASTERN_AFRICA,
    EASTERN_ASIA,
    EASTERN_EUROPE,
    MELANESIA,
    MICRONESIA,
    MIDDLE_AFRICA,
    NORTHERN_AFRICA,
    NORTHERN_AMERICA,
    NORTHERN_EUROPE,
    POLYNESIA,
    SOUTH_AMERICA,
    SOUTHEASTERN_ASIA,
    SOUTHERN_AFRICA,
    SOUTHERN_ASIA,
    SOUTHERN_EUROPE,
    WESTERN_AFRICA,
    WESTERN_ASIA,
    WESTERN_EUROPE
}
```

- [ ] **Step 5: Create `CountryMetadata.kt`**

```kotlin
package org.kimplify.countries.model

import kotlin.jvm.JvmInline

@JvmInline
value class CallingCode(val value: String) {
    init {
        require(value.matches(PATTERN)) {
            "Calling code must be '+' followed by 1-4 digits (base E.164 code, e.g. \"+1\")"
        }
    }
    companion object {
        private val PATTERN = Regex("^\\+\\d{1,4}$")
    }
}

@JvmInline
value class CurrencyCode(val value: String) {
    init {
        require(value.matches(PATTERN)) {
            "Currency code must be 3 uppercase letters (ISO 4217)"
        }
    }
    companion object {
        private val PATTERN = Regex("^[A-Z]{3}$")
    }
}

@JvmInline
value class TimezoneId(val value: String) {
    init {
        require(value.contains("/") || value == "UTC") {
            "Timezone must be IANA format (e.g. \"America/New_York\") or \"UTC\""
        }
    }
}
```

- [ ] **Step 6: Run tests to verify they pass**

Run: `./gradlew :countries-core:jvmTest --tests "*.CountryMetadataValidationTest"`
Expected: All 3 tests pass.

- [ ] **Step 7: Commit**

```bash
git add countries-core/src/commonMain/kotlin/org/kimplify/countries/model/Continent.kt \
       countries-core/src/commonMain/kotlin/org/kimplify/countries/model/Region.kt \
       countries-core/src/commonMain/kotlin/org/kimplify/countries/model/CountryMetadata.kt \
       countries-core/src/commonTest/kotlin/org/kimplify/countries/model/CountryMetadataValidationTest.kt
git commit -m "feat: add Continent, Region, CallingCode, CurrencyCode, TimezoneId types"
```

---

### Task 6: Extend `Country` data class, update `TestCountries`, and populate all `CountriesData`

**Files:**
- Modify: `countries-core/src/commonMain/kotlin/org/kimplify/countries/model/Country.kt:16-24`
- Modify: `countries-core/src/commonTest/kotlin/org/kimplify/countries/testdata/TestCountries.kt`
- Modify: `countries-core/src/commonMain/kotlin/org/kimplify/countries/data/CountriesData.kt` (all 249 entries)

**Important:** The Country class extension and CountriesData population MUST happen in the same commit to keep the build compilable. Never commit a Country class with new required fields while CountriesData still uses the old constructor.

- [ ] **Step 1: Add new fields to `Country` data class**

In `Country.kt`, update the data class (lines 16-24) to:

```kotlin
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
```

Note: Non-default fields after default fields is fine — all construction in this codebase uses named parameters.

- [ ] **Step 2: Update `TestCountries.kt` with new fields**

Update each test country object:

```kotlin
val unitedStates = Country(
    alpha2 = Alpha2Code("US"),
    alpha3 = Alpha3Code("USA"),
    numeric = NumericCode("840"),
    name = CountryName("United States of America (the)"),
    flag = FlagEmoji("🇺🇸"),
    displayName = "United States",
    native = "United States",
    continent = Continent.NORTH_AMERICA,
    region = Region.NORTHERN_AMERICA,
    callingCode = CallingCode("+1"),
    currency = CurrencyCode("USD"),
    timezone = TimezoneId("America/New_York")
)

val unitedKingdom = Country(
    alpha2 = Alpha2Code("GB"),
    alpha3 = Alpha3Code("GBR"),
    numeric = NumericCode("826"),
    name = CountryName("United Kingdom of Great Britain and Northern Ireland (the)"),
    flag = FlagEmoji("🇬🇧"),
    displayName = "United Kingdom",
    native = "United Kingdom",
    continent = Continent.EUROPE,
    region = Region.NORTHERN_EUROPE,
    callingCode = CallingCode("+44"),
    currency = CurrencyCode("GBP"),
    timezone = TimezoneId("Europe/London")
)

val canada = Country(
    alpha2 = Alpha2Code("CA"),
    alpha3 = Alpha3Code("CAN"),
    numeric = NumericCode("124"),
    name = CountryName("Canada"),
    flag = FlagEmoji("🇨🇦"),
    continent = Continent.NORTH_AMERICA,
    region = Region.NORTHERN_AMERICA,
    callingCode = CallingCode("+1"),
    currency = CurrencyCode("CAD"),
    timezone = TimezoneId("America/Toronto")
)

val france = Country(
    alpha2 = Alpha2Code("FR"),
    alpha3 = Alpha3Code("FRA"),
    numeric = NumericCode("250"),
    name = CountryName("France"),
    flag = FlagEmoji("🇫🇷"),
    native = "France",
    continent = Continent.EUROPE,
    region = Region.WESTERN_EUROPE,
    callingCode = CallingCode("+33"),
    currency = CurrencyCode("EUR"),
    timezone = TimezoneId("Europe/Paris")
)
```

- [ ] **Step 3: Populate all 249 country entries in `CountriesData.kt`**

For each country entry, add the 5 new named parameters. Example for Andorra:

Before:
```kotlin
Country(
    alpha2 = Alpha2Code("AD"),
    alpha3 = Alpha3Code("AND"),
    numeric = NumericCode("020"),
    name = CountryName("Andorra"),
    flag = FlagEmoji("🇦🇩"),
    native = "Andorra"
),
```

After:
```kotlin
Country(
    alpha2 = Alpha2Code("AD"),
    alpha3 = Alpha3Code("AND"),
    numeric = NumericCode("020"),
    name = CountryName("Andorra"),
    flag = FlagEmoji("🇦🇩"),
    native = "Andorra",
    continent = Continent.EUROPE,
    region = Region.SOUTHERN_EUROPE,
    callingCode = CallingCode("+376"),
    currency = CurrencyCode("EUR"),
    timezone = TimezoneId("Europe/Andorra")
),
```

This is the largest sub-step (~1,245 data points). Work by continent for manageable chunks. Data sources:
- **Continents & Regions:** UN M49 geoscheme
- **Calling codes:** ITU-T E.164 (base country code with `+` prefix, e.g. `"+1"` for US/Canada)
- **Currencies:** ISO 4217
- **Timezones:** IANA Time Zone Database (most representative timezone per country)

Add required imports at top of `CountriesData.kt`:
```kotlin
import org.kimplify.countries.model.Continent
import org.kimplify.countries.model.Region
import org.kimplify.countries.model.CallingCode
import org.kimplify.countries.model.CurrencyCode
import org.kimplify.countries.model.TimezoneId
```

- [ ] **Step 4: Run full test suite**

Run: `./gradlew :countries-core:jvmTest`
Expected: All tests pass (249 countries compile with valid new fields, TestCountries-based tests pass).

- [ ] **Step 5: Commit**

```bash
git add countries-core/src/commonMain/kotlin/org/kimplify/countries/model/Country.kt \
       countries-core/src/commonTest/kotlin/org/kimplify/countries/testdata/TestCountries.kt \
       countries-core/src/commonMain/kotlin/org/kimplify/countries/data/CountriesData.kt
git commit -m "feat: extend Country with continent, region, callingCode, currency, timezone and populate all 249 entries"
```

---

### Task 7: Add repository query methods and DSL predicates for new fields

**Files:**
- Modify: `countries-core/src/commonMain/kotlin/org/kimplify/countries/repository/CountriesRepository.kt:15-124`
- Modify: `countries-core/src/commonMain/kotlin/org/kimplify/countries/dsl/CountriesQuery.kt:36-195`
- Test: `countries-core/src/commonTest/kotlin/org/kimplify/countries/repository/CountriesRepositoryTest.kt`
- Test: `countries-core/src/commonTest/kotlin/org/kimplify/countries/dsl/CountriesQueryTest.kt`

- [ ] **Step 1: Write repository tests for new query methods**

Add to `CountriesRepositoryTest.kt`:

```kotlin
@Test
fun canFindCountriesByContinent() {
    val result = repository.getByContinent(Continent.NORTH_AMERICA)
    assertEquals(2, result.size) // US and Canada from test data
    assertTrue(result.all { it.continent == Continent.NORTH_AMERICA })
}

@Test
fun canFindCountriesByRegion() {
    val result = repository.getByRegion(Region.NORTHERN_AMERICA)
    assertEquals(2, result.size)
}

@Test
fun canFindCountriesByCallingCode() {
    val result = repository.getByCallingCode(CallingCode("+1"))
    assertEquals(2, result.size) // US and Canada share +1
}

@Test
fun canFindCountriesByCurrency() {
    val result = repository.getByCurrency(CurrencyCode("EUR"))
    assertEquals(1, result.size) // France
    assertEquals("FR", result.first().alpha2.value)
}
```

- [ ] **Step 2: Write DSL query tests for new predicates**

Add to `CountriesQueryTest.kt`:

```kotlin
@Test
fun continentPredicateFiltersCorrectly() {
    val result = repository.query {
        continent(Continent.EUROPE)
    }
    assertEquals(2, result.count()) // UK and France
}

@Test
fun regionPredicateFiltersCorrectly() {
    val result = repository.query {
        region(Region.WESTERN_EUROPE)
    }
    assertEquals(1, result.count()) // France
}

@Test
fun callingCodePredicateFiltersCorrectly() {
    val result = repository.query {
        callingCode("+1")
    }
    assertEquals(2, result.count()) // US and Canada
}

@Test
fun currencyPredicateFiltersCorrectly() {
    val result = repository.query {
        currency("GBP")
    }
    assertEquals(1, result.count()) // UK
}

@Test
fun timezonePredicateFiltersCorrectly() {
    val result = repository.query {
        timezone("Europe/Paris")
    }
    assertEquals(1, result.count()) // France
}
```

- [ ] **Step 3: Run tests to verify they fail**

Run: `./gradlew :countries-core:jvmTest --tests "*.CountriesRepositoryTest" --tests "*.CountriesQueryTest"`
Expected: FAIL — methods don't exist yet.

- [ ] **Step 4: Add methods to `CountriesRepository` interface**

In `CountriesRepository.kt`, add to the interface (after `searchByName` around line 55):

```kotlin
fun getByContinent(continent: Continent): List<Country>
fun getByRegion(region: Region): List<Country>
fun getByCallingCode(callingCode: CallingCode): List<Country>
fun getByCurrency(currencyCode: CurrencyCode): List<Country>
```

Add imports:
```kotlin
import org.kimplify.countries.model.Continent
import org.kimplify.countries.model.Region
import org.kimplify.countries.model.CallingCode
import org.kimplify.countries.model.CurrencyCode
```

- [ ] **Step 5: Implement in `InMemoryCountriesRepository`**

Add lazy index maps (after the existing three around line 97):

```kotlin
private val continentIndex: Map<Continent, List<Country>> by lazy {
    countries.groupBy { it.continent }
}
private val regionIndex: Map<Region, List<Country>> by lazy {
    countries.groupBy { it.region }
}
private val callingCodeIndex: Map<CallingCode, List<Country>> by lazy {
    countries.groupBy { it.callingCode }
}
private val currencyIndex: Map<CurrencyCode, List<Country>> by lazy {
    countries.groupBy { it.currency }
}
```

Add implementations (after existing find methods):

```kotlin
override fun getByContinent(continent: Continent): List<Country> =
    continentIndex[continent] ?: emptyList()

override fun getByRegion(region: Region): List<Country> =
    regionIndex[region] ?: emptyList()

override fun getByCallingCode(callingCode: CallingCode): List<Country> =
    callingCodeIndex[callingCode] ?: emptyList()

override fun getByCurrency(currencyCode: CurrencyCode): List<Country> =
    currencyIndex[currencyCode] ?: emptyList()
```

- [ ] **Step 6: Add DSL predicates to `CountriesQuery`**

In `CountriesQuery.kt`, add after the existing `nameStartsWith` function (around line 158):

```kotlin
fun continent(continent: Continent) {
    predicates.add { it.continent == continent }
}

fun region(region: Region) {
    predicates.add { it.region == region }
}

fun callingCode(code: String) {
    predicates.add { it.callingCode.value == code }
}

fun currency(code: String) {
    predicates.add { it.currency.value == code }
}

fun timezone(id: String) {
    predicates.add { it.timezone.value == id }
}
```

Add imports:
```kotlin
import org.kimplify.countries.model.Continent
import org.kimplify.countries.model.Region
```

- [ ] **Step 7: Run tests to verify they pass**

Run: `./gradlew :countries-core:jvmTest`
Expected: All tests pass.

- [ ] **Step 8: Commit**

```bash
git add countries-core/src/commonMain/kotlin/org/kimplify/countries/repository/CountriesRepository.kt \
       countries-core/src/commonMain/kotlin/org/kimplify/countries/dsl/CountriesQuery.kt \
       countries-core/src/commonTest/kotlin/org/kimplify/countries/repository/CountriesRepositoryTest.kt \
       countries-core/src/commonTest/kotlin/org/kimplify/countries/dsl/CountriesQueryTest.kt
git commit -m "feat: add repository query methods and DSL predicates for continent, region, calling code, currency, timezone"
```

---

### Task 8: Add extension functions for new fields

**Files:**
- Modify: `countries-core/src/commonMain/kotlin/org/kimplify/countries/extensions/CountryExtensions.kt`
- Modify: `countries-core/src/commonTest/kotlin/org/kimplify/countries/extensions/CountryExtensionsTest.kt`

- [ ] **Step 1: Write tests for new extension properties**

Add to `CountryExtensionsTest.kt`:

```kotlin
@Test
fun newFieldExtensionsExposeCountryData() {
    assertEquals("+1", "US".callingCode)
    assertEquals("USD", "US".currencyCode)
    assertEquals(Continent.NORTH_AMERICA, "US".continent)
    assertEquals(Region.NORTHERN_AMERICA, "US".region)
    assertEquals("America/New_York", "US".timezone)

    // Invalid codes return null
    assertNull("ZZ".callingCode)
    assertNull("ZZ".currencyCode)
    assertNull("ZZ".continent)
    assertNull("ZZ".region)
    assertNull("ZZ".timezone)
}
```

Add imports for `Continent`, `Region`.

- [ ] **Step 2: Run test to verify it fails**

Run: `./gradlew :countries-core:jvmTest --tests "*.CountryExtensionsTest.newFieldExtensionsExposeCountryData"`
Expected: FAIL — properties don't exist yet.

- [ ] **Step 3: Implement extension properties**

In `CountryExtensions.kt`, add after the existing extensions (after line 153):

```kotlin
/**
 * Looks up the international calling code for this alpha-2 country code.
 * Returns null if no country matches.
 */
val String.callingCode: String?
    get() = this.toCountry()?.callingCode?.value

/**
 * Looks up the ISO 4217 currency code for this alpha-2 country code.
 * Returns null if no country matches.
 */
val String.currencyCode: String?
    get() = this.toCountry()?.currency?.value

/**
 * Looks up the continent for this alpha-2 country code.
 * Returns null if no country matches.
 */
val String.continent: Continent?
    get() = this.toCountry()?.continent

/**
 * Looks up the UN geoscheme region for this alpha-2 country code.
 * Returns null if no country matches.
 */
val String.region: Region?
    get() = this.toCountry()?.region

/**
 * Looks up the primary IANA timezone for this alpha-2 country code.
 * Returns null if no country matches.
 */
val String.timezone: String?
    get() = this.toCountry()?.timezone?.value
```

Add imports:
```kotlin
import org.kimplify.countries.model.Continent
import org.kimplify.countries.model.Region
```

- [ ] **Step 4: Run tests to verify they pass**

Run: `./gradlew :countries-core:jvmTest --tests "*.CountryExtensionsTest"`
Expected: All tests pass.

- [ ] **Step 5: Commit**

```bash
git add countries-core/src/commonMain/kotlin/org/kimplify/countries/extensions/CountryExtensions.kt \
       countries-core/src/commonTest/kotlin/org/kimplify/countries/extensions/CountryExtensionsTest.kt
git commit -m "feat: add String extension properties for callingCode, currencyCode, continent, region, timezone"
```

---

## Sprint 3: Complete i18n

### Task 9: Complete Chinese translations and add 7 new languages

**Files:**
- Modify: `countries-i18n/src/commonMain/kotlin/org/kimplify/countries/i18n/data/ChineseTranslations.kt` (add 5 missing)
- Create: `countries-i18n/src/commonMain/kotlin/org/kimplify/countries/i18n/data/JapaneseTranslations.kt`
- Create: `countries-i18n/src/commonMain/kotlin/org/kimplify/countries/i18n/data/PortugueseTranslations.kt`
- Create: `countries-i18n/src/commonMain/kotlin/org/kimplify/countries/i18n/data/HindiTranslations.kt`
- Create: `countries-i18n/src/commonMain/kotlin/org/kimplify/countries/i18n/data/KoreanTranslations.kt`
- Create: `countries-i18n/src/commonMain/kotlin/org/kimplify/countries/i18n/data/ItalianTranslations.kt`
- Create: `countries-i18n/src/commonMain/kotlin/org/kimplify/countries/i18n/data/TurkishTranslations.kt`
- Create: `countries-i18n/src/commonMain/kotlin/org/kimplify/countries/i18n/data/IndonesianTranslations.kt`
- Modify: `countries-i18n/src/commonMain/kotlin/org/kimplify/countries/i18n/Locale.kt` (add KO, IT, TR, ID)
- Modify: `countries-i18n/src/commonMain/kotlin/org/kimplify/countries/i18n/CountryTranslations.kt` (register new locales)

- [ ] **Step 1: Add 5 missing Chinese translations**

In `ChineseTranslations.kt`, add:
```kotlin
"CN" to "中国",
"HK" to "中国香港特别行政区",
"MO" to "中国澳门特别行政区",
"SG" to "新加坡",
"TW" to "中国台湾省",
```

Insert these in alphabetical order by alpha-2 code among existing entries.

- [ ] **Step 2: Add `Locale` constants for new languages**

In `Locale.kt`, add to the companion object (after `HI`):

```kotlin
val KO = Locale("ko")
val IT = Locale("it")
val TR = Locale("tr")
val ID = Locale("id")
```

- [ ] **Step 3: Create all 7 new translation files**

Each file follows the same pattern as existing ones. Create in `countries-i18n/src/commonMain/kotlin/org/kimplify/countries/i18n/data/`:

- `JapaneseTranslations.kt` — `internal val jaTranslations = mapOf(...)` with all 249 entries
- `PortugueseTranslations.kt` — `internal val ptTranslations = mapOf(...)` with all 249 entries
- `HindiTranslations.kt` — `internal val hiTranslations = mapOf(...)` with all 249 entries
- `KoreanTranslations.kt` — `internal val koTranslations = mapOf(...)` with all 249 entries
- `ItalianTranslations.kt` — `internal val itTranslations = mapOf(...)` with all 249 entries
- `TurkishTranslations.kt` — `internal val trTranslations = mapOf(...)` with all 249 entries
- `IndonesianTranslations.kt` — `internal val idTranslations = mapOf(...)` with all 249 entries

Each must have exactly 249 entries matching the alpha-2 codes in `CountriesData`.

- [ ] **Step 4: Register all new locales in `CountryTranslations.kt`**

In `CountryTranslations.kt`, update the `translationMaps`:

```kotlin
private val translationMaps: Map<Locale, Map<String, String>> = mapOf(
    Locale.ES to esTranslations,
    Locale.FR to frTranslations,
    Locale.DE to deTranslations,
    Locale.AR to arTranslations,
    Locale.ZH to zhTranslations,
    Locale.RU to ruTranslations,
    Locale.JA to jaTranslations,
    Locale.PT to ptTranslations,
    Locale.HI to hiTranslations,
    Locale.KO to koTranslations,
    Locale.IT to itTranslations,
    Locale.TR to trTranslations,
    Locale.ID to idTranslations
)
```

Add imports for the new translation maps.

- [ ] **Step 5: Run tests**

Run: `./gradlew :countries-i18n:jvmTest`
Expected: All existing tests pass. The `supportedLocales` test will need updating (see Task 11).

- [ ] **Step 6: Commit**

```bash
git add countries-i18n/src/commonMain/kotlin/org/kimplify/countries/i18n/
git commit -m "feat: add JA, PT, HI, KO, IT, TR, ID translations, complete ZH gaps"
```

---

### Task 10: Fix locale string handling and update translation tests

**Files:**
- Modify: `countries-i18n/src/commonMain/kotlin/org/kimplify/countries/i18n/extensions/CountryI18nExtensions.kt:18-23`
- Modify: `countries-i18n/src/commonMain/kotlin/org/kimplify/countries/i18n/CountryTranslations.kt:20-22` (normalize String overload)
- Modify: `countries-i18n/src/commonTest/kotlin/org/kimplify/countries/i18n/TranslationTest.kt`

- [ ] **Step 1: Write tests for locale normalization**

Add to `TranslationTest.kt`:

```kotlin
@Test
fun getLocalizedNameNormalizesLocaleStrings() {
    val us = Countries.repository.findByAlpha2(Alpha2Code("US"))!!

    // Standard format
    assertEquals(us.getLocalizedName("es"), us.getLocalizedName(Locale.ES))
    // Uppercase
    assertEquals(us.getLocalizedName("es"), us.getLocalizedName("ES"))
    // With region code (hyphen)
    assertEquals(us.getLocalizedName("es"), us.getLocalizedName("es-MX"))
    // With region code (underscore)
    assertEquals(us.getLocalizedName("pt"), us.getLocalizedName("pt_BR"))
    // Invalid string falls back gracefully instead of crashing
    val fallback = us.getLocalizedName("xyz")
    assertEquals(us.getDisplayName(), fallback)
}

@Test
fun supportedLocalesContainsAll13Languages() {
    val locales = CountryTranslations.supportedLocales
    assertEquals(13, locales.size)
    assertTrue(locales.containsAll(setOf(
        Locale.ES, Locale.FR, Locale.DE, Locale.AR, Locale.ZH, Locale.RU,
        Locale.JA, Locale.PT, Locale.HI, Locale.KO, Locale.IT, Locale.TR, Locale.ID
    )))
}

@Test
fun allTranslationLocalesHaveComplete249Entries() {
    val allCountries = Countries.repository.getAll()
    CountryTranslations.supportedLocales.forEach { locale ->
        var count = 0
        allCountries.forEach { country ->
            if (CountryTranslations.getTranslation(country.alpha2.value, locale) != null) {
                count++
            }
        }
        assertEquals(249, count, "Locale ${locale.value} has only $count translations, expected 249")
    }
}
```

- [ ] **Step 2: Run tests to verify locale normalization fails**

Run: `./gradlew :countries-i18n:jvmTest --tests "*.TranslationTest.getLocalizedNameNormalizesLocaleStrings"`
Expected: FAIL — `getLocalizedName("ES")` throws `IllegalArgumentException`.

- [ ] **Step 3: Implement locale string normalization**

In `CountryI18nExtensions.kt`, replace the `getLocalizedName(localeCode: String)` function (lines 18-23) with:

```kotlin
fun Country.getLocalizedName(localeCode: String = "en"): String {
    val normalized = localeCode
        .split('-', '_')
        .firstOrNull()
        ?.lowercase()
        ?: return getDisplayName()

    if (normalized == "en") return getDisplayName()
    if (normalized.length != 2) return getDisplayName()

    return try {
        getLocalizedName(Locale(normalized))
    } catch (_: IllegalArgumentException) {
        getDisplayName()
    }
}
```

- [ ] **Step 4: Also normalize `CountryTranslations.getTranslation(String, String)`**

In `CountryTranslations.kt`, replace the String overload (lines 20-22) with:

```kotlin
fun getTranslation(alpha2: String, localeCode: String): String? {
    val normalized = localeCode.split('-', '_').firstOrNull()?.lowercase() ?: return null
    if (normalized.length != 2) return null
    return try {
        getTranslation(alpha2, Locale(normalized))
    } catch (_: IllegalArgumentException) {
        null
    }
}
```

This ensures both public String-accepting APIs handle locale normalization consistently.

- [ ] **Step 5: Update the existing `supportedLocales` test**

In `TranslationTest.kt`, find the old `supportedLocales contains all 6 languages` test (lines 81-91) and remove it (replaced by the new `supportedLocalesContainsAll13Languages` test above).

- [ ] **Step 6: Update old translation count assertion**

Find the `Spanish translations cover all countries` test (lines 133-140) and update the assertion from `>= 245` to `== 249`.

- [ ] **Step 7: Run all i18n tests**

Run: `./gradlew :countries-i18n:jvmTest`
Expected: All tests pass.

- [ ] **Step 8: Commit**

```bash
git add countries-i18n/src/commonMain/kotlin/org/kimplify/countries/i18n/extensions/CountryI18nExtensions.kt \
       countries-i18n/src/commonMain/kotlin/org/kimplify/countries/i18n/CountryTranslations.kt \
       countries-i18n/src/commonTest/kotlin/org/kimplify/countries/i18n/TranslationTest.kt
git commit -m "feat: normalize locale strings in getLocalizedName and getTranslation, update tests for 13 locales"
```

---

## Sprint 4: API Improvements & Polish

### Task 11: Make `CountriesQueryResult` implement `Iterable`, add `@DslMarker`, `not {}`, and fix edge cases

**Files:**
- Modify: `countries-core/src/commonMain/kotlin/org/kimplify/countries/dsl/CountriesQuery.kt`
- Modify: `countries-core/src/commonTest/kotlin/org/kimplify/countries/dsl/CountriesQueryTest.kt`

- [ ] **Step 1: Write tests for all API improvements**

Add to `CountriesQueryTest.kt`:

```kotlin
@Test
fun queryResultIsIterable() {
    val result = repository.query { continent(Continent.EUROPE) }
    val collected = mutableListOf<Country>()
    for (country in result) {
        collected.add(country)
    }
    assertEquals(result.toList(), collected)
}

@Test
fun notCombinatorsExcludesMatchingCountries() {
    val result = repository.query {
        not { continent(Continent.EUROPE) }
    }
    assertTrue(result.toList().none { it.continent == Continent.EUROPE })
    assertEquals(2, result.count()) // US and Canada
}

@Test
fun orWithEmptyBlockDoesNotFilterOutEverything() {
    val result = repository.query {
        or { }
    }
    assertEquals(4, result.count()) // All test countries
}

@Test
fun nameContainsWithBlankStringIsNoOp() {
    val result = repository.query {
        nameContains("")
    }
    assertEquals(4, result.count()) // All test countries — no filter applied
}
```

Add import for `Continent`.

- [ ] **Step 2: Run tests to verify they fail**

Run: `./gradlew :countries-core:jvmTest --tests "*.CountriesQueryTest"`
Expected: FAIL — `Iterable`, `not {}`, empty `or {}` guard, and `nameContains("")` guard don't exist yet.

- [ ] **Step 3: Add `@DslMarker` annotation**

At the top of `CountriesQuery.kt` (after the imports), add:

```kotlin
@DslMarker
annotation class CountriesDsl
```

Then annotate the `CountriesQuery` class:

```kotlin
@CountriesDsl
class CountriesQuery internal constructor(
```

- [ ] **Step 4: Make `CountriesQueryResult` implement `Iterable<Country>`**

Change the class declaration (around line 205):

```kotlin
class CountriesQueryResult internal constructor(
    private val countries: List<Country>
) : Iterable<Country> {
    override fun iterator(): Iterator<Country> = countries.iterator()
```

- [ ] **Step 5: Add `not {}` combinator**

In `CountriesQuery`, add after the `or` function:

```kotlin
fun not(block: CountriesQuery.() -> Unit) {
    val subQuery = CountriesQuery(repository)
    subQuery.block()
    if (subQuery.predicates.isEmpty()) return
    predicates.add { country ->
        !subQuery.predicates.any { it(country) }
    }
}
```

- [ ] **Step 6: Guard `or {}` empty block**

In the existing `or` function (around line 178), add a guard after executing the block:

```kotlin
fun or(block: CountriesQuery.() -> Unit) {
    val subQuery = CountriesQuery(repository)
    subQuery.block()
    if (subQuery.predicates.isEmpty()) return
    predicates.add { country ->
        subQuery.predicates.any { it(country) }
    }
}
```

- [ ] **Step 7: Make `nameContains("")` a no-op**

In the `nameContains` function (around line 105), add a guard at the top:

```kotlin
fun nameContains(text: String) {
    if (text.isBlank()) return
    // ... existing predicate logic
}
```

- [ ] **Step 8: Run tests to verify they pass**

Run: `./gradlew :countries-core:jvmTest`
Expected: All tests pass.

- [ ] **Step 9: Commit**

```bash
git add countries-core/src/commonMain/kotlin/org/kimplify/countries/dsl/CountriesQuery.kt \
       countries-core/src/commonTest/kotlin/org/kimplify/countries/dsl/CountriesQueryTest.kt
git commit -m "feat: Iterable query result, @DslMarker, not{} combinator, fix empty or{}/nameContains edge cases"
```

---

### Task 12: Update sample app

**Files:**
- Modify: `sample/src/commonMain/kotlin/org/kimplify/sample/App.kt`

- [ ] **Step 1: Update language count**

At line 142, change:
```kotlin
InfoItem("Languages", "7")
```
to:
```kotlin
InfoItem("Languages", "14")
```

- [ ] **Step 2: Add new country fields to `CountryDetailsDialog`**

In the `CountryDetailsDialog` composable (around line 256), add detail rows for the new fields after the existing rows:

```kotlin
DetailRow("Continent", country.continent.name.lowercase().replaceFirstChar { it.uppercase() }.replace('_', ' '))
DetailRow("Region", country.region.name.lowercase().replaceFirstChar { it.uppercase() }.replace('_', ' '))
DetailRow("Calling Code", country.callingCode.value)
DetailRow("Currency", country.currency.value)
DetailRow("Timezone", country.timezone.value)
```

- [ ] **Step 3: Add new languages to locale picker**

In the `CountriesScreen` composable, find the language dropdown options and add the new locales (JA, PT, HI, KO, IT, TR, ID) following the existing pattern.

- [ ] **Step 4: Verify the sample compiles**

Run: `./gradlew :sample:jvmJar`
Expected: Compiles successfully.

- [ ] **Step 5: Commit**

```bash
git add sample/src/commonMain/kotlin/org/kimplify/sample/App.kt
git commit -m "feat: update sample app with new country fields and 14 language support"
```

---

### Task 13: Final test pass across all platforms

- [ ] **Step 1: Run all JVM tests**

Run: `./gradlew :countries-core:jvmTest :countries-i18n:jvmTest`
Expected: All tests pass.

- [ ] **Step 2: Run JS tests**

Run: `./gradlew :countries-core:jsTest :countries-i18n:jsTest`
Expected: All tests pass.

- [ ] **Step 3: Run WasmJS tests**

Run: `./gradlew :countries-core:wasmJsTest :countries-i18n:wasmJsTest`
Expected: All tests pass.

- [ ] **Step 4: Run iOS simulator tests (if on macOS)**

Run: `./gradlew :countries-core:iosSimulatorArm64Test :countries-i18n:iosSimulatorArm64Test`
Expected: All tests pass.

- [ ] **Step 5: Verify the full build**

Run: `./gradlew build`
Expected: Clean build with no errors.

- [ ] **Step 6: Final commit if any fixes were needed**

```bash
git add -A
git commit -m "fix: address issues found during cross-platform test pass"
```
