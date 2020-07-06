package ir.adicom.app.beginneridea.rgb2hex

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ir.adicom.app.beginneridea.R

class ColorToHexActivity : AppCompatActivity() {

    lateinit var btnCalculate: Button
    lateinit var edtRed: EditText
    lateinit var edtGreen: EditText
    lateinit var edtBlue: EditText
    lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_to_hex)

        edtBlue = findViewById(R.id.edt_blue)
        edtGreen = findViewById(R.id.edt_green)
        edtRed = findViewById(R.id.edt_red)
        tvResult = findViewById(R.id.tv_result)
        btnCalculate = findViewById(R.id.btn_calculate)

        btnCalculate.setOnClickListener {
            val sb = StringBuilder()
            val redValue = edtRed.text.toString().toInt()
            val greenValue = edtGreen.text.toString().toInt()
            val blueValue = edtBlue.text.toString().toInt()
            if (redValue < 0 || redValue > 255 || greenValue < 0 || greenValue > 255 || blueValue < 0 || blueValue > 255) {
                Toast.makeText(this, "Value must to be 0-255", Toast.LENGTH_SHORT).show()
            } else {
                sb.append(decimalToHex(redValue))
                sb.append(decimalToHex(greenValue))
                sb.append(decimalToHex(blueValue))
                tvResult.text = "Result: $sb"
            }
        }
    }

    fun decimalToHex(value: Int): String {
        val sb = StringBuilder()
        var newValue = value
        while (newValue > 0) {
            val res = newValue % 16
            newValue /= 16
            sb.append(numberToDigit(res))
        }
        if (sb.isEmpty()) {
            sb.append("00")
        } else if (sb.length == 1) {
            sb.append("0")
        }
        return sb.reverse().toString()
    }

    private fun numberToDigit(value: Int): String {
        when (value) {
            10 -> return "A"
            11 -> return "B"
            12 -> return "C"
            13 -> return "D"
            14 -> return "E"
            15 -> return "F"
        }
        return value.toString()
    }
}
