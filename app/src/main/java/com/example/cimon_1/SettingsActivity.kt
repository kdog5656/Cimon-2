package com.example.cimon_1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View

class SettingsActivity : Activity() {
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

            R.id.Sounds_Button -> {

                val soundsButtonIntent = Intent(this, GamePageActivity::class.java)
                startActivity(soundsButtonIntent)
            }
        }
    }
}

