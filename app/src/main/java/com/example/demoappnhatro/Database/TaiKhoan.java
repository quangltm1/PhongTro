package com.example.demoappnhatro.Database;

import java.io.Serializable;

public class TaiKhoan implements Serializable {
    private long nguoiDungId;
    private String tenNguoiDung;
    private String tenDangNhap;
    private String sdt;
    private String matKhau;
    private long phongTroId;

    public TaiKhoan(long id, String username, String password, long nguoiDungId) {

    }

    public TaiKhoan(String tenNguoiThue, String soDienThoai, String matKhau) {
        this.tenNguoiDung = tenNguoiThue;
        this.sdt = soDienThoai;
        this.matKhau = matKhau;
    }

    public long getPhongTroId() {
        return phongTroId;
    }

    public void setPhongTroId(long phongTroId) {
        this.phongTroId = phongTroId;
    }

    private int role;

    public TaiKhoan(long nguoiDungId, String tenNguoiDung, int sdt, String tenDangNhap, String matKhau, int role) {
        this.nguoiDungId =  nguoiDungId;
        this.tenNguoiDung = tenNguoiDung;
        this.sdt = String.valueOf(sdt);
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.role = role;
    }

    public TaiKhoan(String ten, String email, String password, String sdt, int i) {
        this.tenNguoiDung = ten;
        this.tenDangNhap = email;
        this.matKhau = password;
        this.sdt = sdt;
        this.role = i;
    }

    public TaiKhoan(long id, String tenTaiKhoan, String tenDangNhap, String matKhau, String soDienThoai, int quyen) {
        this.nguoiDungId = id;
        this.tenNguoiDung = tenTaiKhoan;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.sdt = soDienThoai;
        this.role = quyen;
    }

    @Override
    public String toString() {
        return tenNguoiDung;
    }


    public long getNguoiDungId() {
        return nguoiDungId;
    }

    public void setNguoiDungId(long nguoiDungId) {
        this.nguoiDungId = nguoiDungId;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }


    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
