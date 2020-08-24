package ir.adicom.app.beginneridea.taskappmvvm.ui.tasks

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ir.adicom.app.beginneridea.databinding.ActivityTasksBinding
import ir.adicom.app.beginneridea.taskappmvvm.ui.CustomViewModelFactory
import ir.adicom.app.beginneridea.taskappmvvm.ui.addedittask.AddEditTaskActivity

class TasksActivity : AppCompatActivity(), CallbackEvent {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityTasksBinding = ActivityTasksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val taskViewModel = ViewModelProvider(this, CustomViewModelFactory(application))
            .get(TaskViewModel::class.java)

        val adapter = TasksAdapter(this)
        binding.rvTasks.adapter = adapter
        binding.rvTasks.layoutManager = LinearLayoutManager(this)

        taskViewModel.getAllTasks()?.observe(this, Observer {
            adapter.setItems(it)
        })

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, AddEditTaskActivity::class.java)
            startActivity(intent)
        }
    }

    override fun editTaskClick(id: Int) {
        val intent = Intent(this, AddEditTaskActivity::class.java)
        intent.putExtra("TASK_ID", id)
        startActivity(intent)
    }
}