package com.playground.database_1;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<StudentPOJO> arrayStudent;
    private int layout;
    private String LOG_TAG = "ADAPTER";

    public  RecyclerViewAdapter(int layout, ArrayList<StudentPOJO> arrayStudent) {
        this.arrayStudent = arrayStudent;
        for (StudentPOJO student : this.arrayStudent) {
            Log.i(LOG_TAG, "Nombre: " + student.getName());
            Log.i(LOG_TAG, "Edad: " + student.getAge());
            Log.i(LOG_TAG, "Group: " + student.getGroup());
        }
        this.layout = layout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View v = li.inflate(layout, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_id.setText(arrayStudent.get(position).getId());
        holder.tv_name.setText(arrayStudent.get(position).getName());
        holder.tv_age.setText(arrayStudent.get(position).getAge());
        holder.tv_group.setText(arrayStudent.get(position).getGroup());

//        holder.tv_id.setText("Hola1");
//        holder.tv_name.setText("Hola2");
//        holder.tv_age.setText("Hola 3");
//        holder.tv_group.setText("Hola 4");
    }

    @Override
    public int getItemCount() {
        return arrayStudent.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_id, tv_name, tv_age, tv_group;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_id = itemView.findViewById(R.id.id);
            tv_name = itemView.findViewById(R.id.nombre);
            tv_age = itemView.findViewById(R.id.edad);
            tv_group = itemView.findViewById(R.id.grupo);
        }
    }
}
