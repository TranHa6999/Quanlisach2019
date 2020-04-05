package com.tuan.duanmau.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    public Database(Context context) {
        super(context, "duanmaulong5.sql",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.create_user_table);
        db.execSQL(Constants.create_category_table);
        db.execSQL(Constants.create_book_table);
        db.execSQL(Constants.create_bill_table);
        db.execSQL(Constants.create_bill_detail_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+ Constants.user_table); // xóa nếu n tồn tại
        db.execSQL("drop table if exists "+ Constants.category_table);
        db.execSQL("drop table if exists "+ Constants.book_table);
        db.execSQL("drop table if exists "+ Constants.bill_table);
        db.execSQL("drop table if exists "+ Constants.detail_bill_table);
        onCreate(db);
    }

}
