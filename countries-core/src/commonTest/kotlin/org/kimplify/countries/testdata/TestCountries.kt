package org.kimplify.countries.testdata

import org.kimplify.countries.model.Alpha2Code
import org.kimplify.countries.model.Alpha3Code
import org.kimplify.countries.model.CallingCode
import org.kimplify.countries.model.Continent
import org.kimplify.countries.model.Country
import org.kimplify.countries.model.CountryName
import org.kimplify.countries.model.CurrencyCode
import org.kimplify.countries.model.FlagEmoji
import org.kimplify.countries.model.NumericCode
import org.kimplify.countries.model.Region
import org.kimplify.countries.model.TimezoneId

internal object TestCountries {
    val unitedStates = Country(
        alpha2 = Alpha2Code("US"), alpha3 = Alpha3Code("USA"), numeric = NumericCode("840"),
        name = CountryName("United States of America (the)"), flag = FlagEmoji("\uD83C\uDDFA\uD83C\uDDF8"),
        displayName = "United States", native = "United States",
        continent = Continent.NORTH_AMERICA, region = Region.NORTHERN_AMERICA,
        callingCode = CallingCode("+1"), currency = CurrencyCode("USD"), timezone = TimezoneId("America/New_York")
    )

    val unitedKingdom = Country(
        alpha2 = Alpha2Code("GB"), alpha3 = Alpha3Code("GBR"), numeric = NumericCode("826"),
        name = CountryName("United Kingdom of Great Britain and Northern Ireland (the)"), flag = FlagEmoji("\uD83C\uDDEC\uD83C\uDDE7"),
        displayName = "United Kingdom", native = "United Kingdom",
        continent = Continent.EUROPE, region = Region.NORTHERN_EUROPE,
        callingCode = CallingCode("+44"), currency = CurrencyCode("GBP"), timezone = TimezoneId("Europe/London")
    )

    val canada = Country(
        alpha2 = Alpha2Code("CA"), alpha3 = Alpha3Code("CAN"), numeric = NumericCode("124"),
        name = CountryName("Canada"), flag = FlagEmoji("\uD83C\uDDE8\uD83C\uDDE6"),
        continent = Continent.NORTH_AMERICA, region = Region.NORTHERN_AMERICA,
        callingCode = CallingCode("+1"), currency = CurrencyCode("CAD"), timezone = TimezoneId("America/Toronto")
    )

    val france = Country(
        alpha2 = Alpha2Code("FR"), alpha3 = Alpha3Code("FRA"), numeric = NumericCode("250"),
        name = CountryName("France"), flag = FlagEmoji("\uD83C\uDDEB\uD83C\uDDF7"), native = "France",
        continent = Continent.EUROPE, region = Region.WESTERN_EUROPE,
        callingCode = CallingCode("+33"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Europe/Paris")
    )

    val sampleCountries = listOf(
        unitedStates,
        unitedKingdom,
        canada,
        france
    )
}
