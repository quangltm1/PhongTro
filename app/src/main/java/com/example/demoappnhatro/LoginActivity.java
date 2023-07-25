package com.example.demoappnhatro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demoappnhatro.Database.DBHelper;
import com.example.demoappnhatro.Database.TaiKhoan;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText edtEmail, edtPassword;
    TextView tv_sign_up, tv_forgot_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btn_sign_in);
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        tv_sign_up = findViewById(R.id.signup);
        tv_forgot_password = findViewById(R.id.forgot_password);

        // kiểm tra đăng nhập xem role là admin hay user
        btnLogin.setOnClickListener(view -> checkLogin());

        // Đăng ký tài khoản
        tv_sign_up.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            finish();
        });

        //Quên mật khẩu
        tv_forgot_password.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, ForgotPassActivity.class));
        });
    }

    private void checkLogin() {
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        DBHelper dbHelper = new DBHelper(this);
        TaiKhoan taiKhoan = dbHelper.getTaiKhoan(email, password);

        if (taiKhoan != null && taiKhoan.getMatKhau() != null && taiKhoan.getMatKhau().equals(password)) {
            int role = taiKhoan.getRole();
            if (role == 0) {
                Toast.makeText(this, "Đăng nhập thành công (vai trò: admin)", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            } else {
                Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, LoginActivity.class));
            }
            finish();
        } else if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Không để email hoặc mật khẩu trống", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Email hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
        }
    }
}
