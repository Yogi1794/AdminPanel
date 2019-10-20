package com.example.adminpanel2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mcontext;
    List<user_query> mdata;

    public RecyclerViewAdapter(Context mcontext, List<user_query> mdata) {
        this.mcontext = mcontext;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.user_query, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_user.setText(mdata.get(position).getSource());
        holder.des.setText(mdata.get(position).getDestination());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_user;
        private TextView des;
        public MyViewHolder(View itemView){
            super((itemView));
            tv_user=itemView.findViewById(R.id.source);
            des=itemView.findViewById(R.id.destination);
        }

    }
}
