package com.tuan.duanmau.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.tuan.duanmau.DAO.UserDAO;
import com.admin.duanmau.R;

public class gioithieuF extends Fragment{
    private EditText edtpass;
    private EditText edtrePass;
    private EditText edtResdt;
    private Button btnAddfixuser;
    private Button btnhuycapnhapuser;
    UserDAO userDAO;



    private View rootview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_gioi_thieu,container,false);
        edtpass = (EditText)rootview. findViewById(R.id.edtpass);
        edtResdt = (EditText)rootview. findViewById(R.id.edtResdt);
        btnAddfixuser = (Button)rootview. findViewById(R.id.btnAddfixuser);
        btnhuycapnhapuser = (Button) rootview.findViewById(R.id.btnhuycapnhapuser);

        return rootview;
    }




}
