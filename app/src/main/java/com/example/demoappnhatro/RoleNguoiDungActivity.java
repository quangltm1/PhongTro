package com.example.demoappnhatro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.demoappnhatro.Database.Database;

public class RoleNguoiDungActivity extends AppCompatActivity {
    TextView tvTenPhong, tvGiaThue, tvHopDong;
    ImageButton btnSuCo, btnTaiKhoan, btnBill, btnHopDong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_nguoi_dung);
        tvTenPhong = findViewById(R.id.tv_ten_phong_nd);
        tvGiaThue = findViewById(R.id.tv_diachi_nd);
        tvHopDong = findViewById(R.id.tv_hopdong_nd);
        btnSuCo = findViewById(R.id.bt_su_co_nd);
        btnTaiKhoan = findViewById(R.id.bt_taikhoan_nd);
        btnBill = findViewById(R.id.bt_bill_nd);

        // Khởi tạo instance của class Database
        Database database = new Database(this);

        // Lấy số lượng phòng từ cơ sở dữ liệu bằng cách gọi phương thức layTatCaDuLieuPhongTro()
        // ...

        Cursor cursor = database.layTatCaDuLieuPhongTro();
        Cursor cursor1 = database.layTatCaDuLieuNguoiThue();
        Cursor cursor2 = database.layTatCaDuLieuHopDong();

        if (cursor.moveToFirst() && cursor2.moveToFirst()) {
            tvTenPhong.setText(String.valueOf(cursor.getString(1)));
            tvGiaThue.setText(String.valueOf(cursor.getString(2)));
            tvHopDong.setText(String.valueOf(cursor2.getString(4)));
        }

        // Close Cursors after using them
        cursor.close();
        cursor1.close();
        cursor2.close();

        

        /*btnBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RoleNguoiDungActivity.this, BillActivity.class));
            }
        });

        btnHopDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RoleNguoiDungActivity.this, HopDongActivity.class));
            }
        });*/

        /*btnTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RoleNguoiDungActivity.this, NguoiThueActivity.class));
            }
        });*/

        /*btnSuCo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }
}