package com.example.demoappnhatro;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demoappnhatro.Adapter.PhongTroAdapter;
import com.example.demoappnhatro.Database.DBHelper;
import com.example.demoappnhatro.Database.Database;
import com.example.demoappnhatro.Database.PhongTro;
import com.example.demoappnhatro.Database.TaiKhoan;

public class PhongChiTietActivity extends AppCompatActivity {
    TextView tvTenPhong, tvTrangThaiPhong, tvNguoiThue;
    Button  btnTaoHopDong, btnTaoTaiKhoan, btnXoaphong;
    Database database;
    DBHelper dbHelper;
    private PhongTro phongTro;
    private static PhongTroAdapter adapter;
    private boolean isChoThue = false;


    @Override
    protected void onResume() {
        super.onResume();
        tvNguoiThue.setText("Người thuê : " + phongTro.getNguoiThueId());
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toanha_chitiet);

        tvTenPhong = findViewById(R.id.tv_tenphong);
        tvTrangThaiPhong = findViewById(R.id.tv_trangthaiphong);
        tvNguoiThue = findViewById(R.id.tv_nguoithuephong);
        btnTaoHopDong = findViewById(R.id.btn_taohopdongphong);
        btnTaoTaiKhoan = findViewById(R.id.btn_taotaikhoanphong);
        btnXoaphong = findViewById(R.id.btn_xoaphong);

        database = new Database(this);
        dbHelper = new DBHelper(this);

        phongTro = (PhongTro) getIntent().getSerializableExtra("phongtro");
        if (phongTro != null) {
            // Hiển thị thông tin phòng lên các TextView tương ứng
            tvTenPhong.setText("Phòng : " + phongTro.getTenPhong());
            tvTrangThaiPhong.setText(phongTro.getTrangThaiPhong() == 0 ? "Trạng thái: Chưa cho thuê" : "Trạng thái: Đã cho thuê");
            tvNguoiThue.setText("Người thuê: " + phongTro.getNguoiThueId());
        } else {
            // Phòng không tồn tại trong cơ sở dữ liệu
            Toast.makeText(this, "Phòng không tồn tại", Toast.LENGTH_SHORT).show();
        }

        btnTaoTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo tên đăng nhập là "user"
                String tenDangNhap = "user";
                // Tạo mật khẩu ngẫu nhiên gồm chữ và số
                String matKhau = taoMatKhauNgauNhien();
                // Role mặc định là 1
                int role = 1;

                // Thực hiện tạo tài khoản trong cơ sở dữ liệu
                long taiKhoanId = taoTaiKhoan(tenDangNhap, matKhau, role);

                if (taiKhoanId != -1) {
                    // Tạo tài khoản thành công
                    // Gán người thuê ID của phòng hiện tại bằng ID tài khoản vừa tạo
                    phongTro.setNguoiThueId(taiKhoanId);

                    // Cập nhật thông tin người thuê trong cơ sở dữ liệu
                    database.capNhatThongTinPhongTro(phongTro);

                    // Cập nhật thông tin người thuê lên giao diện
                    tvNguoiThue.setText("Người thuê: " + taiKhoanId);

                    // Thông báo tạo tài khoản thành công
                    Toast.makeText(PhongChiTietActivity.this, "Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();
                    tvNguoiThue.setText("Người thuê : " + phongTro.getNguoiThueId());

                } else {
                    // Thông báo tạo tài khoản thất bại
                    Toast.makeText(PhongChiTietActivity.this, "Tạo tài khoản thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnTaoHopDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kiểm tra xem phòng đã có người thuê hay chưa
                long nguoiThueId = phongTro.getNguoiThueId();
                if (nguoiThueId == 0) {
                    // Nếu chua có người thuê, tạo hợp đồng
                    Intent intent = new Intent(PhongChiTietActivity.this, AddHopDongActivity.class);
                    intent.putExtra("phongtro", phongTro);
                    startActivity(intent);
                } else {
                    // Nếu đã có người thuê, hiển thị thông báo
                    Toast.makeText(PhongChiTietActivity.this, "Phòng đã có người thuê", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnXoaphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xóa tài khoản của phòng (nếu có)
                long nguoiThueId = phongTro.getNguoiThueId();
                if (nguoiThueId > 0) {
                    xoaTaiKhoan(nguoiThueId);
                }

                // Xóa phòng
                long phongId = phongTro.getPhongId();
                database.deletePhongByID(phongId);
                Toast.makeText(PhongChiTietActivity.this, "Xóa phòng thành công", Toast.LENGTH_SHORT).show();
                // Trả kết quả về cho BuildingFragment để cập nhật danh sách phòng
                updatePhongTroInDatabase(phongTro);
            }
        });
    }

    private String taoMatKhauNgauNhien() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int passwordLength = 8; // Độ dài mật khẩu mong muốn
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < passwordLength; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }

    private long taoTaiKhoan(String tenDangNhap, String matKhau, int role) {
        // Thực hiện tạo tài khoản trong cơ sở dữ liệu
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_TENDANGNHAP, tenDangNhap);
        values.put(DBHelper.COLUMN_MATKHAU, matKhau);
        values.put(DBHelper.COLUMN_ROLE, role);
        long taiKhoanId = db.insert(DBHelper.TABLE_TAIKHOAN, null, values);
        db.close();
        return taiKhoanId;
    }

    private void xoaTaiKhoan(long taiKhoanId) {
        // Thực hiện xóa tài khoản trong cơ sở dữ liệu bằng ID tài khoản
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(DBHelper.TABLE_TAIKHOAN, DBHelper.COLUMN_NGUOIDUNGID + " = ?", new String[]{String.valueOf(taiKhoanId)});
        db.close();
    }

    private void updatePhongTroInDatabase(PhongTro updatedPhongTro) {
        // Cập nhật thông tin phòng trong cơ sở dữ liệu (Database) bằng thông tin trong updatedPhongTro
        database.capNhatThongTinPhongTro(updatedPhongTro);
        // Trả kết quả về cho BuildingFragment để cập nhật danh sách phòng
        Intent intent = new Intent();
        intent.putExtra("updatedPhongTro", updatedPhongTro);
        setResult(RESULT_OK, intent);
        finish(); // Kết thúc PhongChiTietActivity và trở lại BuildingFragment
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                // Nhận dữ liệu từ PhongChiTietActivity
                PhongTro updatedPhongTro = (PhongTro) data.getSerializableExtra("updatedPhongTro");

                // Cập nhật thông tin người thuê lên TextView
                if (updatedPhongTro != null) {
                    long nguoiThueId = updatedPhongTro.getNguoiThueId();
                    if (nguoiThueId > 0) {
                        TaiKhoan nguoiThue = database.getTaiKhoanById(nguoiThueId);
                        if (nguoiThue != null) {
                            tvNguoiThue.setText("Người thuê: " + nguoiThue.getTenNguoiDung());
                        }
                    } else {
                        tvNguoiThue.setText("Chưa có người thuê");
                    }
                }
            }
        }
    }

}