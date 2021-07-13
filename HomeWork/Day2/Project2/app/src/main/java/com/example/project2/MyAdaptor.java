package com.example.project2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdaptor extends RecyclerView.Adapter <MyAdaptor.MyViewHolder> {

    private List<People> peopleList;

    public MyAdaptor(List<People> peopleList) {
        this.peopleList = peopleList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(itemView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        People people = peopleList.get(position);
        holder.nameText.setText(people.getName());
        holder.head.setImageResource(people.getHeadId());
    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameText;
        ImageView head;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.nameText = itemView.findViewById(R.id.textView4);
            this.head = itemView.findViewById(R.id.imageView);
        }
    }
}
