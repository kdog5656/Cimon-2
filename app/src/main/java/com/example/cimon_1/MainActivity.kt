package com.example.cimon_1

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
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

        binding.fabLeft.setOnClickListener { view -> // created UI element on main xml
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action",null).show()
            }
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