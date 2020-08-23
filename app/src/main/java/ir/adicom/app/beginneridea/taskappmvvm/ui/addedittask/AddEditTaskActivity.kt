package ir.adicom.app.beginneridea.taskappmvvm.ui.addedittask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ir.adicom.app.beginneridea.databinding.ActivityAddEditTaskBinding
import ir.adicom.app.beginneridea.taskappmvvm.data.db.Task

class AddEditTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAddEditTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val addEditTaskViewModel = ViewModelProvider(this, AddEditTaskViewModelFactory(application))
            .get(AddEditTaskViewModel::class.java)

        binding.btnSave.setOnClickListener {
            if (binding.etTitle.text.trim().isNotEmpty()) {
                val task = Task(0, binding.etTitle.text.toString())
                addEditTaskViewModel.insertTask(task)
                finish()
            }
        }
    }
}