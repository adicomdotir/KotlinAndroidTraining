package ir.adicom.app.beginneridea.mvvm_training

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import ir.adicom.app.beginneridea.R
import kotlinx.android.synthetic.main.activity_add_project.*


class AddProjectActivity : AppCompatActivity() {
    private val title: String? = null
    private var lang: String = ""
    private val watcher = 0
    private var issues: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_project)
        initDropDown()

        val appRepo = AppRepo(this)
        btnAddProject.setOnClickListener {
            val projectModel = ProjectModel(
                0,
                edtTitle.text.toString(),
                lang,
                edtWatcher.text.toString().toInt(),
                edtIssue.text.toString().toInt()
            )
            appRepo.insertProject(projectModel)
        }
    }

    private fun initDropDown() {
        val languages = arrayOf("Java", "Kotlin", "PHP", "Dart", "Flutter")
        val arrayAdapter: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.select_dialog_item, languages)
        val edtLanguage = findViewById<AutoCompleteTextView>(R.id.edtLanguage)
        edtLanguage.setAdapter(arrayAdapter)
        edtLanguage.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>,
                view: View?,
                position: Int,
                l: Long
            ) {
                lang = adapterView.getItemAtPosition(position) as String
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        })
    }
}