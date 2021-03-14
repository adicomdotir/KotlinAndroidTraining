package ir.adicom.app.beginneridea.noteapp.repository

import ir.adicom.app.beginneridea.noteapp.db.NoteDatabase
import ir.adicom.app.beginneridea.noteapp.model.Note

class NoteRepository(private val db: NoteDatabase) {

    suspend fun addNote(note: Note) = db.getNoteDao().addNote(note)
    suspend fun updateNote(note: Note) = db.getNoteDao().updateNote(note)
    suspend fun deleteNote(note: Note) = db.getNoteDao().deleteNote(note)
    fun getAllNotes() = db.getNoteDao().getAllNotes()

}