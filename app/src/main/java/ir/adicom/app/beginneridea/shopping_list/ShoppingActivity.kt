package ir.adicom.app.beginneridea.shopping_list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ir.adicom.app.beginneridea.R
import ir.adicom.app.beginneridea.shopping_list.data.db.ShoppingDatabase
import ir.adicom.app.beginneridea.shopping_list.data.db.entities.ShoppingItem
import ir.adicom.app.beginneridea.shopping_list.data.repositories.ShoppingRepository
import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase.getDatabase(this)
        val repository = ShoppingRepository(database!!)
        val factory = ViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory).get(ShoppingItemViewModel::class.java)

        val adapter = ShoppingListAdapter(listOf(), viewModel)

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.shoppingItemList = it
            adapter.notifyDataSetChanged()
        })
        rv_shopping.adapter = adapter
        rv_shopping.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        fab.setOnClickListener {
            viewModel.upsert(ShoppingItem("Apples", 55))
        }
    }
}