package ir.adicom.app.beginneridea.taskappmvvm.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ir.adicom.app.beginneridea.taskappmvvm.ui.addedittask.AddEditTaskViewModel
import ir.adicom.app.beginneridea.taskappmvvm.ui.tasks.TaskViewModel

class CustomViewModelFactory(private val application: Application) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java!!)) {
            return TaskViewModel(application) as T
        }
		if (modelClass.isAssignableFrom(AddEditTaskViewModel::class.java!!)) {
            return AddEditTaskViewModel(application) as T
        }
		return throw IllegalArgumentException("ViewModel Not Found")
    }
}
