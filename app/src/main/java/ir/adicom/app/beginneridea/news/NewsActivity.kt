package ir.adicom.app.beginneridea.news

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.adicom.app.beginneridea.R

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val newsList = DataFakeGenerator.getData(this)
        val recyclerView = findViewById<RecyclerView>(R.id.recycle_view_news)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = NewsAdapter(this, newsList)
        recyclerView.adapter = adapter
    }
}