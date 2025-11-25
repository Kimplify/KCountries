package org.kimplify.countries.model

import kotlin.jvm.JvmInline

/**
 * ISO 3166-1 alpha-2 country code.
 *
 * Two-letter codes representing countries (e.g., "US", "GB", "FR").
 * Most commonly used format for country identification.
 *
 * @property value The two-letter uppercase code.
 * @throws IllegalArgumentException if the code is not exactly 2 uppercase letters.
 */
@JvmInline
value class Alpha2Code(val value: String) {
    init {
        require(value.length == 2 && value.all { it.isUpperCase() }) {
            "Alpha-2 code must be 2 uppercase letters, got: '$value'"
        }
    }
}

/**
 * ISO 3166-1 alpha-3 country code.
 *
 * Three-letter codes providing more descriptive country identification (e.g., "USA", "GBR", "FRA").
 *
 * @property value The three-letter uppercase code.
 * @throws IllegalArgumentException if the code is not exactly 3 uppercase letters.
 */
@JvmInline
value class Alpha3Code(val value: String) {
    init {
        require(value.length == 3 && value.all { it.isUpperCase() }) {
            "Alpha-3 code must be 3 uppercase letters, got: '$value'"
        }
    }
}

/**
 * ISO 3166-1 numeric country code.
 *
 * Three-digit codes providing script-independent country identification (e.g., "840" for USA).
 *
 * @property value The three-digit code as a string.
 * @throws IllegalArgumentException if the code is not exactly 3 digits.
 */
@JvmInline
value class NumericCode(val value: String) {
    init {
        require(value.length == 3 && value.all { it.isDigit() }) {
            "Numeric code must be 3 digits, got: '$value'"
        }
    }
}

/**
 * Country name in English.
 *
 * @property value The country name.
 * @throws IllegalArgumentException if the name is blank.
 */
@JvmInline
value class CountryName(val value: String) {
    init {
        require(value.isNotBlank()) {
            "Country name cannot be blank"
        }
    }
}

/**
 * Country flag emoji.
 *
 * Unicode regional indicator symbols representing country flags (e.g., "🇺🇸", "🇬🇧").
 *
 * @property value The flag emoji string.
 * @throws IllegalArgumentException if the emoji is not a valid length.
 */
@JvmInline
value class FlagEmoji(val value: String) {
    init {
        require(value.length in 4..8) {
            "Flag emoji must be valid Unicode regional indicator sequence, got length: ${value.length}"
        }
    }
}
