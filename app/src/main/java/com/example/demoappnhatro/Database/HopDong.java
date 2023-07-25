package com.example.demoappnhatro.Database;

public class HopDong {
    private long hopDongId;
    private String hopDongTen;
    private String hopDongNoiDung;
    private String hopDongNgayBatDau;
    private String hopDongNgayKetThuc;
    private int trangThaiHopDong;
    private long phongId;
    private long nguoiDungId;

    public HopDong() {
    }

    public HopDong(long hopDongId, String hopDongTen, String hopDongNoiDung, String hopDongNgayBatDau, String hopDongNgayKetThuc, int trangThaiHopDong, long phongId, long nguoiDungId) {
        this.hopDongId = hopDongId;
        this.hopDongTen = hopDongTen;
        this.hopDongNoiDung = hopDongNoiDung;
        this.hopDongNgayBatDau = hopDongNgayBatDau;
        this.hopDongNgayKetThuc = hopDongNgayKetThuc;
        this.trangThaiHopDong = trangThaiHopDong;
        this.phongId = phongId;
        this.nguoiDungId = nguoiDungId;
    }

    public long getHopDongId() {
        return hopDongId;
    }

    public void setHopDongId(long hopDongId) {
        this.hopDongId = hopDongId;
    }

    public String getHopDongTen() {
        return hopDongTen;
    }

    public void setHopDongTen(String hopDongTen) {
        this.hopDongTen = hopDongTen;
    }

    public String getHopDongNoiDung() {
        return hopDongNoiDung;
    }

    public void setHopDongNoiDung(String hopDongNoiDung) {
        this.hopDongNoiDung = hopDongNoiDung;
    }

    public String getHopDongNgayBatDau() {
        return hopDongNgayBatDau;
    }

    public void setHopDongNgayBatDau(String hopDongNgayBatDau) {
        this.hopDongNgayBatDau = hopDongNgayBatDau;
    }

    public String getHopDongNgayKetThuc() {
        return hopDongNgayKetThuc;
    }

    public void setHopDongNgayKetThuc(String hopDongNgayKetThuc) {
        this.hopDongNgayKetThuc = hopDongNgayKetThuc;
    }

    public int getTrangThaiHopDong() {
        return trangThaiHopDong;
    }

    public void setTrangThaiHopDong(int trangThaiHopDong) {
        this.trangThaiHopDong = trangThaiHopDong;
    }

    public long getPhongId() {
        return phongId;
    }

    public void setPhongId(long phongId) {
        this.phongId = phongId;
    }

    public long getNguoiDungId() {
        return nguoiDungId;
    }

    public void setNguoiDungId(long nguoiDungId) {
        this.nguoiDungId = nguoiDungId;
    }
}
