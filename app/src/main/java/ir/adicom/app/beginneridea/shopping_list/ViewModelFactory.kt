package ir.adicom.app.beginneridea.shopping_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ir.adicom.app.beginneridea.shopping_list.data.repositories.ShoppingRepository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(val repository: ShoppingRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingItemViewModel(repository) as T
    }
}