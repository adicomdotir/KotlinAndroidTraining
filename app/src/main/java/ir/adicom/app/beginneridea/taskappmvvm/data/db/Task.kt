package ir.adicom.app.beginneridea.taskappmvvm.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Task(@PrimaryKey(autoGenerate = true) var id: Int, var title: String) {}