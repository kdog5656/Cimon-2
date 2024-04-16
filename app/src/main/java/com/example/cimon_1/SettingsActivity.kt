package com.example.cimon_1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View

class SettingsActivity : Activity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
    }
    fun onClick(view: View) {

        when (view.id) {

            R.id.Audio_Button -> {

                val audioButtonIntent = Intent(this, GamePageActivity::class.java)
                startActivity(audioButtonIntent)
            }
            R.id.None_Button -> {

                val noneButtonIntent = Intent(this, GamePageActivity::class.java)
                startActivity(noneButtonIntent)
            }
            R.id.Trianopia_Button -> {

                val trianopiaButtonIntent = Intent(this, GamePageActivity::class.java)
                startActivity(trianopiaButtonIntent)
            }
            R.id.Deuteranopia_Button -> {

                val deuteranopiaButtonIntent = Intent(this, GamePageActivity::class.java)
                startActivity(deuteranopiaButtonIntent)
            }
            R.id.Protanopia_Button -> {

                val protanopiaButtonIntent = Intent(this, GamePageActivity::class.java)
                startActivity(protanopiaButtonIntent)
            }
            R.id.Sounds_Button -> {

                val soundsButtonIntent = Intent(this, GamePageActivity::class.java)
                startActivity(soundsButtonIntent)
            }
            R.id.Darkmode_Button -> {

                val darkmodeButtonIntent = Intent(this, GamePageActivity::class.java)
                startActivity(darkmodeButtonIntent)
            }
        }
    }
}

