package com.tuan.duanmau.Model;

public class Book {

    public String masach;
    public String matheloai;
    public String tensach;
    public double giabia;
    public int soluong;

    public Book(String masach, String matheloai, String tensach, double giabia, int soluong) {
        this.masach = masach;
        this.matheloai = matheloai;
        this.tensach = tensach;
        this.giabia = giabia;
        this.soluong = soluong;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getMatheloai() {
        return matheloai;
    }

    public void setMatheloai(String matheloai) {
        this.matheloai = matheloai;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public double getGiabia() {
        return giabia;
    }

    public void setGiabia(double giabia) {
        this.giabia = giabia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
