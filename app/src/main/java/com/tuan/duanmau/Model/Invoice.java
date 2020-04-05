package com.tuan.duanmau.Model;

public class Invoice {

    public String mahoadon;
    public String ngaymua;

    public String getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    public String getNgaymua() {
        return ngaymua;
    }

    public void setNgaymua(String ngaymua) {
        this.ngaymua = ngaymua;
    }

    public Invoice(String mahoadon, String ngaymua) {

        this.mahoadon = mahoadon;
        this.ngaymua = ngaymua;
    }
}
