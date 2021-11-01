package com.gustainmars.greatwork.model

class Dice (val sides : Int, private val color: String) {
    fun roll() = (1..sides).random().toString()
}

enum class ClassDifficulty (val value: Int){
    EASY(5),
    NORMAL(10),
    HARD(15),
    SUPER_HARD(20),
    MISSION_IMPOSSIBLE(25),
    JUST_4_GODS(30)
}