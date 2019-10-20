package com.mmpc5.multirecyclerview.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.mmpc5.multirecyclerview.R

import java.util.ArrayList

class AdapterReclame(private val mDataset: ArrayList<String>) : RecyclerView.Adapter<AdapterReclame.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.row_recycler_type, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mTitle.text = mDataset[position]
    }

    override fun getItemCount(): Int {
        return mDataset.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mTitle: TextView = itemView.findViewById(R.id.title)

    }
}