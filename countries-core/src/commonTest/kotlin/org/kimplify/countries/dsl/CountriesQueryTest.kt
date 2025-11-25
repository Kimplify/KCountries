package org.kimplify.countries.dsl

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue
import org.kimplify.countries.repository.InMemoryCountriesRepository
import org.kimplify.countries.testdata.TestCountries

class CountriesQueryTest {

    private val repository = InMemoryCountriesRepository(TestCountries.sampleCountries)

    @Test
    fun alphaAndNumericFiltersMatchRegardlessOfInputCase() {
        val alpha2Match = repository.query {
            alpha2("us")
        }.firstOrNull()
        assertEquals(TestCountries.unitedStates, alpha2Match)

        val alpha3Match = repository.query {
            alpha3("gBr")
        }.first()
        assertEquals(TestCountries.unitedKingdom, alpha3Match)

        val numericMatch = repository.query {
            numeric("250")
        }.first()
        assertEquals(TestCountries.france, numericMatch)
    }

    @Test
    fun canCombinePredicatesWithAndLogic() {
        val results = repository.query {
            nameContains("United")
            nameStartsWith("United")
        }.toList()

        assertEquals(
            listOf(TestCountries.unitedStates, TestCountries.unitedKingdom),
            results
        )
    }

    @Test
    fun orBlockMatchesAnyNestedPredicate() {
        val results = repository.query {
            or {
                alpha2("ca")
                alpha3("fra")
            }
        }.toList()

        assertEquals(listOf(TestCountries.canada, TestCountries.france), results)
    }

    @Test
    fun queryResultHelpersReflectMatches() {
        val result = repository.query {
            alpha2("GB")
        }

        assertNotNull(result.firstOrNull())
        assertEquals(TestCountries.unitedKingdom, result.first())
        assertEquals(listOf(TestCountries.unitedKingdom), result.toList())
        assertEquals(1, result.count())
        assertTrue(result.isNotEmpty())
        assertFalse(result.isEmpty())
    }

    @Test
    fun queryResultFirstThrowsWhenNoMatches() {
        val result = repository.query {
            nameEquals("Atlantis")
        }

        assertTrue(result.isEmpty())
        assertNull(result.firstOrNull())
        assertFailsWith<NoSuchElementException> {
            result.first()
        }
    }
}
