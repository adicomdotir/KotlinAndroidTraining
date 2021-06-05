package ir.adicom.app.beginneridea.dagger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.adicom.app.beginneridea.R
import javax.inject.Inject

class DaggerActivity : AppCompatActivity() {

    @Inject
    lateinit var otherCar: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger)

        val carComponent = DaggerCarComponent.builder()
            .horsePower(120)
            .engineCapacity(1000)
            .build()

        carComponent.inject(this)
        otherCar.drive()
    }
}