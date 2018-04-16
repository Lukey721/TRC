package com.example.lukey.trc;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.lukey.trc.Common.Common;
import com.example.lukey.trc.Database.Database;
import com.example.lukey.trc.Interface.ItemClickListener;
import com.example.lukey.trc.Model.Product;
import com.example.lukey.trc.Model.Request;
import com.example.lukey.trc.ViewHolder.DateViewHolder;
import com.example.lukey.trc.ViewHolder.OrderViewHolder;
import com.example.lukey.trc.ViewHolder.StockViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class StockStatus extends AppCompatActivity {

    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;

    FirebaseRecyclerAdapter<Product,StockViewHolder>adapter;

    EditText edtName,edtDescription,edtPrice,edtBestBeforeEnd,edtWarehouseQty,edtBarcode;

    FirebaseDatabase database;
    DatabaseReference products;
    DatabaseReference productList;
    DatabaseReference requests;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_status);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle("Stock Selection");
        setSupportActionBar(toolbar);

        //Firebase

        database = FirebaseDatabase.getInstance();
        products = database.getReference("Products");
        productList = database.getReference("Products");
        requests = database.getReference("Requests");


        recyclerView = (RecyclerView)findViewById(R.id.listStock);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        loadStock();


    }

    private void loadStock() {
        adapter = new FirebaseRecyclerAdapter<Product, StockViewHolder>(
                Product.class,
                R.layout.stock_layout,
                StockViewHolder.class,
                products.orderByChild("warehouseQty")
                        .startAt("1")


        ) {


            @Override
            protected void populateViewHolder(StockViewHolder viewHolder, final Product model, final int position) {

                viewHolder.txtProductName.setText(model.getName());
                viewHolder.txtProductQty.setText(model.getWarehouseQty());


                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int posistion, boolean isLongClick) {
                        //fix crash
                        //Intent myIntent = new Intent(StockStatus.this, DateDetail.class);
                        //DateStatus.this.startActivity(myIntent);
                    }
                });

            }
        };
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }

    private void loadStockCritical() {
        adapter = new FirebaseRecyclerAdapter<Product, StockViewHolder>(
                Product.class,
                R.layout.stock_layout,
                StockViewHolder.class,
                products.orderByChild("warehouseQty")
                        .startAt("101")
        ) {


            @Override
            protected void populateViewHolder(StockViewHolder viewHolder, final Product model, final int position) {

                viewHolder.txtProductName.setText(model.getName());
                viewHolder.txtProductQty.setText(model.getWarehouseQty());


                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int posistion, boolean isLongClick) {
                        //fix crash
                        //Intent myIntent = new Intent(StockStatus.this, DateDetail.class);
                        //DateStatus.this.startActivity(myIntent);
                    }
                });

            }
        };
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }

    private void loadStockReorder() {
        adapter = new FirebaseRecyclerAdapter<Product, StockViewHolder>(
                Product.class,
                R.layout.stock_layout,
                StockViewHolder.class,
                products.orderByChild("warehouseQty")
                        .startAt("1001")
        ) {


            @Override
            protected void populateViewHolder(StockViewHolder viewHolder, final Product model, final int position) {

                viewHolder.txtProductName.setText(model.getName());
                viewHolder.txtProductQty.setText(model.getWarehouseQty());


                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int posistion, boolean isLongClick) {
                        //fix crash
                        //Intent myIntent = new Intent(StockStatus.this, DateDetail.class);
                        //DateStatus.this.startActivity(myIntent);
                    }
                });

            }
        };
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }

    private void loadStockFine() {
        adapter = new FirebaseRecyclerAdapter<Product, StockViewHolder>(
                Product.class,
                R.layout.stock_layout,
                StockViewHolder.class,
                products.orderByChild("warehouseQty")
                        .startAt("10001")
        ) {


            @Override
            protected void populateViewHolder(StockViewHolder viewHolder, final Product model, final int position) {

                viewHolder.txtProductName.setText(model.getName());
                viewHolder.txtProductQty.setText(model.getWarehouseQty());


                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int posistion, boolean isLongClick) {
                        //fix crash
                        //Intent myIntent = new Intent(StockStatus.this, DateDetail.class);
                        //DateStatus.this.startActivity(myIntent);
                    }
                });

            }
        };
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.sort_stock, menu);
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.critical)
            loadStockCritical();
        else if(item.getItemId() == R.id.order){
            loadStockReorder();
        }else if(item.getItemId() == R.id.stocked){
            loadStockFine();
        }else if(item.getItemId() == R.id.all) {
            loadStock();
        }
        return super.onOptionsItemSelected(item);
    }


    // @Override
    //public boolean onCreateOptionsMenu(Menu menu) {





}
