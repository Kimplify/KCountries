package org.kimplify.countries.i18n

@kotlin.jvm.JvmInline
value class Locale(val code: String) {
    init {
        require(code.length == 2 && code.all { it.isLowerCase() && it.isLetter() }) {
            "Locale code must be a two-letter lowercase ISO 639-1 code (e.g., 'en', 'es')"
        }
    }

    companion object {
        val EN = Locale("en")
        val ES = Locale("es")
        val FR = Locale("fr")
        val DE = Locale("de")
        val AR = Locale("ar")
        val ZH = Locale("zh")
        val RU = Locale("ru")
        val JA = Locale("ja")
        val PT = Locale("pt")
        val HI = Locale("hi")
    }
}
