package ir.adicom.app.beginneridea.espresso

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.adicom.app.beginneridea.R
import kotlinx.android.synthetic.main.activity_some_text.*


class SomeTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_some_text)

        val message = intent.getStringExtra(KEY_EXTRA_MESSAGE)
        show_text_view.setText(message)
    }

    companion object {
        val KEY_EXTRA_MESSAGE = "com.example.android.testing.espresso.basicsample.MESSAGE"

        fun newStartIntent(context: Context?, message: String?): Intent? {
            val newIntent = Intent(context, SomeTextActivity::class.java)
            newIntent.putExtra(KEY_EXTRA_MESSAGE, message)
            return newIntent
        }
    }
}