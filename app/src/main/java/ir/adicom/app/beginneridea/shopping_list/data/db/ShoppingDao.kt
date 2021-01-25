package ir.adicom.app.beginneridea.shopping_list.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import ir.adicom.app.beginneridea.shopping_list.data.db.entities.ShoppingItem

@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(shoppingItem: ShoppingItem)

    @Delete
    suspend fun delete(shoppingItem: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}