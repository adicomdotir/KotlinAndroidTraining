package ir.adicom.app.beginneridea.other_recyclerview_sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ir.adicom.app.beginneridea.R
import java.util.ArrayList

class ContactAdapter(val onItemClickListener: OnItemClickListener): RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    val arrayList: ArrayList<String> = arrayListOf()

    init {
        arrayList.add("Ruthann Trustrie")
        arrayList.add("Peadar Dawtrey")
        arrayList.add("Felipe Bradtke")
        arrayList.add("Claude Crissil")
        arrayList.add("Jacky Girardeau")
        arrayList.add("Rubia Dominguez")
        arrayList.add("Michaela Churchley")
        arrayList.add("Harvey Pentelow")
        arrayList.add("Neilla Langton")
        arrayList.add("Marco Greaves")
        arrayList.add("Liz Batchley")
        arrayList.add("Lamond Littlepage")
        arrayList.add("Malina Weir")
        arrayList.add("Tomlin Lenchenko")
        arrayList.add("Hy Pavelin")
        arrayList.add("Jenelle Palin")
        arrayList.add("Damon Knewstubb")
        arrayList.add("Alex Ivanusyev")
        arrayList.add("Hamil Callery")
        arrayList.add("Karol Syer")
    }

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var tvFirstChar: TextView = itemView.findViewById(R.id.tv_first_character)
        private var tvFullName: TextView = itemView.findViewById(R.id.tv_fullname)

        fun bindContact(fullName: String) {
            tvFullName.text = fullName
            tvFirstChar.text = fullName.substring(0, 1)

            itemView.setOnClickListener {
                onItemClickListener.onItemClick(fullName, adapterPosition)
            }

            itemView.setOnLongClickListener {
                arrayList.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
                false
            }
        }
    }

    fun addNewContact(fullName: String) {
        arrayList.add(0, fullName)
        notifyItemInserted(0)
    }

    fun updateNewContact(fullName: String, position: Int) {
        arrayList.add(position, fullName)
        notifyItemChanged(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bindContact(arrayList[position])
    }

    interface OnItemClickListener {
        fun onItemClick(fullName: String, adapterPosition: Int)
    }
}