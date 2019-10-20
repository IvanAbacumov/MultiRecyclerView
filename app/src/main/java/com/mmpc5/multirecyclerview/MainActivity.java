package com.mmpc5.multirecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;


import com.mmpc5.multirecyclerview.adapter.AdapterMultiType;
import com.mmpc5.multirecyclerview.model.Model;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    AdapterMultiType adapterMultiType;

    ArrayList<Model> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();

        list.add(new Model(Model.RECYCLER_CONTACT_TYPE,"test",0));
        list.add(new Model(Model.RECYCLER_RECLAME_TYPE,"test",0));

        for(int i = 1;i<20;i++) {
            list.add(new Model(Model.TEXT_TYPE, "Contact " + String.valueOf(i), 0));
        }


        adapterMultiType = new AdapterMultiType(list,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);

         mRecyclerView =  findViewById(R.id.multiRecycler);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapterMultiType);

    }
}
