package ir.adicom.app.beginneridea.boutique

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import ir.adicom.app.beginneridea.R

class BoutiqueActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boutique)

        val clothesViewPagerAdapter = ClothesViewPagerAdapter(supportFragmentManager)
        val viewpager = findViewById<ViewPager>(R.id.viewpager)
        viewpager.adapter = clothesViewPagerAdapter
        val tabLayout = findViewById<TabLayout>(R.id.tablayout)
        tabLayout.setupWithViewPager(viewpager)
    }
}