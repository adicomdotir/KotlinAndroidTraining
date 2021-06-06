package ir.adicom.app.beginneridea.dagger

import android.util.Log
import javax.inject.Inject

class Car @Inject constructor(val engine: Engine, val wheels: Wheels) {
    @Inject lateinit var remote: Remote

    init {
        Log.e("TAG", "Car created")
    }

    @Inject
    fun inflateRemote() {
        remote.inflateRemote()
    }

    fun drive() {
        engine.start()
        Log.e("TAG", "driving ...")
    }
}
