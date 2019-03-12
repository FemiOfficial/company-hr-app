package com.example.alayesanmifemi.companyapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Alayesanmi Femi on 26/02/2019.
 */

public class ProjectRecyclerAdapter extends RecyclerView.Adapter<ProjectRecyclerAdapter.myViewHolder> {
    private Context mContext;
    private List<Projects> mData;

    public ProjectRecyclerAdapter(Context mContext, List<Projects> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater Inflatter = LayoutInflater.from(mContext);
        view = Inflatter.inflate(R.layout.project_list_layout, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProjectRecyclerAdapter.myViewHolder holder, final int position) {
        holder.project_name.setText(String.format("Project Name: %s", mData.get(position).getName()));
        holder.project_location.setText(String.format("Project Location: %s", mData.get(position).getLocation()));
        holder.project_status.setText(String.format("Project Status: %s", mData.get(position).getStart()));
        holder.project_start.setText(String.format("Project Start: %s", mData.get(position).getStatus()));
        holder.project_finish.setText(String.format("Project Finish: %s", mData.get(position).getFinish()));

    }
    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{
        TextView project_name;
        TextView project_location;
        TextView project_status;
        TextView project_start;
        TextView project_finish;

        public myViewHolder(View itemView){
            super(itemView);
            project_name = (TextView) itemView.findViewById(R.id.project_name);
            project_location = (TextView) itemView.findViewById(R.id.project_location);
            project_status = (TextView) itemView.findViewById(R.id.project_status);
            project_start = (TextView) itemView.findViewById(R.id.project_start);
            project_finish = (TextView) itemView.findViewById(R.id.project_finish);
        }
    }
}
