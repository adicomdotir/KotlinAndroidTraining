package ir.adicom.app.beginneridea.dagger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.adicom.app.beginneridea.R
import kotlinx.android.synthetic.main.activity_dagger.*

class DaggerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger)

        val connector: Connector = DaggerConnector.create()
        val hero: Hero = connector.injectPower()

        tv_dagger_message.text = hero.toString()

    }
}