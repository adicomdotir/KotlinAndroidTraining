package ir.adicom.app.beginneridea.shopping_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ir.adicom.app.beginneridea.shopping_list.data.db.entities.ShoppingItem
import ir.adicom.app.beginneridea.shopping_list.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingItemViewModel(private val shoppingRepository: ShoppingRepository) : ViewModel() {
    fun upsert(shoppingItem: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        shoppingRepository.upsert(shoppingItem)
    }

    fun delete(shoppingItem: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        shoppingRepository.delete(shoppingItem)
    }

    fun getAllShoppingItems(): LiveData<List<ShoppingItem>> {
        return shoppingRepository.getAllShoppingItems()
    }
}