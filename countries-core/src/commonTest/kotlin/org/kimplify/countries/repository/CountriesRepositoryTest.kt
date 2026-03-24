package org.kimplify.countries.repository

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue
import org.kimplify.countries.model.Alpha2Code
import org.kimplify.countries.model.Alpha3Code
import org.kimplify.countries.model.CallingCode
import org.kimplify.countries.model.Continent
import org.kimplify.countries.model.CurrencyCode
import org.kimplify.countries.model.NumericCode
import org.kimplify.countries.model.Region
import org.kimplify.countries.testdata.TestCountries

class CountriesRepositoryTest {

    private val repository = InMemoryCountriesRepository(TestCountries.sampleCountries)

    @Test
    fun getAllReturnsExactlyTheIndexedCountries() {
        assertEquals(TestCountries.sampleCountries, repository.getAll())
    }

    @Test
    fun canFindCountriesByAllCodeTypes() {
        assertEquals(
            TestCountries.unitedStates,
            repository.findByAlpha2(Alpha2Code("US"))
        )
        assertEquals(
            TestCountries.unitedKingdom,
            repository.findByAlpha3(Alpha3Code("GBR"))
        )
        assertEquals(
            TestCountries.france,
            repository.findByNumeric(NumericCode("250"))
        )

        assertNull(repository.findByAlpha2(Alpha2Code("ZZ")))
        assertNull(repository.findByAlpha3(Alpha3Code("ZZZ")))
        assertNull(repository.findByNumeric(NumericCode("999")))
    }

    @Test
    fun searchByNameIsCaseInsensitiveAndIgnoresSurroundingWhitespace() {
        val results = repository.searchByName(" united ")
        assertEquals(
            listOf(TestCountries.unitedStates, TestCountries.unitedKingdom),
            results
        )
    }

    @Test
    fun searchByNameReturnsEmptyForBlankQueries() {
        assertTrue(repository.searchByName("   ").isEmpty())
    }

    @Test
    fun canFindCountriesByContinent() {
        val result = repository.getByContinent(Continent.NORTH_AMERICA)
        assertEquals(2, result.size)
        assertTrue(result.all { it.continent == Continent.NORTH_AMERICA })
    }

    @Test
    fun canFindCountriesByRegion() {
        val result = repository.getByRegion(Region.NORTHERN_AMERICA)
        assertEquals(2, result.size)
    }

    @Test
    fun canFindCountriesByCallingCode() {
        val result = repository.getByCallingCode(CallingCode("+1"))
        assertEquals(2, result.size)
    }

    @Test
    fun canFindCountriesByCurrency() {
        val result = repository.getByCurrency(CurrencyCode("EUR"))
        assertEquals(1, result.size)
        assertEquals("FR", result.first().alpha2.value)
    }
}
