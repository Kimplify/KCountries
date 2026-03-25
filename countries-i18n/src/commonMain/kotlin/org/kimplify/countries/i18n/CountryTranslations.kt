package org.kimplify.countries.i18n

import org.kimplify.countries.i18n.data.*

object CountryTranslations {

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

    fun getTranslation(alpha2: String, locale: Locale): String? {
        return translationMaps[locale]?.get(alpha2.uppercase())
    }

    fun getTranslation(alpha2: String, localeCode: String): String? {
        val normalized = localeCode.split('-', '_').firstOrNull()?.lowercase() ?: return null
        if (normalized.length != 2) return null
        return try {
            getTranslation(alpha2, Locale(normalized))
        } catch (_: IllegalArgumentException) {
            null
        }
    }

    fun getAllTranslations(alpha2: String): Map<Locale, String> {
        val alpha2Upper = alpha2.uppercase()
        return translationMaps.mapNotNull { (locale, translations) ->
            translations[alpha2Upper]?.let { locale to it }
        }.toMap()
    }

    val supportedLocales: Set<Locale> = translationMaps.keys
}
