package ir.adicom.app.beginneridea.dagger

import android.util.Log
import javax.inject.Inject

class Wheels @Inject constructor(rims: Rims, tires: Tires) {

    init {
        Log.e("TAG", "Wheels created")
    }
}
