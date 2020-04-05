package com.tuan.duanmau.Sach;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tuan.duanmau.Adapter.BookAdapter;
import com.tuan.duanmau.Base.BaseActivity;
import com.tuan.duanmau.DAO.BookDAO;
import com.tuan.duanmau.Model.Book;
import com.admin.duanmau.R;

import java.util.ArrayList;
import java.util.List;

public class DanhSachSachActivity extends BaseActivity {

    private RecyclerView rvSach;
    private List<Book> list;
    private BookAdapter adapter;
    private BookDAO bookDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_sach);

        rvSach = (RecyclerView) findViewById(R.id.rvSach);
        bookDAO = new BookDAO(this);

        list = new ArrayList<>();
        list = bookDAO.getAllBook();
        adapter = new BookAdapter(this,list);
        rvSach.setLayoutManager(new LinearLayoutManager(this));
        rvSach.setAdapter(adapter);
        rvSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showMessage("hahahaha");
            }
        });
    }

    public void removeBook(String bookID, int position){
        bookDAO.removeBook(bookID);
        list.remove(position);
        adapter.notifyDataSetChanged();
        showMessage("Xóa sách thành công");
    }

}
