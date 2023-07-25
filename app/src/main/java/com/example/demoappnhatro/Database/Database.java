package com.example.demoappnhatro.Database;

import static com.example.demoappnhatro.Database.DBHelper.TABLE_PHONGTRO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


public class Database {
    SQLiteDatabase database;
    DBHelper dbHelper;

    public Database(Context context) {
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public static Cursor rawQuery(String truyvan, Object o) {
        truyvan = truyvan.replace("'", "''") + ";";
        return null;
    }


    public Cursor layTatCaDuLieuPhongTro(){
        String cot[] = {DBHelper.COLUMN_PHONGID, DBHelper.COLUMN_TENPHONG, DBHelper.COLUMN_GIATHUE_PHONG, DBHelper.COLUMN_TRANGTHAI_PHONG, DBHelper.COLUMN_NGUOITHUEID};
        Cursor cursor = null;
        cursor = database.query(TABLE_PHONGTRO, cot,null,null,null,null,null);
        return cursor;
    }

    public Cursor layTatCaDuLieuNguoiThue() {
        String cot[] = {DBHelper.COLUMN_ROLE}; // Add the COLUMN_ROLE here
        Cursor cursor = null;
        cursor = database.query(DBHelper.TABLE_TAIKHOAN, cot, null, null, null, null, null);
        return cursor;
    }


    public Cursor layTatCaDuLieuHoaDon(){
        String cot[] = {DBHelper.COLUMN_HOADON_HOADONID, DBHelper.COLUMN_NGAYHOADON, DBHelper.COLUMN_TRANGTHAIHOADON, DBHelper.COLUMN_HOADON_PHONGID};
        Cursor cursor = null;
        cursor = database.query(DBHelper.TABLE_HOADON, cot,null,null,null,null,null);
        return cursor;
    }
    public Cursor layTatCaDuLieuHopDong(){
        String cot[] = {DBHelper.COLUMN_HOPDONGID, DBHelper.COLUMN_HOPDONGNGAYBATDAU, DBHelper.COLUMN_HOPDONGNGAYKETTHUC, DBHelper.COLUMN_TRANGTHAIHOPDONG, DBHelper.COLUMN_PHONGID_HOPDONG};
        Cursor cursor = null;
        cursor = database.query(DBHelper.TABLE_HOPDONG, cot,null,null,null,null,null);
        return cursor;
    }

    public Cursor layTatCaDuLieuChiTietHoaDon(){
        String cot[] = {DBHelper.COLUMN_CHITIETID, DBHelper.COLUMN_GIATHUE, DBHelper.COLUMN_TIENDIEN, DBHelper.COLUMN_TIENNUOC, DBHelper.COLUMN_NGAY, DBHelper.COLUMN_TRANGTHAI};
        Cursor cursor = null;
        cursor = database.query(DBHelper.TABLE_CHITIETHOADON, cot,null,null,null,null,null);
        return cursor;
    }
    // Phần CRUD cho bảng PhongTro
    public void addPhongTro(PhongTro phongTro) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_TENPHONG, phongTro.getTenPhong());
        values.put(DBHelper.COLUMN_GIATHUE_PHONG, phongTro.getGiaThuePhong());
        values.put(DBHelper.COLUMN_TRANGTHAI_PHONG, phongTro.getTrangThaiPhong());
        values.put(DBHelper.COLUMN_NGUOITHUEID, phongTro.getNguoiThueId());
        values.put(DBHelper.COLUMN_DIENTICH_PHONG, phongTro.getDienTich());
        values.put(DBHelper.COLUMN_TIENCOC_PHONG, phongTro.getTienCoc());
        values.put(DBHelper.COLUMN_MOTAPHONG, phongTro.getMoTaPhong());
        database.insert(TABLE_PHONGTRO, null, values);
    }

    // Phương thức xóa phòng theo ID
    public void deletePhongByID(long phongID) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TABLE_PHONGTRO, "phongid=?", new String[]{String.valueOf(phongID)});
        db.close();
    }

    // Phương thức để lấy thông tin phòng từ cơ sở dữ liệu dựa vào ID của phòng
    public PhongTro getPhongTroByID(long phongID) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        PhongTro phongTro = null;

        Cursor cursor = db.query(
                DBHelper.TABLE_PHONGTRO,
                new String[] { DBHelper.COLUMN_PHONGID_PHONG, DBHelper.COLUMN_TENPHONG,
                        DBHelper.COLUMN_TRANGTHAI, DBHelper.COLUMN_MOTAPHONG,
                        DBHelper.COLUMN_GIATHUE_PHONG, DBHelper.COLUMN_DIENTICH_PHONG,
                        DBHelper.COLUMN_TIENCOC_PHONG, DBHelper.COLUMN_NGUOITHUEID },
                DBHelper.COLUMN_PHONGID_PHONG + " = ?",
                new String[] { String.valueOf(phongID) },
                null, null, null, null
        );

        if (cursor != null && cursor.moveToFirst()) {
            @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_PHONGID_PHONG));
            @SuppressLint("Range") String tenPhong = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_TENPHONG));
            @SuppressLint("Range") String trangThai = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_TRANGTHAI));
            @SuppressLint("Range") String moTa = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_MOTAPHONG));
            @SuppressLint("Range") int giaThue = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_GIATHUE_PHONG));
            @SuppressLint("Range") int dienTich = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_DIENTICH_PHONG));
            @SuppressLint("Range") int tienCoc = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_TIENCOC_PHONG));

            // Tạo đối tượng PhongTro với dữ liệu lấy từ cơ sở dữ liệu
            phongTro = new PhongTro(id, tenPhong, trangThai, moTa, giaThue, dienTich, tienCoc);

            cursor.close();
        }

        db.close();
        return phongTro;
    }

    public TaiKhoan getTaiKhoan() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        TaiKhoan taiKhoan = null;

        Cursor cursor = db.query(
                DBHelper.TABLE_TAIKHOAN,
                new String[] {
                        DBHelper.COLUMN_NGUOIDUNGID,
                        DBHelper.COLUMN_TENNGUOIDUNG,
                        DBHelper.COLUMN_TENDANGNHAP,
                        DBHelper.COLUMN_MATKHAU,
                        DBHelper.COLUMN_SDT,
                        DBHelper.COLUMN_ROLE
                },
                null,
                null,
                null, null, null, null
        );

        if (cursor != null && cursor.moveToFirst()) {
            @SuppressLint("Range") long id = cursor.getLong(cursor.getColumnIndex(DBHelper.COLUMN_NGUOIDUNGID));
            @SuppressLint("Range") String tenTaiKhoan = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_TENNGUOIDUNG));
            @SuppressLint("Range") String tenDangNhap = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_TENDANGNHAP));
            @SuppressLint("Range") String matKhau = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_MATKHAU));
            @SuppressLint("Range") String soDienThoai = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_SDT));
            @SuppressLint("Range") int quyen = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_ROLE));

            // Tạo đối tượng TaiKhoan với dữ liệu lấy từ cơ sở dữ liệu
            taiKhoan = new TaiKhoan(id, tenTaiKhoan, tenDangNhap, matKhau, soDienThoai, quyen);

            cursor.close();
        }

        db.close();
        return taiKhoan;
    }

    public void capNhatThongTinPhongTro(PhongTro phongTro) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_TENPHONG, phongTro.getTenPhong());
        values.put(DBHelper.COLUMN_TRANGTHAI_PHONG, phongTro.getTrangThaiPhong());
        values.put(DBHelper.COLUMN_MOTAPHONG, phongTro.getMoTaPhong());
        values.put(DBHelper.COLUMN_GIATHUE_PHONG, phongTro.getGiaThuePhong());
        values.put(DBHelper.COLUMN_DIENTICH_PHONG, phongTro.getDienTich());
        values.put(DBHelper.COLUMN_TIENCOC_PHONG, phongTro.getTienCoc());
        values.put(DBHelper.COLUMN_NGUOITHUEID, phongTro.getNguoiThueId());

        db.update(DBHelper.TABLE_PHONGTRO, values, DBHelper.COLUMN_PHONGID_PHONG + " = ?",
                new String[] { String.valueOf(phongTro.getPhongId()) });
    }

    public TaiKhoan getTaiKhoanById(long nguoiThueId) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        TaiKhoan taiKhoan = null;

        Cursor cursor = db.query(
                DBHelper.TABLE_TAIKHOAN,
                new String[] {
                        DBHelper.COLUMN_NGUOIDUNGID,
                        DBHelper.COLUMN_TENNGUOIDUNG,
                        DBHelper.COLUMN_TENDANGNHAP,
                        DBHelper.COLUMN_MATKHAU,
                        DBHelper.COLUMN_SDT,
                        DBHelper.COLUMN_ROLE
                },
                DBHelper.COLUMN_NGUOIDUNGID + " = ?",
                new String[] { String.valueOf(nguoiThueId) },
                null, null, null, null
        );

        if (cursor != null && cursor.moveToFirst()) {
            @SuppressLint("Range") long id = cursor.getLong(cursor.getColumnIndex(DBHelper.COLUMN_NGUOIDUNGID));
            @SuppressLint("Range") String tenTaiKhoan = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_TENNGUOIDUNG));
            @SuppressLint("Range") String tenDangNhap = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_TENDANGNHAP));
            @SuppressLint("Range") String matKhau = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_MATKHAU));
            @SuppressLint("Range") String soDienThoai = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_SDT));
            @SuppressLint("Range") int quyen = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_ROLE));

            // Tạo đối tượng TaiKhoan với dữ liệu lấy từ cơ sở dữ liệu
            taiKhoan = new TaiKhoan(id, tenTaiKhoan, tenDangNhap, matKhau, soDienThoai, quyen);

            cursor.close();
        }

        db.close();
        return taiKhoan;

    }

    public void luuNguoiThueIdChoPhong(long phongId, long nguoiThueId) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_NGUOITHUEID, nguoiThueId);

        db.update(DBHelper.TABLE_PHONGTRO, values, DBHelper.COLUMN_PHONGID_PHONG + " = ?",
                new String[]{String.valueOf(phongId)});

        db.close();
    }


    // Tương tự cho các phương thức thêm, sửa, xóa của các bảng khác
    // ...
}
