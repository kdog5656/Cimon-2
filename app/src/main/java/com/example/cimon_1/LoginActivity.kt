package com.example.cimon_1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View

class LoginActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun onClick(view: View) {

        when (view.id) {

            R.id.Login_Button -> {

                val loginIntent = Intent(this, GamePageActivity::class.java)
                startActivity(loginIntent)
            }
        }
    }
}