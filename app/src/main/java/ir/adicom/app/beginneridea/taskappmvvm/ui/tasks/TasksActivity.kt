package ir.adicom.app.beginneridea.taskappmvvm.ui.tasks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ir.adicom.app.beginneridea.databinding.ActivityTasksBinding

class TasksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityTasksBinding = ActivityTasksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val taskViewModel = ViewModelProvider(
            this,
            TaskViewModelFactory(
                application
            )
        )
            .get(TaskViewModel::class.java)


        taskViewModel.getAllTasks()?.observe(this, Observer {
            binding.tvMessage.text = "Size: ${it.size}"
        })
    }
}