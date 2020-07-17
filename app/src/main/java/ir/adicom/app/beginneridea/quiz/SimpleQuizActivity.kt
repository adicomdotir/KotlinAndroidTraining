package ir.adicom.app.beginneridea.quiz

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ir.adicom.app.beginneridea.R
import kotlin.math.floor

class SimpleQuizActivity : AppCompatActivity() {

    lateinit var answerOne: Button
    lateinit var answerTwo: Button
    lateinit var answerThree: Button
    lateinit var answerFour: Button
    lateinit var tvScore: TextView
    var correctAnswer: Int = 0
    var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_quiz)

        var rand: Int = floor(Math.random() * countries.size).toInt()
        while (rand % 2 == 1) {
            rand = floor(Math.random() * countries.size).toInt()
        }
        val tvQuestion = findViewById<TextView>(R.id.tv_question)
        tvQuestion.text = "What is capital of ${countries[rand]}?"

        val answers = mutableListOf<Int>()
        correctAnswer = rand + 1
        answers.add(rand + 1)
        for (i in 1..3) {
            var answer = floor(Math.random() * countries.size).toInt()
            while (answer % 2 == 0 || answers.contains(answer)) {
                answer = floor(Math.random() * countries.size).toInt()
            }
            answers.add(answer)
        }
        answers.shuffle()

        answerOne = findViewById(R.id.btn_one)
        answerOne.text = countries[answers[0]]
        answerOne.tag = answers[0]
        answerTwo = findViewById(R.id.btn_two)
        answerTwo.text = countries[answers[1]]
        answerTwo.tag = answers[1]
        answerThree = findViewById(R.id.btn_three)
        answerThree.text = countries[answers[2]]
        answerThree.tag = answers[2]
        answerFour = findViewById(R.id.btn_four)
        answerFour.text = countries[answers[3]]
        answerFour.tag = answers[3]

        answerOne.setOnClickListener(::btnOnClick)
        answerTwo.setOnClickListener(::btnOnClick)
        answerThree.setOnClickListener(::btnOnClick)
        answerFour.setOnClickListener(::btnOnClick)

        tvScore = findViewById(R.id.tv_score)
        tvScore.text = "Score: $score"
    }

    fun btnOnClick(l: View) {
        val btn = findViewById<Button>(l.id)
        if (l.getTag() == correctAnswer) {
            btn.setTextColor(Color.GREEN)
            score += 10
            tvScore.text = "Score: $score"
        } else {
            btn.setTextColor(Color.RED)
            val intent = Intent(this, EndGameActivity::class.java)
            intent.putExtra("score", score)
            startActivity(intent)
        }
    }
}
