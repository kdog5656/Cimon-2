package com.example.cimon_1

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button

class GamePageActivity : Activity() {

    private val timer = Handler()  // handler for timer
    private val delayDuration = 1000L
    private val flashDuration = 500L

    private val gameColorQueue = mutableListOf<Int>() // log of colors used, for user to repeat
    private val gameButtons = listOf(

        R.id.Red_Button,
        R.id.Yellow_Button,
        R.id.Purple_Button,
        R.id.Blue_Button,

    )
    private var userIndex = 0  // user tracker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        newGame() // start game
    }

    private fun newGame() {

        gameColorQueue.clear()    // reset game
        userIndex = 0        // Index user place in game
        addNewColorToQueue()      // add another color to the queue
        repeatPattern()    // flash pattern
    }

//    private fun buttonToggle(currentButton: Button): Boolean {
//
//     for (element in gameButtons) {
//
//         val currentButtonId = findViewById<Button>(element) // access button information from button Index
//
//         if (){
//
//             currentButton.isClickable = true
//         }
//         else {
//
//             currentButton.isClickable = false
//         }
//     }
//}
    private fun addNewColorToQueue() {

        val randoColor = gameButtons.random() // pick random button from game buttons
        gameColorQueue.add(randoColor) // add random button to game queue
    }

    private fun repeatPattern() {

        //buttonToggle()

    }



    private fun buttonFlash(buttonId: Int) {

        val accessButton = findViewById<Button>(buttonId)
        // access button info

        val buttonColor = accessButton.background.mutate()
        // log original button color


        when (buttonId) {

            R.id.Red_Button -> {
                accessButton.background.setTint(Color.RED)
                // flash button

                timer.postDelayed({ accessButton.background = buttonColor }, 1000)
                // change button color back to normal
            }

            R.id.Yellow_Button -> {
                buttonColor.setTint(Color.YELLOW)
                // flash button

                timer.postDelayed({ accessButton.background = buttonColor }, 1000)
                // change button color back to normal
            }

            R.id.Purple_Button -> {
                buttonColor.setTint(Color.MAGENTA)
                // flash button

                timer.postDelayed({ accessButton.background = buttonColor }, 1000)
                // change button color back to normal
            }

            R.id.Blue_Button -> {
                buttonColor.setTint(Color.BLUE)
                // flash button

                timer.postDelayed({ accessButton.background = buttonColor }, 1000)
                // change button color back to normal
            }
        }
    }

    fun onClick(view: View) {

        when (view.id) {

            R.id.Red_Button -> {

                buttonFlash(R.id.Red_Button)
                // flash color on click



            }

            R.id.Yellow_Button -> {

                buttonFlash(R.id.Yellow_Button)
                // flash color on click
            }

            R.id.Purple_Button -> {

                buttonFlash(R.id.Purple_Button)
                // flash color on click
            }

            R.id.Blue_Button -> {

                buttonFlash(R.id.Blue_Button)
                // flash color on click
            }

            R.id.Pause_Button -> {


            }

            R.id.About_Button -> {


            }
        }
    }
}