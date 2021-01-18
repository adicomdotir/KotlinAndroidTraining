package ir.adicom.app.beginneridea.boutique

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.adicom.app.beginneridea.R

class BoutiqueAdapter(val boutiqueList: List<Cloth>) :
    RecyclerView.Adapter<BoutiqueAdapter.BoutiqueViewHolder>() {
    class BoutiqueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivBoutiqueImage = itemView.findViewById<ImageView>(R.id.iv_boutique)
        val tvBoutiqueTitle = itemView.findViewById<TextView>(R.id.tv_boutique_title)
        val tvBoutiqueCount = itemView.findViewById<TextView>(R.id.tv_boutique_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoutiqueViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.boutique_item, parent, false)
        return BoutiqueViewHolder(view)
    }

    override fun getItemCount(): Int {
        return boutiqueList.size
    }

    override fun onBindViewHolder(holder: BoutiqueViewHolder, position: Int) {
        val cloth = boutiqueList[position]
        holder.ivBoutiqueImage.setImageDrawable(cloth.source)
        holder.tvBoutiqueCount.text = cloth.count
        holder.tvBoutiqueTitle.text = cloth.title
    }
}