package com.tuan.duanmau.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuan.duanmau.Fragment.DanhSachNguoiDungFragment;
import com.tuan.duanmau.Model.User;
import com.admin.duanmau.R;
import com.tuan.duanmau.fixUser;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    Context context;
    List<User> userList;
    DanhSachNguoiDungFragment fragment;

    public UserAdapter(Context context, List<User> userList, DanhSachNguoiDungFragment fragment) {
        this.context = context;
        this.userList = userList;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item_nguoi_dung,viewGroup,false);

        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int i) {
        final int position = i;
        final User user = userList.get(i);
        holder.txtusername.setText("Tên tài khoảnb :"+user.getUsername());
        holder.txtHoTenNguoiDung.setText("Tên người dùng:"+user.getFullname());
        holder.txtsdt.setText("Số điện thoại :"+user.getPhone());
        holder.imgCloseUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.removeUser(user.getUsername(), position);
            }
        });
        holder.imgfixuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context, fixUser.class);
                Bundle b = new Bundle();
                b.putString("USER", user.getUsername());
                intent.putExtras(b);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder {

        TextView txtHoTenNguoiDung ,txtsdt,txtusername;
        ImageView imgCloseUser,imgfixuser;

        public UserHolder(@NonNull View itemView) {
            super(itemView);
            txtHoTenNguoiDung = itemView.findViewById(R.id.txtHoTenNguoiDung);
            imgCloseUser = itemView.findViewById(R.id.imgCloseUser);
            imgfixuser=itemView.findViewById(R.id.imgFixuser);
            txtsdt=itemView.findViewById(R.id.tvSdt);
            txtusername=itemView.findViewById(R.id.tvuserName);
        }
    }
}
