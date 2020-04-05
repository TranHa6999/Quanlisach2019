package com.tuan.duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tuan.duanmau.Model.BestSale;
import com.tuan.duanmau.Model.BillDetail;
import com.tuan.duanmau.Model.InvoiceDetail;
import com.tuan.duanmau.SQLite.Database;

import java.util.ArrayList;
import java.util.List;

import static com.tuan.duanmau.SQLite.Constants.bill_detail_bill_id;
import static com.tuan.duanmau.SQLite.Constants.bill_detail_book_id;
import static com.tuan.duanmau.SQLite.Constants.bill_detail_buy_amount;
import static com.tuan.duanmau.SQLite.Constants.detail_bill_table;

public class InvoiceDetailDAO {

    Database database;

    public InvoiceDetailDAO(Context context) {
        this.database = new Database(context);
    }

    public long insertInvoiceDetail(InvoiceDetail invoice){
        long result = -1;

        ContentValues c = new ContentValues();
        c.put(bill_detail_book_id, invoice.getMasach());
        c.put(bill_detail_bill_id, invoice.getMahoadon());
        c.put(bill_detail_buy_amount, invoice.getSoluongmua());

        SQLiteDatabase db = database.getWritableDatabase();
        result = db.insert(detail_bill_table, null, c);
        db.close();

        return result;
    }

    public List<BillDetail> getAllInvoice(){
        List<BillDetail> list = new ArrayList<>();

        String query = "select sach.masach, hoadonchitiet.soluongmua, sach.giabia, hoadon.mahoadon " +
                "from sach join hoadonchitiet on sach.masach = hoadonchitiet.masach join hoadon on hoadonchitiet.mahoadon = hoadon.mahoadon"  ;
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor c = db.rawQuery(query,null);

        if(c != null){
            if(c.getCount() > 0){
                while (c.moveToNext()){
                    String mahoadon = c.getString(3);
                    String tensach = c.getString(0);
                    int soluongmua = c.getInt(1);
                    double giabia = c.getDouble(2);
                    double thanhtien = soluongmua * giabia;
                    BillDetail billDetail = new BillDetail(mahoadon,tensach,soluongmua,giabia,thanhtien);
                    list.add(billDetail);
                }
                c.close();
                db.close();
            }
        }

        return list;
    }

    public List<BestSale> getAllBestSale(String thang){
        List<BestSale> list = new ArrayList<>();

        String query = "select sach.tensach, hoadonchitiet.soluongmua, hoadon.ngaymua " +
                "from sach join hoadonchitiet on sach.masach = hoadonchitiet.masach join hoadon on hoadonchitiet.mahoadon = hoadon.mahoadon" +
                " where strftime('%m',hoadon.ngaymua) = '"+thang+"' ";
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor c = db.rawQuery(query,null);

        if(c != null){
            if(c.getCount() > 0){
                while (c.moveToNext()){
                    String ngaymua = c.getString(2);
                    String tensach = c.getString(0);
                    BestSale bestSale = new BestSale(ngaymua,tensach);
                    list.add(bestSale);
                }
                c.close();
                db.close();
            }
        }

        return list;
    }

    public boolean checkMasachHoaDon(String masach, String mahoadon, int switchs){
        Boolean result = true;
        String query = "";
        SQLiteDatabase sqLiteDatabase = database.getReadableDatabase();

        if(switchs == 1){
            query = "select * from sach where masach like '"+masach+"' ";
        }
        else if(switchs == 2){
            query = "select * from hoadon where mahoadon like '"+mahoadon+"' ";
        }

        Cursor c = sqLiteDatabase.rawQuery(query,null);
        if(c.getCount() > 0){
            result = true;
        }
        else{
            result = false;
        }

        return result;
    }

    public String getNumberOfMoney(String ngay, String thang,String nam, int chucnang){

        String result = "Không có thu nhập";
        String query = "";

        if(chucnang == 1){
            query = "select sach.giabia, hoadonchitiet.soluongmua, hoadon.ngaymua from sach join hoadonchitiet on sach.masach = hoadonchitiet.masach " +
                    "join hoadon on hoadonchitiet.mahoadon = hoadon.mahoadon where strftime('%d', hoadon.ngaymua) = '"+ngay+"' and " +
                    "strftime('%m', hoadon.ngaymua) like '"+thang+"' and strftime('%Y', hoadon.ngaymua) = '"+nam+"' ";
        }else if(chucnang == 2){
            query = "select sach.giabia, hoadonchitiet.soluongmua, hoadon.ngaymua from sach join hoadonchitiet on sach.masach = hoadonchitiet.masach " +
                    "join hoadon on hoadonchitiet.mahoadon = hoadon.mahoadon where " +
                    "strftime('%m', hoadon.ngaymua) = '"+thang+"' and strftime('%Y', hoadon.ngaymua) = '"+nam+"' ";

        }else if(chucnang == 3){
            query = "select sach.giabia, hoadonchitiet.soluongmua, hoadon.ngaymua from sach join hoadonchitiet on sach.masach = hoadonchitiet.masach " +
                    "join hoadon on hoadonchitiet.mahoadon = hoadon.mahoadon where " +
                    "strftime('%Y', hoadon.ngaymua) = '"+nam+"' ";

        }

        SQLiteDatabase sqLiteDatabase = database.getReadableDatabase();
        Cursor c = sqLiteDatabase.rawQuery(query,null);
        if (c != null){
            if(c.getCount() > 0){
                double tongtien = 0;
                while (c.moveToNext()){
                    double giabia = c.getDouble(0);
                    int soluongmua = c.getInt(1);
                    double thanhtien = giabia * soluongmua;
                    tongtien += thanhtien;
                }
                result = Double.toString(tongtien);
            }
        }

        return result;
    }

}
