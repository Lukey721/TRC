package com.example.lukey.trc.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;

import com.example.lukey.trc.Interface.ItemClickListener;
import com.example.lukey.trc.R;

/**
 * Created by lukey on 06/02/2018.
 */

public class StockViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
        View.OnLongClickListener,
        View.OnCreateContextMenuListener {

    public TextView txtProductName,txtProductQty;

    private ItemClickListener itemClickListener;


    public StockViewHolder(View itemView) {
        super(itemView);

        txtProductName = (TextView)itemView.findViewById(R.id.product_name);
        txtProductQty = (TextView)itemView.findViewById(R.id.product_qty);


        itemView.setOnClickListener(this);
        //itemView.setOnLongClickListener(this);
        itemView.setOnCreateContextMenuListener(this);

    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {

        //itemClickListener.onClick(view,getAdapterPosition(),false);
        itemClickListener.onClick(view,getAdapterPosition(),true);


    }

    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {

        contextMenu.setHeaderTitle("Select the Action");

        contextMenu.add(0,0,getAdapterPosition(),"Discount");
        contextMenu.add(0,1,getAdapterPosition(),"Waste");
    }

    @Override
    public boolean onLongClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),true);
        return true;
    }
}
