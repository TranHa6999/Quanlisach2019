package com.tuan.duanmau;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tuan.duanmau.Base.BaseActivity;
import com.tuan.duanmau.DAO.CategoryDAO;
import com.tuan.duanmau.Model.Category;
import com.admin.duanmau.R;
import com.tuan.duanmau.TheLoaiSach.TheLoaiSachActivity;

public class fix_theloai extends BaseActivity {
    private EditText edtSuaTentheloai;
    private EditText edtSuaVitri;
    private EditText suaMota;
    private Button btnfixBook;
    private Button btnbackbook;
    CategoryDAO categoryDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_theloai);
            init();


    }
    public void init(){

        edtSuaTentheloai = (EditText) findViewById(R.id.edtSuaTentheloai);
        edtSuaVitri = (EditText) findViewById(R.id.edtSuaVitri);
        suaMota = (EditText) findViewById(R.id.suaMota);
        btnfixBook = (Button) findViewById(R.id.btnfixBook);
        btnbackbook = (Button) findViewById(R.id.btnbackbook);
        categoryDAO =new CategoryDAO(this);
        btnfixBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateForm();
            }
        });
        btnbackbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeClass(TheLoaiSachActivity.class);
            }
        });

    }
    public void validateForm(){

        try{
            Intent in = getIntent();
            Bundle b = in.getExtras();
            String matheloai = b.getString("MATHELOAI");
            String tentheloai = edtSuaTentheloai.getText().toString();
            int vitri = Integer.parseInt(edtSuaVitri.getText().toString());
            String mota = edtSuaVitri.getText().toString();

            if(matheloai.length() < 5){
                showMessage("vui lòng nhập mã trên 5 kí tự");
            }
            else if(tentheloai.equals("")) {
                showMessage("vui lòng nhập tên thể loại");

            }else if(mota.equals("")){
                showMessage("vui lòng nhập mô tả");
            }

            else if(vitri < 0){
                showMessage("Vui lòng nhập  vị trí hơn 0");
            }
            else if(categoryDAO.update(new Category(matheloai,tentheloai,vitri,mota))){
                showMessage(" cập nhập Thành công");

            }
            else{
           showMessage(" cập nhập không thành công");
            }


        }catch (NumberFormatException e){
            this.showMessage("Vui lòng nhập vị trí là số");
        }
    }
}
