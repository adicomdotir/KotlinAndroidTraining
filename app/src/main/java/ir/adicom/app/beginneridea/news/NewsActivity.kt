package ir.adicom.app.beginneridea.news

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ir.adicom.app.beginneridea.R
import ir.adicom.app.beginneridea.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val adapter = NewsAdapter(DataFakeGenerator.getData(this))
        binding.recycleViewNews.adapter = adapter
        binding.recycleViewNews.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
}
