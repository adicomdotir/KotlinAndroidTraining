package ir.adicom.app.beginneridea.news

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.adicom.app.beginneridea.R


class NewsAdapter(val context: Context, val newsPost: List<News>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    class NewsViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val newsImage: ImageView
        val title: TextView
        val content: TextView
        val date: TextView

        init {
            newsImage = itemView.findViewById<View>(R.id.item_image) as ImageView
            title = itemView.findViewById<View>(R.id.news_title) as TextView
            content = itemView.findViewById<View>(R.id.news_content) as TextView
            date = itemView.findViewById<View>(R.id.news_date) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int = newsPost.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val post = newsPost[position]
        holder.title.text = post.title
        holder.content.text = post.content
        holder.date.text = post.date
        holder.newsImage.setImageDrawable(post.postImage)
    }
}