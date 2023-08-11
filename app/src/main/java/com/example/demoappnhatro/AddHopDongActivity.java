package com.example.demoappnhatro;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demoappnhatro.Database.DBHelper;
import com.example.demoappnhatro.Database.Database;
import com.example.demoappnhatro.Database.HopDong;

public class AddHopDongActivity extends AppCompatActivity {
    ImageButton imageButton;
    public Database database;
    Button btnLuuHopDong;
    EditText edtTenPhong, edtTenChuTro, edtCMNDChuTro,edtNoiDung,edtTenNguoiThue, edtCMNDNguoiThue, edtNgayThue, edtNgayTra, edtTienCoc, edtTienPhong, edtTienDien, edtTienNuoc;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hop_dong);

        imageButton = findViewById(R.id.btnBack);
        edtTenPhong = findViewById(R.id.etTenPhong);
        edtTenChuTro = findViewById(R.id.etTenChuTro);
        edtCMNDChuTro = findViewById(R.id.etCCCDChuTro);
        edtTenNguoiThue = findViewById(R.id.etTenNguoiThue);
        edtCMNDNguoiThue = findViewById(R.id.etCCCDNguoiThue);
        edtNgayThue = findViewById(R.id.etNgayBatDau);
        edtNgayTra = findViewById(R.id.etNgayKetThuc);
        edtTienCoc = findViewById(R.id.etTienCoc);
        edtTienPhong = findViewById(R.id.etTienPhong);
        edtTienDien = findViewById(R.id.etTienDien);
        edtTienNuoc = findViewById(R.id.etTienNuoc);
        edtNoiDung = findViewById(R.id.etNoiDungHopDong);
        btnLuuHopDong = findViewById(R.id.btnTaoHopDong);

        imageButton.setOnClickListener(v -> {
            finish();
        });

        btnLuuHopDong.setOnClickListener(v -> {
            String tenPhong = edtTenPhong.getText().toString();
            String tenChuTro = edtTenChuTro.getText().toString();
            int cmndChuTro = Integer.parseInt(edtCMNDChuTro.getText().toString());
            String tenNguoiThue = edtTenNguoiThue.getText().toString();
            int cmndNguoiThue = Integer.parseInt(edtCMNDNguoiThue.getText().toString());
            String ngayThue = edtNgayThue.getText().toString();
            String ngayTra = edtNgayTra.getText().toString();
            int tienCoc = Integer.parseInt(edtTienCoc.getText().toString());
            int tienPhong = Integer.parseInt(edtTienPhong.getText().toString());
            int tienDien = Integer.parseInt(edtTienDien.getText().toString());
            int tienNuoc = Integer.parseInt(edtTienNuoc.getText().toString());
            String noiDung = edtNoiDung.getText().toString();

            if(tenPhong.isEmpty() || tenChuTro.isEmpty() || cmndChuTro == 0 || tenNguoiThue.isEmpty() || cmndNguoiThue == 0 || ngayThue.isEmpty() || ngayTra.isEmpty() || tienCoc == 0 || tienPhong == 0 || tienDien == 0 || tienNuoc == 0 || noiDung.isEmpty()){
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            }else{
                HopDong hopDong = new HopDong(tenPhong, ngayThue, ngayTra, tenNguoiThue, cmndNguoiThue, tenChuTro, cmndChuTro, tienPhong, tienCoc, tienDien, tienNuoc, noiDung);
                database = new Database(this);
                database.addHopDong(hopDong);
                Toast.makeText(this, "Thêm hợp đồng thành công", Toast.LENGTH_SHORT).show();
            }
            finish();
        });




    }


}
