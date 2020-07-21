package ir.adicom.app.beginneridea.quiz

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
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
    lateinit var answers: MutableList<Int>
    lateinit var tvQuestion: TextView
    lateinit var wrongAnimation: Animation
    var correctAnswer: Int = 0
    var score: Int = 0
    var questionRandomIndex: Int = 0
    var isClick = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_quiz)

        wrongAnimation = AnimationUtils.loadAnimation(this, R.anim.wrong_animation)

        tvQuestion = findViewById(R.id.tv_question)
        answerOne = findViewById(R.id.btn_one)
        answerTwo = findViewById(R.id.btn_two)
        answerThree = findViewById(R.id.btn_three)
        answerFour = findViewById(R.id.btn_four)
        generateQuestion()

        answerOne.setOnClickListener(::btnOnClick)
        answerTwo.setOnClickListener(::btnOnClick)
        answerThree.setOnClickListener(::btnOnClick)
        answerFour.setOnClickListener(::btnOnClick)

        tvScore = findViewById(R.id.tv_score)
        tvScore.text = "Score: $score"
    }

    private fun btnOnClick(l: View) {
        if (!isClick) {
            val btn = findViewById<Button>(l.id)
            if (l.getTag() == correctAnswer) {
//                btn.setTextColor(Color.GREEN)
                score += 10
                tvScore.text = "Score: $score"
                val handler = Handler()
                handler.postDelayed({
                    generateQuestion()
                }, 1500)
                correctAnswerAnimation(btn)
            } else {
//                btn.setTextColor(Color.RED)
                val intent = Intent(this, EndGameActivity::class.java)
                intent.putExtra("score", score)
                val handler = Handler()
                handler.postDelayed({
                    startActivity(intent)
                    finish()
                }, 1500)
                wrongAnswerAnimation(btn)
                btn.startAnimation(wrongAnimation)
            }
            isClick = true
        }
    }

    private fun generateQuestion() {
        isClick = false

        questionRandomIndex = floor(Math.random() * countries.size).toInt()
        while (questionRandomIndex % 2 == 1) {
            questionRandomIndex = floor(Math.random() * countries.size).toInt()
        }

        answers = mutableListOf()
        correctAnswer = questionRandomIndex + 1
        answers.add(questionRandomIndex + 1)
        for (i in 1..3) {
            var answer = floor(Math.random() * countries.size).toInt()
            while (answer % 2 == 0 || answers.contains(answer)) {
                answer = floor(Math.random() * countries.size).toInt()
            }
            answers.add(answer)
        }
        answers.shuffle()

        tvQuestion.text = "What is capital of ${countries[questionRandomIndex]}?"
        answerOne.text = countries[answers[0]]
        answerOne.tag = answers[0]
        answerOne.setTextColor(resources.getColor(R.color.colorA))
        answerOne.setBackgroundDrawable(resources.getDrawable(R.drawable.btn_custom))
        answerTwo.text = countries[answers[1]]
        answerTwo.tag = answers[1]
        answerTwo.setTextColor(resources.getColor(R.color.colorA))
        answerTwo.setBackgroundDrawable(resources.getDrawable(R.drawable.btn_custom))
        answerThree.text = countries[answers[2]]
        answerThree.tag = answers[2]
        answerThree.setTextColor(resources.getColor(R.color.colorA))
        answerThree.setBackgroundDrawable(resources.getDrawable(R.drawable.btn_custom))
        answerFour.text = countries[answers[3]]
        answerFour.tag = answers[3]
        answerFour.setTextColor(resources.getColor(R.color.colorA))
        answerFour.setBackgroundDrawable(resources.getDrawable(R.drawable.btn_custom))
    }

    private fun wrongAnswerAnimation(view: View) {
        val colorAnimation =
            ValueAnimator.ofObject(ArgbEvaluator(), Color.WHITE, Color.RED)
        colorAnimation.duration = 300L
        colorAnimation.addUpdateListener { animator ->
            view.setBackgroundColor(animator.animatedValue as Int)
        }
        colorAnimation.start()

        val textColorAnim =
            ValueAnimator.ofObject(ArgbEvaluator(), resources.getColor(R.color.colorA), Color.WHITE)
        textColorAnim.duration = 300L
        textColorAnim.addUpdateListener { animator ->
            val btn: Button = view as Button
            btn.setTextColor(animator.animatedValue as Int)
        }
        textColorAnim.start()
    }

    private fun correctAnswerAnimation(view: View) {
        val colorAnimation =
            ValueAnimator.ofObject(ArgbEvaluator(), Color.WHITE, Color.GREEN)
        colorAnimation.duration = 300L
        colorAnimation.addUpdateListener { animator ->
            view.setBackgroundColor(animator.animatedValue as Int)
        }
        colorAnimation.start()

        val textColorAnim =
            ValueAnimator.ofObject(ArgbEvaluator(), resources.getColor(R.color.colorA), Color.WHITE)
        textColorAnim.duration = 300L
        textColorAnim.addUpdateListener { animator ->
            val btn: Button = view as Button
            btn.setTextColor(animator.animatedValue as Int)
        }
        textColorAnim.start()
    }
}
