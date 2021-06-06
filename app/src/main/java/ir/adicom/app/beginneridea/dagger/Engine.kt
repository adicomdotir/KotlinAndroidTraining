package ir.adicom.app.beginneridea.dagger

import android.util.Log
import javax.inject.Inject

class Engine @Inject constructor() {
    init {
        Log.e("TAG", "Engine created")
    }
}
