package com.tuan.duanmau;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.tuan.duanmau.DAO.InvoiceDetailDAO;
import com.admin.duanmau.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ThongKeActivity extends AppCompatActivity {

    private TextView txtDoanhThuHangNgay;
    private TextView txtDoanhThuThangNay;
    private TextView txtDoanhThuNamNay;
    private InvoiceDetailDAO invoiceDetailDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);

        txtDoanhThuHangNgay = (TextView) findViewById(R.id.txtDoanhThuHangNgay);
        txtDoanhThuThangNay = (TextView) findViewById(R.id.txtDoanhThuThangNay);
        txtDoanhThuNamNay = (TextView) findViewById(R.id.txtDoanhThuNamNay);

        String ngay = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
        String thang = new SimpleDateFormat("MM").format(Calendar.getInstance().getTime());
        String nam = new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());

        invoiceDetailDAO = new InvoiceDetailDAO(this);

        String doanhthungay = invoiceDetailDAO.getNumberOfMoney(ngay,thang,nam,1);
        String doanhthuthang = invoiceDetailDAO.getNumberOfMoney("",thang,nam,2);
        String doanhthunam = invoiceDetailDAO.getNumberOfMoney("","",nam,3);

        txtDoanhThuHangNgay.setText(doanhthungay);
        txtDoanhThuThangNay.setText(doanhthuthang);
        txtDoanhThuNamNay.setText(doanhthunam);

    }

}
