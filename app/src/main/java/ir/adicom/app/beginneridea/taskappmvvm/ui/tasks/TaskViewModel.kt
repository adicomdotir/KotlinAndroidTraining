package ir.adicom.app.beginneridea.taskappmvvm.ui.tasks

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ir.adicom.app.beginneridea.taskappmvvm.data.TaskRepository
import ir.adicom.app.beginneridea.taskappmvvm.data.db.Task

class TaskViewModel(application: Application) : ViewModel() {
    private val taskRepository = TaskRepository(application)

    init {
        taskRepository.saveTask(Task(0, "First Task"))
        taskRepository.saveTask(Task(0, "Second Task"))
    }

    fun getAllTasks(): LiveData<List<Task>>? {
        return taskRepository.getAllTasks()
    }
}

class TaskViewModelFactory(private val application: Application) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TaskViewModel(
            application
        ) as T
    }

}