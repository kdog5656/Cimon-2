package com.example.cimon_1

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button

class GamePageActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }

    private fun onButtonFlash(buttonId: Int) {

        val timer = Handler()

        val accessButton = findViewById<Button>(buttonId)
        // access button info

        val buttonColor = accessButton.background
        // log original button color


        when (buttonId) {

            R.id.Red_Button -> {
                accessButton.background.setTint(Color.RED)
                // flash button

                timer.postDelayed({accessButton.background = buttonColor }, 1000)
                // change button color back to normal
            }

            R.id.Yellow_Button -> {
                buttonColor.setTint(Color.YELLOW)
                // flash button

                timer.postDelayed({accessButton.background = buttonColor }, 1000)
                // change button color back to normal
            }

            R.id.Purple_Button -> {
                buttonColor.setTint(Color.MAGENTA)
                // flash button

                timer.postDelayed({accessButton.background = buttonColor }, 1000)
                // change button color back to normal
            }

            R.id.Blue_Button -> {
                buttonColor.setTint(Color.BLUE)
                // flash button

                timer.postDelayed({accessButton.background = buttonColor }, 1000)
                // change button color back to normal
            }
        }
    }

    fun onClick(view: View) {

        when (view.id) {

            R.id.Red_Button -> {

                val redButtonIntent = Intent(this, GamePageActivity::class.java)
                // this (button) -> needs to be flash & record button click

                startActivity(redButtonIntent)
                // button does wanted action

                onButtonFlash(R.id.Red_Button)
                // flash color on click
            }
            R.id.Yellow_Button -> {

                val yellowButtonIntent = Intent(this, GamePageActivity::class.java)
                // this (button) -> needs to be flash & record button click

                startActivity(yellowButtonIntent)
                // button does wanted action

                onButtonFlash(R.id.Yellow_Button)
                // flash color on click
            }
            R.id.Purple_Button -> {

                val purpleButtonIntent = Intent(this, GamePageActivity::class.java)
                // this (button) -> needs to be flash & record button click

                startActivity(purpleButtonIntent)
                // button does wanted action

                onButtonFlash(R.id.Purple_Button)
                // flash color on click
            }
            R.id.Blue_Button -> {

                val blueButtonIntent = Intent(this, GamePageActivity::class.java)
                // this (button) -> needs to be flash & record button click

                startActivity(blueButtonIntent)
                // button does wanted action

                onButtonFlash(R.id.Blue_Button)
                // flash color on click
            }
            R.id.Pause_Button -> {

                val pauseButtonIntent = Intent(this, GamePageActivity::class.java)
                // this (button) -> needs to be flash & record button click

                startActivity(pauseButtonIntent)
                // button does wanted action
            }
            R.id.About_Button -> {

                val aboutButtonIntent = Intent(this, GamePageActivity::class.java)
                // this (button) -> needs to be flash & record button click

                startActivity(aboutButtonIntent)
                // button does wanted action
            }
        }
    }
}
