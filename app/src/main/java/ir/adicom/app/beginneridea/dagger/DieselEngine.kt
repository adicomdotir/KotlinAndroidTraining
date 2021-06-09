package ir.adicom.app.beginneridea.dagger

import android.util.Log
import javax.inject.Inject
import javax.inject.Named

class DieselEngine @Inject constructor() : Engine {
    override fun start() {
        Log.e("TAG", "diesel engine started, Horse Power = 0 Engine Capacity = 0")
    }
}