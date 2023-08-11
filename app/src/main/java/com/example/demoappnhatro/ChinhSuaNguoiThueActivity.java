package com.example.demoappnhatro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demoappnhatro.Database.TaiKhoan;

public class ChinhSuaNguoiThueActivity extends AppCompatActivity {
    EditText edtTenNguoiThue, edtSoDienThoai, edtReMatKhau, edtMatKhau;
    Button btnChinhSuaNguoiThue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinhsua_nguoithue);
        // Ánh xạ các view
        edtTenNguoiThue = findViewById(R.id.edtTenDangNhap);
        edtSoDienThoai = findViewById(R.id.edtSoDienThoai);
        edtReMatKhau = findViewById(R.id.edtReMatKhau);
        edtMatKhau = findViewById(R.id.edtMatKhau);
        btnChinhSuaNguoiThue = findViewById(R.id.btnCapNhat);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("taikhoan")) {
            TaiKhoan taiKhoan = (TaiKhoan) intent.getSerializableExtra("taikhoan");
            if (taiKhoan != null) {
                // Hiển thị thông tin người thuê lên giao diện
                edtTenNguoiThue.setText(taiKhoan.getTenDangNhap());
                edtSoDienThoai.setText(taiKhoan.getSdt());
                edtMatKhau.setText(taiKhoan.getMatKhau());
                edtReMatKhau.setText(taiKhoan.getMatKhau());
            }
        }

        // Xử lý sự kiện khi người dùng nhấn nút "Cập nhật"
        btnChinhSuaNguoiThue.setOnClickListener(v -> {
            // Lấy thông tin người thuê được chỉnh sửa từ các EditText
            String tenNguoiThue = edtTenNguoiThue.getText().toString().trim();
            String soDienThoai = edtSoDienThoai.getText().toString().trim();
            String matKhau = edtMatKhau.getText().toString().trim();
            String reMatKhau = edtReMatKhau.getText().toString().trim();

            // Kiểm tra các trường thông tin nếu có thay đổi và đảm bảo thông tin hợp lệ
            if (tenNguoiThue.isEmpty()) {
                edtTenNguoiThue.setError("Tên người thuê không được để trống");
                return;
            }

            if (soDienThoai.isEmpty()) {
                edtSoDienThoai.setError("Số điện thoại không được để trống");
                return;
            }

            if (matKhau.isEmpty()) {
                edtMatKhau.setError("Mật khẩu không được để trống");
                return;
            }

            if (!matKhau.equals(reMatKhau)) {
                edtReMatKhau.setError("Mật khẩu không khớp");
                return;
            }

            // Tạo một đối tượng TaiKhoan mới với các thông tin đã chỉnh sửa
            TaiKhoan taiKhoanCapNhat = new TaiKhoan(tenNguoiThue, soDienThoai, matKhau);

            // Đặt kết quả và trả về cho màn hình trước đó (NguoiThueChiTietActivity)
            Intent intent1 = getIntent();
            intent1.putExtra("updatedTaikhoan", taiKhoanCapNhat);
            setResult(RESULT_OK, intent1);
            finish();
        });

    }
}
