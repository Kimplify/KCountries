package org.kimplify.countries.extensions

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class CountryExtensionsTest {

    @Test
    fun toCountryDetectsCodeTypeAutomatically() {
        val alpha2 = "us".toCountry()
        assertNotNull(alpha2)
        assertEquals("USA", alpha2.alpha3.value)

        val alpha3 = "gbr".toCountry()
        assertNotNull(alpha3)
        assertEquals("GB", alpha3.alpha2.value)

        val numeric = "250".toCountry()
        assertNotNull(numeric)
        assertEquals("France", numeric.name.value)
    }

    @Test
    fun toCountryReturnsNullForUnsupportedLengthsAndThrowsForInvalidFormats() {
        assertNull("".toCountry())
        assertNull("12345".toCountry())

        assertFailsWith<IllegalArgumentException> {
            "U1".toCountry()
        }
    }

    @Test
    fun conveniencePropertiesExposeCountryData() {
        assertEquals("\uD83C\uDDFA\uD83C\uDDF8", "US".flagEmoji)
        assertEquals("United States of America (the)", "usa".countryName)
        assertEquals("US", "USA".toAlpha2)
        assertEquals("USA", "840".toAlpha3)
    }
}
