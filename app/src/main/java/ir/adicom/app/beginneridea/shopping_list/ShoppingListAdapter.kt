package ir.adicom.app.beginneridea.shopping_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.adicom.app.beginneridea.R
import ir.adicom.app.beginneridea.shopping_list.data.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingListAdapter(
    var shoppingItemList: List<ShoppingItem>,
    val viewModel: ShoppingItemViewModel
) : RecyclerView.Adapter<ShoppingListAdapter.ShoppingListViewHolder>() {
    inner class ShoppingListViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return shoppingItemList.size
    }

    override fun onBindViewHolder(holder: ShoppingListViewHolder, position: Int) {
        val shoppingItem = shoppingItemList[position]

        holder.itemView.tv_name.text = shoppingItem.name
        holder.itemView.tv_amount.text = shoppingItem.amount.toString()

        holder.itemView.iv_delete.setOnClickListener {
            viewModel.delete(shoppingItem)
        }

        holder.itemView.iv_minus.setOnClickListener {
            shoppingItem.amount--
            viewModel.upsert(shoppingItem)
        }

        holder.itemView.iv_plus.setOnClickListener {
            shoppingItem.amount++
            viewModel.upsert(shoppingItem)
        }
    }


}