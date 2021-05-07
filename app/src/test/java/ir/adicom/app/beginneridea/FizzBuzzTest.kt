package ir.adicom.app.beginneridea

import org.junit.Assert.assertEquals
import org.junit.Test

class FizzBuzzTest {

    @Test
    fun numberOne() {
        assertEquals("1", returnNumber(1))
    }

    @Test
    fun numberTwo() {
        assertEquals("2", returnNumber(2))
    }

    @Test
    fun numberThree() {
        assertEquals("Fizz", returnNumber(3))
    }

    @Test
    fun numberFive() {
        assertEquals("Buzz", returnNumber(5))
    }

    @Test
    fun numberSix() {
        assertEquals("Fizz", returnNumber(6))
    }

    @Test
    fun numberTen() {
        assertEquals("Buzz", returnNumber(10))
    }

    @Test
    fun numberFifteen() {
        assertEquals("FizzBuzz", returnNumber(15))
    }

    @Test
    fun numberThirty() {
        assertEquals("FizzBuzz", returnNumber(30))
    }

     @Test
     fun numbersCustom() {
         assertEquals("Fizz", returnNumber(81))
         assertEquals("Buzz", returnNumber(250))
         assertEquals("343", returnNumber(343))
         assertEquals("FizzBuzz", returnNumber(615))
     }

    private fun returnNumber(n: Int): String {
        if (n % 15 == 0) {
            return "FizzBuzz"
        }
        if (n % 3 == 0) {
            return "Fizz"
        }
        if (n % 5 == 0) {
            return "Buzz"
        }
        return n.toString()
    }
}