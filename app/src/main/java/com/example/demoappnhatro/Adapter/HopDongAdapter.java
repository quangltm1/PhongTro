package com.example.demoappnhatro.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.demoappnhatro.Database.HopDong;
import com.example.demoappnhatro.R;

import java.util.ArrayList;

public class HopDongAdapter extends ArrayAdapter<HopDong> {
    private Context mContext;
    private ArrayList<HopDong> mListHopDong;

    public HopDongAdapter(Context context, ArrayList<HopDong> listHopDong) {
        super(context, 0, listHopDong);
        mContext = context;
        mListHopDong = listHopDong;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;

        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_hopdong, parent, false);
            holder = new ViewHolder();
            holder.tvTenPhong = view.findViewById(R.id.textViewTenNha);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        // Lấy đối tượng hợp đồng tại vị trí position
        HopDong hopDong = mListHopDong.get(position);

        // Hiển thị thông tin hợp đồng lên giao diện
        holder.tvTenPhong.setText("Phòng: " + hopDong.getHopDongTen());
        return view;
    }

    static class ViewHolder {
        TextView tvTenPhong;
    }
}
