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
    fun flagEmojiEnforcesValidLength() {
        val emoji = FlagEmoji("\uD83C\uDDFA\uD83C\uDDF8")
        assertEquals("\uD83C\uDDFA\uD83C\uDDF8", emoji.value)

        assertFailsWith<IllegalArgumentException> {
            FlagEmoji("")
        }
        assertFailsWith<IllegalArgumentException> {
            FlagEmoji("A")
        }
    }
}
