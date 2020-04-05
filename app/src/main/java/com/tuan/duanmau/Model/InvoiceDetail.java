package com.tuan.duanmau.Model;

public class InvoiceDetail {

    String masach;
    String mahoadon;
    int soluongmua;

    public InvoiceDetail(String masach, String mahoadon, int soluongmua) {
        this.masach = masach;
        this.mahoadon = mahoadon;
        this.soluongmua = soluongmua;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    public int getSoluongmua() {
        return soluongmua;
    }

    public void setSoluongmua(int soluongmua) {
        this.soluongmua = soluongmua;
    }
}
