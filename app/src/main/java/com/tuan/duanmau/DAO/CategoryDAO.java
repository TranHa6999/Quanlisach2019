package com.tuan.duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tuan.duanmau.Model.Category;
import com.tuan.duanmau.SQLite.Database;

import java.util.ArrayList;
import java.util.List;

import static com.tuan.duanmau.SQLite.Constants.category_describe;
import static com.tuan.duanmau.SQLite.Constants.category_id;
import static com.tuan.duanmau.SQLite.Constants.category_name;
import static com.tuan.duanmau.SQLite.Constants.category_position;
import static com.tuan.duanmau.SQLite.Constants.category_table;

public class CategoryDAO { //Thể loại

    Database database;

    public CategoryDAO(Context context) {
        this.database = new Database(context);
    }

    public long insertCategory(Category category){
        long result = -1;

        ContentValues c = new ContentValues();
        c.put(category_id, category.matheloai);
        c.put(category_name, category.tentheloai);
        c.put(category_position, category.vitri);
        c.put(category_describe , category.mota);

        SQLiteDatabase db = database.getWritableDatabase();
        result = db.insert(category_table, null, c);
        db.close();

        return result;
    }

    public long removeCategory(String categoryID){
        long result = -1;

        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        result = sqLiteDatabase.delete(category_table, category_id+"=?", new String[]{categoryID});
        sqLiteDatabase.close();

        return result;
    }

    public List<Category> getAllCategory(){
        List<Category> list = new ArrayList<>();

        String query = "select * from "+category_table;
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor c = db.rawQuery(query,null);

        if(c != null){
            if(c.getCount() > 0){
                while (c.moveToNext()){
                    String matheloai = c.getString(0);
                    String tentheloai = c.getString(1);
                    int vitri = Integer.parseInt(c.getString(2));
                    String mota = c.getString(3);

                    Category category = new Category(matheloai,tentheloai,vitri,mota);
                    list.add(category);
                }
                c.close();
                db.close();
            }
        }

        return list;
    }
    public boolean update(Category category) {


        ContentValues values = new ContentValues();
        values.put(category_id,category.matheloai);
        values.put(category_name, category.tentheloai);

        values.put(category_position,category.vitri);
        values.put(category_describe, category.mota);

        SQLiteDatabase sqLiteDatabase=database.getWritableDatabase();
        sqLiteDatabase .update(category_table, values, category_id + " = ?", new String[] { String.valueOf(category.matheloai) });
        sqLiteDatabase.close();
        return  true;
    }

}
