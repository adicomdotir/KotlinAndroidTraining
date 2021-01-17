package ir.adicom.app.beginneridea.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.adicom.app.beginneridea.R

class NewsAdapter(val newsList: List<News>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle = itemView.findViewById<TextView>(R.id.news_title)
        val tvContent = itemView.findViewById<TextView>(R.id.news_content)
        val tvDate = itemView.findViewById<TextView>(R.id.news_date)
        val ivImage = itemView.findViewById<ImageView>(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_news, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = newsList[position]
        holder.tvTitle.text = post.title
        holder.tvContent.text = post.content
        holder.tvDate.text = post.date
        holder.ivImage.setImageDrawable(post.postImage)
    }
}