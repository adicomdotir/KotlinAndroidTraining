package ir.adicom.app.beginneridea.dagger

import android.util.Log
import javax.inject.Inject

class DieselEngine @Inject constructor() : Engine {
    override fun start() {
        Log.e("TAG", "diesel engine started")
    }
}