package com.example.cimon_1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View

class ProfileActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }

    fun onClick(view: View) {

        when (view.id) {

            R.id.Logout_Button -> {

                val logoutButtonIntent = Intent(this, GamePageActivity::class.java)
                startActivity(logoutButtonIntent)
            }
        }
    }
}
