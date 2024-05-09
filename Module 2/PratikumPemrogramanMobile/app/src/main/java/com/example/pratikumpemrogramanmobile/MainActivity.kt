package com.example.pratikumpemrogramanmobile

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var imageViewDice1: ImageView
    private lateinit var imageViewDice2: ImageView
    private lateinit var buttonRollDice: Button
    private lateinit var textViewMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageViewDice1 = findViewById(R.id.imageViewDice1)
        imageViewDice2 = findViewById(R.id.imageViewDice2)
        buttonRollDice = findViewById(R.id.buttonRollDice)
        textViewMessage = findViewById(R.id.textViewMessage)

        buttonRollDice.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val dice1 = (1..6).random()
        val dice2 = (1..6).random()

        val drawableResource1 = when (dice1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResource2 = when (dice2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        imageViewDice1.setImageResource(drawableResource1)
        imageViewDice2.setImageResource(drawableResource2)

        if (dice1 != dice2) {
            textViewMessage.text = "Anda belum beruntung!"
        } else {
            textViewMessage.text = "Selamat anda dapat dadu double!"
        }
    }
}
