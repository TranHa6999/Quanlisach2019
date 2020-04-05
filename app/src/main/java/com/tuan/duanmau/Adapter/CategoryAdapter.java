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

import com.tuan.duanmau.Model.Category;
import com.admin.duanmau.R;
import com.tuan.duanmau.TheLoaiSach.DanhSachTheLoaiActivity;
import com.tuan.duanmau.fix_theloai;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    public DanhSachTheLoaiActivity context;
    public List<Category> categoryList;

    public CategoryAdapter(DanhSachTheLoaiActivity context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_the_loai,viewGroup,false);

        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int i) {
        final int position = i;
        final Category category = categoryList.get(i);
        holder.txtIdTheLoai.setText("mã thể loại :"+category.matheloai);
        holder.txtTenTheLoai.setText("tên thê loại :"+category.tentheloai);
        holder.txtmota.setText("mô tả :"+category.mota);
        holder.imgCloseTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.removeCategory(category.matheloai, position);
            }
        });
        holder.suatheloai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context, fix_theloai.class);
                Bundle c = new Bundle();
                c.putString("MATHELOAI", category.matheloai);
                intent.putExtras(c);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        TextView txtIdTheLoai,txtTenTheLoai,txtmota;
        ImageView imgCloseTheLoai,suatheloai;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            suatheloai=itemView.findViewById(R.id.fixTheloai);
            txtmota=itemView.findViewById(R.id.tvMota);
            txtIdTheLoai= itemView.findViewById(R.id.txtIdTheLoai);
            txtTenTheLoai = itemView.findViewById(R.id.txtTenTheLoai);
            imgCloseTheLoai = itemView.findViewById(R.id.imgCloseTheLoai);

        }
    }
}
