package com.example.demoappnhatro.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.demoappnhatro.Database.PhongTro;
import com.example.demoappnhatro.R;

import java.util.ArrayList;

public class PhongTroAdapter extends ArrayAdapter<PhongTro> {
    private Context mContext;

    public PhongTroAdapter(Context context, ArrayList<PhongTro> mListPhongTro) {
        super(context, 0, mListPhongTro);
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);

        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.item_phong, parent, false);
        }
        PhongTro phongTro = getItem(position);
        if (phongTro != null) {
            TextView tvTenPhong = view.findViewById(R.id.tv_Name_Phong);
            TextView tvGiaPhong = view.findViewById(R.id.tv_Gia_Tien);
            TextView tvDienTich = view.findViewById(R.id.tv_Dien_Tich);
            TextView tvTrangThai = view.findViewById(R.id.tv_Trang_Thai);
            int trangThai = phongTro.getTrangThaiPhong();
            String trangThaiText = trangThai == 0 ? "Chưa cho thuê" : "Đã cho thuê";
            TextView tvMoTa = view.findViewById(R.id.tv_Mo_Ta);

            // Set giá trị cho từng TextView
            tvTenPhong.setText(phongTro.getTenPhong());
            tvGiaPhong.setText("Giá tiền: " + phongTro.getGiaThuePhong());
            tvDienTich.setText("Diện tích: " + phongTro.getDienTich());
            tvTrangThai.setText("Trạng thái: " + trangThaiText);
            tvMoTa.setText("Mô tả: " + phongTro.getMoTaPhong());
        }
        return view;
    }
}
