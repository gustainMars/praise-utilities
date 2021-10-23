package com.gustainmars.greatwork

import com.gustainmars.greatwork.model.Dice

abstract class DiceActivity {
    private val myd6 = Dice(6, "red")
    private val myd20 = Dice(20, "black")

    fun rollD6() {
        myd6.roll()
    }

    fun rollD20() {
        myd20.roll()
    }
}