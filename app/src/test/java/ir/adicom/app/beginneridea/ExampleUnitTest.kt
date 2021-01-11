package ir.adicom.app.beginneridea

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ExampleUnitTest {
    private lateinit var primeNumbers: PrimeNumbers

    @Before
    fun init() {
        primeNumbers = PrimeNumbers()
    }

    @Test
    fun testOne() {
        assertEquals(getList(), primeNumbers.generate(1))
    }

    @Test
    fun testTwo() {
        assertEquals(getList(2), primeNumbers.generate(2))
    }

    @Test
    fun testThree() {
        assertEquals(getList(3), primeNumbers.generate(3))
    }

    @Test
    fun testFour() {
        assertEquals(getList(2, 2), primeNumbers.generate(4))
    }

    @Test
    fun testSix() {
        assertEquals(getList(2, 3), primeNumbers.generate(6))
    }

    @Test
    fun testEight() {
        assertEquals(getList(2, 2, 2), primeNumbers.generate(8))
    }

    @Test
    fun testNine() {
        assertEquals(getList(3, 3), primeNumbers.generate(9))
    }

    @Test
    fun testTen() {
        assertEquals(getList(2, 5), primeNumbers.generate(10))
    }

    private fun getList(vararg numbers: Int): MutableList<Int> {
        val list = mutableListOf<Int>()
        for (number in numbers) {
            list.add(number)
        }
        return list
    }
}
