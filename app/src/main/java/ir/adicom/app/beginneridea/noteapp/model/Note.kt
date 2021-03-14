package ir.adicom.app.beginneridea.noteapp.model

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "notes")
@Parcelize
data class Note(
    val id: Int,
    val noteTitle: String,
    val noteBody: String
): Parcelable {
}