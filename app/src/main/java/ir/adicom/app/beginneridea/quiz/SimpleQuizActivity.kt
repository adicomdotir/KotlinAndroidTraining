package ir.adicom.app.beginneridea.quiz

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ir.adicom.app.beginneridea.R
import kotlin.math.floor

class SimpleQuizActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_quiz)

        var rand: Int = floor(Math.random() * countries.size).toInt()
        while (rand % 2 == 1) {
            rand = floor(Math.random() * countries.size).toInt()
        }
        val tvQuestion = findViewById<TextView>(R.id.tv_question)
        tvQuestion.text = "$rand ${countries[rand]} ${countries[rand + 1]}"
    }
}
