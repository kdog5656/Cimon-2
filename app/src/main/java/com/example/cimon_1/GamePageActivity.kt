package com.example.cimon_1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View

class GamePageActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }

    fun onClick(view: View) {

        when (view.id) {

            R.id.Red_Button -> {

                val redButtonIntent = Intent(this, GamePageActivity::class.java)
                startActivity(redButtonIntent)
            }
            R.id.Yellow_Button -> {

                val yellowButtonIntent = Intent(this, GamePageActivity::class.java)
                startActivity(yellowButtonIntent)
            }
            R.id.Purple_Button -> {

                val purpleButtonIntent = Intent(this, GamePageActivity::class.java)
                startActivity(purpleButtonIntent)
            }
            R.id.Blue_Button -> {

                val blueButtonIntent = Intent(this, GamePageActivity::class.java)
                startActivity(blueButtonIntent)
            }
            R.id.Pause_Button -> {

                val pauseButtonIntent = Intent(this, GamePageActivity::class.java)
                startActivity(pauseButtonIntent)
            }
            R.id.About_Button -> {

                val aboutButtonIntent = Intent(this, GamePageActivity::class.java)
                startActivity(aboutButtonIntent)
            }

        }
    }
}
