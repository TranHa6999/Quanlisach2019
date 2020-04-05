package com.tuan.duanmau;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tuan.duanmau.Base.BaseActivity;
import com.tuan.duanmau.DAO.BookDAO;
import com.tuan.duanmau.Model.Book;
import com.admin.duanmau.R;
import com.tuan.duanmau.Sach.SachActivity;

public class fix_sach extends BaseActivity {
    private EditText edtSuanameboook;
    private EditText edtSuaGiasach;
    private EditText suaSoluong;
    private Button btnfixBook;
    private Button btnbackbook;
    private BookDAO bookDAO;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_sach);

    init();
    }
    public  void init(){
        edtSuanameboook = (EditText) findViewById(R.id.edtSuanameboook);
        edtSuaGiasach = (EditText) findViewById(R.id.edtSuaGiasach);
        suaSoluong = (EditText) findViewById(R.id.suaSoluong);
        btnfixBook = (Button) findViewById(R.id.btnfixBook);
        btnbackbook = (Button) findViewById(R.id.btnbackbook);
        bookDAO = new BookDAO(this);
        btnfixBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateForm();
            }
        });
        btnbackbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeClass(SachActivity.class);
            }
        });
    }

    public void validateForm(){

        try{
            Intent in = getIntent();
            Bundle b = in.getExtras();
            String masach = b.getString("MAHOADON");
           String matheloai="" ;
            String tensach = edtSuanameboook.getText().toString();
            double giabia = Double.parseDouble(edtSuaGiasach.getText().toString());
            int soluong = Integer.parseInt(suaSoluong.getText().toString());

       if(giabia < 5000){
                showMessage("Vui lòng nhập giá lớn hơn 5.000 VND");
            }
            else if(tensach.equals("")) {
                showMessage("vui lòng nhập tên sách");

       }

            else if(soluong < 0){
                showMessage("Vui lòng nhập số lượng lớn hơn 0");
            }
            else if(bookDAO.update(new Book(masach,matheloai,tensach,giabia,soluong))){

            showMessage("cập nhập thành công thành công ");
            }
            else{
                showMessage(" không thành công ");
       }


        }catch (NumberFormatException e){
            this.showMessage("Vui lòng nhập số lượng và giá bìa là số");
        }
    }
}
