package br.com.portal.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton : Button = findViewById(R.id.roll_bt)
        rollButton.setOnClickListener{
            rollDice()
        }
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides passed and roll it
        val dice = Dice( 6 )
        // Update the screen with the dice roll
        // Find the ImageView in the layout
        val imageDice : ImageView = findViewById(R.id.imageView)
        // Determine which drawable resource ID to use based on the dice roll
        val drawbleResource = when ( dice.roll() ) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID
        imageDice.setImageResource(drawbleResource)
        // Update the content description
        imageDice.contentDescription = dice.roll().toString()
    }
}

class Dice( private val numSides: Int ) {
    fun roll() : Int {
        return (1..numSides).random()
    }
}