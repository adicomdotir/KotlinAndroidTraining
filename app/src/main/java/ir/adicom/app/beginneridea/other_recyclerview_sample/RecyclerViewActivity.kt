package ir.adicom.app.beginneridea.other_recyclerview_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.adicom.app.beginneridea.R
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity(), ContactAdapter.OnItemClickListener {
    private lateinit var contactAdapter: ContactAdapter
    private lateinit var recyclerView: RecyclerView
    private var editingItemPosition: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        recyclerView = findViewById(R.id.rv_contacts)
        contactAdapter = ContactAdapter(this)
        recyclerView.adapter = contactAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        iv_main_addNewContact.setOnClickListener {
            if (et_main_contactFullname.text.isNotEmpty()) {
                if (editingItemPosition == -1) {
                    contactAdapter.addNewContact(et_main_contactFullname.text.toString())
                    et_main_contactFullname.setText("")
                    recyclerView.scrollToPosition(0)
                } else {
                    contactAdapter.updateNewContact(et_main_contactFullname.text.toString(), editingItemPosition)
                    et_main_contactFullname.setText("")
                    editingItemPosition = -1
                    iv_main_addNewContact.setImageResource(R.drawable.ic_add_white_24)
                }
            }
        }
    }

    override fun onItemClick(fullName: String, adapterPosition: Int) {
        et_main_contactFullname.setText(fullName)
        editingItemPosition = adapterPosition
        iv_main_addNewContact.setImageResource(R.drawable.ic_done_white_24)
    }
}