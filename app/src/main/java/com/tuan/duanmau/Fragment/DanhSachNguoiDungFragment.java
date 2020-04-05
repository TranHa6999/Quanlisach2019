package com.tuan.duanmau.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tuan.duanmau.Adapter.UserAdapter;
import com.tuan.duanmau.DAO.UserDAO;
import com.tuan.duanmau.Model.User;
import com.admin.duanmau.R;

import java.util.ArrayList;
import java.util.List;

public class DanhSachNguoiDungFragment extends Fragment {

    private View rootview;
    private UserAdapter adapter;
    private List<User> list;
    private RecyclerView rvNguoiDung;
    private UserDAO userDAO;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_danh_sach_nguoi_dung,container,false);
        rvNguoiDung = rootview.findViewById(R.id.rvNguoiDung);

        userDAO = new UserDAO(getContext());
        list = new ArrayList<>();

        list = userDAO.getAllUser();
        adapter = new UserAdapter(getContext(),list,this);
        rvNguoiDung.setLayoutManager(new LinearLayoutManager(getContext()));
        rvNguoiDung.setAdapter(adapter);

        return rootview;
    }

    public void removeUser(String username, int position){
        userDAO.removeUser(username);
        list.remove(position);
        adapter.notifyDataSetChanged();
        Toast.makeText(getContext(), "Xóa người dùng thành công", Toast.LENGTH_SHORT).show();
    }


}
