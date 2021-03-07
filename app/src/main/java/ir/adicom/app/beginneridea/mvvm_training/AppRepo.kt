package ir.adicom.app.beginneridea.mvvm_training

import android.content.Context

class AppRepo(context: Context) {
    val appDatabase: AppDatabase = AppDatabase.getDatabase(context)!!

    fun insertProject(projectModel: ProjectModel) {
        appDatabase.projectDao().insertProject(projectModel)
    }

    fun updateProject(projectModel: ProjectModel) {
        appDatabase.projectDao().updateProject(projectModel)
    }

    fun deleteProject(projectModel: ProjectModel) {
        appDatabase.projectDao().deleteProject(projectModel)
    }

    fun getAllProject(): List<ProjectModel> {
        return appDatabase.projectDao().getAllProject()
    }
}