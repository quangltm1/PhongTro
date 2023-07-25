package com.example.demoappnhatro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demoappnhatro.Database.DBHelper;
import com.example.demoappnhatro.Database.TaiKhoan;

public class NguoiThueChiTietActivity extends AppCompatActivity {

    private TextView tvTenNguoiThue, tvSoDienThoai, tvPhongDangThue;
    Button XoaNguoiThue, ResetMatKhau, SuaThongTinNguoiThue;
    private OnAccountUpdatedListener accountUpdatedListener;
    // Các trường dữ liệu khác của người thuê...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoithue_chitiet);

        // Ánh xạ các view
        tvTenNguoiThue = findViewById(R.id.tvTenNguoiThueChiTiet);
        tvSoDienThoai = findViewById(R.id.tvSoDienThoaiChiTiet);
        tvPhongDangThue = findViewById(R.id.tvPhongDangThueChiTiet);
        XoaNguoiThue = findViewById(R.id.btnXoaTaiKhoanChiTiet);
        ResetMatKhau = findViewById(R.id.btnResetMatKhauChiTiet);
        SuaThongTinNguoiThue = findViewById(R.id.btnChinhSuaChiTiet);
        // Ánh xạ các view dữ liệu khác của người thuê...

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("taikhoan")) {
            TaiKhoan taiKhoan = (TaiKhoan) intent.getSerializableExtra("taikhoan");
            if (taiKhoan != null) {
                // Hiển thị thông tin người thuê lên giao diện
                tvTenNguoiThue.setText("Tên người thuê: " + taiKhoan.getTenDangNhap());
                tvSoDienThoai.setText("Số điện thoại: " + taiKhoan.getSdt());

                // Lấy tên phòng từ cơ sở dữ liệu và hiển thị lên tvPhongDangThue
                DBHelper dbHelper = new DBHelper(NguoiThueChiTietActivity.this);
                String tenPhong = dbHelper.getTenPhongTroById(taiKhoan.getPhongTroId());
                dbHelper.close();
                tvPhongDangThue.setText("Phòng đang thuê: " + tenPhong);
            }
        }

        XoaNguoiThue.setOnClickListener(v -> {
            // Thực hiện xóa tài khoản trong cơ sở dữ liệu
            DBHelper dbHelper = new DBHelper(NguoiThueChiTietActivity.this);
            TaiKhoan taiKhoan = (TaiKhoan) intent.getSerializableExtra("taikhoan");
            dbHelper.deleteTaiKhoanById(taiKhoan.getNguoiDungId());

            // Hiển thị thông báo đã xóa thành công
            Toast.makeText(NguoiThueChiTietActivity.this, "Đã xóa tài khoản", Toast.LENGTH_SHORT).show();

            // Gọi phương thức thông báo reset mật khẩu thành công qua Interface
            if (accountUpdatedListener != null) {
                accountUpdatedListener.onAccountUpdated();
            }

            // Trở lại màn hình trước đó (nếu cần)
            setResult(RESULT_OK);
            finish();
        });

        // Xử lý sự kiện khi nhấn vào nút "Reset mật khẩu"
        ResetMatKhau.setOnClickListener(v -> {
            // Thực hiện reset mật khẩu của tài khoản trong cơ sở dữ liệu (nếu cần)
            DBHelper dbHelper = new DBHelper(NguoiThueChiTietActivity.this);
            TaiKhoan taiKhoan = (TaiKhoan) intent.getSerializableExtra("taikhoan");
            dbHelper.resetMatKhauById(taiKhoan.getNguoiDungId());

            // Hiển thị thông báo reset mật khẩu thành công (nếu cần)
            Toast.makeText(NguoiThueChiTietActivity.this, "Đã reset mật khẩu", Toast.LENGTH_SHORT).show();
            // Gọi phương thức thông báo xóa thành công qua Interface
            if (accountUpdatedListener != null) {
                accountUpdatedListener.onAccountUpdated();
            }

            // Trở lại màn hình trước đó (nếu cần)
            setResult(RESULT_OK);
            finish();
        });

        /*// Xử lý sự kiện khi nhấn vào nút "Chỉnh sửa"
        SuaThongTinNguoiThue.setOnClickListener(v -> {
            // Chuyển sang màn hình chỉnh sửa thông tin người thuê
            Intent intentChinhSua = new Intent(NguoiThueChiTietActivity.this, ChinhSuaNguoiThueActivity.class);
            intentChinhSua.putExtra("taikhoan", taiKhoan);
            startActivity(intentChinhSua);
        });*/
    }

    public interface OnAccountUpdatedListener {
        void onAccountUpdated();
    }
}