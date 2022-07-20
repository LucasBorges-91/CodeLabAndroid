package br.com.portal.tiptime

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import br.com.portal.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateBt.setOnClickListener{ calculateTip() }

        binding.costOfServiceTiet.setOnKeyListener { view, keyCode, _ ->
            handleKeyEvent(view, keyCode) }
    }

    private fun calculateTip() {
        val coastServiceText = binding.costOfServiceTiet.text.toString()
        val coastService = coastServiceText.toDoubleOrNull()
        if ( coastService == null ) {
            displayTip( 0.0 )
            return
        }
        val selectIdRg = binding.tipOptionsRg.checkedRadioButtonId
        val tipPercentage = when (selectIdRg) {
            R.id.tip_twenty_rb -> 0.2
            R.id.tip_eighteen_rb -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * coastService
        val roundUp = binding.roundTipSwitch.isChecked
        if ( roundUp ) tip = kotlin.math.ceil( tip )
        displayTip( tip )
    }

    private fun displayTip(tip : Double) {
        val formattedTip = NumberFormat.getCurrencyInstance().format( tip )
        binding.tipResultTv.text = getString(R.string.tip_amount, formattedTip)
    }

    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}