package com.gustainmars.greatwork

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.gustainmars.greatwork.model.ClassDifficulty
import com.gustainmars.greatwork.model.Dice

class DiceActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)
        val btnD6: Button =  findViewById(R.id.btnD6)
        val btnD20: Button =  findViewById(R.id.btnD20)
        val txtResultRoll = findViewById<TextView>(R.id.txtRollResult)
        val imgDice = findViewById<ImageView>(R.id.imvDice)

        btnD6.setOnClickListener {
            rollHandler(myd6, txtResultRoll, imgDice)
        }
        btnD20.setOnClickListener {
            rollHandler(myd20, txtResultRoll, imgDice)
        }

        rollHandler(myd6, txtResultRoll, imgDice)
    }

    private val myd6 = Dice(6, "red")
    private val myd20 = Dice(20, "black")

    private fun rollD6(): Int {
        return when(myd6.roll().toInt()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    private fun rollD20(cd: ClassDifficulty): String {
        val roll = myd20.roll().toInt()
        return when (roll >= cd.value) {
            true -> if(roll == 20) "A critical success, a nat $roll!" else "You rolled $roll, your test has succeeded!"
            false -> "Snap, you fail, you rolled $roll :c"
        }
    }

    private fun rollHandler(dice: Dice, txtResultRoll: TextView, imgDice: ImageView) {
        when(dice.sides) {
            6 -> {
                txtResultRoll.visibility = View.INVISIBLE
                if (!imgDice.isVisible) imgDice.visibility = View.VISIBLE
                rollD6().also { imgDice.setImageResource(it) }
            }
            20 -> {
                imgDice.visibility = View.INVISIBLE
                if(!txtResultRoll.isVisible) txtResultRoll.visibility = View.VISIBLE
                rollD20(ClassDifficulty.NORMAL).also { txtResultRoll.text = it }
            }
            else -> {
                imgDice.visibility = View.INVISIBLE
                if(!txtResultRoll.isVisible) txtResultRoll.visibility = View.VISIBLE
                dice.roll().also { txtResultRoll.text = it }
            }
        }
    }
}