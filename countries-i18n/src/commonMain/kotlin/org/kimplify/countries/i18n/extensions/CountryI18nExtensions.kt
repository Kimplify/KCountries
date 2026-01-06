package org.kimplify.countries.i18n.extensions

import org.kimplify.countries.extensions.getDisplayName
import org.kimplify.countries.i18n.CountryTranslations
import org.kimplify.countries.i18n.Locale
import org.kimplify.countries.model.Country

fun Country.getLocalizedName(locale: Locale): String {
    return when (locale) {
        Locale.EN -> getDisplayName()
        else -> CountryTranslations.getTranslation(alpha2.value, locale)
            ?: displayName
            ?: native
            ?: name.value
    }
}

fun Country.getLocalizedName(localeCode: String = "en"): String {
    return when (localeCode.lowercase()) {
        "en" -> getDisplayName()
        else -> getLocalizedName(Locale(localeCode))
    }
}
