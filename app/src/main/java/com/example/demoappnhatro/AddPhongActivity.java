package com.example.demoappnhatro;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.demoappnhatro.Database.Database;
import com.example.demoappnhatro.Database.PhongTro;

public class AddPhongActivity extends AppCompatActivity {
    EditText edtTenPhong, edtGiaPhong, edtDienTich, edtMoTa, edtTienDatCoc;
    Spinner spinnerTrangThai;
    Button btnThemPhong;
    public static Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_phong);
        edtTenPhong = findViewById(R.id.edt_Ten_Phong);
        edtTienDatCoc = findViewById(R.id.edt_Tien_Dat_Coc);
        edtGiaPhong = findViewById(R.id.edt_Gia_Phong);
        edtDienTich = findViewById(R.id.edt_Dien_Tich);
        edtMoTa = findViewById(R.id.tv_mo_ta);
        spinnerTrangThai = findViewById(R.id.spinnerTrangThai);
        btnThemPhong = findViewById(R.id.bt_add_phong);
        database = new Database(this);

        // Lấy danh sách trạng thái từ strings.xml
        String[] trangThaiArray = getResources().getStringArray(R.array.trang_thai_array);
        String[] trangThaiValues = getResources().getStringArray(R.array.trang_thai_values);

        // Tạo ArrayAdapter để kết nối danh sách trạng thái với Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, trangThaiArray);

        // Định dạng giao diện cho Spinner (có thể là simple_spinner_item hoặc simple_spinner_dropdown_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Gán ArrayAdapter đã tạo vào Spinner
        spinnerTrangThai.setAdapter(adapter);

        btnThemPhong.setOnClickListener(v -> {
            String tenPhong = edtTenPhong.getText().toString().trim();
            String tienDatCoc = edtTienDatCoc.getText().toString().trim();
            String giaPhong = edtGiaPhong.getText().toString().trim();
            String dienTich = edtDienTich.getText().toString().trim();
            String moTa = edtMoTa.getText().toString().trim();

            //validation: kiểm tra rỗng và chứa ký tự đặc biệt cho các trường
            if (tenPhong.isEmpty()) {
                edtTenPhong.setError("Tên phòng không được để trống");
            } else if (tienDatCoc.isEmpty()) {
                edtTienDatCoc.setError("Tiền đặt cọc không được để trống");
            } else if (giaPhong.isEmpty()) {
                edtGiaPhong.setError("Giá phòng không được để trống");
            } else if (dienTich.isEmpty()) {
                edtDienTich.setError("Diện tích không được để trống");
            } else if (moTa.isEmpty()) {
                edtMoTa.setError("Mô tả không được để trống");
            } else if (!tenPhong.matches("[a-zA-Z0-9]+")) {
                edtTenPhong.setError("Tên phòng không chứa ký tự đặc biệt hoặc trống");
            } else if (!tienDatCoc.matches("[0-9]+") || tienDatCoc.length()>1000) {
                edtTienDatCoc.setError("Tiền đặt cọc không chứa ký tự đặc biệt hoặc trống");
            } else if (!giaPhong.matches("[0-9]+") || giaPhong.length()>1000) {
                edtGiaPhong.setError("Giá phòng không chứa ký tự đặc biệt hoặc trống");
            } else if (!dienTich.matches("[0-9]+")) {
                edtDienTich.setError("Diện tích không chứa ký tự đặc biệt hoặc trống");
            } else {
                // Lấy vị trí (index) của mục đã chọn trong Spinner
                int selectedPosition = spinnerTrangThai.getSelectedItemPosition();

                // Lấy giá trị tương ứng với vị trí đã chọn trong mảng trangThaiValues
                String trangThaiValue = trangThaiValues[selectedPosition];

                // Tiếp tục xử lý trạng thái của phòng
                // Đặt trạng thái cho phòng (0 hoặc 1) bằng cách sử dụng giá trị trangThaiValue

                PhongTro phongTro = new PhongTro(tenPhong, tienDatCoc, giaPhong, dienTich, moTa, trangThaiValue);

                // Tiếp tục thêm phòng vào cơ sở dữ liệu và hiển thị thông báo

                database.addPhongTro(phongTro);
                Toast.makeText(AddPhongActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AddPhongActivity.this, MainActivity.class));
                setResult(RESULT_OK);
                finish();
            }

        });
    }
}
