package com.mmpc5.multirecyclerview.adapter

import android.content.Context

import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.mmpc5.multirecyclerview.R
import com.mmpc5.multirecyclerview.model.Model

import java.util.ArrayList

class AdapterMultiType(private val dataSet: ArrayList<Model>, internal var mContext: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
     var total_types: Int = 0

    class TextTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


         var txtType: TextView = itemView.findViewById(R.id.type)
         var cardView: CardView = itemView.findViewById(R.id.card_view)



    }

    // RecyclerView for RECLAME
    class RecyclerReclameTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val mRecyclerViewProfile: RecyclerView
        private val mLayoutManagerProfile: RecyclerView.LayoutManager
        private val mAdapterProfile: RecyclerView.Adapter<*>
        private val mDataSet: ArrayList<String> = ArrayList()

        init {

            for (i in 0..29) {
                mDataSet.add("New Title #$i")
            }

            // Initializing the RecyclerView and sending data to it(string)
            mRecyclerViewProfile = itemView.findViewById<View>(R.id.recycler_type) as RecyclerView

            val snapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(mRecyclerViewProfile)

            mRecyclerViewProfile.setHasFixedSize(true)
            mLayoutManagerProfile = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            mRecyclerViewProfile.layoutManager = mLayoutManagerProfile
            mAdapterProfile = AdapterReclame(mDataSet)
            mRecyclerViewProfile.adapter = mAdapterProfile

        }
    }


    // RecyclerView for CONTACTS
    class RecyclerContactTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val mRecyclerViewProfile: RecyclerView
        private val mLayoutManagerProfile: RecyclerView.LayoutManager
        private val mAdapterProfile: RecyclerView.Adapter<*>
        private val mDataSet: ArrayList<String> = ArrayList()

        init {

            for (i in 0..29) {
                mDataSet.add("Name #$i")
            }

            // Initializing the RecyclerView and sending data to it(string)
            mRecyclerViewProfile = itemView.findViewById<View>(R.id.recycler_contact_type) as RecyclerView

          //  val snapHelper = PagerSnapHelper()
           // snapHelper.attachToRecyclerView(mRecyclerViewProfile)

            mRecyclerViewProfile.setHasFixedSize(true)
            mLayoutManagerProfile = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            mRecyclerViewProfile.layoutManager = mLayoutManagerProfile
            mAdapterProfile = AdapterContact(mDataSet)
            mRecyclerViewProfile.adapter = mAdapterProfile
        }
    }


    init {
        total_types = dataSet.size

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view: View
        return when (viewType) {
            Model.TEXT_TYPE -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.text_type, parent, false)
                TextTypeViewHolder(view)
            }
            Model.RECYCLER_RECLAME_TYPE -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_reclame_type, parent, false)
                RecyclerReclameTypeViewHolder(view)
            }
            Model.RECYCLER_CONTACT_TYPE -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_contact_type, parent, false)
                RecyclerContactTypeViewHolder(view)
            }
            else -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.text_type, parent, false)
                TextTypeViewHolder(view)
            }
        }

    }

    override fun getItemViewType(position: Int): Int {

        when (dataSet[position].type) {
            0 -> return Model.TEXT_TYPE
            1 -> return Model.RECYCLER_RECLAME_TYPE
            2 -> return Model.RECYCLER_CONTACT_TYPE
            else -> return -1
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, listPosition: Int) {

        val `object` = dataSet[listPosition]
        when (`object`.type) {
            Model.TEXT_TYPE -> (holder as TextTypeViewHolder).txtType.text = `object`.text
        }

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}
