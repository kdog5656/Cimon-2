package com.example.cimon_1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View

class StartActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
    }

    fun onClick(view: View) {

        when (view.id){

            R.id.CimonSays_Button -> {

                val cimonsaysIntent = Intent(this, GamePageActivity::class.java)
                startActivity(cimonsaysIntent)
            }
            R.id.Lightning_Button -> {

                val lightningIntent = Intent(this, SettingsActivity::class.java)
                startActivity(lightningIntent)
            }
            R.id.Beat_Button -> {

                val beatIntent = Intent(this, SettingsActivity::class.java)
                startActivity(beatIntent)
            }
        }

    }
}
