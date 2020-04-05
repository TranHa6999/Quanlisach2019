package com.tuan.duanmau;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tuan.duanmau.Adapter.BillDetailAdapter;
import com.tuan.duanmau.DAO.InvoiceDetailDAO;
import com.tuan.duanmau.Model.BillDetail;
import com.admin.duanmau.R;

import java.util.ArrayList;
import java.util.List;

public class lv_hdct extends AppCompatActivity {
RecyclerView recyclerViewlist;
    private InvoiceDetailDAO invoiceDetailDAO;
    private BillDetailAdapter adapter;
    private List<BillDetail> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv_hdct);
        recyclerViewlist=findViewById(R.id.rclisthd);
        invoiceDetailDAO = new InvoiceDetailDAO(this);
        list = new ArrayList<>();
        list = invoiceDetailDAO.getAllInvoice();
        adapter = new BillDetailAdapter(this,list);
        recyclerViewlist.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewlist.setAdapter(adapter);

    }
}
