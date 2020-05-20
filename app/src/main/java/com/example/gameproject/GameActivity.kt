package com.example.gameproject

import android.annotation.SuppressLint
import android.app.ProgressDialog.show
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_game.*
import com.example.gameproject.R.drawable.*

class GameActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

         //show a timer on the top of the screen.
        // It starts when cards randomized and stop when the player completing the game//
        // after the player finishing the game, it will show a toast message "congratulation"


        //using an array to store image cards
        //shuffle images to the different columns during each play time
        val images:MutableList<Int> =
            mutableListOf(R.drawable.frozen_anna,R.drawable.frozen_elsa, R.drawable.frozen_olaf,R.drawable.frozen_anna,R.drawable.frozen_elsa, R.drawable.frozen_olaf)

        //creating an array of buttons card
        val buttons = arrayOf(button1, button2, button3, button4, button5, button6)

        val cardBack = questionmark   // (allow to flip card and turn to original card if not match cards)

        // to prevent the player from looking to all cards at once, we have to create some variable below
        var clicked = 0      //track how many cards are clicked
        var turnOver = false   //check if two cards are turned over
        var lastClicked = -1   // what is the last cards for matching

        // randomizing images for each play time //
        images.shuffle()

        //using for loop to push images into buttons

        for (i:Int in 0..5){
            buttons[i].setBackgroundResource(cardBack)
            buttons[i].text= "cardBack"
            buttons[i].textSize = 0.0F
            buttons[i].setOnClickListener {
                //check if buttons text equal to cardBack then turn over
                if (buttons[i].text == "cardBack" && !turnOver) {
                    buttons[i].setBackgroundResource(images[i])
                    buttons[i].setText(images[i])
                    if (clicked == 0) {
                        lastClicked = i
                    }
                    clicked++

                //return images to question mark image
                }else if (buttons[i].text !in "cardBack") {
                    buttons[i].setBackgroundResource(cardBack)
                    buttons[i].text = "cardBack"
                    clicked--  // return to question mark cardBack, if two cards are not matched
                }
                //prevent two matched cards to return more than one time
                if(clicked == 2) {
                    turnOver = true
                    if (buttons[i].text == buttons[lastClicked].text) {
                        buttons[i].isClickable = false
                        buttons[lastClicked].isClickable = false
                        turnOver = false
                        clicked = 0
                        //show a toast message when two cards are matched
                        Toast.makeText(this, "WELL DONE", Toast.LENGTH_LONG).show()
                    }

                }else if (clicked == 0) {

                    turnOver = false
                }

            }


        }


    }

        //  After the player completing the game,
        //  Then he/ she  clicks on Close the Game button and it will move to the feedback activity

        fun callFeedbackActivity(view: View?){
         val moveToLast = Intent(this, FeedbackActivity::class.java)
            startActivity(moveToLast)
        }
}
