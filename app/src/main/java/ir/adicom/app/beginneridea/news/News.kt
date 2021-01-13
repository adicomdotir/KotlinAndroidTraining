package ir.adicom.app.beginneridea.news

import android.graphics.drawable.Drawable

data class News(
    val id: Int, val postImage: Drawable, val date: String,
    val content: String, val title: String
)