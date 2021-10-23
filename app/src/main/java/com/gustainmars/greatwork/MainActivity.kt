package com.gustainmars.greatwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openDiceActivity(view : android.view.View) {
        setContentView(R.layout.activity_dice)
    }
}