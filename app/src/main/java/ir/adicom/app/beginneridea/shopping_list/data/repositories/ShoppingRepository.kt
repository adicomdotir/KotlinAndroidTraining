package ir.adicom.app.beginneridea.shopping_list.data.repositories

import androidx.lifecycle.LiveData
import ir.adicom.app.beginneridea.shopping_list.data.db.ShoppingDatabase
import ir.adicom.app.beginneridea.shopping_list.data.db.entities.ShoppingItem

class ShoppingRepository(private val db: ShoppingDatabase) {

    suspend fun upsert(shoppingItem: ShoppingItem) = db.getShoppingDao().upsert(shoppingItem)

    suspend fun delete(shoppingItem: ShoppingItem) = db.getShoppingDao().delete(shoppingItem)

    fun getAllShoppingItems(): LiveData<List<ShoppingItem>> =
        db.getShoppingDao().getAllShoppingItems()
}