package com.example.demoappnhatro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demoappnhatro.Database.DBHelper;
import com.example.demoappnhatro.Database.Database;
import com.example.demoappnhatro.Database.HopDong;

public class ThongTinHopDongActivity extends AppCompatActivity {
    Button btnTaoHoaDon, btnTraPhong;
    ImageButton btnBack;
    TextView tvTenPhong, tvTenChuTro,tvnoidung, tvNgayThue, tvNgayTra, tvTienCoc, tvTienThue, tvTienDien, tvTienNuoc, tvcccdnguoithue, tvcccdchutro, tvtennguoithue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_hop_dong);
        tvTenPhong = findViewById(R.id.tv_TenPhong_HD);
        tvTenChuTro = findViewById(R.id.tv_nguoithue2);
        tvNgayThue = findViewById(R.id.tv_calender_den_tt);
        tvNgayTra = findViewById(R.id.tv_calender_di_tt);
        tvTienCoc = findViewById(R.id.tv_gia_thue_tt2);
        tvTienThue = findViewById(R.id.tv_gia_thue_tt);
        tvTienDien = findViewById(R.id.tv_gia_thue_tt3);
        tvTienNuoc = findViewById(R.id.tv_gia_thue_tt4);
        tvcccdnguoithue = findViewById(R.id.tv_cccdnguoithue);
        tvcccdchutro = findViewById(R.id.tv_cccdnguoithue2);
        tvtennguoithue = findViewById(R.id.tv_nguoithue);
        tvnoidung = findViewById(R.id.edt_mota_NgThue_tt);
        btnTaoHoaDon = findViewById(R.id.bt_tao_hoa_don_thang);
        btnTraPhong = findViewById(R.id.bt_ket_thuc_hop_dong);
        btnBack = findViewById(R.id.img_Back_hopdong_tt);

        // Lấy dữ liệu từ intent gửi sang
        Intent intent = getIntent();
        HopDong hopDong = (HopDong) intent.getSerializableExtra("hopdong");
        String tenphong = hopDong.getTenphong();
        String tenchutro = hopDong.getTenchutro();
        String ngaythue = hopDong.getHopDongNgayBatDau();
        String ngaytra = hopDong.getHopDongNgayKetThuc();
        String tiencoc = String.valueOf(hopDong.getTienCoc());
        String tienthue = String.valueOf(hopDong.getTienPhong());
        String tiendien = String.valueOf(hopDong.getTienDien());
        String tiennuoc = String.valueOf(hopDong.getTienNuoc());
        String cccdnguoithue = String.valueOf(hopDong.getCccdnguoithue());
        String cccdchutro = String.valueOf(hopDong.getCccdchutro());
        String tennguoithue = hopDong.getTennguoithue();
        String noidung = hopDong.getHopDongNoiDung();


        // Gán dữ liệu lên giao diện
        tvTenPhong.setText(tenphong);
        tvTenChuTro.setText(tenchutro);
        tvNgayThue.setText(ngaythue);
        tvNgayTra.setText(ngaytra);
        tvTienCoc.setText(tiencoc);
        tvTienThue.setText(tienthue);
        tvTienDien.setText(tiendien);
        tvTienNuoc.setText(tiennuoc);
        tvcccdnguoithue.setText(cccdnguoithue);
        tvcccdchutro.setText(cccdchutro);
        tvtennguoithue.setText(tennguoithue);
        tvnoidung.setText("  " + noidung);

        // Sự kiện click button
        btnBack.setOnClickListener(v -> {
            finish();
        });

        btnTraPhong.setOnClickListener(v -> {
            // Thực hiện các hành động khi nút "Trả Phòng" được nhấp
            // Ví dụ: cập nhật dữ liệu trong cơ sở dữ liệu

            // Xóa tài khoản của người thuê
            boolean isNgThueDeleted = deleteNguoiThueAccount( hopDong.getNguoiDungId());

            // Cập nhật trạng thái của phòng (chuyển về trạng thái 0)
            boolean isRoomStatusUpdated = updateRoomStatus( hopDong.getPhongId(), 0);

            // Cập nhật trạng thái của hợp đồng (chuyển về trạng thái 1)
            boolean isHopDongStatusUpdated = updateHopDongStatus(hopDong.getHopDongTen(), 1);

            if (isNgThueDeleted && isRoomStatusUpdated && isHopDongStatusUpdated) {
                Toast.makeText(this, "Trả phòng thành công", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Trả phòng thất bại", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Xóa tài khoản của người thuê
    private boolean deleteNguoiThueAccount(long nguoiDungId) {
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return Database.deleteNguoiThue(db, nguoiDungId);
    }

    // Cập nhật trạng thái của phòng
    private boolean updateRoomStatus(long phongId, int trangThai) {
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return Database.updateRoomStatus(db, phongId, trangThai);
    }

    // Cập nhật trạng thái của hợp đồng
    private boolean updateHopDongStatus(String hopDongTen, int trangThai) {
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return Database.updateHopDongStatus(db, hopDongTen, trangThai);
    }


}