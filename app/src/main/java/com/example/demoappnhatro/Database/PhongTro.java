package com.example.demoappnhatro.Database;

import java.io.Serializable;

public class PhongTro implements Serializable {
    private long phongId;
    private String tenPhong;
    private int giaThuePhong;
    private int dienTich;
    private int tienCoc;
    private int trangThaiPhong;
    private long nguoiThueId;
    private String moTaPhong;

    public PhongTro(String tenToaNha, String chiPhi, String moTa) {
    }


    public PhongTro(String tenPhong, String tienDatCoc, String giaPhong, String dienTich, String moTa) {
        this.tenPhong = tenPhong;
        this.tienCoc = Integer.parseInt(tienDatCoc);
        this.giaThuePhong = Integer.parseInt(giaPhong);
        this.dienTich = Integer.parseInt(dienTich);
        this.moTaPhong = moTa;
    }

    public PhongTro(long phongId, String tenPhong, int datCoc, int giaPhong, int dienTich, int trangThaiPhong, String moTaPhong) {
        this.phongId = phongId;
        this.tenPhong = tenPhong;
        this.tienCoc = datCoc;
        this.giaThuePhong = giaPhong;
        this.dienTich = dienTich;
        this.trangThaiPhong = trangThaiPhong;
        this.moTaPhong = moTaPhong;
    }

    public PhongTro(String tenPhong, String tienDatCoc, String giaPhong, String dienTich, String moTa, String trangThaiValue) {
        this.tenPhong = tenPhong;
        this.tienCoc = Integer.parseInt(tienDatCoc);
        this.giaThuePhong = Integer.parseInt(giaPhong);
        this.dienTich = Integer.parseInt(dienTich);
        this.moTaPhong = moTa;
        this.trangThaiPhong = Integer.parseInt(trangThaiValue);
    }

    public PhongTro(long id, String tenPhong, String trangThai, String moTa, int giaThue, int dienTich, int tienCoc) {
        this.phongId = id;
        this.tenPhong = tenPhong;
        this.trangThaiPhong = Integer.parseInt(trangThai);
        this.moTaPhong = moTa;
        this.giaThuePhong = giaThue;
        this.dienTich = dienTich;
        this.tienCoc = tienCoc;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public int getTienCoc() {
        return tienCoc;
    }

    public int getGiaThuePhong() {
        return giaThuePhong;
    }

    public int getDienTich() {
        return dienTich;
    }

    public String getMoTaPhong() {
        return moTaPhong;
    }

    public int getTrangThaiPhong() {
        return trangThaiPhong;
    }

    public long getNguoiThueId() {
        return nguoiThueId;
    }

    public long getId() {
        return phongId;
    }

    public long getPhongId() {
        return phongId;
    }

    public void setNguoiThueId(long taiKhoanId) {
        this.nguoiThueId = taiKhoanId;
    }
}
