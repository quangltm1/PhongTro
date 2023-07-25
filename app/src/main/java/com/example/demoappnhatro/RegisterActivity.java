package com.example.demoappnhatro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demoappnhatro.Database.DBHelper;
import com.example.demoappnhatro.Database.TaiKhoan;

public class RegisterActivity extends AppCompatActivity {
    EditText edtTen, edtEmail, edtPass, edtRePass, edtPhone;
    Button btnRegister;
    ImageButton imageBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edtTen = findViewById(R.id.edt_dk_tentaikhoan);
        edtEmail = findViewById(R.id.edt_dk_email);
        edtPass = findViewById(R.id.edt_dk_password);
        edtRePass = findViewById(R.id.edt_config_password);
        edtPhone = findViewById(R.id.edt_dk_sdt);
        btnRegister = findViewById(R.id.btn_sign_in);
        imageBack = findViewById(R.id.imbBack);

        // Quay lại màn hình đăng nhập
        imageBack.setOnClickListener(v -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            finish();
        });

        // Đăng ký tài khoản
        btnRegister.setOnClickListener(view -> registerAccount());
    }

    private void registerAccount() {
        String ten = edtTen.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String password = edtPass.getText().toString().trim();
        String rePassword = edtRePass.getText().toString().trim();
        String sdt = edtPhone.getText().toString().trim();

        DBHelper dbHelper = new DBHelper(this);

        if (ten.isEmpty() || email.isEmpty() || password.isEmpty() || rePassword.isEmpty() || sdt.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
        } else if (!password.equals(rePassword)) {
            Toast.makeText(this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
        } else if (!sdt.matches("[0-9]+") || sdt.length() < 10 || sdt.length() > 12) {
            Toast.makeText(this, "Số điện thoại không hợp lệ", Toast.LENGTH_SHORT).show();
        } else if (dbHelper.checkTaiKhoanTonTai(email)) {
            Toast.makeText(this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
        } else {
            TaiKhoan taiKhoan = new TaiKhoan(ten, email, password, sdt, 0);
            dbHelper.addTaiKhoanAdmin(taiKhoan);
            Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            finish();
        }
    }
}
