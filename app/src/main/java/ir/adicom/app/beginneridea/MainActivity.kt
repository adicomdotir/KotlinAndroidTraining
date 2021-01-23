package ir.adicom.app.beginneridea

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ir.adicom.app.beginneridea.bin2dec.Bin2DecActivity
import ir.adicom.app.beginneridea.boutique.BoutiqueActivity
import ir.adicom.app.beginneridea.coroutine.CoroutineSampleActivity
import ir.adicom.app.beginneridea.dagger.DaggerActivity
import ir.adicom.app.beginneridea.databinding.ActivityMainBinding
import ir.adicom.app.beginneridea.news.NewsActivity
import ir.adicom.app.beginneridea.quiz.SimpleQuizActivity
import ir.adicom.app.beginneridea.rgb2hex.ColorToHexActivity
import ir.adicom.app.beginneridea.taskappmvvm.ui.tasks.TasksActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

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

        // Using kotlin extension for binding
        btn_task_app.setOnClickListener {
            val intent = Intent(this, TasksActivity::class.java)
            startActivity(intent)
        }

        btn_dagger.setOnClickListener {
            val intent = Intent(this, DaggerActivity::class.java)
            startActivity(intent)
        }

        btn_news.setOnClickListener {
            val intent = Intent(this, NewsActivity::class.java)
            startActivity(intent)
        }

        // Using view binding for binding
        activityMainBinding.btnBoutique.setOnClickListener {
            val intent = Intent(this, BoutiqueActivity::class.java)
            startActivity(intent)
        }
    }
}
