package ir.adicom.app.beginneridea.quiz

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ir.adicom.app.beginneridea.R


class EndGameActivity : AppCompatActivity() {

    private val MyPREFERENCES: String = "HighScores"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_game)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val score = intent.extras.getInt("score").toString()
        tvResult.text = "Your Score is $score"

        val sharedpreferences =
            getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE)
        val listOfScoreInString = sharedpreferences.getString("HighScore", "0").split(",")
        val listOfScore = mutableListOf<Int>()
        for (scoreString in listOfScoreInString) {
            listOfScore.add(scoreString.toInt())
        }
        listOfScore.add(score.toInt())
        listOfScore.sortDescending()
        sharedpreferences.edit().putString("HighScore", listOfScore.joinToString(","))
        sharedpreferences.apply { }

        val lvHighScore = findViewById<TextView>(R.id.tv_high_scores)
        val sb = StringBuilder()
        sb.append("High Scores").append('\n')
        for ((index, value) in listOfScore.withIndex()) {
            sb.append("${index + 1}. $value").append("\n")
        }
        lvHighScore.text = sb.toString()
    }
}
