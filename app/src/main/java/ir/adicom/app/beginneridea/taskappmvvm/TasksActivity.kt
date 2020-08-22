package ir.adicom.app.beginneridea.taskappmvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.adicom.app.beginneridea.databinding.ActivityTasksBinding

class TasksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTasksBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}