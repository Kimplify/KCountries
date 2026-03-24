package org.kimplify.countries.model

import kotlin.jvm.JvmInline

@JvmInline
value class CallingCode(val value: String) {
    init {
        require(value.matches(PATTERN)) {
            "Calling code must be '+' followed by 1-4 digits (base E.164 code, e.g. \"+1\")"
        }
    }
    companion object {
        private val PATTERN = Regex("^\\+\\d{1,4}$")
    }
}

@JvmInline
value class CurrencyCode(val value: String) {
    init {
        require(value.matches(PATTERN)) {
            "Currency code must be 3 uppercase letters (ISO 4217)"
        }
    }
    companion object {
        private val PATTERN = Regex("^[A-Z]{3}$")
    }
}

@JvmInline
value class TimezoneId(val value: String) {
    init {
        require(value.contains("/") || value == "UTC") {
            "Timezone must be IANA format (e.g. \"America/New_York\") or \"UTC\""
        }
    }
}
