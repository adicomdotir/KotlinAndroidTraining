package ir.adicom.app.beginneridea.dagger

import android.util.Log
import javax.inject.Inject
import javax.inject.Named

class DieselEngine @Inject constructor(
    @Named("horse power") private var powerHorse: Int,
    @Named("engine capacity") private var engineCapacity: Int
) : Engine {

    override fun start() {
        Log.e(
            "TAG",
            "start petrol engine, Power Horse = $powerHorse, Engine Capacity = $engineCapacity"
        )
    }
}