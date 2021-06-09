package ir.adicom.app.beginneridea.dagger

import android.util.Log
import javax.inject.Inject
import javax.inject.Named

class PetrolEngine @Inject constructor(@Named("horsePower") private val horsePower: Int, @Named("engineCapacity") private val engineCapacity: Int) : Engine {
    override fun start() {
        Log.e("TAG", "petrol engine started, Horse Power = $horsePower, Engine Capacity = $engineCapacity")
    }
}