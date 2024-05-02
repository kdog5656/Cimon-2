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
    private val handlerMap = mutableMapOf<Int, Runnable>() // stop button flash from overlapping

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

        redButton.setOnClickListener { beginGame(it) }
        blueButton.setOnClickListener { beginGame(it) }
        yellowButton.setOnClickListener { beginGame(it) }
        purpleButton.setOnClickListener { beginGame(it) }

        timer.postDelayed({
            newGame()
        }, 1000) // start game
    }

    private fun newGame() {

        gameQueue.clear()     // reset game
        gameRound = 0               // reset game round
        addNewToGameQueue()          // add one button to the queue
        repeatPattern()             // flash pattern
    }

    fun beginGame(button: View) {

        when (button.id) {

            R.id.Red_Button -> {

                userQueue.add(R.id.Red_Button)
                compareQueue()
                gameStatus()
            }

            R.id.Yellow_Button -> {

                userQueue.add(R.id.Yellow_Button)
                compareQueue()
                gameStatus()
            }

            R.id.Purple_Button -> {

                userQueue.add(R.id.Purple_Button)
                compareQueue()
                gameStatus()
            }

            R.id.Blue_Button -> {
                userQueue.add(R.id.Blue_Button)
                compareQueue()
                gameStatus()
            }

            R.id.Back_Button -> {
                val intent = Intent(this@GamePageActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun gameStatus() {  // win or lose message status

        if (compareQueue()) {
            Toast.makeText(this@GamePageActivity, "NICE!", Toast.LENGTH_SHORT).show()
        }
        if (!compareQueue()) {
            Toast.makeText(this@GamePageActivity, "TRY AGAIN!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun compareQueue(): Boolean {

        return if (userQueue == gameQueue) {
            gameRound++
            addNewToGameQueue()
            repeatPattern()
            true
        } else {
            newGame()
            false
        }
    }

    private fun addNewToGameQueue() {

        val randoColor = gameButtons.random() // pick random button from game buttons
        gameQueue.add(randoColor) // add random button to game queue
    }

    private fun repeatPattern() {

        for (button in gameQueue) {

            buttonFlash(button) // flash each button in records
        }
        addNewToGameQueue() // add new button after repeat
    }

    private fun buttonFlash(buttonId: Int) {

        val accessButton = findViewById<Button>(buttonId)
        handlerMap[buttonId]?.let { timer.removeCallbacks(it) }
        val originalTintList = accessButton.backgroundTintList

        val flashColor = ColorStateList.valueOf(
            when (buttonId) {
                R.id.Red_Button -> Color.RED
                R.id.Yellow_Button -> Color.YELLOW
                R.id.Purple_Button -> Color.MAGENTA
                R.id.Blue_Button -> Color.BLUE
                else -> return
            }
        )

        accessButton.backgroundTintList = flashColor

        val restoreRunnable = Runnable {
            accessButton.backgroundTintList = originalTintList
        }

        handlerMap[buttonId] = restoreRunnable
        timer.postDelayed(restoreRunnable, 1000)
    }
}