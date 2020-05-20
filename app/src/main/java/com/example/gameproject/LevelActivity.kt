package com.example.gameproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LevelActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)

    }
    //select a level and then move to game activity
    // we activate level one only to open the game activity
    fun callGameActivity(view: View?){
        val moveToGame = Intent(this, GameActivity::class.java)
        startActivity(moveToGame)

    }
}
