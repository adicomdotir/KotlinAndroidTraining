package ir.adicom.app.beginneridea.dagger

import android.util.Log

class PetrolEngine(private val horsePower: Int, private val engineCapacity: Int) : Engine {
    override fun start() {
        Log.e("TAG", "petrol engine started, Horse Power = $horsePower, Engine Capacity = $engineCapacity")
    }
}