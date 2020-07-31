package ir.adicom.app.beginneridea

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ir.adicom.app.beginneridea.bin2dec.Bin2DecActivity
import ir.adicom.app.beginneridea.coroutine.CoroutineSampleActivity
import ir.adicom.app.beginneridea.quiz.SimpleQuizActivity
import ir.adicom.app.beginneridea.rgb2hex.ColorToHexActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bin2decBtn = findViewById<Button>(R.id.btn_bin2dec)
        bin2decBtn.setOnClickListener {
            val intent = Intent(this, Bin2DecActivity::class.java)
            startActivity(intent)
        }

        val rgb2hexBtn = findViewById<Button>(R.id.btn_rgb2hex)
        rgb2hexBtn.setOnClickListener {
            val intent = Intent(this, ColorToHexActivity::class.java)
            startActivity(intent)
        }

        val quizAppBtn = findViewById<Button>(R.id.btn_quiz_app)
        quizAppBtn.setOnClickListener {
            val intent = Intent(this, SimpleQuizActivity::class.java)
            startActivity(intent)
        }

        val coroutineBtn = findViewById<Button>(R.id.btn_coroutine)
        coroutineBtn.setOnClickListener {
            val intent = Intent(this, CoroutineSampleActivity::class.java)
            startActivity(intent)
        }
    }
}
