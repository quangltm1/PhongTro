package com.example.demoappnhatro.Database;

import java.io.Serializable;

public class HopDong implements Serializable {
    private long hopDongId;
    private String hopDongTen;
    private String hopDongNoiDung;
    private String hopDongNgayBatDau;
    private String hopDongNgayKetThuc;
    private String tennguoithue;
    private String tenchutro;
    private int cccdnguoithue;
    private int cccdchutro;
    private int TienDien;
    private int TienNuoc;
    private int TienPhong;
    private int TienCoc;
    private int trangThaiHopDong;
    private long phongId;
    private long nguoiDungId;

    public HopDong(String tenPhong, String ngayThue, String ngayTra, String tenNguoiThue, int  cmndNguoiThue, String tenChuTro, int cmndChuTro, int tienPhong, int tienCoc, int tienDien, int tienNuoc, String noiDung) {
        this.hopDongTen = tenPhong;
        this.hopDongNgayBatDau = ngayThue;
        this.hopDongNgayKetThuc = ngayTra;
        this.tennguoithue = tenNguoiThue;
        this.cccdnguoithue = cmndNguoiThue;
        this.tenchutro = tenChuTro;
        this.cccdchutro = cmndChuTro;
        this.TienPhong = tienPhong;
        this.TienCoc = tienCoc;
        this.TienDien = tienDien;
        this.TienNuoc = tienNuoc;
        this.hopDongNoiDung = noiDung;
    }


    public HopDong(long id,String tenphong, String ngayBatDau, String ngayKetThuc, int tienPhong, int tienDien, int tienNuoc, int tienCoc, int cccdnguoithue, int cccdchutrongoi, String tennguoithue, String tenchutro,String noidung, long nguoiDungId) {
        this.hopDongId = id;
        this.hopDongTen = tenphong;
        this.hopDongNgayBatDau = ngayBatDau;
        this.hopDongNgayKetThuc = ngayKetThuc;
        this.TienPhong = tienPhong;
        this.TienDien = tienDien;
        this.TienNuoc = tienNuoc;
        this.TienCoc = tienCoc;
        this.cccdnguoithue = cccdnguoithue;
        this.cccdchutro = cccdchutrongoi;
        this.tennguoithue = tennguoithue;
        this.tenchutro = tenchutro;
        this.hopDongNoiDung = noidung;
        this.nguoiDungId = nguoiDungId;
    }

    public String getTennguoithue() {
        return tennguoithue;
    }

    public void setTennguoithue(String tennguoithue) {
        this.tennguoithue = tennguoithue;
    }

    public String getTenchutro() {
        return tenchutro;
    }

    public void setTenchutro(String tenchutro) {
        this.tenchutro = tenchutro;
    }

    public int getCccdnguoithue() {
        return cccdnguoithue;
    }

    public void setCccdnguoithue(int cccdnguoithue) {
        this.cccdnguoithue = cccdnguoithue;
    }

    public int getCccdchutro() {
        return cccdchutro;
    }

    public void setCccdchutro(int cccdchutro) {
        this.cccdchutro = cccdchutro;
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

    public int getTienDien() {
        return TienDien;
    }

    public void setTienDien(int tienDien) {
        TienDien = tienDien;
    }

    public int getTienNuoc() {
        return TienNuoc;
    }

    public void setTienNuoc(int tienNuoc) {
        TienNuoc = tienNuoc;
    }

    public int getTienPhong() {
        return TienPhong;
    }

    public void setTienPhong(int tienPhong) {
        TienPhong = tienPhong;
    }

    public int getTienCoc() {
        return TienCoc;
    }

    public void setTienCoc(int tienCoc) {
        TienCoc = tienCoc;
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

    public String getTenphong() {
        return hopDongTen;
    }
}
