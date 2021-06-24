package ir.adicom.app.beginneridea.other_recyclerview_sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ir.adicom.app.beginneridea.R

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    val mutableList: MutableList<String> = mutableListOf()

    init {
        mutableList.add("Ruthann Trustrie")
        mutableList.add("Peadar Dawtrey")
        mutableList.add("Felipe Bradtke")
        mutableList.add("Claude Crissil")
        mutableList.add("Jacky Girardeau")
        mutableList.add("Rubia Dominguez")
        mutableList.add("Michaela Churchley")
        mutableList.add("Harvey Pentelow")
        mutableList.add("Neilla Langton")
        mutableList.add("Marco Greaves")
        mutableList.add("Liz Batchley")
        mutableList.add("Lamond Littlepage")
        mutableList.add("Malina Weir")
        mutableList.add("Tomlin Lenchenko")
        mutableList.add("Hy Pavelin")
        mutableList.add("Jenelle Palin")
        mutableList.add("Damon Knewstubb")
        mutableList.add("Alex Ivanusyev")
        mutableList.add("Hamil Callery")
        mutableList.add("Karol Syer")
    }

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var tvFirstChar: TextView = itemView.findViewById(R.id.tv_first_character)
        private var tvFullName: TextView = itemView.findViewById(R.id.tv_fullname)

        fun bindContact(fullName: String) {
            tvFullName.text = fullName
            tvFirstChar.text = fullName.substring(0, 1)
            itemView.setOnClickListener {
                Toast.makeText(itemView.context, fullName, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mutableList.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bindContact(mutableList[position])
    }
}