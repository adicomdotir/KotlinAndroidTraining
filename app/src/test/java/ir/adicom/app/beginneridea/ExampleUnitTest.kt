package ir.adicom.app.beginneridea

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ExampleUnitTest {
    private lateinit var stringCalculator: StringCalculator

    @Before
    fun init() {
        stringCalculator = StringCalculator()
    }

    @Test
    fun emptyString() {
        val res = stringCalculator.add("")
        assertEquals(0, res)
    }

    @Test
    fun oneNumberInString() {
        val res = stringCalculator.add("1")
        assertEquals(1, res)
    }

    @Test
    fun twoNumberInString() {
        val res = stringCalculator.add("1,2")
        assertEquals(3, res)
    }

    @Test
    fun unknownNumberInString() {
        val res = stringCalculator.add("1,2,3,4,5")
        assertEquals(15, res)
    }

    @Test
    fun newLineInString() {
        val res = stringCalculator.add("1,2\n3")
        assertEquals(6, res)
    }
}
