package com.example.demoappnhatro.Database;

import static java.nio.file.Files.delete;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.demoappnhatro.UI.ToaNha.BuildingFragment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "QLPhongTro.db";
    private static final int DATABASE_VERSION = 2;

    // Table ChiTietHoaDon
    public static final String TABLE_CHITIETHOADON = "ChiTietHoaDon";
    public static final String COLUMN_CHITIETID = "chitietid";
    public static final String COLUMN_HOADONID = "hoadonid";
    public static final String COLUMN_PHONGID = "phongid";
    public static final String COLUMN_GIATHUE = "giathue";
    public static final String COLUMN_TIENDIEN = "tiendien";
    public static final String COLUMN_TIENNUOC = "tiennuoc";
    public static final String COLUMN_NGAY = "ngay";
    public static final String COLUMN_TRANGTHAI = "trangthai";

    // Table HoaDon
    public static final String TABLE_HOADON = "HoaDon";
    public static final String COLUMN_HOADON_HOADONID = "hoadonid";
    public static final String COLUMN_NGAYHOADON = "ngayhoadon";
    public static final String COLUMN_TRANGTHAIHOADON = "trangthaihoadon";
    public static final String COLUMN_HOADON_PHONGID = "phongid";

    // Table PhongTro
    public static final String TABLE_PHONGTRO = "PhongTro";
    public static final String COLUMN_PHONGID_PHONG = "phongid";
    public static final String COLUMN_TENPHONG = "tenphong";
    public static final String COLUMN_MOTAPHONG = "motaphong";
    public static final String COLUMN_TIENCOC_PHONG = "tiencoc";
    public static final String COLUMN_DIENTICH_PHONG = "dientich";
    public static final String COLUMN_GIATHUE_PHONG = "giathuephong";
    public static final String COLUMN_TRANGTHAI_PHONG = "trangthaiphong";
    public static final String COLUMN_NGUOITHUEID = "nguoithueid";

    /*// Table ToaNha
    public static final String TABLE_TOANHA = "ToaNha";
    public static final String COLUMN_TOANHAID = "toanhaid";
    public static final String COLUMN_TENTOANHA = "tentoanha";
    public static final String COLUMN_MOTATOANHA = "mota";
    public static final String COLUMN_DIACHITOANHA = "diachi";
    public static final String COLUMN_TOANHA_PHONGID = "phongid";*/

    // Table TaiKhoan
    public static final String TABLE_TAIKHOAN = "TaiKhoan";
    public static final String COLUMN_NGUOIDUNGID = "nguoidungid";
    public static final String COLUMN_TENNGUOIDUNG = "tennguoidung";
    public static final String COLUMN_SDT = "sdt";
    public static final String COLUMN_TENDANGNHAP = "tendangnhap";
    public static final String COLUMN_MATKHAU = "matkhau";
    public static final String COLUMN_PHONGID_TAIKHOAN = "phongid";
    public static final String COLUMN_ROLE = "role";

    // Table SuCo
    public static final String TABLE_SUCO = "SuCo";
    public static final String COLUMN_SUCOID = "sucoid";
    public static final String COLUMN_TENSUCO = "tensuco";
    public static final String COLUMN_MOTASUCO = "motasuco";
    public static final String COLUMN_TRANGTHAISUCO = "trangthaisuco";
    public static final String COLUMN_PHONGID_SUCO = "phongid";
    public static final String COLUMN_NGUOIDUNGID_SUCO = "nguoidungid";

    // Table ThongBaoSuCo
    public static final String TABLE_THONGBAO_SUCO = "ThongBaoSuCo";
    public static final String COLUMN_THONGBAO_SUCOID = "thongbao_sucoid";
    public static final String COLUMN_THONGBAO_SUCOTEN = "thongbao_sucoten";
    public static final String COLUMN_THONGBAO_SUCONGAY = "thongbao_sucongay";
    public static final String COLUMN_PHONGID_THONGBAO_SUCO = "phongid";
    public static final String COLUMN_NGUOIDUNGID_THONGBAO_SUCO = "nguoidungid";


    // Table HopDong
    public static final String TABLE_HOPDONG = "HopDong";
    public static final String COLUMN_HOPDONGID = "hopdong_id";
    public static final String COLUMN_HOPDONGTEN = "hopdong_ten";
    public static final String COLUMN_HOPDONGTIENDIEN = "hopdong_tiendien";
    public static final String COLUMN_HOPDONGTIENNUOC = "hopdong_tiennuoc";
    public static final String COLUMN_HOPDONGTIENPHONG = "hopdong_tienphong";
    public static final String COLUMN_HOPDONGTIENCOC = "hopdong_tiencoc";
    public static final String COLUMN_HOPDONGNOIDUNG = "hopdong_noidung";
    public static final String COLUMN_HOPDONGNGAYBATDAU = "hopdong_ngaybatdau";
    public static final String COLUMN_HOPDONGNGAYKETTHUC = "hopdong_ngayketthuc";
    public static final String COLUMN_HOPDONGTENNGUOITHUE = "hopdong_tennguoithue";
    public static final String COLUMN_HOPDONGCCCDNGUOITHUE = "hopdong_cccdnguoithue";
    public static final String COLUMN_HOPDONGTENCHUTRO = "hopdong_tenchutro";
    public static final String COLUMN_HOPDONGCCCDCHUTRO = "hopdong_cccdchutro";
    public static final String COLUMN_TRANGTHAIHOPDONG = "hopdong_trangthai";
    public static final String COLUMN_PHONGID_HOPDONG = "phongid";
    public static final String COLUMN_NGUOIDUNGID_HOPDONG = "nguoidungid";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public DBHelper(BuildingFragment buildingFragment) {
           super(buildingFragment.getContext(), DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createChiTietHoaDonTable = "CREATE TABLE " + TABLE_CHITIETHOADON + "(" +
                COLUMN_CHITIETID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_HOADONID + " INTEGER, " +
                COLUMN_PHONGID + " INTEGER, " +
                COLUMN_GIATHUE + " INTEGER, " +
                COLUMN_TIENDIEN + " INTEGER, " +
                COLUMN_TIENNUOC + " INTEGER, " +
                COLUMN_NGAY + " TEXT, " +
                COLUMN_TRANGTHAI + " INTEGER, " +
                "FOREIGN KEY(" + COLUMN_HOADONID + ") REFERENCES " + TABLE_HOADON + "(" + COLUMN_HOADON_HOADONID + "), " +
                "FOREIGN KEY(" + COLUMN_PHONGID + ") REFERENCES " + TABLE_PHONGTRO + "(" + COLUMN_PHONGID_PHONG + ")" +
                ")";
        db.execSQL(createChiTietHoaDonTable);

        String createHoaDonTable = "CREATE TABLE " + TABLE_HOADON + "(" +
                COLUMN_HOADON_HOADONID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NGAYHOADON + " TEXT, " +
                COLUMN_TRANGTHAIHOADON + " INTEGER, " +
                COLUMN_HOADON_PHONGID + " INTEGER, " +
                "FOREIGN KEY(" + COLUMN_HOADON_PHONGID + ") REFERENCES " + TABLE_PHONGTRO + "(" + COLUMN_PHONGID_PHONG + ")" +
                ")";
        db.execSQL(createHoaDonTable);

        String createPhongTroTable = "CREATE TABLE " + TABLE_PHONGTRO + "(" +
                COLUMN_PHONGID_PHONG + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TENPHONG + " TEXT, " +
                COLUMN_MOTAPHONG + " TEXT, " +
                COLUMN_TIENCOC_PHONG + " INTEGER, " +
                COLUMN_DIENTICH_PHONG + " INTEGER, " +
                COLUMN_GIATHUE_PHONG + " INTEGER, " +
                COLUMN_TRANGTHAI_PHONG + " INTEGER, " +
                COLUMN_NGUOITHUEID + " INTEGER" +
                ")";
        db.execSQL(createPhongTroTable);

        String createTaiKhoanTable = "CREATE TABLE " + TABLE_TAIKHOAN + "(" +
                COLUMN_NGUOIDUNGID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TENNGUOIDUNG + " TEXT, " +
                COLUMN_SDT + " INT, " +
                COLUMN_TENDANGNHAP + " TEXT, " +
                COLUMN_MATKHAU + " TEXT, " +
                COLUMN_PHONGID_TAIKHOAN + " INTEGER, " +
                COLUMN_ROLE + " INTEGER" +
                ")";
        db.execSQL(createTaiKhoanTable);

        String createSuCoTable = "CREATE TABLE " + TABLE_SUCO + "(" +
                COLUMN_SUCOID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TENSUCO + " TEXT, " +
                COLUMN_MOTASUCO + " TEXT, " +
                COLUMN_TRANGTHAISUCO + " INTEGER, " +
                COLUMN_PHONGID_SUCO + " INTEGER, " +
                COLUMN_NGUOIDUNGID_SUCO + " INTEGER, " +
                "FOREIGN KEY(" + COLUMN_PHONGID_SUCO + ") REFERENCES " + TABLE_PHONGTRO + "(" + COLUMN_PHONGID_PHONG + "), " +
                "FOREIGN KEY(" + COLUMN_NGUOIDUNGID_SUCO + ") REFERENCES " + TABLE_TAIKHOAN + "(" + COLUMN_NGUOIDUNGID + ")" +
                ")";
        db.execSQL(createSuCoTable);

        String createThongBaoSuCoTable = "CREATE TABLE " + TABLE_THONGBAO_SUCO + "(" +
                COLUMN_THONGBAO_SUCOID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_THONGBAO_SUCOTEN + " TEXT, " +
                COLUMN_THONGBAO_SUCONGAY + " TEXT, " +
                COLUMN_PHONGID_THONGBAO_SUCO + " INTEGER, " +
                COLUMN_NGUOIDUNGID_THONGBAO_SUCO + " INTEGER, " +
                "FOREIGN KEY(" + COLUMN_PHONGID_THONGBAO_SUCO + ") REFERENCES " + TABLE_PHONGTRO + "(" + COLUMN_PHONGID_PHONG + "), " +
                "FOREIGN KEY(" + COLUMN_NGUOIDUNGID_THONGBAO_SUCO + ") REFERENCES " + TABLE_TAIKHOAN + "(" + COLUMN_NGUOIDUNGID + ")" +
                ")";
        db.execSQL(createThongBaoSuCoTable);

        /*String createThongBaoTable = "CREATE TABLE " + TABLE_THONGBAO + "(" +
                COLUMN_THONGBAOID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_THONGBAONOIDUNG + " TEXT, " +
                COLUMN_THONGBAONGAY + " TEXT, " +
                COLUMN_NGUOIDUNGID_THONGBAO + " INTEGER, " +
                "FOREIGN KEY(" + COLUMN_NGUOIDUNGID_THONGBAO + ") REFERENCES " + TABLE_TAIKHOAN + "(" + COLUMN_NGUOIDUNGID + ")" +
                ")";
        db.execSQL(createThongBaoTable);*/

        String createHopDongTable = "CREATE TABLE " + TABLE_HOPDONG + "(" +
                COLUMN_HOPDONGID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_HOPDONGTEN + " TEXT, " +
                COLUMN_HOPDONGTIENDIEN + " INTEGER, " +
                COLUMN_HOPDONGTIENNUOC + " INTEGER, " +
                COLUMN_HOPDONGTIENPHONG + " INTEGER, " +
                COLUMN_HOPDONGTIENCOC + " INTEGER, " +
                COLUMN_HOPDONGNOIDUNG + " TEXT, " +
                COLUMN_HOPDONGNGAYBATDAU + " TEXT, " +
                COLUMN_HOPDONGNGAYKETTHUC + " TEXT, " +
                COLUMN_HOPDONGTENNGUOITHUE + " TEXT, " +
                COLUMN_HOPDONGTENCHUTRO + " TEXT, " +
                COLUMN_HOPDONGCCCDNGUOITHUE + " INTEGER, " +
                COLUMN_HOPDONGCCCDCHUTRO + " INTEGER, " +
                COLUMN_TRANGTHAIHOPDONG + " INTEGER, " +
                COLUMN_PHONGID_HOPDONG + " INTEGER, " +
                COLUMN_NGUOIDUNGID_HOPDONG + " INTEGER, " +
                "FOREIGN KEY(" + COLUMN_PHONGID_HOPDONG + ") REFERENCES " + TABLE_PHONGTRO + "(" + COLUMN_PHONGID_PHONG + "), " +
                "FOREIGN KEY(" + COLUMN_NGUOIDUNGID_HOPDONG + ") REFERENCES " + TABLE_TAIKHOAN + "(" + COLUMN_NGUOIDUNGID + ")" +
                ")";
        db.execSQL(createHopDongTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            // Nếu phiên bản cũ nhỏ hơn 2, thêm cột "trangthai" vào bảng "PhongTro"
            db.execSQL("ALTER TABLE " + TABLE_PHONGTRO + " ADD COLUMN trangthai INTEGER");
        }
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHITIETHOADON);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_HOADON);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_PHONGTRO);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_TAIKHOAN);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUCO);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_THONGBAO_SUCO);
            /*db.execSQL("DROP TABLE IF EXISTS " + TABLE_THONGBAO);*/
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_HOPDONG);
            onCreate(db);

    }

    public void addChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_HOADONID, chiTietHoaDon.getHoaDonId());
        values.put(COLUMN_NGAY, chiTietHoaDon.getNgay());
        values.put(COLUMN_GIATHUE, chiTietHoaDon.getGiaThue());
        values.put(COLUMN_TIENDIEN, chiTietHoaDon.getTienDien());
        values.put(COLUMN_TIENNUOC, chiTietHoaDon.getTienNuoc());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_CHITIETHOADON, null, values);
        db.close();
    }

    public void addHoaDon(HoaDon hoaDon) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_HOADONID, hoaDon.getHoaDonId());
        values.put(COLUMN_NGAYHOADON, hoaDon.getNgayHoaDon());
        values.put(COLUMN_TRANGTHAIHOADON, hoaDon.getTrangThaiHoaDon());
        values.put(COLUMN_HOADON_PHONGID, hoaDon.getPhongId());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_HOADON, null, values);
        db.close();
    }



    public boolean checkTaiKhoanTonTai(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_TAIKHOAN, null,
                COLUMN_TENDANGNHAP + " = ?", new String[]{email},
                null, null, null);

        boolean taiKhoanTonTai = cursor != null && cursor.getCount() > 0;

        if (cursor != null) {
            cursor.close();
        }

        return taiKhoanTonTai;
    }

    public void addTaiKhoanAdmin(TaiKhoan taiKhoan) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_TENNGUOIDUNG, taiKhoan.getTenNguoiDung());
        values.put(COLUMN_SDT, taiKhoan.getSdt());
        values.put(COLUMN_TENDANGNHAP, taiKhoan.getTenDangNhap());
        values.put(COLUMN_MATKHAU, taiKhoan.getMatKhau());
        values.put(COLUMN_ROLE, taiKhoan.getRole());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_TAIKHOAN, null, values);
        db.close();
    }

    public TaiKhoan getTaiKhoan(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_TAIKHOAN, new String[]{COLUMN_NGUOIDUNGID, COLUMN_TENNGUOIDUNG,
                        COLUMN_SDT, COLUMN_TENDANGNHAP, COLUMN_MATKHAU, COLUMN_ROLE},
                COLUMN_TENDANGNHAP + " = ? AND " + COLUMN_MATKHAU + " = ?",
                new String[]{email, password}, null, null, null, null);

        TaiKhoan taiKhoan = null;
        if (cursor != null && cursor.moveToFirst()) {
            @SuppressLint("Range") int nguoiDungId = cursor.getInt(cursor.getColumnIndex(COLUMN_NGUOIDUNGID));
            @SuppressLint("Range") String tenNguoiDung = cursor.getString(cursor.getColumnIndex(COLUMN_TENNGUOIDUNG));
            @SuppressLint("Range") int sdt = cursor.getInt(cursor.getColumnIndex(COLUMN_SDT));
            @SuppressLint("Range") String tenDangNhap = cursor.getString(cursor.getColumnIndex(COLUMN_TENDANGNHAP));
            @SuppressLint("Range") String matKhau = cursor.getString(cursor.getColumnIndex(COLUMN_MATKHAU)); // Corrected line
            @SuppressLint("Range") int role = cursor.getInt(cursor.getColumnIndex(COLUMN_ROLE));

            taiKhoan = new TaiKhoan(nguoiDungId, tenNguoiDung, sdt, tenDangNhap, matKhau, role); // Updated constructor
        }

        if (cursor != null) {
            cursor.close();
        }
        db.close();

        return taiKhoan;
    }


    public ArrayList<PhongTro> getAllPhong() {
        ArrayList<PhongTro> listPhong = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_PHONGTRO;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                long phongId = cursor.getInt(0);
                String tenPhong = cursor.getString(1);
                String moTaPhong = cursor.getString(2);
                int datCoc = cursor.getInt(3);
                int giaPhong = cursor.getInt(4);
                int dienTich = cursor.getInt(5);
                int trangThaiPhong = cursor.getInt(6);
                long toaNhaId = cursor.getInt(7);
                PhongTro phongTro = new PhongTro(phongId, tenPhong, datCoc, giaPhong, dienTich, trangThaiPhong, moTaPhong);
                listPhong.add(phongTro);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listPhong;
    }

    public Cursor getdata() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_PHONGTRO, null);
        return cursor;
    }

    public ArrayList<TaiKhoan> getAllTaiKhoanWithRole1() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<TaiKhoan> taiKhoanList = new ArrayList<>();

        Cursor cursor = db.query(
                TABLE_TAIKHOAN,
                new String[]{COLUMN_NGUOIDUNGID, COLUMN_TENNGUOIDUNG, COLUMN_TENDANGNHAP, COLUMN_MATKHAU, COLUMN_SDT, COLUMN_ROLE},
                COLUMN_ROLE + " = ?",
                new String[]{String.valueOf(1)}, // Role là 1
                null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                long id = cursor.getLong(cursor.getColumnIndex(COLUMN_NGUOIDUNGID));
                String tenNguoiDung = cursor.getString(cursor.getColumnIndex(COLUMN_TENNGUOIDUNG));
                String tenDangNhap = cursor.getString(cursor.getColumnIndex(COLUMN_TENDANGNHAP));
                String matKhau = cursor.getString(cursor.getColumnIndex(COLUMN_MATKHAU));
                String soDienThoai = cursor.getString(cursor.getColumnIndex(COLUMN_SDT));
                int quyen = cursor.getInt(cursor.getColumnIndex(COLUMN_ROLE));

                TaiKhoan taiKhoan = new TaiKhoan(id, tenNguoiDung, tenDangNhap, matKhau, soDienThoai, quyen);
                taiKhoanList.add(taiKhoan);
            } while (cursor.moveToNext());

            cursor.close();
        }

        db.close();
        return taiKhoanList;
    }

    public void deleteTaiKhoanById(long nguoiDungId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TAIKHOAN, COLUMN_NGUOIDUNGID + " = ?", new String[]{String.valueOf(nguoiDungId)});
        db.close();
    }

    public void resetMatKhauById(long nguoiDungId) {
        // Tạo mật khẩu ngẫu nhiên (chỉ bao gồm chữ cái và chữ số)
        String newPassword = generateRandomPassword();

        // Cập nhật mật khẩu mới vào cơ sở dữ liệu
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_MATKHAU, newPassword);
        db.update(TABLE_TAIKHOAN, values, COLUMN_NGUOIDUNGID + " = ?", new String[]{String.valueOf(nguoiDungId)});
        db.close();
    }

    // Phương thức để tạo mật khẩu ngẫu nhiên
    private String generateRandomPassword() {
        String upperCaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseChars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";

        String allChars = upperCaseChars + lowerCaseChars + numbers;

        // Độ dài của mật khẩu ngẫu nhiên (có thể thay đổi nếu bạn muốn)
        int passwordLength = 8;
        StringBuilder newPassword = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(allChars.length());
            newPassword.append(allChars.charAt(randomIndex));
        }

        return newPassword.toString();
    }

    @SuppressLint("Range")
    public String getTenPhongTroById(long idphong) {
        String tenPhong = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        try {
            String[] projection = {COLUMN_TENPHONG};
            String selection = COLUMN_PHONGID_PHONG + " = ?";
            String[] selectionArgs = {String.valueOf(idphong)};

            cursor = db.query(
                    TABLE_PHONGTRO,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    null
            );

            if (cursor != null && cursor.moveToFirst()) {
                tenPhong = cursor.getString(cursor.getColumnIndex(COLUMN_TENPHONG));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return tenPhong;
    }


    public ArrayList<HopDong> getAllHopDong() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<HopDong> hopDongList = new ArrayList<>();

        Cursor cursor = db.query(
                TABLE_HOPDONG,
                new String[]{COLUMN_HOPDONGID,
                        COLUMN_HOPDONGTEN,
                        COLUMN_HOPDONGNGAYBATDAU,
                        COLUMN_HOPDONGNGAYKETTHUC,
                        COLUMN_HOPDONGTIENPHONG,
                        COLUMN_HOPDONGTIENDIEN,
                        COLUMN_HOPDONGTIENNUOC,
                        COLUMN_HOPDONGTIENCOC,
                        COLUMN_HOPDONGTENNGUOITHUE,
                        COLUMN_HOPDONGCCCDNGUOITHUE,
                        COLUMN_HOPDONGTENCHUTRO,
                        COLUMN_HOPDONGCCCDCHUTRO,
                        COLUMN_HOPDONGNOIDUNG,
                        COLUMN_NGUOIDUNGID_HOPDONG},
                null,
                null,
                null,
                null,
                null
        );

        if (cursor != null && cursor.moveToFirst()) {
            do {
                long id = cursor.getLong(cursor.getColumnIndex(COLUMN_HOPDONGID));
                String tenphong = cursor.getString(cursor.getColumnIndex(COLUMN_HOPDONGTEN));
                String ngayBatDau = cursor.getString(cursor.getColumnIndex(COLUMN_HOPDONGNGAYBATDAU));
                String ngayKetThuc = cursor.getString(cursor.getColumnIndex(COLUMN_HOPDONGNGAYKETTHUC));
                int tienPhong = cursor.getInt(cursor.getColumnIndex(COLUMN_HOPDONGTIENPHONG));
                int tienDien = cursor.getInt(cursor.getColumnIndex(COLUMN_HOPDONGTIENDIEN));
                int tienNuoc = cursor.getInt(cursor.getColumnIndex(COLUMN_HOPDONGTIENNUOC));
                int tienCoc = cursor.getInt(cursor.getColumnIndex(COLUMN_HOPDONGTIENCOC));
                String tennguoithue = cursor.getString(cursor.getColumnIndex(COLUMN_HOPDONGTENNGUOITHUE));
                int cccdnguoithue = cursor.getInt(cursor.getColumnIndex(COLUMN_HOPDONGCCCDNGUOITHUE));
                String tenchutro = cursor.getString(cursor.getColumnIndex(COLUMN_HOPDONGTENCHUTRO));
                int cccdchutrongoi = cursor.getInt(cursor.getColumnIndex(COLUMN_HOPDONGCCCDCHUTRO));
                String noidung = cursor.getString(cursor.getColumnIndex(COLUMN_HOPDONGNOIDUNG));
                long nguoiDungId = cursor.getLong(cursor.getColumnIndex(COLUMN_NGUOIDUNGID_HOPDONG));

                HopDong hopDong = new HopDong(id,tenphong, ngayBatDau, ngayKetThuc, tienPhong, tienDien, tienNuoc, tienCoc, cccdnguoithue, cccdchutrongoi, tennguoithue, tenchutro,noidung, nguoiDungId);
                hopDongList.add(hopDong);
            } while (cursor.moveToNext());

            cursor.close();
        }

        db.close();
        return hopDongList;
    }

    public ArrayList<TaiKhoan> getTaiKhoan(long nguoiThueId) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<TaiKhoan> taiKhoanList = new ArrayList<>();

        Cursor cursor = db.query(
                TABLE_TAIKHOAN,
                new String[]{COLUMN_NGUOIDUNGID,
                        COLUMN_TENDANGNHAP,
                        COLUMN_MATKHAU,
                        COLUMN_NGUOIDUNGID},
                COLUMN_NGUOIDUNGID + "=?",
                new String[]{String.valueOf(nguoiThueId)},
                null,
                null,
                null,
                null
        );

        if (cursor != null && cursor.moveToFirst()) {
            long id = cursor.getLong(cursor.getColumnIndex(COLUMN_NGUOIDUNGID));
            String username = cursor.getString(cursor.getColumnIndex(COLUMN_TENDANGNHAP));
            String password = cursor.getString(cursor.getColumnIndex(COLUMN_MATKHAU));
            long nguoiDungId = cursor.getLong(cursor.getColumnIndex(COLUMN_NGUOIDUNGID));

            TaiKhoan taiKhoan = new TaiKhoan(id, username, password, nguoiDungId);
            taiKhoanList.add(taiKhoan);
            cursor.close();
        }while (cursor.moveToNext());

        db.close();
        return taiKhoanList;
    }

    public void addHopDong(HopDong hopDong) {
        ContentValues values = new ContentValues();

        values.put(COLUMN_HOPDONGTEN, hopDong.getHopDongTen());
        values.put(COLUMN_HOPDONGNGAYBATDAU, hopDong.getHopDongNgayBatDau());
        values.put(COLUMN_HOPDONGNGAYKETTHUC, hopDong.getHopDongNgayKetThuc());
        values.put(COLUMN_HOPDONGTIENPHONG, hopDong.getTienPhong());
        values.put(COLUMN_HOPDONGTIENDIEN, hopDong.getTienDien());
        values.put(COLUMN_HOPDONGTIENNUOC, hopDong.getTienNuoc());
        values.put(COLUMN_HOPDONGTIENCOC, hopDong.getTienCoc());
        values.put(COLUMN_HOPDONGTENNGUOITHUE, hopDong.getTennguoithue());
        values.put(COLUMN_HOPDONGCCCDNGUOITHUE, hopDong.getCccdnguoithue());
        values.put(COLUMN_HOPDONGTENCHUTRO, hopDong.getTenchutro());
        values.put(COLUMN_HOPDONGCCCDCHUTRO, hopDong.getCccdchutro());
        values.put(COLUMN_HOPDONGNOIDUNG, hopDong.getHopDongNoiDung());
        values.put(COLUMN_NGUOIDUNGID_HOPDONG, hopDong.getNguoiDungId());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_HOPDONG, null, values);
        db.close();
    }
}
