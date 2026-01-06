package org.kimplify.countries.i18n

import org.kimplify.countries.Countries
import org.kimplify.countries.i18n.extensions.getLocalizedName
import org.kimplify.countries.model.Alpha2Code
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class TranslationTest {

    @Test
    fun `Locale value class validates ISO 639-1 codes`() {
        val validLocale = Locale("en")
        assertEquals("en", validLocale.code)

        val result = runCatching { Locale("ENG") }
        assertTrue(result.isFailure)

        val result2 = runCatching { Locale("e") }
        assertTrue(result2.isFailure)
    }

    @Test
    fun `CountryTranslations returns Spanish translation`() {
        val translation = CountryTranslations.getTranslation("US", Locale.ES)
        assertNotNull(translation)
        assertTrue(translation.contains("Estados Unidos") || translation.contains("EE. UU"))
    }

    @Test
    fun `CountryTranslations returns French translation`() {
        val translation = CountryTranslations.getTranslation("FR", Locale.FR)
        assertNotNull(translation)
        assertEquals("France", translation)
    }

    @Test
    fun `CountryTranslations returns German translation`() {
        val translation = CountryTranslations.getTranslation("DE", Locale.DE)
        assertNotNull(translation)
        assertEquals("Deutschland", translation)
    }

    @Test
    fun `CountryTranslations returns Arabic translation`() {
        val translation = CountryTranslations.getTranslation("EG", Locale.AR)
        assertNotNull(translation)
        assertTrue(translation.contains("مصر"))
    }

    @Test
    fun `CountryTranslations returns Chinese translation`() {
        val translation = CountryTranslations.getTranslation("US", Locale.ZH)
        assertNotNull(translation)
        assertEquals("美国", translation)
    }

    @Test
    fun `CountryTranslations returns Russian translation`() {
        val translation = CountryTranslations.getTranslation("RU", Locale.RU)
        assertNotNull(translation)
        assertTrue(translation.contains("Россия"))
    }

    @Test
    fun `CountryTranslations works with string locale code`() {
        val translation = CountryTranslations.getTranslation("JP", "es")
        assertNotNull(translation)
        assertEquals("Japón", translation)
    }

    @Test
    fun `getAllTranslations returns all available translations`() {
        val translations = CountryTranslations.getAllTranslations("US")
        assertTrue(translations.isNotEmpty())
        assertTrue(translations.size >= 5)
    }

    @Test
    fun `supportedLocales contains all 6 languages`() {
        val locales = CountryTranslations.supportedLocales
        assertEquals(6, locales.size)
        assertTrue(locales.contains(Locale.ES))
        assertTrue(locales.contains(Locale.FR))
        assertTrue(locales.contains(Locale.DE))
        assertTrue(locales.contains(Locale.AR))
        assertTrue(locales.contains(Locale.ZH))
        assertTrue(locales.contains(Locale.RU))
    }

    @Test
    fun `getLocalizedName returns Spanish name`() {
        val country = Countries.repository.findByAlpha2(Alpha2Code("MX"))
        assertNotNull(country)
        val localizedName = country.getLocalizedName(Locale.ES)
        assertEquals("México", localizedName)
    }

    @Test
    fun `getLocalizedName returns French name`() {
        val country = Countries.repository.findByAlpha2(Alpha2Code("CA"))
        assertNotNull(country)
        val localizedName = country.getLocalizedName(Locale.FR)
        assertEquals("Canada", localizedName)
    }

    @Test
    fun `getLocalizedName falls back to English for EN locale`() {
        val country = Countries.repository.findByAlpha2(Alpha2Code("US"))
        assertNotNull(country)
        val localizedName = country.getLocalizedName(Locale.EN)
        assertEquals("United States", localizedName)
    }

    @Test
    fun `getLocalizedName with string code works`() {
        val country = Countries.repository.findByAlpha2(Alpha2Code("BR"))
        assertNotNull(country)
        val localizedName = country.getLocalizedName("es")
        assertEquals("Brasil", localizedName)
    }

    @Test
    fun `getLocalizedName defaults to English`() {
        val country = Countries.repository.findByAlpha2(Alpha2Code("GB"))
        assertNotNull(country)
        val localizedName = country.getLocalizedName()
        assertEquals("United Kingdom", localizedName)
    }

    @Test
    fun `Spanish translations cover all countries`() {
        val allCountries = Countries.repository.getAll()
        val translatedCount = allCountries.count { country ->
            CountryTranslations.getTranslation(country.alpha2.value, Locale.ES) != null
        }
        assertTrue(translatedCount >= 245)
    }

    @Test
    fun `RTL language Arabic has correct encoding`() {
        val translation = CountryTranslations.getTranslation("SA", Locale.AR)
        assertNotNull(translation)
        assertTrue(translation.contains("العربية") || translation.contains("السعودية"))
    }

    @Test
    fun `translations with special characters are preserved`() {
        val translation = CountryTranslations.getTranslation("ES", Locale.ES)
        assertNotNull(translation)
        assertEquals("España", translation)
    }
}
