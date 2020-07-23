package ir.adicom.app.beginneridea.quiz

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ir.adicom.app.beginneridea.R


class EndGameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_game)

        val db = DatabaseHandler(this)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val score = intent.extras.getInt("score").toString()
        tvResult.text = "Your Score is $score"

        val scoreModel = Score()
        scoreModel.setScore(0, "Unknown", score.toInt())
        if (!db.addScore(scoreModel)) {
            Toast.makeText(this, "Error in saving score in db!", Toast.LENGTH_SHORT).show()
        }
        val scoreList = db.getAll()

        val lvHighScore = findViewById<TextView>(R.id.tv_high_scores)
        val sb = StringBuilder()
        sb.append("High Scores").append('\n')
        for ((index, value) in scoreList.withIndex()) {
            sb.append("${index + 1}.${value.username}    ${value.score}").append("\n")
        }
        lvHighScore.text = sb.toString()
    }
}
