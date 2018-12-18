package com.nand_project.www.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    ArrayList<Data> rvData;
    Context context;

    public RecyclerViewAdapter(Context mContext, ArrayList<Data> inputan) {
        this.rvData = inputan;
        this.context = mContext;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_nama;
        TextView tv_mobile;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_nama = itemView.findViewById(R.id.nama);
            tv_mobile = itemView.findViewById(R.id.mobile);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_main_list,viewGroup,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, int i) {
        viewHolder.tv_nama.setText(rvData.get(i).getNama());
        viewHolder.tv_mobile.setText(rvData.get(i).getMobile());
    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }
}
