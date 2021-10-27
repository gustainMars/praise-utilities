package com.gustainmars.greatwork

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gustainmars.greatwork.model.Dice

class DiceActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)
        val rollD6: Button =  findViewById(R.id.btnD6)
        val rollD20: Button =  findViewById(R.id.btnD20)
        val txtResultRoll = findViewById<TextView>(R.id.txtRollResult)

        rollD6.setOnClickListener {
            txtResultRoll.text = showResultDieRoll(myd6)
        }
        rollD20.setOnClickListener {
            txtResultRoll.text = showResultDieRoll(myd20)
        }
    }

    private val myd6 = Dice(6, "red")
    private val myd20 = Dice(20, "black")

    private fun rollD6() = myd6.roll()

    private fun rollD20() = myd20.roll()

    private fun showResultDieRoll(dice: Dice) =
        if(dice.sides == 6) rollD6()
        else rollD20()


}