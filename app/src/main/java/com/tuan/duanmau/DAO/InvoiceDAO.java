package com.tuan.duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tuan.duanmau.Model.Invoice;
import com.tuan.duanmau.SQLite.Database;

import java.util.ArrayList;
import java.util.List;

import static com.tuan.duanmau.SQLite.Constants.bill_buy_date;
import static com.tuan.duanmau.SQLite.Constants.bill_id;
import static com.tuan.duanmau.SQLite.Constants.bill_table;

public class InvoiceDAO {

    Database database;

    public InvoiceDAO(Context context) {
        this.database = new Database(context);
    }

    public long insertInvoice(Invoice invoice){
        long result = -1;

        ContentValues c = new ContentValues();
        c.put(bill_id, invoice.mahoadon);
        c.put(bill_buy_date, invoice.ngaymua);

        SQLiteDatabase db = database.getWritableDatabase();
        result = db.insert(bill_table, null, c);
        db.close();

        return result;
    }

    public long removeInvoice(String invoiceID){
        long result = -1;

        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        result = sqLiteDatabase.delete(bill_table, bill_id+"=?", new String[]{invoiceID});
        sqLiteDatabase.close();

        return result;
    }

    public List<Invoice> getAllInvoice(){
        List<Invoice> list = new ArrayList<>();

        String query = "select * from "+bill_table;
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor c = db.rawQuery(query,null);

        if(c != null){
            if(c.getCount() > 0){
                while (c.moveToNext()){
                    String mahoadon = c.getString(0);
                    String ngaymua = c.getString(1);

                    Invoice invoice = new Invoice(mahoadon,ngaymua);
                    list.add(invoice);
                }
                c.close();
                db.close();
            }
        }

        return list;
    }



}
