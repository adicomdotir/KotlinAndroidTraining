package ir.adicom.app.beginneridea

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ir.adicom.app.beginneridea.bin2dec.Bin2DecActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bin2dec = findViewById<Button>(R.id.btn_bin2dec)
        bin2dec.setOnClickListener {
            val intent = Intent(this, Bin2DecActivity::class.java)
            startActivity(intent)
        }
    }
}
