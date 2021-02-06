package ir.adicom.app.beginneridea.boutique

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.adicom.app.beginneridea.R
import kotlinx.android.synthetic.main.boutique_item.view.*

class BoutiqueAdapter(val clothList: List<Cloth>) : RecyclerView.Adapter<BoutiqueAdapter.BouViewHolder>() {
    class BouViewHolder(view: View) : RecyclerView.ViewHolder(view) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BouViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.boutique_item, parent, false)
        return BouViewHolder(view)
    }

    override fun getItemCount(): Int {
        return clothList.size
    }

    override fun onBindViewHolder(holder: BouViewHolder, position: Int) {
        val cloth = clothList[position]
        holder.itemView.iv_boutique.setImageDrawable(cloth.source)
        holder.itemView.tv_boutique_count.text = cloth.count
        holder.itemView.tv_boutique_title.text = cloth.title
    }
}