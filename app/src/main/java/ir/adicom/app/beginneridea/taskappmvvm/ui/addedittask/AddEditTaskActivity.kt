package ir.adicom.app.beginneridea.taskappmvvm.ui.addedittask

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ir.adicom.app.beginneridea.databinding.ActivityAddEditTaskBinding
import ir.adicom.app.beginneridea.taskappmvvm.data.db.Task
import ir.adicom.app.beginneridea.taskappmvvm.ui.CustomViewModelFactory

class AddEditTaskActivity : AppCompatActivity() {

    private var id: Int = 0
    private var task: Task? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAddEditTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        id = intent.getIntExtra("TASK_ID", 0)
        val addEditTaskViewModel = ViewModelProvider(this, CustomViewModelFactory(application))
            .get(AddEditTaskViewModel::class.java)

        addEditTaskViewModel.getTask(id)?.observe(this, Observer {
            it?.let {
                binding.etTitle.setText(it.title)
                binding.btnDelete.visibility = View.VISIBLE
                task = it
            }
        })

        binding.btnSave.setOnClickListener {
            if (binding.etTitle.text.trim().isNotEmpty()) {
                val task = Task(id, binding.etTitle.text.toString())
                if (id == 0) {
                    addEditTaskViewModel.insertTask(task)
                } else {
                    addEditTaskViewModel.updateTask(task)
                }
                finish()
            }
        }

        binding.btnDelete.setOnClickListener {
            task?.run {
                addEditTaskViewModel.removeTask(this)
                finish()
            }
        }
    }
}