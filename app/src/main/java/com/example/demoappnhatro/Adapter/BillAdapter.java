package com.example.demoappnhatro.Adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoappnhatro.Database.HoaDon;

import java.util.ArrayList;
import java.util.List;

public class BillAdapter extends ArrayAdapter<HoaDon> {
    private Context mContext;
    private ArrayList<HoaDon> mListBill;

    public BillAdapter(Context context, ArrayList<HoaDon> listBill) {
        super(context, 0, listBill);
        mContext = context;
        mListBill = listBill;
    }
}
