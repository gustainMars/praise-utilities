package com.gustainmars.greatwork

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gustainmars.greatwork.model.ClassDifficulty
import com.gustainmars.greatwork.model.Dice

class DiceActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)
        val rollD6: Button =  findViewById(R.id.btnD6)
        val rollD20: Button =  findViewById(R.id.btnD20)
        val txtResultRoll = findViewById<TextView>(R.id.txtRollResult)

        rollD6.setOnClickListener {
            showResultDieRoll(myd6).also { txtResultRoll.text = it }
        }
        rollD20.setOnClickListener {
            showResultDieRoll(myd20).also { txtResultRoll.text = it }
        }
    }

    private val myd6 = Dice(6, "red")
    private val myd20 = Dice(20, "black")

    private fun rollD6() = myd6.roll()

    private fun rollD20(cd: ClassDifficulty): String {
        val roll = myd20.roll().toInt()
        return when(roll >= cd.value) {
            true -> if(roll == 20) "A critical success, a nat $roll!" else "You rolled $roll, your test has succeeded!"
            false -> "Snap, you fail, you rolled $roll :c"
        }
    }

    private fun showResultDieRoll(dice: Dice) =
        if(dice.sides == 6) rollD6()
        else rollD20(ClassDifficulty.NORMAL)


}