package com.tuan.duanmau.Model;

public class Category {

    public String matheloai;
    public String tentheloai;
    public int vitri;
    public String mota;

    public String getMatheloai() {
        return matheloai;
    }

    public void setMatheloai(String matheloai) {
        this.matheloai = matheloai;
    }

    public String getTentheloai() {
        return tentheloai;
    }

    public void setTentheloai(String tentheloai) {
        this.tentheloai = tentheloai;
    }

    public int getVitri() {
        return vitri;
    }

    public void setVitri(int vitri) {
        this.vitri = vitri;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Category(String matheloai, String tentheloai, int vitri, String mota) {

        this.matheloai = matheloai;
        this.tentheloai = tentheloai;
        this.vitri = vitri;
        this.mota = mota;
    }
}
