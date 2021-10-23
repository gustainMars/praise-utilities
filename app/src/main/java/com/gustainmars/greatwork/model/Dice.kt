package com.gustainmars.greatwork.model

class Dice (private val sides : Int, private val color: String) {

    fun roll(): Int {
        return (1..sides).random()
    }
}