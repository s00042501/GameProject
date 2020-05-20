package com.example.gameproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ThemeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme)

    }
        //select  a theme and then move to the level activity
        // we activate  the theme (img_frozen_theme ) only to open next activity


        fun callLevelActivity (view: View?) {
            val moveToLevel= Intent (this, LevelActivity::class.java)
            startActivity(moveToLevel)

        }

}
