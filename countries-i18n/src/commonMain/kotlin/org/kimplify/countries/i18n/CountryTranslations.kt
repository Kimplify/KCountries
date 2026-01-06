package org.kimplify.countries.i18n

import org.kimplify.countries.i18n.data.*

object CountryTranslations {

    private val translationMaps = mapOf(
        Locale.ES to esTranslations,
        Locale.FR to frTranslations,
        Locale.DE to deTranslations,
        Locale.AR to arTranslations,
        Locale.ZH to zhTranslations,
        Locale.RU to ruTranslations
    )

    fun getTranslation(alpha2: String, locale: Locale): String? {
        return translationMaps[locale]?.get(alpha2.uppercase())
    }

    fun getTranslation(alpha2: String, localeCode: String): String? {
        return getTranslation(alpha2, Locale(localeCode))
    }

    fun getAllTranslations(alpha2: String): Map<Locale, String> {
        val alpha2Upper = alpha2.uppercase()
        return translationMaps.mapNotNull { (locale, translations) ->
            translations[alpha2Upper]?.let { locale to it }
        }.toMap()
    }

    val supportedLocales: Set<Locale> = translationMaps.keys
}
