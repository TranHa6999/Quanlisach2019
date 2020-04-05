package com.tuan.duanmau.Adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuan.duanmau.Model.Book;
import com.admin.duanmau.R;
import com.tuan.duanmau.Sach.DanhSachSachActivity;
import com.tuan.duanmau.fix_sach;

import java.util.List;

public class BookAdapter extends  RecyclerView.Adapter<BookAdapter.BookViewHolder>{

    public DanhSachSachActivity context;
    public List<Book> bookList;

    public BookAdapter(DanhSachSachActivity context, List<Book> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_sach,viewGroup,false);

        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int i) {
        final int position = i;
        final Book book = bookList.get(i);
        holder.txtMasach.setText("mã sách :"+book.masach);
        holder.txtTenSach.setText("tên sách:"+book.tensach);
        holder.txtSoLuongSach.setText("số lượng :"+String.valueOf(book.soluong));
        holder.txtGiaban.setText("đơn giá :"+String.valueOf(book.giabia));
        holder.imgCloseSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.removeBook(book.masach, position);
            }
        });
        holder.imgfixbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent =new Intent(context, fix_sach.class);
                Bundle b = new Bundle();
                b.putString("MAHOADON", book.masach);
                intent.putExtras(b);
             context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {

        TextView txtTenSach,txtSoLuongSach,txtGiaban,txtMasach;
        ImageView imgCloseSach ,imgfixbook;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMasach=itemView.findViewById(R.id.txtMasach);
            txtTenSach = itemView.findViewById(R.id.txtTenSach);
            txtSoLuongSach = itemView.findViewById(R.id.txtSoLuongSach);
            imgCloseSach = itemView.findViewById(R.id.imgCloseSach);
            txtGiaban=itemView.findViewById(R.id.txtGiaban);
            imgfixbook=itemView.findViewById(R.id.imgfixbook);

        }
    }
}
