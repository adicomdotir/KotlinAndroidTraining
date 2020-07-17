package ir.adicom.app.beginneridea.quiz

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ir.adicom.app.beginneridea.R

class EndGameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_game)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val score = intent.extras.getInt("score").toString()
        tvResult.text = "Your Score is $score"

    }
}
