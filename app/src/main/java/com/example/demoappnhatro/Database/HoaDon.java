package com.example.demoappnhatro.Database;

public class HoaDon {
    private long hoaDonId;
    private String ngayHoaDon;
    private int trangThaiHoaDon;
    private long phongId;

    public HoaDon() {
    }

    public HoaDon(long hoaDonId, String ngayHoaDon, int trangThaiHoaDon, int phongId) {
        this.hoaDonId = hoaDonId;
        this.ngayHoaDon = ngayHoaDon;
        this.trangThaiHoaDon = trangThaiHoaDon;
        this.phongId = phongId;
    }

    public long getHoaDonId() {
        return hoaDonId;
    }

    public void setHoaDonId(long hoaDonId) {
        this.hoaDonId = hoaDonId;
    }

    public String getNgayHoaDon() {
        return ngayHoaDon;
    }

    public void setNgayHoaDon(String ngayHoaDon) {
        this.ngayHoaDon = ngayHoaDon;
    }

    public int getTrangThaiHoaDon() {
        return trangThaiHoaDon;
    }

    public void setTrangThaiHoaDon(int trangThaiHoaDon) {
        this.trangThaiHoaDon = trangThaiHoaDon;
    }

    public long getPhongId() {
        return phongId;
    }

    public void setPhongId(long phongId) {
        this.phongId = phongId;
    }
}
