package com.tuan.duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tuan.duanmau.Model.User;
import com.tuan.duanmau.SQLite.Database;

import java.util.ArrayList;
import java.util.List;

import static com.tuan.duanmau.SQLite.Constants.user_fullname;
import static com.tuan.duanmau.SQLite.Constants.user_password;
import static com.tuan.duanmau.SQLite.Constants.user_phone;
import static com.tuan.duanmau.SQLite.Constants.user_table;
import static com.tuan.duanmau.SQLite.Constants.user_username;

public class UserDAO {

    Database database;

    public UserDAO(Context context) {
        this.database = new Database(context);
    }

    public long insertUser(User user){
        long result = -1;

        ContentValues c = new ContentValues();
        c.put(user_username, user.getUsername());
        c.put(user_password, user.getPassword());
        c.put(user_phone, user.getPhone());
        c.put(user_fullname , user.getFullname());

        SQLiteDatabase db = database.getWritableDatabase();
        result = db.insert(user_table, null, c);
        db.close();

        return result;
    }

    public long removeUser(String userID){
        long result = -1;

        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        result = sqLiteDatabase.delete(user_table, user_username+"=?", new String[]{userID});
        sqLiteDatabase.close();

        return result;
    }

    public List<User> getAllUser(){
        List<User> list = new ArrayList<>();

        String query = "select * from "+user_table;
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor c = db.rawQuery(query,null);

        if(c != null){
            if(c.getCount() > 0){
                while (c.moveToNext()){
                    String username = c.getString(0);
                    String password = c.getString(1);
                    String phone = c.getString(2);
                    String fullname = c.getString(3);

                    User user = new User(username,password,phone,fullname);
                    list.add(user);
                }
                c.close();
                db.close();
            }
        }

        return list;
    }

    public boolean checkLogin(String username,String password){
        boolean result = false;

        String query = "select * from nguoidung where username like '"+username+"' and password like '"+password+"' ";
        SQLiteDatabase sqLiteDatabase = database.getReadableDatabase();
        Cursor c = sqLiteDatabase.rawQuery(query,null);

        if(c.getCount() > 0){
            result = true;
        }
        else{
            result = false;
        }

        return  result;
    }
    public boolean update(User user) {


        ContentValues values = new ContentValues();
        values.put(user_username, user.username);
        values.put(user_password, user.password);
        values.put(user_phone, user.phone);
        values.put(user_fullname, user.fullname);
        SQLiteDatabase sqLiteDatabase=database.getWritableDatabase();
        sqLiteDatabase .update(user_table, values,  user_username+ " = ?", new String[] { String.valueOf(user.username) });
        sqLiteDatabase.close();
      return  true;
    }

}
