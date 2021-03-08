package ir.adicom.app.beginneridea.mvvm_training

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao()
interface ProjectDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProject(projectModel: ProjectModel)

    @Update
    fun updateProject(projectModel: ProjectModel)

    @Delete
    fun deleteProject(projectModel: ProjectModel)

    @Query("SELECT * FROM project")
    fun getAllProject(): LiveData<List<ProjectModel>>

    @Query("SELECT * FROM project WHERE pId=:id")
    fun getProject(id: Int): ProjectModel
}