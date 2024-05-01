package com.example.cimon_1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // added

        val startButton = findViewById<Button>(R.id.Start_Button)

        startButton.setOnClickListener { onClick(it) }
}

    private fun onClick(view: View) {

        val intent = when (view.id) {

            R.id.Start_Button -> Intent(this@MainActivity, StartActivity::class.java)
            else -> throw IllegalArgumentException("Unknown")
        }
        startActivity(intent)
    }
}