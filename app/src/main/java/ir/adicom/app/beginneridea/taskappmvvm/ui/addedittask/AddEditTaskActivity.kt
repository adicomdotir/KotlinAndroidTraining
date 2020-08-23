package ir.adicom.app.beginneridea.taskappmvvm.ui.addedittask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.adicom.app.beginneridea.databinding.ActivityAddEditTaskBinding

class AddEditTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAddEditTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}