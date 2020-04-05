package com.tuan.duanmau;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.tuan.duanmau.BanChay.BanChayActivity;
import com.tuan.duanmau.Base.BaseActivity;
import com.tuan.duanmau.HoaDon.HoaDonActivity;
import com.tuan.duanmau.NguoiDungActivity.NguoiDungActivity;
import com.admin.duanmau.R;
import com.tuan.duanmau.Sach.SachActivity;
import com.tuan.duanmau.TheLoaiSach.TheLoaiSachActivity;

public class ManHinhChinhActivity extends BaseActivity implements View.OnClickListener {


    private LinearLayout llNguoiDung;
    private LinearLayout llTheLoaiSach;
    private LinearLayout llSach;
    private LinearLayout llHoaDon;
    private LinearLayout llBanChay;
    private LinearLayout llThongKe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chinh);

        llNguoiDung = (LinearLayout) findViewById(R.id.llNguoiDung);
        llTheLoaiSach = (LinearLayout) findViewById(R.id.llTheLoaiSach);
        llSach = (LinearLayout) findViewById(R.id.llSach);
        llHoaDon = (LinearLayout) findViewById(R.id.llHoaDon);
        llBanChay = (LinearLayout) findViewById(R.id.llBanChay);
        llThongKe = (LinearLayout) findViewById(R.id.llThongKe);

        llNguoiDung.setOnClickListener(this);
        llTheLoaiSach.setOnClickListener(this);
        llSach.setOnClickListener(this);
        llHoaDon.setOnClickListener(this);
        llBanChay.setOnClickListener(this);
        llThongKe.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == llNguoiDung){
            changeClass(NguoiDungActivity.class);
        }
        else if(v == llTheLoaiSach){
            changeClass(TheLoaiSachActivity.class);
        }
        else if(v == llSach){
            changeClass(SachActivity.class);
        }
        else if(v == llHoaDon){
            changeClass(HoaDonActivity.class);
        }
        else if(v == llBanChay){
            changeClass(BanChayActivity.class);
        }
        else if(v == llThongKe){
            changeClass(ThongKeActivity.class);
        }
    }
}
