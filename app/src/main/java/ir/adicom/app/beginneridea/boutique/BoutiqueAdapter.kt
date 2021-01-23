package ir.adicom.app.beginneridea.boutique

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.adicom.app.beginneridea.R

class BoutiqueAdapter(val clothesList: List<Cloth>) :
    RecyclerView.Adapter<BoutiqueAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivImage = view.findViewById<ImageView>(R.id.iv_boutique)
        val tvTitle = view.findViewById<TextView>(R.id.tv_boutique_title)
        val tvCount = view.findViewById<TextView>(R.id.tv_boutique_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.boutique_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return clothesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cloth = clothesList[position]
        holder.ivImage.setImageDrawable(cloth.source)
        holder.tvCount.text = cloth.count
        holder.tvTitle.text = cloth.title
    }
}