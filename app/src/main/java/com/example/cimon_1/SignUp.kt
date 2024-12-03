package com.example.cimon_1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SignUp : AppCompatActivity() {

    private lateinit var pRecyclerView: RecyclerView
    private lateinit var tvLoadingData: TextView
    private lateinit var pList: ArrayList<PlayerModel>
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        pRecyclerView = findViewById(R.id.rvEmp)
        pRecyclerView.layoutManager = LinearLayoutManager(this)
        pRecyclerView.setHasFixedSize(true)
        tvLoadingData = findViewById(R.id.tvLoadingData)

        pList = arrayListOf<PlayerModel>()

        getPlayerData()

    }

    private fun getPlayerData() {

        pRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE

        dbRef = FirebaseDatabase.getInstance().getReference("Players")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                pList.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(PlayerModel::class.java)
                        pList.add(empData!!)
                    }
                    val mAdapter = PayerAdapter(pList)
                    pRecyclerView.adapter = mAdapter

                    mAdapter.setOnItemClickListener(object : PayerAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {

                            val intent = Intent(this@SignUp, PlayerDetails::class.java)

                            //put extras
                            intent.putExtra("pId", pList[position].pId)
                            intent.putExtra("pName", pList[position].pName)
                            intent.putExtra("pScore", pList[position].pScore)
                            startActivity(intent)
                        }

                    })

                    pRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}