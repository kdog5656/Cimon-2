package com.example.cimon_1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cimon_1.R.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Login : AppCompatActivity() {

    private lateinit var etPName: EditText
    private lateinit var etPScore: Button
    private lateinit var btnSaveData: Button

    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_login)

        etPName = findViewById(id.etPName)
        etPScore = findViewById(id.etPScore)
        btnSaveData = findViewById(id.btnSave)

        dbRef = FirebaseDatabase.getInstance().getReference("Players")

        btnSaveData.setOnClickListener {
            savePlayerData()
        }
    }

    private fun savePlayerData() {

        //getting values
        val pName = etPName.text.toString()
        val pScore = etPScore.text.toString()

        if (pName.isEmpty()) {
            etPName.error = "Please enter name"
        }

        if (pScore.isEmpty()) {
            etPScore.error = "Sorry try again later"
        }

        val pId = dbRef.push().key!!

        val player = PlayerModel(pId, pName, pScore)

        dbRef.child(pId).setValue(player)
            .addOnCompleteListener {
                Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_LONG).show()

                etPName.text.clear()

            }.addOnFailureListener { err ->
                Toast.makeText(this, "Error ${err.message},(ㆆ_ㆆ) try again", Toast.LENGTH_LONG).show()
            }

    }

}