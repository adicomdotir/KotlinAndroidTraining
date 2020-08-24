package ir.adicom.app.beginneridea.taskappmvvm.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider

class CustomViewModelFactory(private val application: Application) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java!!)) {
            TaskViewModel(application) as T
        }
		if (modelClass.isAssignableFrom(AddEditTaskViewModel::class.java!!)) {
            AddEditTaskViewModel(application) as T
        }
		return throw IllegalArgumentException("ViewModel Not Found")
    }
}
