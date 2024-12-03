package com.example.cimon_1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PayerAdapter(private val pList: ArrayList<PlayerModel>) :
    RecyclerView.Adapter<PayerAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(clickListener: onItemClickListener){
        mListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.player_list, parent, false)
        return RecyclerView.ViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentP = pList[position]
        holder.tvpName.text = currentP.pName
    }

    override fun getItemCount(): Int {
        return pList.size
    }