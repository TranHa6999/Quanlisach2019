package com.tuan.duanmau.BanChay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.tuan.duanmau.Adapter.BestSaleAdapter;
import com.tuan.duanmau.DAO.InvoiceDetailDAO;
import com.tuan.duanmau.Model.BestSale;
import com.admin.duanmau.R;

import java.util.ArrayList;
import java.util.List;

public class BanChayActivity extends AppCompatActivity {

    private Spinner spnBanChay;
    private RecyclerView rvBanChay;
    private InvoiceDetailDAO invoiceDetailDAO;
    private String[] spnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ban_chay);
        spnBanChay = (Spinner) findViewById(R.id.spnBanChay);
        rvBanChay = (RecyclerView) findViewById(R.id.rvBanChay);

        spnList = new String[]{"01", "02", "03", "04", "05", "06"
                , "07", "08", "09", "10", "11", "12"};
        ArrayAdapter<String> spnAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,spnList);
        spnAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnBanChay.setAdapter(spnAdapter);
        invoiceDetailDAO = new InvoiceDetailDAO(this);

        spnBanChay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getData(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void getData(int position){

        List<BestSale> list = new ArrayList<>();
        list.clear();
        list = invoiceDetailDAO.getAllBestSale(spnList[position]);
        BestSaleAdapter adapter = new BestSaleAdapter(this,list);

        rvBanChay.setLayoutManager(new LinearLayoutManager(this));
        rvBanChay.setAdapter(adapter);
    }

}
