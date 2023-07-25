package com.example.demoappnhatro.Adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BillAdapter extends RecyclerView.Adapter {
    //viết code lấy tên phòng và tổng tiền từ database hiện lên màn hình
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class BillViewHolder extends RecyclerView.ViewHolder {
        public BillViewHolder(@NonNull ViewGroup parent) {
            super(parent);
        }
    }


}
