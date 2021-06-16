package ir.adicom.app.beginneridea.dagger_training

import android.util.Log
import javax.inject.Inject

class TargetClass @Inject constructor() {
    init {
        Log.e("TAG", "object created")
    }

    fun iAmOk() {
        Log.e("TAG", "I am OK")
    }
}
