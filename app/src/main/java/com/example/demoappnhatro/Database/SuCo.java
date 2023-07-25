package com.example.demoappnhatro.Database;

public class SuCo {
    private long suCoId;
    private String tenSuCo;
    private String moTaSuCo;
    private int trangThaiSuCo;
    private long phongId;
    private long nguoiDungId;

    public SuCo() {
    }

    public SuCo(long suCoId, String tenSuCo, String moTaSuCo, int trangThaiSuCo, long phongId, long nguoiDungId) {
        this.suCoId = suCoId;
        this.tenSuCo = tenSuCo;
        this.moTaSuCo = moTaSuCo;
        this.trangThaiSuCo = trangThaiSuCo;
        this.phongId = phongId;
        this.nguoiDungId = nguoiDungId;
    }

    public long getSuCoId() {
        return suCoId;
    }

    public void setSuCoId(long suCoId) {
        this.suCoId = suCoId;
    }

    public String getTenSuCo() {
        return tenSuCo;
    }

    public void setTenSuCo(String tenSuCo) {
        this.tenSuCo = tenSuCo;
    }

    public String getMoTaSuCo() {
        return moTaSuCo;
    }

    public void setMoTaSuCo(String moTaSuCo) {
        this.moTaSuCo = moTaSuCo;
    }

    public int getTrangThaiSuCo() {
        return trangThaiSuCo;
    }

    public void setTrangThaiSuCo(int trangThaiSuCo) {
        this.trangThaiSuCo = trangThaiSuCo;
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
