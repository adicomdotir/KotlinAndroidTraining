package ir.adicom.app.beginneridea.taskappmvvm.ui.tasks

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ir.adicom.app.beginneridea.taskappmvvm.data.TaskRepository
import ir.adicom.app.beginneridea.taskappmvvm.data.db.Task

class TaskViewModel(application: Application) : ViewModel() {
    private val taskRepository = TaskRepository(application)

    fun getAllTasks(): LiveData<List<Task>>? {
        return taskRepository.getAllTasks()
    }
}