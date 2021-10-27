package com.gustainmars.greatwork.model

class Dice (val sides : Int, private val color: String) {
    fun roll() : String = (1..sides).random().toString()
}