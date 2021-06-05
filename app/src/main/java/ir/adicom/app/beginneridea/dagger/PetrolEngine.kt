package ir.adicom.app.beginneridea.dagger

import android.util.Log

class PetrolEngine(private var powerHorse: Int, private var engineCapacity: Int): Engine {

    override fun start() {
        Log.e("TAG", "start petrol engine, Power Horse = $powerHorse, Engine Capacity = $engineCapacity")
    }
}