package com.example.adminpanel2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter1 extends RecyclerView.Adapter<RecyclerViewAdapter1.MyViewHolder1> {

    Context context;
    List<Event> list;

    public RecyclerViewAdapter1(Context context, List<Event> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter1.MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.event, parent, false);
        return new MyViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter1.MyViewHolder1 holder, int position) {

        holder.address.setText(list.get(position).getAddress());
        holder.time.setText(list.get(position).getTime());
        holder.date.setText(list.get(position).getDate());
        holder.Name.setText(list.get(position).getEventn());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder {

        TextView date,time,address,Name;

        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.date);
            time=itemView.findViewById(R.id.time);
            address=itemView.findViewById(R.id.address);
            Name=itemView.findViewById(R.id.eventn);
        }
    }
}
