package com.tuan.duanmau.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tuan.duanmau.Model.BestSale;
import com.admin.duanmau.R;

import java.util.List;

public class BestSaleAdapter extends RecyclerView.Adapter<BestSaleAdapter.BestSaleHolder> {

    Context context;
    List<BestSale> list;

    public BestSaleAdapter(Context context, List<BestSale> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public BestSaleHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_best_sale,viewGroup,false);
        return new BestSaleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BestSaleHolder holder, int i) {
        BestSale bestSale = list.get(i);
        holder.txtNgayMuaBanChay.setText("ngày mua :" +bestSale.ngaymua);
        holder.txtTenSachBanChay.setText("tên sách :"+bestSale.tensach);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BestSaleHolder extends RecyclerView.ViewHolder {

        TextView txtNgayMuaBanChay;
        TextView txtTenSachBanChay;

        public BestSaleHolder(@NonNull View itemView) {
            super(itemView);

            txtNgayMuaBanChay = (TextView) itemView.findViewById(R.id.txtNgayMuaBanChay);
            txtTenSachBanChay = (TextView) itemView.findViewById(R.id.txtTenSachBanChay);

        }
    }
}
