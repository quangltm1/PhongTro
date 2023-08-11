package com.example.demoappnhatro.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.demoappnhatro.Database.TaiKhoan;
import com.example.demoappnhatro.R;

import java.util.ArrayList;

public class NguoiThueAdapter extends ArrayAdapter<TaiKhoan> {

    private Context mContext;
    private ArrayList<TaiKhoan> mListNguoiThue;

    public NguoiThueAdapter(Context context, ArrayList<TaiKhoan> listNguoiThue) {
        super(context, 0, listNguoiThue);
        mContext = context;
        mListNguoiThue = listNguoiThue;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;

        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_nguoithue, parent, false);
            holder = new ViewHolder();
            holder.tvNguoiThueId = view.findViewById(R.id.tvNguoiThueId);
            holder.tvTenTaiKhoan = view.findViewById(R.id.tvTenTaiKhoan);
            holder.tvTenPhong = view.findViewById(R.id.tvTenPhong);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        // Lấy đối tượng người thuê tại vị trí position
        TaiKhoan nguoiThue = mListNguoiThue.get(position);


        // Hiển thị thông tin người thuê lên giao diện
        holder.tvNguoiThueId.setText("Người thuê: " + nguoiThue.getNguoiDungId());
        holder.tvTenTaiKhoan.setText("Tên tài khoản: " + nguoiThue.getTenDangNhap());
        holder.tvTenPhong.setText("Phòng: " + nguoiThue.getPhongTroId());

        return view;
    }

    static class ViewHolder {
        TextView tvNguoiThueId;
        TextView tvTenTaiKhoan;
        TextView tvTenPhong;
    }
}
