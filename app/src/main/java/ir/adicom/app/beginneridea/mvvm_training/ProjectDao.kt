package ir.adicom.app.beginneridea.mvvm_training

import androidx.room.*

@Dao()
interface ProjectDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProject(projectModel: ProjectModel): Int

    @Update
    fun updateProject(projectModel: ProjectModel): Int

    @Delete
    fun deleteProject(projectModel: ProjectModel): Int

    @Query("SELECT * FROM project")
    fun getAllProject(): List<ProjectModel>

    @Query("SELECT * FROM project WHERE pId=:id")
    fun getProject(id: Int): ProjectModel
}