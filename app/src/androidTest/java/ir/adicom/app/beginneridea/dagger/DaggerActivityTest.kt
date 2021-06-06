package ir.adicom.app.beginneridea.dagger

import org.junit.Assert.*
import org.junit.Test

class DaggerActivityTest {
    @Test
    fun daggerTest() {
        val carComponent = DaggerCarComponent.create()
        carComponent.getCar().drive()
    }
}