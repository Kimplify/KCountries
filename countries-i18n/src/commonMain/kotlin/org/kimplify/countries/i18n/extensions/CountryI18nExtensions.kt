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
