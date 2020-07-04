package ir.adicom.app.beginneridea.bin2dec

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ir.adicom.app.beginneridea.R
import kotlin.math.pow

class Bin2DecActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bin2_dec)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val edtInputBinary = findViewById<EditText>(R.id.edt_binary_input)

        val btnCalculate = findViewById<Button>(R.id.btn_calculate)
        btnCalculate.setOnClickListener {
            tvResult.text = bin2Dec(edtInputBinary.text.toString())
        }
    }

    private fun bin2Dec(value: String): String {
        // 111 = 1 * 2^2 + 1 * 2^1 + 1 * 2^0
        var bin = value.toLong()
        var result = 0
        var index = 0
        while (bin > 0) {
            result += ((bin % 10) * 2.0.pow(index.toDouble())).toInt()
            if (bin % 10 > 1) {
                Toast.makeText(this, "Input must be 0 and 1", Toast.LENGTH_SHORT).show()
                return "Incorrect Input"
            }
            bin /= 10
            index++
        }
        return "Result: $result"
    }
}
