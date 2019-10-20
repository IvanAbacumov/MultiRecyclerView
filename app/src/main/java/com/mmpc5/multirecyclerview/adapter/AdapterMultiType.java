package com.mmpc5.multirecyclerview.adapter;

import android.content.Context;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mmpc5.multirecyclerview.R;
import com.mmpc5.multirecyclerview.model.Model;

import java.util.ArrayList;

public class AdapterMultiType extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<Model> dataSet;
    Context mContext;
    int total_types;

    public static class TextTypeViewHolder extends RecyclerView.ViewHolder {


        TextView txtType;
        CardView cardView;

        public TextTypeViewHolder(View itemView) {
            super(itemView);

            this.txtType = (TextView) itemView.findViewById(R.id.type);
            this.cardView = (CardView) itemView.findViewById(R.id.card_view);

        }

    }

    // RecyclerView for RECLAME
    public  static  class RecyclerReclameTypeViewHolder extends RecyclerView.ViewHolder{

        private RecyclerView mRecyclerViewProfile;
        private RecyclerView.LayoutManager mLayoutManagerProfile;
        private RecyclerView.Adapter mAdapterProfile;
        private ArrayList<String> mDataSet;

        public RecyclerReclameTypeViewHolder(View itemView) {
            super(itemView);

            mDataSet = new ArrayList<>();
            for (int i = 0; i<30; i++){
                mDataSet.add("New Title #" + i);
            }

            // Initializing the RecyclerView and sending data to it(string)
            mRecyclerViewProfile = (RecyclerView) itemView.findViewById(R.id.recycler_type);

            SnapHelper snapHelper = new PagerSnapHelper();
            snapHelper.attachToRecyclerView(mRecyclerViewProfile);

            mRecyclerViewProfile.setHasFixedSize(true);
            mLayoutManagerProfile = new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.HORIZONTAL,false);
            mRecyclerViewProfile.setLayoutManager(mLayoutManagerProfile);
            mAdapterProfile = new AdapterReclame(mDataSet);
            mRecyclerViewProfile.setAdapter(mAdapterProfile);

        }
    }



    // RecyclerView for CONTACTS
    public  static  class RecyclerContactTypeViewHolder extends RecyclerView.ViewHolder{

        private RecyclerView mRecyclerViewProfile;
        private RecyclerView.LayoutManager mLayoutManagerProfile;
        private RecyclerView.Adapter mAdapterProfile;
        private ArrayList<String> mDataSet;

        public RecyclerContactTypeViewHolder(View itemView) {
            super(itemView);

            mDataSet = new ArrayList<>();
            for (int i = 0; i<30; i++){
                mDataSet.add("Name #" + i);
            }

            // Initializing the RecyclerView and sending data to it(string)
            mRecyclerViewProfile = (RecyclerView) itemView.findViewById(R.id.recycler_contact_type);

            SnapHelper snapHelper = new PagerSnapHelper();
            snapHelper.attachToRecyclerView(mRecyclerViewProfile);

            mRecyclerViewProfile.setHasFixedSize(true);
            mLayoutManagerProfile = new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.HORIZONTAL,false);
            mRecyclerViewProfile.setLayoutManager(mLayoutManagerProfile);
            mAdapterProfile = new AdapterContact(mDataSet);
            mRecyclerViewProfile.setAdapter(mAdapterProfile);
        }
    }



    public AdapterMultiType(ArrayList<Model> data, Context context) {
        this.dataSet = data;
        this.mContext = context;
        total_types = dataSet.size();

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        switch (viewType) {
            case Model.TEXT_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_type, parent, false);
                return new TextTypeViewHolder(view);
            case Model.RECYCLER_RECLAME_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_reclame_type,parent,false);
                return new RecyclerReclameTypeViewHolder(view);
            case Model.RECYCLER_CONTACT_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_contact_type,parent,false);
                return new RecyclerContactTypeViewHolder(view);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {

        switch (dataSet.get(position).type) {
            case 0:
                return Model.TEXT_TYPE;
            case 1:
                return Model.RECYCLER_RECLAME_TYPE;
            case 2:
                return Model.RECYCLER_CONTACT_TYPE;
            default:
                return -1;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {

        Model object = dataSet.get(listPosition);
        if (object != null) {
            switch (object.type) {
                case Model.TEXT_TYPE:
                    ((TextTypeViewHolder) holder).txtType.setText(object.text);

                    break;
            }
        }

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
