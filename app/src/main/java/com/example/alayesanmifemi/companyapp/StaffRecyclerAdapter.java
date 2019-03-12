package com.example.alayesanmifemi.companyapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Alayesanmi Femi on 25/02/2019.
 */

public class StaffRecyclerAdapter extends RecyclerView.Adapter<StaffRecyclerAdapter.myViewHolder> {

    private Context mContext;
    private List<Staff> mData;

    public StaffRecyclerAdapter(Context mContext, List<Staff> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater Inflatter = LayoutInflater.from(mContext);
        view = Inflatter.inflate(R.layout.list_layout, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, final int position) {
        holder.staff_name.setText(String.format("Staff Name: %s", mData.get(position).getName()));
        holder.staff_post.setText(String.format("Staff Position: %s", mData.get(position).getPosition()));

    }
    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{
        TextView staff_name;
        TextView staff_post;
        public myViewHolder(View itemView){
            super(itemView);
            staff_name = (TextView) itemView.findViewById(R.id.staff_name);

            staff_post = (TextView) itemView.findViewById(R.id.staff_post);
        }
    }
}
