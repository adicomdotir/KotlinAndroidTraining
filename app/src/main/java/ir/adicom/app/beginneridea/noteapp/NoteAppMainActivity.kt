package ir.adicom.app.beginneridea.noteapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.adicom.app.beginneridea.R
import ir.adicom.app.beginneridea.databinding.ActivityNoteAppMainBinding

class NoteAppMainActivity : AppCompatActivity() {
    lateinit var binding: ActivityNoteAppMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteAppMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
    }
}