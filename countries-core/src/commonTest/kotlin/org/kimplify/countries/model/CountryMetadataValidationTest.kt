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
