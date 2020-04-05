package com.tuan.duanmau.Sach;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.tuan.duanmau.Base.BaseActivity;
import com.tuan.duanmau.DAO.BookDAO;
import com.tuan.duanmau.DAO.CategoryDAO;
import com.tuan.duanmau.Model.Book;
import com.tuan.duanmau.Model.Category;
import com.admin.duanmau.R;

import java.util.ArrayList;
import java.util.List;

public class SachActivity extends BaseActivity implements View.OnClickListener {

    private EditText edtMaSach;
    private Spinner spnMaTheLoai;
    private EditText edtTacGia;
    private EditText edtGiaBia;
    private EditText edtSoLuong;
    private Button btnThemSach;
    private Button btnHuyBo;
    private Button btnDanhSachSach;
    private List<Category> categoryList;
    private List<String> spnList;
    private CategoryDAO categoryDAO;
    private BookDAO bookDAO;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach);

        this.initView();

    }

    public void validateForm(){
        try{
            String masach = edtMaSach.getText().toString();
            String matheloai = spnList.get(spnMaTheLoai.getSelectedItemPosition());
            String tensach = edtTacGia.getText().toString();
            double giabia = Double.parseDouble(edtGiaBia.getText().toString());
            int soluong = Integer.parseInt(edtSoLuong.getText().toString());

            if(giabia < 5000){
                showMessage("Vui lòng nhập giá lớn hơn 5.000 VND");
            }
            else if (masach.length()!=4){
                showMessage("vui lòng nhập mã sách 4 kí tự");
            }
            else  if(tensach.equals("")){
                showMessage("vui lòng nhập tên sách");
            }
            else if(soluong < 0){
                showMessage("Vui lòng nhập số lượng lớn hơn 0");
            }
            else if(bookDAO.insertBook(new Book(masach,matheloai,tensach,giabia,soluong)) > 0){
                showMessage("Thêm sách thành công");
                this.cancelAllView();
            }
            else if(bookDAO.insertBook(new Book(masach,matheloai,tensach,giabia,soluong)) <= 0){
                showMessage("Thêm sách thất bại do trùng mã sách");
            }

        }catch (NumberFormatException e){
            this.showMessage("Vui lòng nhập số lượng và giá bìa là số");
        }
        catch (ArrayIndexOutOfBoundsException a){
            showMessage("chưa có thể loại");
        }
    }

    public void initView(){

        spnMaTheLoai = (Spinner) findViewById(R.id.spnMaTheLoai);

        bookDAO = new BookDAO(this);
        categoryDAO = new CategoryDAO(this);
        categoryList = new ArrayList<>();
        spnList = new ArrayList<>();
        this.initSpinnerList();

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,spnList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnMaTheLoai.setAdapter(adapter);

        edtMaSach = (EditText) findViewById(R.id.edtMaSach);
        edtTacGia = (EditText) findViewById(R.id.edtTacGia);
        edtGiaBia = (EditText) findViewById(R.id.edtGiaBia);
        edtSoLuong = (EditText) findViewById(R.id.edtSoLuong);
        btnThemSach = (Button) findViewById(R.id.btnThemSach);
        btnHuyBo = (Button) findViewById(R.id.btnHuyBo);
        btnDanhSachSach = (Button) findViewById(R.id.btnDanhSachSach);

        btnThemSach.setOnClickListener(this);
        btnHuyBo.setOnClickListener(this);
        btnDanhSachSach.setOnClickListener(this);
    }

    public void initSpinnerList(){
        categoryList = categoryDAO.getAllCategory();
        for(int i = 0; i < categoryList.size(); i++){
            Category category = categoryList.get(i);
            spnList.add(category.getMatheloai());
        }
    }

    public void cancelAllView(){
        edtMaSach.setText("");
        edtTacGia.setText("");
        edtGiaBia.setText("");
        edtSoLuong.setText("");
    }

    @Override
    public void onClick(View v) {
        if(v == btnDanhSachSach){
            this.changeClass(DanhSachSachActivity.class);
        }
        else if(v == btnHuyBo){
            this.cancelAllView();
        }
        else if(v == btnThemSach){
            this.validateForm();
        }
    }
}
