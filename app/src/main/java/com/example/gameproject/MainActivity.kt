package com.example.gameproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
        //connect the first screen to the second screen by using Intent
        //click on start button to move to theme activity
        fun callThemeActivity (view: View?) {
            val moveToSecond = Intent (this, ThemeActivity::class.java)
            startActivity(moveToSecond)
        }

}
