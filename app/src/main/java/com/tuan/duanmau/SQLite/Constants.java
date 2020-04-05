package com.tuan.duanmau.SQLite;

public class Constants {

    //bảng
    public static final String user_table = "nguoidung";
    public static final String category_table = "theloai";
    public static final String book_table = "sach";
    public static final String bill_table = "hoadon";
    public static final String detail_bill_table = "hoadonchitiet";

    //cột
    // -- Người dùng
    public static final String user_username = "username";
    public static final String user_password = "password";
    public static final String user_phone = "phone";
    public static final String user_fullname = "fullname";
    // -- Thể loại
    public static final String category_id = "matheloai";
    public static final String category_name = "tentheloai";
    public static final String category_position = "vitri";
    public static final String category_describe = "mota";
    // -- Sách
    public static final String book_id = "masach";
    public static final String book_category_id = "matheloai";
    public static final String book_name = "tensach";
    public static final String book_price = "giabia";
    public static final String book_amount = "soluong";
    public static final String book_foreign_key = "foreign key ( "+book_category_id+" ) references "+category_table+"("+category_id+") ";
    // -- Hóa đơn
    public static final String bill_id = "mahoadon";
    public static final String bill_buy_date = "ngaymua";
    // -- Hóa đơn chi tiết
    public static final String bill_detail_id = "mahoadonchitiet";
    public static final String bill_detail_bill_id = "mahoadon";
    public static final String bill_detail_book_id = "masach";
    public static final String bill_detail_buy_amount = "soluongmua";
    public static final String bill_detail__foreign_key1 = "foreign key ( "+bill_detail_bill_id +" ) references "+bill_table+"("+bill_id+") ";
    public static final String bill_detail__foreign_key2 = "foreign key ( "+bill_detail_book_id+" ) references "+book_table+"("+book_id+") ";


    // Tạo bảng

    public static final String create_user_table =
            "create table "+user_table+"(" +
                    "" + user_username +" nvarchar primary key not null,"+
                    "" + user_password +" nvarchar not null,"+
                    "" + user_phone +" nvarchar,"+
                    "" + user_fullname +" nvarchar"+
                    ")";
    public static final String create_category_table =
            "create table "+category_table+"(" +
                    "" + category_id +" nvarchar primary key not null ,"+
                    "" + category_name +" nvarchar not null,"+
                    "" + category_position +" integer,"+
                    "" + category_describe +" nvarchar"+
                    ")";
    public static final String create_book_table =
            "create table "+book_table+"(" +
                    "" + book_id +" nvarchar primary key not null ,"+
                    "" + book_category_id +" nvarchar not null ,"+
                    "" + book_name +" nvarchar not null,"+
                    "" + book_price +" integer,"+
                    "" + book_amount +" integer,"+
                    "" + book_foreign_key +
                    ")";
    public static final String create_bill_table =
            "create table "+bill_table+"(" +
                    "" + bill_id +" nvarchar primary key not null,"+
                    "" + bill_buy_date +" date"+
                    ")";
    public static final String create_bill_detail_table =
            "create table "+detail_bill_table+"(" +
                    "" + bill_detail_id +" nvarchar,"+
                    "" + bill_detail_bill_id +" nvarchar,"+
                    "" + bill_detail_book_id +" nvarchar,"+
                    "" + bill_detail_buy_amount +" integer,"+
                    "" + bill_detail__foreign_key1 +","+
                    "" + bill_detail__foreign_key2 +
                    ")";

}
