package com.tuan.duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tuan.duanmau.Model.Book;
import com.tuan.duanmau.SQLite.Database;

import java.util.ArrayList;
import java.util.List;

import static com.tuan.duanmau.SQLite.Constants.book_amount;
import static com.tuan.duanmau.SQLite.Constants.book_category_id;
import static com.tuan.duanmau.SQLite.Constants.book_id;
import static com.tuan.duanmau.SQLite.Constants.book_name;
import static com.tuan.duanmau.SQLite.Constants.book_price;
import static com.tuan.duanmau.SQLite.Constants.book_table;

public class BookDAO {

    Database database;

    public BookDAO(Context context) {
        this.database = new Database(context);
    }

    public long insertBook(Book book){
        long result = -1;

        ContentValues c = new ContentValues();
        c.put(book_id, book.masach);
        c.put(book_category_id, book.matheloai);
        c.put(book_name, book.tensach);
        c.put(book_price , book.giabia);
        c.put(book_amount , book.soluong);

        SQLiteDatabase db = database.getWritableDatabase();
        result = db.insert(book_table, null, c);
        db.close();

        return result;
    }

    public long removeBook(String bookID){
        long result = -1;

        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        result = sqLiteDatabase.delete(book_table, book_id+"=?", new String[]{bookID});
        sqLiteDatabase.close();

        return result;
    }
    //hiển thị lên list
    public List<Book> getAllBook(){
        List<Book> list = new ArrayList<>();

        String query = "select * from "+book_table;
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor c = db.rawQuery(query,null);

        if(c != null){
            if(c.getCount() > 0){
                while (c.moveToNext()){
                    String masach = c.getString(0);
                    String matheloai = c.getString(1);
                    String tensach = c.getString(2);
                    double giabia = Double.parseDouble(c.getString(3));
                    int soluong = Integer.parseInt(c.getString(4));

                    Book book = new Book(masach,matheloai,tensach,giabia,soluong);
                    list.add(book);
                }
                c.close();
                db.close();
            }
        }

        return list;
    }

//select so from hs where so ='55'
    public int getTaskCount(String bookId) {
        int dem = 0;
        try {


            SQLiteDatabase db = database.getWritableDatabase();
            Cursor cursor = db.rawQuery("select * from " + book_table + " where " + book_id + "='" + bookId + "'"
                    ,null);
            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    while (cursor.moveToNext()) {
                        dem= cursor.getInt(cursor.getColumnIndex(book_amount));
                       //  đếm phần tử trong bảng
                    }
                    db.close();
                    cursor.close();
                }
            }

        } catch (NullPointerException e) {
            e.getMessage();

        }
        return dem;
    }

      //  var query = "select * from $bookTable where $bookId = '$bookID' "

    public boolean update(Book book) {


        ContentValues values = new ContentValues();
        values.put(book_id, book.matheloai);
        values.put(book_name, book.tensach);

        values.put(book_category_id,book.matheloai);
        values.put(book_price, book.giabia);
        values.put(book_amount, book.soluong);
            SQLiteDatabase sqLiteDatabase=database.getWritableDatabase();  // lấy dữ liệu từ bảng mình tạo
       sqLiteDatabase .update(book_table, values, book_id + " = ?", new String[] { String.valueOf(book.masach) });
        sqLiteDatabase.close();
        return  true;
    }

}
