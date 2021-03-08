package ir.adicom.app.beginneridea.mvvm_training

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ir.adicom.app.beginneridea.R

class MainTrainingActivity : AppCompatActivity() {
    lateinit var adapter: ProjectAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_training)

        adapter = ProjectAdapter()

        val recyclerView = findViewById<RecyclerView>(R.id.projectRecyclerView)
        recyclerView.adapter = adapter

        val addProject = findViewById<FloatingActionButton>(R.id.addProject)
        addProject.setOnClickListener {
            startActivity(Intent(this, AddProjectActivity::class.java))
        }

        val projectViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(ProjectViewModel::class.java)
        projectViewModel.getAllProject().observe(this, Observer {
            adapter.setProjects(it)
        })
    }
}