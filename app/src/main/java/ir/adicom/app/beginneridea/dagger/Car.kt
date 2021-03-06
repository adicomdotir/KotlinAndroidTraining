package ir.adicom.app.beginneridea.dagger

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@PerActivityScope
class Car @Inject constructor(val driver: Driver, val engine: Engine, val wheels: Wheels) {
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
        Log.e("TAG", "driver $driver, drives $this")
    }
}
