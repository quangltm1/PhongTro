package com.example.demoappnhatro.Database;

import java.sql.Struct;

public class ChiTietHoaDon {
    private int chitietId;
    private int hoaDonId;
    private int phongId;
    private int giaThue;
    private int tienDien;
    private int tienNuoc;
    private String ngay;
    private int trangThai;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int chitietId, int hoaDonId, int phongId, int giaThue, int tienDien, int tienNuoc, String ngay, int trangThai) {
        this.chitietId = chitietId;
        this.hoaDonId = hoaDonId;
        this.phongId = phongId;
        this.giaThue = giaThue;
        this.tienDien = tienDien;
        this.tienNuoc = tienNuoc;
        this.ngay = ngay;
        this.trangThai = trangThai;
    }

    public int getChitietId() {
        return chitietId;
    }

    public void setChitietId(int chitietId) {
        this.chitietId = chitietId;
    }

    public int getHoaDonId() {
        return hoaDonId;
    }

    public void setHoaDonId(int hoaDonId) {
        this.hoaDonId = hoaDonId;
    }

    public int getPhongId() {
        return phongId;
    }

    public void setPhongId(int phongId) {
        this.phongId = phongId;
    }

    public int getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(int giaThue) {
        this.giaThue = giaThue;
    }

    public int getTienDien() {
        return tienDien;
    }

    public void setTienDien(int tienDien) {
        this.tienDien = tienDien;
    }

    public int getTienNuoc() {
        return tienNuoc;
    }

    public void setTienNuoc(int tienNuoc) {
        this.tienNuoc = tienNuoc;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
