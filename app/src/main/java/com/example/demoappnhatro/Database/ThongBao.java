package com.example.demoappnhatro.Database;

public class ThongBao {
    private long thongbaoId;
    private long nguoidungId;
    private String noidung;
    private String ngaytao;

    public ThongBao(long thongbaoId, long nguoidungId, String noidung, String ngaytao) {
        this.thongbaoId = thongbaoId;
        this.nguoidungId = nguoidungId;
        this.noidung = noidung;
        this.ngaytao = ngaytao;
    }

    public long getThongbaoId() {
        return thongbaoId;
    }

    public void setThongbaoId(long thongbaoId) {
        this.thongbaoId = thongbaoId;
    }

    public long getNguoidungId() {
        return nguoidungId;
    }

    public void setNguoidungId(long nguoidungId) {
        this.nguoidungId = nguoidungId;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }
}
