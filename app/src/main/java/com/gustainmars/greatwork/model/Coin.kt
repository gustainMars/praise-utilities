package com.gustainmars.greatwork.model

object CoinStates {
    const val HEADS = "heads"
    const val TAILS = "tails"
}

class Coin {

    private fun flip(): String {
        return if((1..2).random() == 1) CoinStates.TAILS else CoinStates.HEADS
    }

    fun bestOf3(): String {
        var headsCount = 0
        var tailsCount = 0

        repeat(3){
            val coin = flip()
            if(coin == CoinStates.TAILS)
                tailsCount++
            else
                headsCount++
        }

        return if(tailsCount > headsCount) "${CoinStates.TAILS} wins!" else "${CoinStates.HEADS} wins!"
    }
}