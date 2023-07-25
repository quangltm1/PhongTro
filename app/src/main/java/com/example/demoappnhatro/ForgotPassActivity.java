package com.example.demoappnhatro;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPassActivity extends AppCompatActivity {
    ImageButton imgBack;
    EditText edtemail;
    Button btnSend;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        imgBack = findViewById(R.id.imbBack2);
        edtemail = findViewById(R.id.edt_email);
        btnSend = findViewById(R.id.btn_forgot);

        imgBack.setOnClickListener(v -> {
            startActivity(new Intent(ForgotPassActivity.this, LoginActivity.class));
        });

        btnSend.setOnClickListener(v -> {
            String email = edtemail.getText().toString().trim();
            if (email.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập email", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Mật khẩu đã được gửi về email của bạn", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
