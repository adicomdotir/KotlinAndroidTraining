package ir.adicom.app.beginneridea.taskappmvvm.ui.addedittask

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ir.adicom.app.beginneridea.taskappmvvm.data.TaskRepository
import ir.adicom.app.beginneridea.taskappmvvm.data.db.Task

class AddEditTaskViewModel(application: Application) : ViewModel() {
    private val taskRepository = TaskRepository(application)

    fun insertTask(task: Task) {
        taskRepository.saveTask(task)
    }

    fun updateTask(task: Task) {
        taskRepository.editTask(task)
    }

    fun getTask(id: Int): LiveData<Task>? {
        return taskRepository.getTask(id)
    }

    fun removeTask(task: Task) {
        taskRepository.removeTask(task)
    }
}