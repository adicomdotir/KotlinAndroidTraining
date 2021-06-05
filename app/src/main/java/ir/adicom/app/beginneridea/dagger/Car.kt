package ir.adicom.app.beginneridea.dagger

import android.util.Log
import javax.inject.Inject

class Car @Inject constructor(engine: Engine, wheels: Wheels) {

    init {
        Log.e("TAG", "Car created")
        engine.start()
    }

    fun drive() {
        Log.e("TAG", "driving ...")
    }
}
