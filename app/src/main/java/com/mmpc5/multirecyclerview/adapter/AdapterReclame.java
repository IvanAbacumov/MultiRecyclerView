package com.mmpc5.multirecyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mmpc5.multirecyclerview.R;

import java.util.ArrayList;

public class AdapterReclame extends RecyclerView.Adapter<AdapterReclame.ViewHolder> {


    private ArrayList<String> mDataset;

    public AdapterReclame(ArrayList<String> mDataset){
        this.mDataset = mDataset;
    }

    @Override
    public AdapterReclame.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_recycler_type,parent,false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(AdapterReclame.ViewHolder holder, int position) {
        holder.mTitle.setText(mDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        public TextView mTitle;
        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title);
        }
    }
}