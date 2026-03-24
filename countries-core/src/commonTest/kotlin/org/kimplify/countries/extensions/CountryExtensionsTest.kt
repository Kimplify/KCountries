package org.kimplify.countries.extensions

import org.kimplify.countries.model.Continent
import org.kimplify.countries.model.Region
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

    @Test
    fun newFieldExtensionsExposeCountryData() {
        assertEquals("+1", "US".callingCode)
        assertEquals("USD", "US".currencyCode)
        assertEquals(Continent.NORTH_AMERICA, "US".continent)
        assertEquals(Region.NORTHERN_AMERICA, "US".region)
        assertEquals("America/New_York", "US".timezone)

        assertNull("ZZ".callingCode)
        assertNull("ZZ".currencyCode)
        assertNull("ZZ".continent)
        assertNull("ZZ".region)
        assertNull("ZZ".timezone)
    }
}
