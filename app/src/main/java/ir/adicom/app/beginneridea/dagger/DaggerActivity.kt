package ir.adicom.app.beginneridea.dagger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.adicom.app.beginneridea.R
import javax.inject.Inject

class DaggerActivity : AppCompatActivity() {
    @Inject
    lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger)

        val carComponent = (application as MyApplication).getDriverComponent()
            .getCarComponentBuilder()
            .horsePower(160)
            .engineCapacity(2000)
            .build()

//        val carComponent = (application as MyApplication).getDriverComponent()
//            .getCarComponent()

//        val carComponent = DaggerCarComponent.builder()
//            .driverComponent((application as MyApplication).getDriverComponent())
//            .build()

//        val carComponent = DaggerCarComponent.builder()
//            .driverComponent((application as MyApplication).getDriverComponent())
//            .engineCapacity(2000)
//            .horsePower(120)
//            .build()

        carComponent.inject(this)
        car.drive()

        val car2 = carComponent.getCar()
        car2.drive()
    }
}