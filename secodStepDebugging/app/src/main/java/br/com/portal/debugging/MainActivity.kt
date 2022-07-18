package br.com.portal.debugging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    var denominator = 4
    val numerator = 60
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "this is where the app crashed before")
        val helloTextView: TextView = findViewById(R.id.hello_world)
        Log.d(TAG, "this should be logged if the bug is fixed")
        helloTextView.text = "Hello, debugging!"
        findViewById<TextView>(R.id.division_textview).setText("${numerator / denominator}")
        fourth()
        second()
        first()
        division()
    }

    fun first() {
        second()
        Log.v(TAG, "1")
    }

    fun second() {
        third()
        Log.v(TAG, "2")
        fourth()
    }

    fun third() {
        Log.v(TAG, "3")
    }

    fun fourth() {
        Log.v(TAG, "4")
    }

    fun division() {
        repeat(4) {
            Thread.sleep(3)
            Log.v(TAG, "${numerator / denominator}")
            denominator--
        }
    }

    fun logging() {
        Log.e(TAG, "ERROR: a serious error like an app crash")
        Log.w(TAG, "WARN: warns about the potential for serious errors")
        Log.i(TAG, "INFO: reporting technical information, such as an operation succeeding")
        Log.d(TAG, "DEBUG: reporting technical information useful for debugging")
        Log.v(TAG, "VERBOSE: more verbose than DEBUG logs")
        Log.d(TAG, "$denominator")
    }
}