package com.example.cimon_1

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.cimon_1.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // added

        val menu = Menu::class.java.newInstance()  // created instance for menu
        menuInflater.inflate(R.menu.menu_main, menu) // menu will inflate

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar) // created UI element on main xml

        val navController = findNavController(R.id.nav_graph) // changed to correct ID for nav
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        val startButton = findViewById<Button>(R.id.Start_Button)
        val leaderboardButton = findViewById<Button>(R.id.Leaderboard_Button)
        val settingsButton = findViewById<Button>(R.id.Settings_Button)
        val aboutButton = findViewById<Button>(R.id.About_Button)
        val profileButton = findViewById<Button>(R.id.Profile_Button)

        startButton.setOnClickListener { onClick(it) }
        leaderboardButton.setOnClickListener { onClick(it) }
        settingsButton.setOnClickListener { onClick(it) }
        aboutButton.setOnClickListener { onClick(it) }
        profileButton.setOnClickListener { onClick(it) }

        binding.fabLeft.setOnClickListener { view -> // created UI element on main xml
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action",null).show()
            }
        }

    private fun onClick(view: View) {

        val intent = when (view.id) {

            R.id.Start_Button -> Intent(this@MainActivity, StartActivity::class.java)
            R.id.Leaderboard_Button -> Intent(this@MainActivity, LeaderBoardActivity::class.java)
            R.id.Settings_Button -> Intent(this@MainActivity, SettingsActivity::class.java)
            R.id.About_Button -> Intent(this@MainActivity, AboutActivity::class.java)
            R.id.Profile_Button -> Intent(this@MainActivity, ProfileActivity::class.java)
            else -> throw IllegalArgumentException("Unknown")
        }

        startActivity(intent)
    }
}

    fun onActionClick(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> false  // removed super usage, no fragment available
           // now returns false for click not handled by Options menu
        }
    }

//    fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_graph)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
