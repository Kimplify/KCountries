package org.kimplify.countries

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import org.kimplify.countries.model.Alpha2Code

class CountriesTest {

    @Test
    fun repositoryExposesAllCountriesFromDataset() {
        val countries = Countries.repository.getAll()
        assertEquals(Countries.TOTAL_COUNTRIES, countries.size)
        assertTrue(countries.any { it.alpha2.value == "US" })
    }

    @Test
    fun canResolveKnownCountryViaDefaultRepository() {
        val country = Countries.repository.findByAlpha2(Alpha2Code("US"))
        requireNotNull(country)
        assertEquals("USA", country.alpha3.value)
    }
}
