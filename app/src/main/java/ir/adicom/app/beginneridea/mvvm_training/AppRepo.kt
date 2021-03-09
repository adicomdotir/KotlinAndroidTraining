package ir.adicom.app.beginneridea.mvvm_training

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AppRepo(context: Context) {
    val appDatabase: AppDatabase = AppDatabase.getDatabase(context)!!

    fun insertProject(projectModel: ProjectModel) {
        Thread {
            appDatabase.projectDao().insertProject(projectModel)
        }.start()
    }

    fun updateProject(projectModel: ProjectModel) {
        GlobalScope.launch {
            appDatabase.projectDao().updateProject(projectModel)
        }
    }

    fun deleteProject(projectModel: ProjectModel) {
        GlobalScope.launch {
            appDatabase.projectDao().deleteProject(projectModel)
        }
    }

    fun getAllProject(): LiveData<List<ProjectModel>> {
        return appDatabase.projectDao().getAllProject()
    }
}