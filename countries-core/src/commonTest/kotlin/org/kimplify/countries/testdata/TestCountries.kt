package org.kimplify.countries.testdata

import org.kimplify.countries.model.Alpha2Code
import org.kimplify.countries.model.Alpha3Code
import org.kimplify.countries.model.Country
import org.kimplify.countries.model.CountryName
import org.kimplify.countries.model.FlagEmoji
import org.kimplify.countries.model.NumericCode

internal object TestCountries {
    val unitedStates = Country(
        alpha2 = Alpha2Code("US"),
        alpha3 = Alpha3Code("USA"),
        numeric = NumericCode("840"),
        name = CountryName("United States of America (the)"),
        flag = FlagEmoji("\uD83C\uDDFA\uD83C\uDDF8"),
        displayName = "United States",
        native = "United States"
    )

    val unitedKingdom = Country(
        alpha2 = Alpha2Code("GB"),
        alpha3 = Alpha3Code("GBR"),
        numeric = NumericCode("826"),
        name = CountryName("United Kingdom of Great Britain and Northern Ireland (the)"),
        flag = FlagEmoji("\uD83C\uDDEC\uD83C\uDDE7"),
        displayName = "United Kingdom",
        native = "United Kingdom"
    )

    val canada = Country(
        alpha2 = Alpha2Code("CA"),
        alpha3 = Alpha3Code("CAN"),
        numeric = NumericCode("124"),
        name = CountryName("Canada"),
        flag = FlagEmoji("\uD83C\uDDE8\uD83C\uDDE6")
    )

    val france = Country(
        alpha2 = Alpha2Code("FR"),
        alpha3 = Alpha3Code("FRA"),
        numeric = NumericCode("250"),
        name = CountryName("France"),
        flag = FlagEmoji("\uD83C\uDDEB\uD83C\uDDF7")
    )

    val sampleCountries = listOf(
        unitedStates,
        unitedKingdom,
        canada,
        france
    )
}
