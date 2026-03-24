package org.kimplify.countries.dsl

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue
import org.kimplify.countries.model.Continent
import org.kimplify.countries.model.Country
import org.kimplify.countries.model.Region
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

    @Test
    fun continentPredicateFiltersCorrectly() {
        val result = repository.query { continent(Continent.EUROPE) }
        assertEquals(2, result.count())
    }

    @Test
    fun regionPredicateFiltersCorrectly() {
        val result = repository.query { region(Region.WESTERN_EUROPE) }
        assertEquals(1, result.count())
    }

    @Test
    fun callingCodePredicateFiltersCorrectly() {
        val result = repository.query { callingCode("+1") }
        assertEquals(2, result.count())
    }

    @Test
    fun currencyPredicateFiltersCorrectly() {
        val result = repository.query { currency("GBP") }
        assertEquals(1, result.count())
    }

    @Test
    fun timezonePredicateFiltersCorrectly() {
        val result = repository.query { timezone("Europe/Paris") }
        assertEquals(1, result.count())
    }

    @Test
    fun queryResultIsIterable() {
        val result = repository.query { continent(Continent.EUROPE) }
        val collected = mutableListOf<Country>()
        for (country in result) {
            collected.add(country)
        }
        assertEquals(result.toList(), collected)
    }

    @Test
    fun notCombinatorExcludesMatchingCountries() {
        val result = repository.query {
            not { continent(Continent.EUROPE) }
        }
        assertTrue(result.toList().none { it.continent == Continent.EUROPE })
        assertEquals(2, result.count()) // US and Canada
    }

    @Test
    fun orWithEmptyBlockDoesNotFilterOutEverything() {
        val result = repository.query {
            or { }
        }
        assertEquals(4, result.count())
    }

    @Test
    fun nameContainsWithBlankStringIsNoOp() {
        val result = repository.query {
            nameContains("")
        }
        assertEquals(4, result.count())
    }
}
