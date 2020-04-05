package com.tuan.duanmau;

import android.content.Intent;
import android.os.Bundle;

import com.tuan.duanmau.Base.BaseActivity;
import com.tuan.duanmau.DangNhap.DangNhapActivity;
import com.admin.duanmau.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, DangNhapActivity.class));
                finish();
            }
        },3000);

    }
}
