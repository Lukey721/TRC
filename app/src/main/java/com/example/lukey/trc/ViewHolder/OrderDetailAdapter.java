package com.example.lukey.trc.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lukey.trc.Common.Common;
import com.example.lukey.trc.Model.Order;
import com.example.lukey.trc.Model.Product;
import com.example.lukey.trc.R;

import java.util.List;

/**
 * Created by lukey on 20/02/2018.
 */

class MyViewHolder extends RecyclerView.ViewHolder{

    public TextView name,quantity,price,warehouse;



    public MyViewHolder(View itemView) {
        super(itemView);
        name = (TextView)itemView.findViewById(R.id.product_name);
        quantity = (TextView)itemView.findViewById(R.id.product_quantity);
        price = (TextView)itemView.findViewById(R.id.product_price);
        warehouse = (TextView)itemView.findViewById(R.id.product_qtyInWarehouse);
    }
}

public class OrderDetailAdapter extends RecyclerView.Adapter<MyViewHolder> {

    List<Order> myOrders;


    public OrderDetailAdapter(List<Order> myOrders) {
        this.myOrders = myOrders;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_detail_layout,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Order order = myOrders.get(position);
        holder.name.setText(String.format("Name : %s",order.getProductName()));
        holder.quantity.setText(String.format("Quantity : %s",order.getQuantity()));
        holder.price.setText(String.format("Price : %s",order.getPrice()));
        holder.warehouse.setText(String.format("New QTY in Warehouse : %s",order.getQtyInWarehouse()));
    }

    @Override
    public int getItemCount() {
        return myOrders.size();
    }
}
