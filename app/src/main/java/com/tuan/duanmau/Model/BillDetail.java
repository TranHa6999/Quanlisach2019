package com.tuan.duanmau.Model;

public class BillDetail {

    String mahoadon;
    String tensach;

    public String getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public int getSoluongmua() {
        return soluongmua;
    }

    public void setSoluongmua(int soluongmua) {
        this.soluongmua = soluongmua;
    }

    public double getGiabia() {
        return giabia;
    }

    public void setGiabia(double giabia) {
        this.giabia = giabia;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }

    int soluongmua;
    double giabia;
    double thanhtien;

    public BillDetail(String mahoadon, String tensach, int soluongmua, double giabia, double thanhtien) {
        this.mahoadon = mahoadon;
        this.tensach = tensach;
        this.soluongmua = soluongmua;
        this.giabia = giabia;
        this.thanhtien = thanhtien;
    }
}
