package ir.adicom.app.beginneridea.quiz

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import ir.adicom.app.beginneridea.R
import java.util.*
import kotlin.math.floor


class SimpleQuizActivity : AppCompatActivity() {

    lateinit var answerOne: Button
    lateinit var answerTwo: Button
    lateinit var answerThree: Button
    lateinit var answerFour: Button
    lateinit var tvScore: TextView
    lateinit var tvUsername: TextView
    lateinit var answers: MutableList<Int>
    private lateinit var tvQuestion: TextView
    lateinit var wrongAnimation: Animation
    private val questionArray = mutableListOf<Int>()
    private var correctAnswer: Int = 0
    var score: Int = 0
    var questionRandomIndex: Int = 0
    var isClick = false
    var userName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_quiz)

        getUsername()

        wrongAnimation = AnimationUtils.loadAnimation(this, R.anim.wrong_animation)

        tvQuestion = findViewById(R.id.tv_question)
        answerOne = findViewById(R.id.btn_one)
        answerTwo = findViewById(R.id.btn_two)
        answerThree = findViewById(R.id.btn_three)
        answerFour = findViewById(R.id.btn_four)

        answerOne.setOnClickListener(::btnOnClick)
        answerTwo.setOnClickListener(::btnOnClick)
        answerThree.setOnClickListener(::btnOnClick)
        answerFour.setOnClickListener(::btnOnClick)

        tvScore = findViewById(R.id.tv_score)
        tvUsername = findViewById(R.id.tv_username)
        tvScore.text = String.format(Locale.ENGLISH, "Score: %s", score.toString())
    }

    private fun getUsername() {
        val alert: AlertDialog.Builder = AlertDialog.Builder(this)
        alert.setTitle("What is your name?")
        alert.setCancelable(false)
        val linearLayout = LinearLayout(this)
        linearLayout.setPadding(32, 0, 32, 0)
        val input = EditText(this)

        val lp = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        input.layoutParams = lp

        val rand: Int = (floor(Math.random() * 89999) + 10000).toInt()
        input.text = Editable.Factory.getInstance().newEditable("Player$rand")
        linearLayout.addView(input)
        alert.setView(linearLayout)

        alert.setPositiveButton("Confirm",
            DialogInterface.OnClickListener { dialog, whichButton ->
                userName = input.text.toString()
                if (userName.trim().isEmpty()) {
                    val randNumber: Int = (floor(Math.random() * 89999) + 10000).toInt()
                    userName = "Player$randNumber"
                }
                tvUsername.text = userName
                visibileQuestionAndAnswer()
                generateQuestion()
                return@OnClickListener
            })
        alert.show()
    }

    private fun visibileQuestionAndAnswer() {
        tvQuestion.visibility = View.VISIBLE
        answerOne.visibility = View.VISIBLE
        answerTwo.visibility = View.VISIBLE
        answerThree.visibility = View.VISIBLE
        answerFour.visibility = View.VISIBLE
    }

    private fun btnOnClick(l: View) {
        if (!isClick) {
            val btn = findViewById<Button>(l.id)
            if (l.tag == correctAnswer) {
                score += 10
                tvScore.text = String.format(Locale.ENGLISH, "Score: %s", score.toString())
                val handler = Handler()
                handler.postDelayed({
                    generateQuestion()
                }, 1500)
                correctAnswerAnimation(btn)
            } else {
//                btn.setTextColor(Color.RED)
                val intent = Intent(this, EndGameActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("username", userName)
                val handler = Handler()
                handler.postDelayed({
                    startActivity(intent)
                    finish()
                }, 1500)
                wrongAnswerAnimation(btn)
                showCorrectAnswer()
                btn.startAnimation(wrongAnimation)
            }
            isClick = true
        }
    }

    private fun pushRightInAnimation(view: View) {
        val animFadein =
            AnimationUtils.loadAnimation(applicationContext, R.anim.push_left_in)
        view.startAnimation(animFadein)
    }

    private fun showCorrectAnswer() {
        val arrayOfButton = arrayOf(answerOne, answerTwo, answerThree, answerFour)
        for (btn in arrayOfButton) {
            if (btn.tag == correctAnswer) {
                correctAnswerAnimation(btn)
            }
        }
    }

    private fun isQuestionDuplicate(id: Int): Boolean {
        return questionArray.contains(id)
    }

    private fun generateQuestion() {
        isClick = false

        questionRandomIndex = floor(Math.random() * countries.size).toInt()
        while (questionRandomIndex % 2 == 1 || isQuestionDuplicate(questionRandomIndex)) {
            questionRandomIndex = floor(Math.random() * countries.size).toInt()
        }
        questionArray.add(questionRandomIndex)
        questionArray.sort()

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

        tvQuestion.text =
            String.format(Locale.ENGLISH, "What is capital of %s?", countries[questionRandomIndex])
        pushRightInAnimation(tvQuestion)
        answerOne.text = countries[answers[0]]
        answerOne.tag = answers[0]
        answerOne.setTextColor(resources.getColor(R.color.colorA))
        answerOne.setBackgroundDrawable(resources.getDrawable(R.drawable.btn_custom))
        pushRightInAnimation(answerOne)
        answerTwo.text = countries[answers[1]]
        answerTwo.tag = answers[1]
        answerTwo.setTextColor(resources.getColor(R.color.colorA))
        answerTwo.setBackgroundDrawable(resources.getDrawable(R.drawable.btn_custom))
        pushRightInAnimation(answerTwo)
        answerThree.text = countries[answers[2]]
        answerThree.tag = answers[2]
        answerThree.setTextColor(resources.getColor(R.color.colorA))
        answerThree.setBackgroundDrawable(resources.getDrawable(R.drawable.btn_custom))
        pushRightInAnimation(answerThree)
        answerFour.text = countries[answers[3]]
        answerFour.tag = answers[3]
        answerFour.setTextColor(resources.getColor(R.color.colorA))
        answerFour.setBackgroundDrawable(resources.getDrawable(R.drawable.btn_custom))
        pushRightInAnimation(answerFour)
    }

    private fun wrongAnswerAnimation(view: View) {
        val colorAnimation =
            ValueAnimator.ofObject(
                ArgbEvaluator(),
                Color.WHITE,
                resources.getColor(R.color.wrongAnswer)
            )
        colorAnimation.duration = 250L
        colorAnimation.addUpdateListener { animator ->
            view.setBackgroundColor(animator.animatedValue as Int)
        }
        colorAnimation.start()

        val textColorAnim =
            ValueAnimator.ofObject(ArgbEvaluator(), resources.getColor(R.color.colorA), Color.WHITE)
        textColorAnim.duration = 250L
        textColorAnim.addUpdateListener { animator ->
            val btn: Button = view as Button
            btn.setTextColor(animator.animatedValue as Int)
        }
        textColorAnim.start()
    }

    private fun correctAnswerAnimation(view: View) {
        val colorAnimation =
            ValueAnimator.ofObject(
                ArgbEvaluator(),
                Color.WHITE,
                resources.getColor(R.color.correctAnswer)
            )
        colorAnimation.duration = 250L
        colorAnimation.addUpdateListener { animator ->
            view.setBackgroundColor(animator.animatedValue as Int)
        }
        colorAnimation.start()

        val textColorAnim =
            ValueAnimator.ofObject(ArgbEvaluator(), resources.getColor(R.color.colorA), Color.WHITE)
        textColorAnim.duration = 250L
        textColorAnim.addUpdateListener { animator ->
            val btn: Button = view as Button
            btn.setTextColor(animator.animatedValue as Int)
        }
        textColorAnim.start()
    }
}
