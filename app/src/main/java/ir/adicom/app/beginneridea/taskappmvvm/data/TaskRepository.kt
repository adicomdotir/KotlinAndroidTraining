package ir.adicom.app.beginneridea.taskappmvvm.data

import android.app.Application
import androidx.lifecycle.LiveData
import ir.adicom.app.beginneridea.taskappmvvm.data.db.Task
import ir.adicom.app.beginneridea.taskappmvvm.data.db.TaskDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TaskRepository(application: Application) {
    private val db: TaskDatabase? = TaskDatabase.getDatabase(application)
    private val taskDao = db?.taskDao()
    private val allTasks = taskDao?.getAllTask()

    fun getAllTasks(): LiveData<List<Task>>? {
        return allTasks
    }

    fun saveTask(task: Task) {
        GlobalScope.launch {
            taskDao?.insertTask(task)
        }
    }

    fun getTask(id: Int): LiveData<Task>? {
        return taskDao?.getTask(id)
    }

    fun editTask(task: Task) {
        GlobalScope.launch {
            taskDao?.updateTask(task)
        }
    }

    fun removeTask(task: Task) {
        GlobalScope.launch {
            taskDao?.deleteTask(task)
        }
    }
}