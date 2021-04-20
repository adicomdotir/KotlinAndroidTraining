package ir.adicom.app.beginneridea.mvvmpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import ir.adicom.app.beginneridea.R
import kotlinx.android.synthetic.main.activity_mvvm_practice.*

class MvvmPracticeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_practice)
        val viewModel = ViewModelProvider(this).get(CustomViewModel::class.java)

        btnClick.setOnClickListener {
            viewModel.generate()
        }

        viewModel.customString.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }
}