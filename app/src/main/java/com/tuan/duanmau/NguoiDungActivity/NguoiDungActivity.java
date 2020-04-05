package com.tuan.duanmau.NguoiDungActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.tuan.duanmau.Base.BaseActivity;
import com.tuan.duanmau.DangNhap.DangNhapActivity;
import com.tuan.duanmau.Fragment.DanhSachNguoiDungFragment;
import com.tuan.duanmau.Fragment.gioithieuF;
import com.tuan.duanmau.Fragment.ThemNguoiDungFragment;
import com.admin.duanmau.R;

public class NguoiDungActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoi_dung);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Fragment fragment = new DanhSachNguoiDungFragment();
        this.replaceFragment(R.id.flNguoiDung,fragment);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.Xử lý các mục xem điều hướng nhấp vào đây.
        int id = item.getItemId();

        Fragment fragment = null;

        if (id == R.id.nav_camera) {
            fragment = new DanhSachNguoiDungFragment();
        } else if (id == R.id.nav_gallery) {
            fragment = new ThemNguoiDungFragment();
        } else if (id == R.id.nav_suathongtin) {
            fragment = new gioithieuF();
        } else if (id == R.id.nav_send) {
            Intent intent = new Intent(NguoiDungActivity.this, DangNhapActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        this.replaceFragment(R.id.flNguoiDung,fragment);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
