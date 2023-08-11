package com.example.demoappnhatro.UI.Home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.demoappnhatro.BillActivity;
import com.example.demoappnhatro.Database.DBHelper;
import com.example.demoappnhatro.Database.Database;
import com.example.demoappnhatro.AddHopDongActivity;
import com.example.demoappnhatro.HopDongActivity;
import com.example.demoappnhatro.NguoiThueActivity;
import com.example.demoappnhatro.R;
import com.example.demoappnhatro.SuCoActivity;

import java.util.Calendar;

public class HomeFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    TextView sophongtrong, sophong, nguoithue, textView;
    RelativeLayout relativeLayout;
    ImageButton btnSuCo, btnNguoiThue, btnBill, btnHopDong;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        relativeLayout = view.findViewById(R.id.br_day);
        textView = view.findViewById(R.id.tv_xinChao);
        Calendar calendar = Calendar.getInstance();
        int Hours = calendar.get(Calendar.HOUR_OF_DAY);
        if (Hours >= 0 && Hours < 12) {
            textView.setText("Chào buổi sáng!");
            relativeLayout.setBackgroundResource(R.drawable.sang);
        } else if (Hours >= 12 && Hours < 18) {
            textView.setText("Chào buổi chiều!");
        } else {
            textView.setText("Chào buổi tối!");
            textView.setTextColor(getResources().getColor(R.color.white));
            relativeLayout.setBackgroundResource(R.drawable.sang);
        }
    }

    public void onResume() {
        super.onResume();
        updatePhongTrongVaNguoiThue();
    }

    private void updatePhongTrongVaNguoiThue() {
        // Khởi tạo instance của class Database
        Database database = new Database(getActivity());

        // Lấy số lượng phòng từ cơ sở dữ liệu bằng cách gọi phương thức layTatCaDuLieuPhongTro()
        Cursor cursor = database.layTatCaDuLieuPhongTro();
        Cursor cursor1 = database.layTatCaDuLieuNguoiThue();
        int soLuongPhong = cursor.getCount();
        int soLuongPhongTrong = 0;
        int soLuongNguoiThue = 0;

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int trangThaiPhong = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_TRANGTHAI_PHONG));
                if (trangThaiPhong == 0) {
                    // Nếu trạng thái phòng là 0 (trống) thì tăng số lượng phòng trống lên 1
                    soLuongPhongTrong++;
                }
            } while (cursor.moveToNext());
        }

        if (cursor1.moveToFirst()) {
            do {
                @SuppressLint("Range") int role = cursor1.getInt(cursor1.getColumnIndex(DBHelper.COLUMN_ROLE));
                if (role == 1) {
                    // Nếu role là 1 (người thuê) thì tăng số lượng người thuê lên 1
                    soLuongNguoiThue++;
                }
            } while (cursor1.moveToNext());
        }

        // Đóng Cursor sau khi sử dụng
        cursor.close();
        cursor1.close();

        // Hiển thị số lượng lên giao diện
        sophong.setText(String.valueOf(soLuongPhong));
        sophongtrong.setText(String.valueOf(soLuongPhongTrong));
        nguoithue.setText(String.valueOf(soLuongNguoiThue));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sophongtrong = view.findViewById(R.id.tv_sophongtrong);
        sophong = view.findViewById(R.id.tv_sophong);
        nguoithue = view.findViewById(R.id.tv_songuoithue);
        btnBill = view.findViewById(R.id.bt_bill);
        btnHopDong = view.findViewById(R.id.bt_HopDong);
        btnNguoiThue = view.findViewById(R.id.bt_nguoi_thue);
        btnSuCo = view.findViewById(R.id.bt_TienCoc);

        // Khởi tạo instance của class Database
        Database database = new Database(getActivity());

        // Lấy số lượng phòng từ cơ sở dữ liệu bằng cách gọi phương thức layTatCaDuLieuPhongTro()
        Cursor cursor = database.layTatCaDuLieuPhongTro();
        Cursor cursor1 = database.layTatCaDuLieuNguoiThue();
        int soLuongPhong = cursor.getCount();
        int soLuongPhongTrong = 0;
        int soLuongNguoiThue = 0;

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int trangThaiPhong = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_TRANGTHAI_PHONG));
                if (trangThaiPhong == 0) {
                    // Nếu trạng thái phòng là 0 (trống) thì tăng số lượng phòng trống lên 1
                    soLuongPhongTrong++;
                }
            } while (cursor.moveToNext());
        }

        if (cursor1.moveToFirst()) {
            do {
                @SuppressLint("Range") int role = cursor1.getInt(cursor1.getColumnIndex(DBHelper.COLUMN_ROLE));
                if (role == 1) {
                    // Nếu role là 1 (người thuê) thì tăng số lượng người thuê lên 1
                    soLuongNguoiThue++;
                }
            } while (cursor1.moveToNext());
        }

        // Đóng Cursor sau khi sử dụng
        cursor.close();
        cursor1.close();

        // Hiển thị số lượng lên giao diện
        sophong.setText(String.valueOf(soLuongPhong));
        sophongtrong.setText(String.valueOf(soLuongPhongTrong));
        nguoithue.setText(String.valueOf(soLuongNguoiThue));

        btnBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BillActivity.class));
            }
        });

        btnHopDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), HopDongActivity.class));
            }
        });

        btnNguoiThue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NguoiThueActivity.class));
            }
        });

        btnSuCo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SuCoActivity.class));
            }
        });

        return view;
    }
}
