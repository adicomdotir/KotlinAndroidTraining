package ir.adicom.app.beginneridea.dagger

import android.util.Log
import javax.inject.Inject

class Car @Inject constructor(wheels: Wheels) {
    @Inject lateinit var engine: Engine
    @Inject lateinit var remote: Remote

    init {
        Log.e("TAG", "Car created")
    }

    @Inject
    fun inflateRemote() {
        remote.inflateRemote()
    }

    fun drive() {
        Log.e("TAG", "driving ...")
    }
}
