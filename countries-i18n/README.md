# KCountries I18n

Internationalization module for KCountries library providing country name translations in 6 major languages.

## Features

- **6 Languages**: English, Spanish, French, German, Arabic, Chinese, Russian
- **Type-Safe Locale**: ISO 639-1 validated locale value class
- **250 Countries**: Comprehensive translation coverage (245+ for all languages)
- **Multiplatform**: Works on Android, iOS, JVM, JS, and WASM
- **Zero Dependencies**: Standalone module with static data
- **Fast**: O(1) lookup with in-memory maps

## Installation

```kotlin
dependencies {
    implementation("org.kimplify:countries-core:0.1.0")
    implementation("org.kimplify:countries-i18n:0.1.0")
}
```

## Usage

### Basic Translation

```kotlin
import org.kimplify.countries.Countries
import org.kimplify.countries.i18n.Locale
import org.kimplify.countries.i18n.extensions.getLocalizedName
import org.kimplify.countries.model.Alpha2Code

val country = Countries.repository.findByAlpha2(Alpha2Code("US"))!!

country.getLocalizedName(Locale.EN)  // "United States"
country.getLocalizedName(Locale.ES)  // "Estados Unidos"
country.getLocalizedName(Locale.FR)  // "États-Unis"
country.getLocalizedName(Locale.DE)  // "Vereinigte Staaten"
country.getLocalizedName(Locale.AR)  // "الولايات المتحدة"
country.getLocalizedName(Locale.ZH)  // "美国"
country.getLocalizedName(Locale.RU)  // "Соединенные Штаты"
```

### Using String Locale Codes

```kotlin
country.getLocalizedName("es")  // "Estados Unidos"
country.getLocalizedName()      // "United States" (defaults to English)
```

### Get All Translations

```kotlin
import org.kimplify.countries.i18n.CountryTranslations

val translations = CountryTranslations.getAllTranslations("JP")
translations.forEach { (locale, name) ->
    println("${locale.code}: $name")
}
// en: Japan
// es: Japón
// fr: Japon
// de: Japan
// ar: اليابان
// zh: 日本
// ru: Япония
```

### Supported Locales

```kotlin
import org.kimplify.countries.i18n.CountryTranslations

CountryTranslations.supportedLocales
// [Locale.EN, Locale.ES, Locale.FR, Locale.DE, Locale.AR, Locale.ZH, Locale.RU]
```

### Type-Safe Locale

The `Locale` value class ensures ISO 639-1 compliance:

```kotlin
val validLocale = Locale("en")  // ✅ Valid
val invalidLocale = Locale("eng")  // ❌ Exception: must be 2 letters
val invalidCase = Locale("EN")  // ❌ Exception: must be lowercase
```

Predefined constants for convenience:

```kotlin
Locale.EN  // English
Locale.ES  // Spanish
Locale.FR  // French
Locale.DE  // German
Locale.AR  // Arabic
Locale.ZH  // Chinese
Locale.RU  // Russian
```

## Fallback Chain

The `getLocalizedName()` extension provides a smart fallback chain:

1. Translation in requested locale
2. Display name (user-friendly English)
3. Native name
4. Formal ISO name

```kotlin
val country = Countries.repository.findByAlpha2(Alpha2Code("GB"))!!

country.getLocalizedName(Locale.ES)  // "Reino Unido" (Spanish translation)
country.getLocalizedName(Locale.EN)  // "United Kingdom" (display name)
```

## Language Coverage

| Language | Code | Countries | Script |
|----------|------|-----------|--------|
| English | en | 249 | Latin |
| Spanish | es | 250 | Latin |
| French | fr | 250 | Latin |
| German | de | 250 | Latin |
| Arabic | ar | 250 | Arabic (RTL) |
| Chinese | zh | 245 | Chinese |
| Russian | ru | 250 | Cyrillic |

## Example: Compose UI with Locale Switcher

```kotlin
@Composable
fun CountryList() {
    var selectedLocale by remember { mutableStateOf(Locale.EN) }

    val countries = Countries.repository.getAll()

    Column {
        LocaleSelector(
            selected = selectedLocale,
            onLocaleChanged = { selectedLocale = it }
        )

        LazyColumn {
            items(countries) { country ->
                Text(country.getLocalizedName(selectedLocale))
            }
        }
    }
}
```

## Data Source

Translations are sourced from [REST Countries API](https://restcountries.com/) and embedded as static data for offline-first, fast access.

## License

MIT License - See [LICENSE](../LICENSE) file for details.
