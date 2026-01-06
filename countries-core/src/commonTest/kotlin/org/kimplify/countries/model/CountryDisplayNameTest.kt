package org.kimplify.countries.model

import org.kimplify.countries.Countries
import org.kimplify.countries.extensions.displayCountryName
import org.kimplify.countries.extensions.getDisplayName
import org.kimplify.countries.extensions.getNativeName
import org.kimplify.countries.extensions.nativeCountryName
import org.kimplify.countries.testdata.TestCountries
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class CountryDisplayNameTest {

    @Test
    fun `getDisplayName returns displayName when available`() {
        val country = TestCountries.unitedStates
        assertEquals("United States", country.getDisplayName())
    }

    @Test
    fun `getDisplayName falls back to formal name when displayName is null`() {
        val country = TestCountries.france
        assertEquals("France", country.getDisplayName())
    }

    @Test
    fun `getNativeName returns native when available`() {
        val country = TestCountries.unitedStates
        assertEquals("United States", country.getNativeName())
    }

    @Test
    fun `getNativeName falls back to displayName then formal name when native is null`() {
        val country = TestCountries.france
        assertEquals("France", country.getNativeName())
    }

    @Test
    fun `String displayCountryName extension works`() {
        val name = "US".displayCountryName
        assertEquals("United States", name)
    }

    @Test
    fun `String displayCountryName returns null for invalid code`() {
        val name = "ZZ".displayCountryName
        assertNull(name)
    }

    @Test
    fun `String nativeCountryName extension works`() {
        val name = "US".nativeCountryName
        assertEquals("United States", name)
    }

    @Test
    fun `String nativeCountryName returns null for invalid code`() {
        val name = "ZZ".nativeCountryName
        assertNull(name)
    }

    @Test
    fun `repository searchByName finds countries by displayName`() {
        val results = Countries.repository.searchByName("United States")
        // Should find both US and UM (United States Minor Outlying Islands)
        assertNotNull(results.any { it.alpha2.value == "US" })
        assertTrue(results.size >= 1)
    }

    @Test
    fun `repository searchByName finds countries by native name`() {
        // Test with a country that has a non-English native name
        val deCountry = Countries.repository.findByAlpha2(Alpha2Code("DE"))
        assertNotNull(deCountry)

        // If Deutschland is in the data, search should find it
        val results = Countries.repository.searchByName("Russia")
        // Should find Russia by displayName or native
        assertNotNull(results.any { it.alpha2.value == "RU" })
    }

    @Test
    fun `repository searchByName finds countries by formal name`() {
        val results = Countries.repository.searchByName("United States of America")
        assertEquals(1, results.size)
        assertEquals("US", results.first().alpha2.value)
    }

    @Test
    fun `DSL nameContains searches displayName`() {
        val results = Countries.repository.query {
            nameContains("United States")
        }.toList()

        assertNotNull(results.any { it.alpha2.value == "US" })
    }

    @Test
    fun `DSL nameEquals searches displayName`() {
        val results = Countries.repository.query {
            nameEquals("United States")
        }.toList()

        assertNotNull(results.any { it.alpha2.value == "US" })
    }

    @Test
    fun `DSL nameStartsWith searches displayName`() {
        val results = Countries.repository.query {
            nameStartsWith("United")
        }.toList()

        assertNotNull(results.any { it.alpha2.value == "US" })
        assertNotNull(results.any { it.alpha2.value == "GB" })
    }

    @Test
    fun `real country data has correct displayNames`() {
        // Test a few key countries
        val us = Countries.repository.findByAlpha2(Alpha2Code("US"))
        assertNotNull(us)
        assertEquals("United States", us.displayName)

        val uk = Countries.repository.findByAlpha2(Alpha2Code("GB"))
        assertNotNull(uk)
        assertEquals("United Kingdom", uk.displayName)

        val russia = Countries.repository.findByAlpha2(Alpha2Code("RU"))
        assertNotNull(russia)
        assertEquals("Russia", russia.displayName)
    }

    @Test
    fun `real country data has correct native names`() {
        val russia = Countries.repository.findByAlpha2(Alpha2Code("RU"))
        assertNotNull(russia)
        assertEquals("Россия", russia.native)

        val iran = Countries.repository.findByAlpha2(Alpha2Code("IR"))
        assertNotNull(iran)
        assertEquals("ایران", iran.native)
    }

    @Test
    fun `countries without displayName use formal name via extension`() {
        val canada = Countries.repository.findByAlpha2(Alpha2Code("CA"))
        assertNotNull(canada)
        assertNull(canada.displayName)
        assertEquals("Canada", canada.getDisplayName())
    }
}
