package com.mmpc5.multirecyclerview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


import com.mmpc5.multirecyclerview.adapter.AdapterMultiType
import com.mmpc5.multirecyclerview.model.Model


import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var adapterMultiType: AdapterMultiType

    private lateinit var list: ArrayList<Model>


    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list = ArrayList()

        list.add(Model(Model.RECYCLER_CONTACT_TYPE, "test", 0))
        list.add(Model(Model.RECYCLER_RECLAME_TYPE, "test", 0))

        for (i in 1..19) {
            list.add(Model(Model.TEXT_TYPE, "Contact $i", 0))
        }


        adapterMultiType = AdapterMultiType(list, this)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        mRecyclerView = findViewById(R.id.multiRecycler)
        mRecyclerView.layoutManager = linearLayoutManager
        mRecyclerView.itemAnimator = DefaultItemAnimator()
        mRecyclerView.adapter = adapterMultiType

    }
}
