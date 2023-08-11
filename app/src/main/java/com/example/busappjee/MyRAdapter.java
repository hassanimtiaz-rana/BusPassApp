package com.example.busappjee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRAdapter extends RecyclerView.Adapter<MyRAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<user> list;
    private ArrayList<user> filteredList;

    public MyRAdapter(Context context, ArrayList<user> list) {
        this.context = context;
        this.list = list;
        this.filteredList = new ArrayList<>(list);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        user User = filteredList.get(position);
        holder.firstname.setText(User.getUsername());
        holder.lastname.setText(User.getRollNum());
        holder.age.setText(User.getRoute());
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    public void filterList(ArrayList<user> filteredList) {
        this.filteredList = filteredList;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView firstname, lastname, age;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            firstname = itemView.findViewById(R.id.tvfirstName);
            lastname = itemView.findViewById(R.id.tvlastName);
            age = itemView.findViewById(R.id.tvage);
        }
    }
}
