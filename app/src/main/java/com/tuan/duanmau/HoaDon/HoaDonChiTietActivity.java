package com.tuan.duanmau.HoaDon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.tuan.duanmau.Adapter.BillDetailAdapter;
import com.tuan.duanmau.Base.BaseActivity;
import com.tuan.duanmau.DAO.BookDAO;
import com.tuan.duanmau.DAO.InvoiceDetailDAO;
import com.tuan.duanmau.Model.BillDetail;
import com.tuan.duanmau.Model.Book;
import com.tuan.duanmau.Model.InvoiceDetail;
import com.admin.duanmau.R;

import java.util.ArrayList;
import java.util.List;

public class HoaDonChiTietActivity extends BaseActivity {

    private EditText edtHDCTMaSach;
   // private EditText edtHDCTMaHD;
   private Spinner spnMasach;
    private EditText editText3;
    private Button btnThemHDCT;
    private List<String> spnList;
    private RecyclerView rvHoaDonChiTiet;
    private InvoiceDetailDAO invoiceDetailDAO;
    private BillDetailAdapter adapter;
    private List<Book> bookList;
    BookDAO bookDAO;
    private List<BillDetail> list;
    private ArrayAdapter<String> ladapter;
    Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don_chi_tiet);

        initView();

        btnThemHDCT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
            }
        });

        rvHoaDonChiTiet.setLayoutManager(new LinearLayoutManager(this));
        rvHoaDonChiTiet.setAdapter(adapter);

    }


    private void validation(){

        try{
            Intent intent = getIntent();
            Bundle in = intent.getExtras();

            String masach = spnList.get(spnMasach.getSelectedItemPosition());
            String mahoadon = in.getString("MHOADON");;
            int soluongmua = Integer.parseInt(editText3.getText().toString());
         int dem=bookDAO.getTaskCount(masach);
          if(soluongmua>dem){
                showMessage("sách trong kho không đủ");
           }

            else if(invoiceDetailDAO.insertInvoiceDetail(new InvoiceDetail(masach,mahoadon,soluongmua)) > 0){
                showMessage("Thêm hóa đơn chi tiết thành công");
                clearAllEditText();
                this.recreate();
            }
            else if(invoiceDetailDAO.insertInvoiceDetail(new InvoiceDetail(masach,mahoadon,soluongmua)) <= 0){
                showMessage("Thêm hóa đơn chi tiết thất bại");
            }
        }catch (NumberFormatException e){
            showMessage("Vui lòng nhập số lượng mua là số");
        }
        catch (ArrayIndexOutOfBoundsException e){
            showMessage("chưa có sách");
        }

    }

    private void clearAllEditText(){
        editText3.setText("");
       // edtHDCTMaSach.setText("");
       // edtHDCTMaHD.setText("");
    }

    private void initView(){
        spnMasach = (Spinner) findViewById(R.id.spnHDCTMaSach);
   //     edtHDCTMaHD = (EditText) findViewById(R.id.edtHDCTMaHD);

        bookDAO = new BookDAO(this);

        bookList = new ArrayList<>();
        spnList = new ArrayList<>();
        initSpinnerList();
        ladapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,spnList);
        ladapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnMasach.setAdapter(ladapter);
        editText3 = (EditText) findViewById(R.id.editText3);
        btnThemHDCT = (Button) findViewById(R.id.btnThemHDCT);
        rvHoaDonChiTiet = (RecyclerView) findViewById(R.id.rvHoaDonChiTiet);
        invoiceDetailDAO = new InvoiceDetailDAO(this);
        list = new ArrayList<>();
        list = invoiceDetailDAO.getAllInvoice();
        adapter = new BillDetailAdapter(this,list);

    }
    public void initSpinnerList(){
        bookList = bookDAO.getAllBook();
        for(int i = 0; i < bookList.size(); i++){
            Book book = bookList.get(i);
            spnList.add(book.getMasach());
        }
    }

}
