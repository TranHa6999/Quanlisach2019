package com.tuan.duanmau.TheLoaiSach;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tuan.duanmau.Base.BaseActivity;
import com.tuan.duanmau.DAO.CategoryDAO;
import com.tuan.duanmau.Model.Category;
import com.admin.duanmau.R;

public class TheLoaiSachActivity extends BaseActivity implements View.OnClickListener {

    private EditText edtMaTheLoai;
    private EditText edtTenTheLoai;
    private EditText edtViTriTheLoai;
    private EditText edtMoTaTheLoai;
    private Button btnThemTheLoai;
    private Button btnHuyBoTheLoai;
    private Button btnDanhSachTheLoai;
    private CategoryDAO categoryDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_loai_sach);

        this.initView();

    }

    public void validateForm(){
        try {
            String matheloai = edtMaTheLoai.getText().toString();
            String tentheloai = edtTenTheLoai.getText().toString();
            int vitri = Integer.parseInt(edtViTriTheLoai.getText().toString());
            String mota = edtMoTaTheLoai.getText().toString();

            if(matheloai.equals("")){
                showMessage("Vui lòng nhập thể loại");
            }
            else if(tentheloai.length() < 3){
                showMessage("Vui lòng nhập tên thể loại hơn 3 ký tự");
            }
            else if(vitri < 0){
                showMessage("Vui lòng nhập vị trí lớn hơn 0");
            }
            else if(categoryDAO.insertCategory(new Category(matheloai,tentheloai,vitri,mota)) > 0){
                showMessage("Thêm thể loại thành công");
                this.cancelAllView();
            }
            else if(categoryDAO.insertCategory(new Category(matheloai,tentheloai,vitri,mota)) <= 0){
                showMessage("Thêm thể loại thất bại do trùng mã thể loại");
            }

        }catch (NumberFormatException e){
            this.showMessage("Vui lòng nhập vị trí là số");
        }
    }

    public void initView(){
        categoryDAO = new CategoryDAO(this);
        edtMaTheLoai = (EditText) findViewById(R.id.edtMaTheLoai);
        edtTenTheLoai = (EditText) findViewById(R.id.edtTenTheLoai);
        edtViTriTheLoai = (EditText) findViewById(R.id.edtViTriTheLoai);
        edtMoTaTheLoai = (EditText) findViewById(R.id.edtMoTaTheLoai);
        btnThemTheLoai = (Button) findViewById(R.id.btnThemTheLoai);
        btnHuyBoTheLoai = (Button) findViewById(R.id.btnHuyBoTheLoai);
        btnDanhSachTheLoai = (Button) findViewById(R.id.btnDanhSachTheLoai);
        btnThemTheLoai.setOnClickListener(this);
        btnHuyBoTheLoai.setOnClickListener(this);
        btnDanhSachTheLoai.setOnClickListener(this);
    }

    public void cancelAllView(){
        edtMaTheLoai.setText("");
        edtTenTheLoai.setText("");
        edtViTriTheLoai.setText("");
        edtMoTaTheLoai.setText("");
    }

    @Override
    public void onClick(View v) {
        if(v == btnDanhSachTheLoai){
            changeClass(DanhSachTheLoaiActivity.class);
        }
        else if(v == btnHuyBoTheLoai){
            this.cancelAllView();
        }
        else if(v == btnThemTheLoai){
            this.validateForm();
        }
    }
}
