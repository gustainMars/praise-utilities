package com.gustainmars.greatwork

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDiceActivity = findViewById<Button>(R.id.btnDice)

        btnDiceActivity.setOnClickListener {
            val intent = Intent(this, DiceActivity::class.java)
            startActivity(intent)
        }
    }

    fun openDiceActivity() {
        setContentView(R.layout.activity_dice)
    }
}