package com.example.cimon_1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cimon_1.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class MainActivity : AppCompatActivity() {
    private lateinit var fbRef: DatabaseReference
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // added

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fbRef= FirebaseDatabase.getInstance().getReference("test")

        binding.ProfileButton.setOnClickListener{
            fbRef.setValue("Checking").addOnCompleteListener{
                Toast.makeText(this, "Success, data stored", Toast.LENGTH_SHORT).show()
            }
        }

        val startButton = findViewById<Button>(R.id.Start_Button)

        startButton.setOnClickListener { onClick(it) }
}

    fun onClick(view: View) {

        val intent = when (view.id) {

            R.id.Start_Button -> Intent(this@MainActivity, GamePageActivity::class.java)
            else -> throw IllegalArgumentException("Unknown")
        }
        startActivity(intent)
    }
}