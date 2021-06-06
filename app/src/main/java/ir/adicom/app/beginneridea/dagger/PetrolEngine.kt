package ir.adicom.app.beginneridea.dagger

import android.util.Log

class PetrolEngine(private val horsePower: Int) : Engine {
    override fun start() {
        Log.e("TAG", "petrol engine started, horse power = $horsePower")
    }
}