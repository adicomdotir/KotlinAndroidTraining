package ir.adicom.app.beginneridea.mvvm_training

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "project")
class ProjectModel(
    @PrimaryKey(autoGenerate = true)
    var pId: Int,
    @ColumnInfo(name = "p_title")
    var title: String,
    var language: String,
    var watcher: Int,
    var issues: Int
): Serializable {
}