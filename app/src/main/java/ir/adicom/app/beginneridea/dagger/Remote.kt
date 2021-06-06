package ir.adicom.app.beginneridea.dagger

import android.util.Log
import javax.inject.Inject

class Remote @Inject constructor() {
    fun inflateRemote() {
        Log.e("TAG", "remote connected")
    }

}
