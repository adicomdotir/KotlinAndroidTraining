package ir.adicom.app.beginneridea.coroutine

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ir.adicom.app.beginneridea.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutineSampleActivity : AppCompatActivity() {

    private lateinit var tvMessage: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_sample)

        val gr = GithubRepository()
        tvMessage = findViewById(R.id.tv_message)
        progressBar = findViewById(R.id.progressBar)
        tvMessage.text = "Fetching data ..."

        CoroutineScope(Dispatchers.Default).launch {
            val count = gr.getTodo().size
            Log.e("TAG", count.toString())

            withContext(Dispatchers.Main) {
                tvMessage.text = "Count $count"
                progressBar.visibility = View.INVISIBLE

            }
        }
    }
}
