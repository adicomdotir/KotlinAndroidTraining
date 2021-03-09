package ir.adicom.app.beginneridea.mvvm_training

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ir.adicom.app.beginneridea.R

class MainTrainingActivity : AppCompatActivity(), OnClickItemListenerInterface {
    lateinit var adapter: ProjectAdapter
    lateinit var projectViewModel: ProjectViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_training)

        adapter = ProjectAdapter(this)

        val recyclerView = findViewById<RecyclerView>(R.id.projectRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter

        val addProject = findViewById<FloatingActionButton>(R.id.addProject)
        addProject.setOnClickListener {
            startActivity(Intent(this, AddProjectActivity::class.java))
        }

        projectViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(ProjectViewModel::class.java)
        projectViewModel.getAllProject().observe(this, Observer {
            adapter.setProjects(it)
        })
    }

    override fun onClickItem(projectModel: ProjectModel, isEdit: Boolean) {
        if (isEdit) {
            val intent = Intent(this, AddProjectActivity::class.java)
            intent.putExtra("model", projectModel)
            startActivity(intent)
        } else {
            projectViewModel.deleteProject(projectModel)
        }
        Toast.makeText(this, isEdit.toString(), Toast.LENGTH_SHORT).show()
    }
}