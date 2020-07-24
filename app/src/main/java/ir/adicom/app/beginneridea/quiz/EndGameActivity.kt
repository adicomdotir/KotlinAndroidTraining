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
        val score = intent?.extras?.getInt("score")
        val userName = intent?.extras?.getString("username")
        tvResult.text = String.format("Your score is %s", score)

        val scoreModel = Score()
        scoreModel.setScore(0, userName!!, score!!)
        if (!db.addScore(scoreModel)) {
            Toast.makeText(this, "Error in saving score in db!", Toast.LENGTH_SHORT).show()
        }
        val scoreList = db.getAll()

        val tvRowNumber = findViewById<TextView>(R.id.tv_row_number)
        val tvUserName = findViewById<TextView>(R.id.tv_username)
        val tvScore = findViewById<TextView>(R.id.tv_score)
        val sbRowNumber = StringBuilder()
        val sbUserName = StringBuilder()
        val sbScore = StringBuilder()
        sbRowNumber.append("#").append('\n').append('\n')
        sbUserName.append("Name").append('\n').append('\n')
        sbScore.append("Score").append('\n').append('\n')
        for ((index, value) in scoreList.withIndex()) {
            sbRowNumber.append("${index + 1}").append('\n')
            sbUserName.append(value.username).append('\n')
            sbScore.append("${value.score}").append('\n')
        }
        tvRowNumber.text = sbRowNumber
        tvUserName.text = sbUserName
        tvScore.text = sbScore
    }
}
