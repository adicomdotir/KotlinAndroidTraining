package ir.adicom.app.beginneridea.boutique

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.adicom.app.beginneridea.R
import kotlinx.android.synthetic.main.boutique_item.view.*

class BoutiqueAdapter(val clothesList: List<Cloth>) :
    RecyclerView.Adapter<BoutiqueAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

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
        holder.itemView.tv_boutique_title.text = cloth.title
        holder.itemView.tv_boutique_count.text = cloth.count
        holder.itemView.iv_boutique.setImageDrawable(cloth.source)
    }
}