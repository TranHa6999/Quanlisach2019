package com.tuan.duanmau;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.admin.duanmau.R;
import com.tuan.duanmau.DAO.BookDAO;

public class test extends AppCompatActivity {
    private TextView tvtesst;

    BookDAO bookDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        tvtesst = (TextView) findViewById(R.id.tvtesst);
        bookDAO=new BookDAO(this);

    }

    public void chaythu(View view) {
        tvtesst.setText(String.valueOf(bookDAO.getTaskCount("s0001")));

    }
}
