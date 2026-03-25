package org.kimplify.countries.model

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CountryCodesValidationTest {

    @Test
    fun alpha2CodeRequiresTwoUppercaseCharacters() {
        val code = Alpha2Code("US")
        assertEquals("US", code.value)

        assertFailsWith<IllegalArgumentException> {
            Alpha2Code("usa")
        }
        assertFailsWith<IllegalArgumentException> {
            Alpha2Code("U1")
        }
        assertFailsWith<IllegalArgumentException> {
            Alpha2Code("U")
        }
    }

    @Test
    fun alpha3CodeRequiresThreeUppercaseCharacters() {
        val code = Alpha3Code("USA")
        assertEquals("USA", code.value)

        assertFailsWith<IllegalArgumentException> {
            Alpha3Code("US")
        }
        assertFailsWith<IllegalArgumentException> {
            Alpha3Code("Usa")
        }
    }

    @Test
    fun numericCodeRequiresThreeDigits() {
        val code = NumericCode("840")
        assertEquals("840", code.value)

        assertFailsWith<IllegalArgumentException> {
            NumericCode("84")
        }
        assertFailsWith<IllegalArgumentException> {
            NumericCode("8A0")
        }
    }

    @Test
    fun countryNameCannotBeBlank() {
        assertFailsWith<IllegalArgumentException> {
            CountryName("")
        }
        assertFailsWith<IllegalArgumentException> {
            CountryName("   ")
        }
    }

    @Test
    fun flagEmojiRequiresExactlyTwoRegionalIndicatorCodepoints() {
        // Valid flag emojis (2 regional indicator symbols)
        FlagEmoji("🇺🇸") // US
        FlagEmoji("🇬🇧") // GB
        FlagEmoji("🇯🇵") // JP

        // Reject ASCII strings that happen to have length 4
        assertFailsWith<IllegalArgumentException> { FlagEmoji("ABCD") }
        // Reject single regional indicator
        assertFailsWith<IllegalArgumentException> { FlagEmoji("🇺") }
        // Reject empty
        assertFailsWith<IllegalArgumentException> { FlagEmoji("") }
        // Reject non-flag emoji
        assertFailsWith<IllegalArgumentException> { FlagEmoji("😀😀") }
    }
}
