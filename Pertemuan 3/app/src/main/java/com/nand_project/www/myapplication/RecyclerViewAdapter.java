package com.nand_project.www.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<String> rvData;

    public RecyclerViewAdapter(ArrayList<String> data){
        rvData = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_nama;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_nama = itemView.findViewById(R.id.nama);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_main_list,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.tv_nama.setText(rvData.get(i));

    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }
}
