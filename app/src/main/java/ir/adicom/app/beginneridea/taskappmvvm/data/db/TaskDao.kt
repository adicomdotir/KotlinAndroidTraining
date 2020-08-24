package ir.adicom.app.beginneridea.taskappmvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao {
    @Query("SELECT * FROM Task")
    fun getAllTask(): LiveData<List<Task>>

    @Query("SELECT * FROM Task WHERE id=:id")
    fun getTask(id: Int): LiveData<Task>

    @Insert
    fun insertTask(task: Task)

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)
}