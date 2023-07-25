package com.example.demoappnhatro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demoappnhatro.Adapter.NguoiThueAdapter;
import com.example.demoappnhatro.Database.DBHelper;
import com.example.demoappnhatro.Database.TaiKhoan;
import java.util.ArrayList;

public class NguoiThueActivity extends AppCompatActivity {

    private ListView listViewNguoiThue;
    private ArrayList<TaiKhoan> mListNguoiThue;
    private NguoiThueAdapter mNguoiThueAdapter;
    private static final int REQUEST_CODE_NGUOI_THUE_CHI_TIET = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoithue);

        // Khởi tạo ListView và ArrayList danh sách người thuê
        listViewNguoiThue = findViewById(R.id.listViewNguoiThue);

        // TODO: Lấy danh sách người thuê có role là 1 từ cơ sở dữ liệu (Database) và thêm vào mListNguoiThue
        DBHelper dbHelper = new DBHelper(this);
        mListNguoiThue = dbHelper.getAllTaiKhoanWithRole1(); // Lấy danh sách tài khoản có role là 1
        mNguoiThueAdapter = new NguoiThueAdapter(this, mListNguoiThue);
        listViewNguoiThue.setAdapter(mNguoiThueAdapter);

        // Xử lý sự kiện nhấp vào một mục trong ListView
        listViewNguoiThue.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Lấy tài khoản được chọn từ danh sách
                TaiKhoan taiKhoan = mListNguoiThue.get(position);

                // Chuyển dữ liệu tới NguoiThueChiTietActivity với startActivityForResult
                Intent intent = new Intent(NguoiThueActivity.this, NguoiThueChiTietActivity.class);
                intent.putExtra("taikhoan", taiKhoan);
                startActivityForResult(intent, REQUEST_CODE_NGUOI_THUE_CHI_TIET);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_NGUOI_THUE_CHI_TIET && resultCode == RESULT_OK) {
            // Cập nhật lại dữ liệu trong ListView
            DBHelper dbHelper = new DBHelper(this);
            mListNguoiThue.clear();
            mListNguoiThue.addAll(dbHelper.getAllTaiKhoanWithRole1());
            mNguoiThueAdapter.notifyDataSetChanged();
        }
    }

}
