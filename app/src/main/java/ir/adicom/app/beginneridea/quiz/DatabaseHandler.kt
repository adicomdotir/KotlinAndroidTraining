package ir.adicom.app.beginneridea.quiz

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE $TABLE_NAME (" +
                ID + " INTEGER PRIMARY KEY," +
                SCORE + " INTEGER," +
                USERNAME + " TEXT);"
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val dropTable = "DROP TABLE IF EXISTS $TABLE_NAME"
        db.execSQL(dropTable)
        onCreate(db)
    }

    companion object {

        private const val DB_VERSION = 2
        private const val DB_NAME = "MyDataBase"
        private const val TABLE_NAME = "QuizzHighScores"
        private const val ID = "Id"
        private const val USERNAME = "UserName"
        private const val SCORE = "Score"
    }

    fun getAll(): List<Score> {
        val scoreList = ArrayList<Score>()
        val db = writableDatabase
        val selectQuery = "SELECT * FROM $TABLE_NAME ORDER BY $SCORE DESC LIMIT 10"
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    val score = Score()
                    score.id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID)))
                    score.username = cursor.getString(cursor.getColumnIndex(USERNAME))
                    score.score = Integer.parseInt(cursor.getString(cursor.getColumnIndex(SCORE)))
                    scoreList.add(score)
                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        return scoreList
    }

    fun addScore(score: Score): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(USERNAME, score.username)
        values.put(SCORE, score.score)
        val success = db.insert(TABLE_NAME, null, values)
        db.close()
        return (Integer.parseInt("$success") != -1)
    }

//    fun getScore(_id: Int): Score {
//        val score = Score()
//        val db = writableDatabase
//        val selectQuery = "SELECT  * FROM $TABLE_NAME WHERE $ID = $_id"
//        val cursor = db.rawQuery(selectQuery, null)
//        if (cursor != null) {
//            cursor.moveToFirst()
//            while (cursor.moveToNext()) {
//                score.id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID)))
//                score.name = cursor.getString(cursor.getColumnIndex(NAME))
//                score.desc = cursor.getString(cursor.getColumnIndex(DESC))
//                score.completed = cursor.getString(cursor.getColumnIndex(COMPLETED))
//            }
//        }
//        cursor.close()
//        return score
//    }
//
//    val task: List<Score>
//        get() {
//            val taskList = ArrayList<Score>()
//            val db = writableDatabase
//            val selectQuery = "SELECT  * FROM $TABLE_NAME"
//            val cursor = db.rawQuery(selectQuery, null)
//            if (cursor != null) {
//                cursor.moveToFirst()
//                while (cursor.moveToNext()) {
//                    val score = Score()
//                    score.id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID)))
//                    score.name = cursor.getString(cursor.getColumnIndex(NAME))
//                    score.desc = cursor.getString(cursor.getColumnIndex(DESC))
//                    score.completed = cursor.getString(cursor.getColumnIndex(COMPLETED))
//                    taskList.add(score)
//                }
//            }
//            cursor.close()
//            return taskList
//        }
//
//    fun updateScore(score: Score): Boolean {
//        val db = this.writableDatabase
//        val values = ContentValues()
//        values.put(NAME, score.name)
//        values.put(DESC, score.desc)
//        values.put(COMPLETED, score.completed)
//        val _success = db.update(TABLE_NAME, values, ID + "=?", arrayOf(score.id.toString())).toLong()
//        db.close()
//        return Integer.parseInt("$_success") != -1
//    }
//
//    fun deleteScore(_id: Int): Boolean {
//        val db = this.writableDatabase
//        val _success = db.delete(TABLE_NAME, ID + "=?", arrayOf(_id.toString())).toLong()
//        db.close()
//        return Integer.parseInt("$_success") != -1
//    }
} 
