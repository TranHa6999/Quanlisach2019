package com.tuan.duanmau.DangNhap;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.tuan.duanmau.Base.BaseActivity;
import com.tuan.duanmau.DAO.UserDAO;
import com.tuan.duanmau.ManHinhChinhActivity;
import com.admin.duanmau.R;

import static android.content.Context.MODE_PRIVATE;

public class  DangNhapActivity extends BaseActivity implements View.OnClickListener {

    private ImageView imageView;
    private EditText edtTenDangNhap;
    private EditText edtMatKhau;
    private CheckBox cbNhoMatKhau;
    private Button btnDangNhap;
    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        userDAO  = new UserDAO(this);

        imageView = (ImageView) findViewById(R.id.imageView);
        edtTenDangNhap = (EditText) findViewById(R.id.edtTenDangNhap);
        edtMatKhau = (EditText) findViewById(R.id.edtMatKhau);
        cbNhoMatKhau = (CheckBox) findViewById(R.id.cbNhoMatKhau);
        btnDangNhap = (Button) findViewById(R.id.btnDangNhap);

        btnDangNhap.setOnClickListener(this);

        SharedPreferences sharedPreferences = getSharedPreferences("tranha",MODE_PRIVATE);
        String username = sharedPreferences.getString("username","");
        String password = sharedPreferences.getString("password","");
        boolean ischecked = sharedPreferences.getBoolean("ischecked",false);

        edtTenDangNhap.setText(username);
        edtMatKhau.setText(password);
        cbNhoMatKhau.setChecked(ischecked);

    }

    @Override
    public void onClick(View v) {
        if(v == btnDangNhap){
            String username = edtTenDangNhap.getText().toString();
            String password = edtMatKhau.getText().toString();
            boolean ischecked = cbNhoMatKhau.isChecked();
            boolean connected = userDAO.checkLogin(username,password);

            if(username.isEmpty()){
                showMessage("Vui lòng không để trống username");
            }
            else if(password.isEmpty()){
                showMessage("Vui lòng không để trống password");
            }
            else if(username.equals("admin") && password.equals("admin")){
                if(ischecked){
                    rememberUser(username,password,ischecked);
                    showMessage("Đăng nhập thành công tài khoản admin");
                    changeClass(ManHinhChinhActivity.class);
                    finish();
                }else if(ischecked == false){
                    rememberUser("","",false);
                    showMessage("Đăng nhập thành công user");
                    changeClass(ManHinhChinhActivity.class);
                    finish();
                }
            }
            else if(connected == true){
                if(ischecked){
                    rememberUser(username,password,ischecked);
                    showMessage("Đăng nhập thành công");
                    changeClass(ManHinhChinhActivity.class);
                    finish();
                }else if(ischecked == false){
                    rememberUser("","",false);
                    showMessage("Đăng nhập thành công");
                    changeClass(ManHinhChinhActivity.class);
                    finish();
                }
            }
            else if(connected == false){
                showMessage("Tài khoản không tồn tại");
            }
        }
    }

    private void rememberUser(String username, String password, boolean ischecked){
        SharedPreferences sharedPreferences =  getSharedPreferences("tranha",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(ischecked == false){
            editor.clear();
        }
        editor.putString("username",username);
        editor.putString("password",password);
        editor.putBoolean("ischecked",ischecked);
        editor.commit();
    }

}
