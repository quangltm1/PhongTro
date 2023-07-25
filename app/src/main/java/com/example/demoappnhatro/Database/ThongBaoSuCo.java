package com.example.demoappnhatro.Database;

public class ThongBaoSuCo {
    private long thongBaoSuCoId;
    private String thongBaoSuCoTen;
    private String thongBaoSuCoNgay;
    private long phongId;
    private long nguoiDungId;

    public long getThongBaoSuCoId() {
        return thongBaoSuCoId;
    }

    public void setThongBaoSuCoId(long thongBaoSuCoId) {
        this.thongBaoSuCoId = thongBaoSuCoId;
    }

    public String getThongBaoSuCoTen() {
        return thongBaoSuCoTen;
    }

    public void setThongBaoSuCoTen(String thongBaoSuCoTen) {
        this.thongBaoSuCoTen = thongBaoSuCoTen;
    }

    public String getThongBaoSuCoNgay() {
        return thongBaoSuCoNgay;
    }

    public void setThongBaoSuCoNgay(String thongBaoSuCoNgay) {
        this.thongBaoSuCoNgay = thongBaoSuCoNgay;
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

    public ThongBaoSuCo(long thongBaoSuCoId, String thongBaoSuCoTen, String thongBaoSuCoNgay, long phongId, long nguoiDungId) {
        this.thongBaoSuCoId = thongBaoSuCoId;
        this.thongBaoSuCoTen = thongBaoSuCoTen;
        this.thongBaoSuCoNgay = thongBaoSuCoNgay;
        this.phongId = phongId;
        this.nguoiDungId = nguoiDungId;
    }
}
