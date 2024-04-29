package com.example.cimon_1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.cimon_1.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

//NOTE: No floating action bar named fab in kt just java

class MainActivity : AppCompatActivity() {

    private lateinit var fbRef: DatabaseReference
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fbRef= FirebaseDatabase.getInstance().getReference("test")

        binding.ProfileButton.setOnClickListener{
            fbRef.setValue("Checking").addOnCompleteListener{
                Toast.makeText(this, "Success, data stored", Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun onClick(view: View) {

        when (view.id) {

            R.id.Start_Button -> {
                val startIntent = Intent(this, StartActivity::class.java)
                startActivity(startIntent)
            }
            R.id.Leaderboard_Button -> {
                val leaderboardIntent = Intent(this,LeaderBoardActivity::class.java)
                startActivity(leaderboardIntent)
            }
            R.id.Settings_Button -> {
                val settingsIntent = Intent(this, SettingsActivity::class.java)
                startActivity(settingsIntent)

            }
            R.id.About_Button -> {
                val aboutActivity = Intent(this, AboutActivity::class.java)
                startActivity(aboutActivity)
            }
            R.id.Profile_Button -> {
                val profileIntent = Intent(this, ProfileActivity::class.java)
                startActivity(profileIntent)
            }

        }
    }
}