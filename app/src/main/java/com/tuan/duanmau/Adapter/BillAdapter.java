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

import com.tuan.duanmau.HoaDon.HoaDonActivity;
import com.tuan.duanmau.HoaDon.HoaDonChiTietActivity;
import com.tuan.duanmau.Model.Invoice;
import com.admin.duanmau.R;

import java.util.List;

public class BillAdapter extends RecyclerView.Adapter<BillAdapter.BillHolder> {

    HoaDonActivity context;
    List<Invoice> list;

    public BillAdapter(HoaDonActivity context, List<Invoice> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public BillHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_hoa_don,viewGroup,false);
        return new BillHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BillHolder billHolder, int i) {
        final int position = i;
        final Invoice invoice = list.get(i);
        billHolder.txtIDHoaDon.setText("mã hóa đơn :"+invoice.mahoadon);
        billHolder.txtNgayMuaHoaDon.setText("ngày mua :"+invoice.ngaymua);
        billHolder.imgCloseHoaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.removeUser(invoice.mahoadon,position);
            }
        });
        billHolder.imgaddhdct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context, HoaDonChiTietActivity.class);
                Bundle b = new Bundle();
                b.putString("MHOADON",invoice .mahoadon);
                intent.putExtras(b);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BillHolder extends RecyclerView.ViewHolder {

        TextView txtIDHoaDon, txtNgayMuaHoaDon;
        ImageView imgCloseHoaDon,imgaddhdct;

        public BillHolder(@NonNull View itemView) {
            super(itemView);

            txtIDHoaDon = (TextView) itemView.findViewById(R.id.txtIDHoaDon);
            txtNgayMuaHoaDon = (TextView) itemView.findViewById(R.id.txtNgayMuaHoaDon);
            imgCloseHoaDon = (ImageView) itemView.findViewById(R.id.imgCloseHoaDon);
            imgaddhdct=itemView.findViewById(R.id.imgaddhdct);
        }
    }
}
