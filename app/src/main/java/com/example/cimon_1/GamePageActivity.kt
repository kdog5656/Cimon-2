package com.example.cimon_1

import android.app.Activity
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.Toast

class GamePageActivity : Activity() {

    private val timer = Handler()  // handler for timer
    private var gameRound: Int = 0

    private val gameQueue = mutableListOf<Int>() // log of colors used, for user to repeat
    private val userQueue = mutableListOf<Int>() // log of colors used, from user

    private val gameButtons = listOf(

        R.id.Red_Button,
        R.id.Yellow_Button,
        R.id.Purple_Button,
        R.id.Blue_Button,

        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val redButton = findViewById<Button>(R.id.Red_Button)
        val blueButton = findViewById<Button>(R.id.Blue_Button)
        val yellowButton = findViewById<Button>(R.id.Yellow_Button)
        val purpleButton = findViewById<Button>(R.id.Purple_Button)
        val doneButton = findViewById<Button>(R.id.Done_Button)

        redButton.setOnClickListener { beginGame(it) }
        blueButton.setOnClickListener { beginGame(it) }
        yellowButton.setOnClickListener { beginGame(it) }
        purpleButton.setOnClickListener { beginGame(it) }
        doneButton.setOnClickListener{beginGame(it)}


            newGame()
    }

    private fun newGame() {

        gameQueue.clear()     // reset game
        userQueue.clear()     // reset user queue
        gameRound = 0               // reset game round
        addNewToGameQueue()          // add one button to the queue
        repeatPattern()             // flash pattern
    }

    private fun beginGame(button: View) {

        when (button.id) {

            R.id.Red_Button -> {
                userQueue.add(R.id.Red_Button)
            }
            R.id.Yellow_Button -> {
                userQueue.add(R.id.Yellow_Button)
            }
            R.id.Purple_Button -> {
                userQueue.add(R.id.Purple_Button)
            }
            R.id.Blue_Button -> {
                userQueue.add(R.id.Blue_Button)
            }
            R.id.Back_Button -> {

                val intent = Intent(this@GamePageActivity, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.Done_Button -> {
                val result = compareQueue()
                gameStatus(result)
                if (result) {
                    gameRound++
                    addNewToGameQueue()
                    repeatPattern()
                } else {
                    newGame()
                }
            }
        }
    }

    private fun gameStatus(result: Boolean) {  // win or lose message status

        if (result) {
            Toast.makeText(this@GamePageActivity, "NICE!", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(this@GamePageActivity, "TRY AGAIN!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun compareQueue(): Boolean {

        return gameQueue == userQueue
    }

    private fun addNewToGameQueue() {

        val randoColor = gameButtons.random() // pick random button from game buttons
        gameQueue.add(randoColor) // add random button to game queue
    }

    private fun repeatPattern() {

        for ((index, button) in gameQueue.withIndex())  {

                timer.postDelayed({
                    buttonFlash(button)
                }, (index * 1000).toLong())  // stop button flash happening at the same time
        }
    }

    private fun buttonFlash(buttonId: Int) {
        val button = findViewById<Button>(buttonId)
        val originalColor = button.backgroundTintList  // Save the original button color

        // Assigning button color to color of flash
        val flashColor = when (buttonId) {
            R.id.Red_Button -> Color.RED
            R.id.Yellow_Button -> Color.YELLOW
            R.id.Purple_Button -> Color.MAGENTA
            R.id.Blue_Button -> Color.BLUE
            else -> return  // Exit if button ID is not recognized
        }

        button.backgroundTintList = ColorStateList.valueOf(flashColor)  // Flash the button color

        timer.postDelayed({
            // Restore the original button color
            button.backgroundTintList = originalColor
        }, 1000)
    }
}
