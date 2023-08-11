package com.example.demoappnhatro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demoappnhatro.Database.DBHelper;
import com.example.demoappnhatro.Database.TaiKhoan;

public class NguoiThueChiTietActivity extends AppCompatActivity {

    private TextView tvTenNguoiThue, tvSoDienThoai, tvPhongDangThue, tvTK, tvMK;
    Button XoaNguoiThue, ResetMatKhau, SuaThongTinNguoiThue, XemTaiKhoan;
    private OnAccountUpdatedListener accountUpdatedListener;
    private TaiKhoan taiKhoan;
    // Các trường dữ liệu khác của người thuê...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoithue_chitiet);

        // Ánh xạ các view
        tvTenNguoiThue = findViewById(R.id.tvTenNguoiThueChiTiet);
        tvSoDienThoai = findViewById(R.id.tvSoDienThoaiChiTiet);
        tvPhongDangThue = findViewById(R.id.tvPhongDangThueChiTiet);
        tvTK = findViewById(R.id.tvTaiKhoan);
        tvMK = findViewById(R.id.tvMatKhau);
        XoaNguoiThue = findViewById(R.id.btnXoaTaiKhoanChiTiet);
        ResetMatKhau = findViewById(R.id.btnResetMatKhauChiTiet);
        SuaThongTinNguoiThue = findViewById(R.id.btnChinhSuaChiTiet);
        XemTaiKhoan = findViewById(R.id.btnXemTKMK);
        // Ánh xạ các view dữ liệu khác của người thuê...

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("taikhoan")) {
            taiKhoan = (TaiKhoan) intent.getSerializableExtra("taikhoan");
            if (taiKhoan != null) {
                // Hiển thị thông tin người thuê lên giao diện
                tvTenNguoiThue.setText("Tên người thuê: " + taiKhoan.getTenDangNhap());
                tvSoDienThoai.setText("Số điện thoại: " + taiKhoan.getSdt());

                // Lấy tên phòng từ cơ sở dữ liệu và hiển thị lên tvPhongDangThue
                DBHelper dbHelper = new DBHelper(NguoiThueChiTietActivity.this);
                String tenPhong = dbHelper.getTenPhongTroById(taiKhoan.getPhongTroId());
                tvPhongDangThue.setText("Phòng đang thuê: " + tenPhong);
                dbHelper.close();
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

        XemTaiKhoan.setOnClickListener(v -> {
            // Lấy thông tin tài khoản từ Intent
            TaiKhoan taiKhoan = (TaiKhoan) intent.getSerializableExtra("taikhoan");
            if (taiKhoan != null) {
                // Lưu thông tin tài khoản vào các biến
                String tenDangNhap = taiKhoan.getTenDangNhap();
                String matKhau = taiKhoan.getMatKhau();

                // Hiển thị thông tin tài khoản và mật khẩu lên TextView
                tvTK.setText("Tên đăng nhập: " + tenDangNhap);
                tvMK.setText("Mật khẩu: " + matKhau);
            }
        });



        // Xử lý sự kiện khi nhấn vào nút "Chỉnh sửa"
        SuaThongTinNguoiThue.setOnClickListener(v -> {
            // Lấy thông tin tài khoản từ Intent
            TaiKhoan taiKhoan = (TaiKhoan) intent.getSerializableExtra("taikhoan");
            if (taiKhoan != null) {
                // Lưu thông tin tài khoản vào các biến
                String tenDangNhap = taiKhoan.getTenDangNhap();

                // Chuyển sang màn hình chỉnh sửa thông tin người thuê và truyền thông tin tài khoản hiện tại
                Intent intentChinhSua = new Intent(NguoiThueChiTietActivity.this, ChinhSuaNguoiThueActivity.class);
                intentChinhSua.putExtra("taikhoan", taiKhoan);
                startActivity(intentChinhSua);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            // Nhận dữ liệu từ màn hình chỉnh sửa thông tin người thuê
            TaiKhoan updatedTaiKhoan = (TaiKhoan) data.getSerializableExtra("updatedTaikhoan");
            // Kiểm tra dữ liệu nhận được
            if (updatedTaiKhoan != null) {
                // Cập nhật thông tin tài khoản với thông tin đã được chỉnh sửa
                taiKhoan = updatedTaiKhoan;
                // Hiển thị lại thông tin tài khoản lên giao diện
                tvTenNguoiThue.setText("Tên người thuê: " + taiKhoan.getTenDangNhap());
                tvSoDienThoai.setText("Số điện thoại: " + taiKhoan.getSdt());
            }
        }
    }


    public interface OnAccountUpdatedListener {
        void onAccountUpdated();
    }
}