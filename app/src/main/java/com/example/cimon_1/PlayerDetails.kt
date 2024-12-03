package com.example.cimon_1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.color.utilities.Score


private lateinit var tvpId: TextView
private lateinit var tvpName: TextView
private lateinit var tvpScore: TextView
private lateinit var btnUpdate: Button
private lateinit var btnDelete: Button

class PlayerDetails {
    fun onCreate(savedInstanceState: Bundle?) {
        onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_details)

    initView()
    setValuesToViews()
    btnUpdate.setOnClickListener{
        openUpdateDialog(
            intent.getStringExtra("pId").toString,
            intent.getStringExtra("pName").toString()
        )

}

private fun initView() {
    tvpId = findViewById(R.id.tvpId)
    tvpName = findViewById(R.id.tvpName)
    tvpScore = findViewById(R.id.tvpScore)

    btnUpdate = findViewById(R.id.btnUpdate)
    btnDelete = findViewById(R.id.btnDelete)
}

private fun setValuesToViews() {
        tvpId.text = intent.getStringExtra("pId")
        tvpName.text = intent.getStringExtra("pName")
        tvpScore.text = intent.getStringExtra("pScore")

}
}

    private fun Any.onCreate(savedInstanceState: Bundle?) {

}
}