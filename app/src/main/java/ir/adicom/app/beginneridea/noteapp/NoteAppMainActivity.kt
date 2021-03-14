package ir.adicom.app.beginneridea.noteapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ir.adicom.app.beginneridea.R
import ir.adicom.app.beginneridea.databinding.ActivityNoteAppMainBinding
import ir.adicom.app.beginneridea.noteapp.db.NoteDatabase
import ir.adicom.app.beginneridea.noteapp.repository.NoteRepository
import ir.adicom.app.beginneridea.noteapp.viewmodel.NoteViewModel
import ir.adicom.app.beginneridea.noteapp.viewmodel.NoteViewModelProviderFactory

class NoteAppMainActivity : AppCompatActivity() {
    lateinit var binding: ActivityNoteAppMainBinding
    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteAppMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        setUpViewModel()
    }

    fun setUpViewModel() {
        val noteRepository = NoteRepository(NoteDatabase(this))

        val viewModelProviderFactory = NoteViewModelProviderFactory(application, noteRepository)

        noteViewModel = ViewModelProvider(
            this,
            viewModelProviderFactory
        ).get(NoteViewModel::class.java)
    }
}