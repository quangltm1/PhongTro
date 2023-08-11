package com.example.demoappnhatro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demoappnhatro.Adapter.HopDongAdapter;
import com.example.demoappnhatro.Database.DBHelper;
import com.example.demoappnhatro.Database.HopDong;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HopDongActivity extends AppCompatActivity {
    ListView lvHopDong;
    ArrayList<HopDong> listHopDong;
    HopDongAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsach_hopdong);

        lvHopDong = findViewById(R.id.lv_danhsachhopdong);

        DBHelper dbHelper = new DBHelper(this);
        listHopDong = dbHelper.getAllHopDong();
        adapter = new HopDongAdapter(this, listHopDong);
        lvHopDong.setAdapter(adapter);

        lvHopDong.setOnItemClickListener((parent, view, position, id) -> {
            HopDong hopDong = listHopDong.get(position);
            Intent intent = new Intent(HopDongActivity.this, ThongTinHopDongActivity.class);
            intent.putExtra("hopdong", (Serializable) hopDong);
            startActivity(intent);
        });
    }
}
