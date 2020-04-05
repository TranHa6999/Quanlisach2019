package com.tuan.duanmau;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tuan.duanmau.Base.BaseActivity;
import com.tuan.duanmau.DAO.UserDAO;
import com.tuan.duanmau.Fragment.DanhSachNguoiDungFragment;
import com.tuan.duanmau.Model.User;
import com.admin.duanmau.R;

public class fixUser extends BaseActivity {
    private EditText edtpass;
    private EditText edtrefullname;
    private EditText edtResdt;
    private Button btnAddfixuser;
    private Button btnhuycapnhapuser;
    UserDAO userDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_user);
        userDAO= new UserDAO(this);
        edtpass = (EditText) findViewById(R.id.edtpass);
        edtResdt = (EditText)findViewById(R.id.edtResdt);
        btnAddfixuser = (Button) findViewById(R.id.btnAddfixuser);
        btnhuycapnhapuser = (Button) findViewById(R.id.btnhuycapnhapuser);
        edtrefullname = (EditText) findViewById(R.id.edtrefullname);
        btnAddfixuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateForm();
            }
        });
        btnhuycapnhapuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeClass(DanhSachNguoiDungFragment.class);
            }
        });


    }
    public void validateForm(){
      try {
          Intent intent = getIntent();
          Bundle in = intent.getExtras();
          String username = in.getString("USER");
          String password = edtpass.getText().toString();
          String sdt = edtResdt.getText().toString();
          String fullname = edtrefullname.getText().toString();
          if (edtpass.length() < 5) {
              showMessage("Vui lòng nhập pass lớn hơn 5 ký tự");
          } else if (sdt.length() !=10) {
              showMessage("Vui lòng nhập số điện thoại 10 số");
          } else if (userDAO.update(new User(username, password, sdt, fullname))) {
              showMessage("thành công");


          } else {
              showMessage("lỗi cập nhập");
          }
      }catch (NumberFormatException e){
          showMessage("vui lòng nhập lại cho đúng");
      }

    }

}
