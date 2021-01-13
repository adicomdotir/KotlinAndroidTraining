package ir.adicom.app.beginneridea.news

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import ir.adicom.app.beginneridea.R
import java.util.*


/**
 * Created by Saeed shahini on 7/21/2016.
 */
object DataFakeGenerator {
    fun getData(context: Context): List<News> {
        val posts: MutableList<News> = ArrayList()
        for (i in 1..6) {
            val postImage: Drawable? = when (i) {
                1 -> ResourcesCompat.getDrawable(context.resources, R.drawable.pic1, null)
                2 -> ResourcesCompat.getDrawable(context.resources, R.drawable.pic2, null)
                3 -> ResourcesCompat.getDrawable(context.resources, R.drawable.pic3, null)
                4 -> ResourcesCompat.getDrawable(context.resources, R.drawable.pic4, null)
                5 -> ResourcesCompat.getDrawable(context.resources, R.drawable.pic5, null)
                else -> ResourcesCompat.getDrawable(context.resources, R.drawable.pic6, null)
            }
            val post = News(
                id = i,
                title = "لورم ایپسوم متن ساختگی",
                content = "لورم ایپسوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ و با استفاده از طراحان گرافیک است. چاپگرها و متون بلکه روزنامه و مجله در ستون و سطرآنچنان که لازم است و برای شرایط فعلی تکنولوژی مورد نیاز و کاربردهای متنوع با هدف بهبود ابزارهای کاربردی می باشد. لورم ایپسوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ و با استفاده از طراحان گرافیک است.",
                date = "2 ساعت پیش",
                postImage = postImage!!
            )
            posts.add(post)
        }
        return posts
    }
}
