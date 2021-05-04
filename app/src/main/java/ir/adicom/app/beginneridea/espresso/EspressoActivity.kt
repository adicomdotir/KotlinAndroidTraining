package ir.adicom.app.beginneridea.espresso

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ir.adicom.app.beginneridea.R


class EspressoActivity : AppCompatActivity(), View.OnClickListener {
    private var mTextView: TextView? = null
    private var mEditText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_espresso)

        findViewById<View>(R.id.changeTextBt).setOnClickListener(this)
        findViewById<View>(R.id.activityChangeTextBtn).setOnClickListener(this)
        mTextView = findViewById<View>(R.id.textToBeChanged) as TextView
        mEditText = findViewById<View>(R.id.editTextUserInput) as EditText
    }

    override fun onClick(view: View) {
        val text = mEditText!!.text.toString()
        val changeTextBtId: Int = R.id.changeTextBt
        val activityChangeTextBtnId: Int =
            R.id.activityChangeTextBtn
        if (view.id == changeTextBtId) {
            mTextView!!.text = text
        } else if (view.id == activityChangeTextBtnId) {
            val intent: Intent? = SomeTextActivity.newStartIntent(this, text)
            startActivity(intent)
        }
    }
}