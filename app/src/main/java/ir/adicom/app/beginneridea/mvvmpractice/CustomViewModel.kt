package ir.adicom.app.beginneridea.mvvmpractice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class CustomViewModel : ViewModel() {
    fun generate() {
        val rnd = Random(System.currentTimeMillis())
        customString.postValue(rnd.nextInt().toString())
    }

    val customString: MutableLiveData<String> = MutableLiveData()

}