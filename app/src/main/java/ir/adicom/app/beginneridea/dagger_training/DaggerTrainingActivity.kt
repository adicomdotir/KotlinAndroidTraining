package ir.adicom.app.beginneridea.dagger_training

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.adicom.app.beginneridea.R
import javax.inject.Inject

class DaggerTrainingActivity : AppCompatActivity() {

    private lateinit var targetClass: TargetClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_training)

        targetClass = DaggerMyComponent.builder()
            .build()
            .getMySubcomponent()
            .getTargetClass()

        targetClass.iAmOk()
    }
}