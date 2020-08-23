package ir.adicom.app.beginneridea.taskappmvvm.ui.addedittask

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ir.adicom.app.beginneridea.taskappmvvm.data.TaskRepository
import ir.adicom.app.beginneridea.taskappmvvm.data.db.Task

class AddEditTaskViewModel(application: Application) : ViewModel() {
    val taskRepository = TaskRepository(application)

    fun insertTask(task: Task) {
        taskRepository.saveTask(task)
    }
}

class AddEditTaskViewModelFactory(private val application: Application) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddEditTaskViewModel(application) as T
    }

}