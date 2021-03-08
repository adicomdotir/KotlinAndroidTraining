package ir.adicom.app.beginneridea.mvvm_training

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ProjectViewModel(application: Application) : AndroidViewModel(application) {
    val appRepo: AppRepo = AppRepo(application)

    fun insertProject(projectModel: ProjectModel) {
        appRepo.insertProject(projectModel)
    }

    fun updateProject(projectModel: ProjectModel) {
        appRepo.updateProject(projectModel)
    }

    fun deleteProject(projectModel: ProjectModel) {
        appRepo.deleteProject(projectModel)
    }

    fun getAllProject(): LiveData<List<ProjectModel>> {
        return appRepo.getAllProject()
    }
}