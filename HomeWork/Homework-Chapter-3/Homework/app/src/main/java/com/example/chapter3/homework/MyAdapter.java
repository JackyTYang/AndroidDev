package com.example.chapter3.homework;

import android.provider.ContactsContract;
import android.service.autofill.Dataset;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<TestData> mDataset = new ArrayList<>();
    private IOnItemClickListener mItemClickListener;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.onBind(position, mDataset.get(position));
        holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemCLick(position, mDataset.get(position));
                }
            }
        });
        holder.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemLongCLick(position, mDataset.get(position));
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface IOnItemClickListener {
        void onItemCLick(int position, TestData data);
        void onItemLongCLick(int position, TestData data);
    }

    public MyAdapter(List<TestData> myDataset) {
        mDataset.addAll(myDataset);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvMessage;
        private TextView tvTime;
        private ImageView tvImage;
        private View contentView;


        public MyViewHolder(View v) {
            super(v);
            contentView = v;
            tvName = v.findViewById(R.id.tv_name);
            tvImage = v.findViewById(R.id.tv_image);
            tvMessage = v.findViewById(R.id.tv_message);
            tvTime = v.findViewById(R.id.tv_time);
        }

        public void onBind(int position, TestData data) {
            tvName.setText(data.name.concat(": "));
            tvMessage.setText(data.title);
            tvTime.setText(data.time);
            tvImage.setImageResource(R.drawable.ic_launcher_foreground);
        }

        public void setOnClickListener(View.OnClickListener listener) {
            if (listener != null) {
                contentView.setOnClickListener(listener);
            }
        }

        public void setOnLongClickListener(View.OnLongClickListener listener) {
            if (listener != null) {
                contentView.setOnLongClickListener(listener);
            }
        }
    }
}
