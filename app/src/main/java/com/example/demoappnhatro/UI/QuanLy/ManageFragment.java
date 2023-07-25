package com.example.demoappnhatro.UI.QuanLy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.demoappnhatro.Database.DBHelper;
import com.example.demoappnhatro.Database.Database;
import com.example.demoappnhatro.Database.TaiKhoan;
import com.example.demoappnhatro.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ManageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ManageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView tv_sdt, tv_ten;

    TextView tv_round_quanly;
    Button btn_dangxuat;

    Database database;
    DBHelper dbHelper;


    public ManageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ManageFragment newInstance(String param1, String param2) {
        ManageFragment fragment = new ManageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view , savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public void onResume()
    {
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manage, container, false);
        // Inflate the layout for this fragment
        tv_sdt = view.findViewById(R.id.tv_sdt);
        tv_round_quanly = view.findViewById(R.id.tv_chucvu);
        tv_ten = view.findViewById(R.id.tv_name);
        btn_dangxuat = view.findViewById(R.id.btn_dang_xuat);


        database = new Database(this.getContext());
        dbHelper = new DBHelper(this.getContext());

        TaiKhoan taiKhoan = database.getTaiKhoan();
        tv_ten.setText("Tên: "+taiKhoan.getTenNguoiDung());
        tv_sdt.setText("Số điện thoại: 0"+taiKhoan.getSdt());
        int role = taiKhoan.getRole();
        String roleText = role == 0 ? "Quản lý" : "Người Thuê";
        tv_round_quanly.setText(roleText);

        btn_dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        return view;
    }
}