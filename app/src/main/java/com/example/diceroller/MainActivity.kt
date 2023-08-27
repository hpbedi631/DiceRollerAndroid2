package com.example.diceroller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
/* My name is Harshdeep Bedi and my student number is N01358063. I wrote the code because it was part of my lab, I wrote this code on
September 14 and 15 and this code should be starting by saying Hello World!, rolling the Dice when clicking the Roll button,
showing the output in the TextView (text) and imageView (Images) while updating the Text and Images when clicking the Count Up button.
*/
class MainActivity : AppCompatActivity() {

    private var diceImage: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        val countButton: Button = findViewById(R.id.count_up)
        diceImage = findViewById(R.id.imageView)
        rollButton.setOnClickListener { rollDice() }
        countButton.setOnClickListener { countUp() }
    }

    private var randomInt = (1..6).random()
    private fun rollDice() {
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()
        //  Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()

        val drawableResource = when (randomInt) {
            1 -> R.drawable.die_1
            2 -> R.drawable.die_2
            3 -> R.drawable.die_3
            4 -> R.drawable.die_4
            5 -> R.drawable.die_5
            else -> R.drawable.die_6
        }
        diceImage?.setImageResource(drawableResource)
    }


    private fun countUp() {
        randomInt++
        if (randomInt >= 6) {
            randomInt = 6
        }
        val drawableResource = when (randomInt) {
            1 -> R.drawable.die_1
            2 -> R.drawable.die_2
            3 -> R.drawable.die_3
            4 -> R.drawable.die_4
            5 -> R.drawable.die_5
            else -> R.drawable.die_6
        }
        diceImage?.setImageResource(drawableResource)
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()
    }
    fun onClickNext(view: View) {
        // onClickNext will trigger new activity to be opened
        // Create an intent to start the second activity

        val newIntent = Intent (this, SecondActivity::class.java)
        startActivity(newIntent)
    }
}


