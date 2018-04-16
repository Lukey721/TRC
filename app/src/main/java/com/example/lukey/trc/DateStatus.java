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
import android.widget.Button;
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
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class DateStatus extends AppCompatActivity {

    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;

    FirebaseRecyclerAdapter<Product,DateViewHolder>adapter;

    EditText edtName,edtDescription,edtPrice,edtBestBeforeEnd,edtWarehouseQty,edtBarcode;

    Button btndiscount,btnwaste;

    FirebaseDatabase database;
    DatabaseReference products;
    DatabaseReference productList;
    DatabaseReference requests;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_status);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle("Date Selection");
        setSupportActionBar(toolbar);

        //Firebase

        database = FirebaseDatabase.getInstance();
        products = database.getReference("Products");
        productList = database.getReference("Products");
        requests = database.getReference("Requests");


        recyclerView = (RecyclerView)findViewById(R.id.listOrders);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        loadDates();


    }

    private void loadDates() {
        adapter = new FirebaseRecyclerAdapter<Product, DateViewHolder>(
                Product.class,
                R.layout.date_layout,
                DateViewHolder.class,
                products.orderByChild("bestBeforeEnd")
                        //.equalTo("January")
        ) {


            @Override
            protected void populateViewHolder(DateViewHolder viewHolder, final Product model, final int position) {

                viewHolder.txtProductName.setText(model.getName());
                viewHolder.txtProductBbe.setText(model.getBestBeforeEnd());
                viewHolder.txtProductQty.setText(model.getWarehouseQty());

                viewHolder.btndiscount.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showUpdateProductDialog(adapter.getRef(position).getKey(), adapter.getItem(position));
                    }
                });

                viewHolder.btnwaste.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        deleteDate(adapter.getRef(position).getKey());
                    }
                });
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int posistion, boolean isLongClick) {
                        //fix crash
                        Intent myIntent = new Intent(DateStatus.this, DateDetail.class);
                        DateStatus.this.startActivity(myIntent);
                    }
                });

            }
        };
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }

    private void loadDatesJanuary() {
        adapter = new FirebaseRecyclerAdapter<Product, DateViewHolder>(
                Product.class,
                R.layout.date_layout,
                DateViewHolder.class,
                products.orderByChild("bestBeforeEnd")
                .equalTo("January")
        ) {


            @Override
            protected void populateViewHolder(DateViewHolder viewHolder, final Product model, final int position) {

                viewHolder.txtProductName.setText(model.getName());
                viewHolder.txtProductBbe.setText(model.getBestBeforeEnd());
                viewHolder.txtProductQty.setText(model.getWarehouseQty());


                viewHolder.btndiscount.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showUpdateProductDialog(adapter.getRef(position).getKey(), adapter.getItem(position));
                    }
                });

                viewHolder.btnwaste.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        deleteDate(adapter.getRef(position).getKey());
                    }
                });
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int posistion, boolean isLongClick) {
                        //fix crash
                        Intent myIntent = new Intent(DateStatus.this, DateDetail.class);
                        DateStatus.this.startActivity(myIntent);
                    }
                });

            }
        };
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }

    private void loadDatesFebruary() {
        adapter = new FirebaseRecyclerAdapter<Product, DateViewHolder>(
                Product.class,
                R.layout.date_layout,
                DateViewHolder.class,
                products.orderByChild("bestBeforeEnd")
                        .equalTo("February")
        ) {


            @Override
            protected void populateViewHolder(DateViewHolder viewHolder, final Product model, final int position) {

                viewHolder.txtProductName.setText(model.getName());
                viewHolder.txtProductBbe.setText(model.getBestBeforeEnd());
                viewHolder.txtProductQty.setText(model.getWarehouseQty());


                viewHolder.btndiscount.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showUpdateProductDialog(adapter.getRef(position).getKey(), adapter.getItem(position));
                    }
                });

                viewHolder.btnwaste.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        deleteDate(adapter.getRef(position).getKey());
                    }
                });
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int posistion, boolean isLongClick) {
                        //fix crash
                        Intent myIntent = new Intent(DateStatus.this, DateDetail.class);
                        DateStatus.this.startActivity(myIntent);
                    }
                });

            }
        };
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }

    private void loadDatesMarch() {
        adapter = new FirebaseRecyclerAdapter<Product, DateViewHolder>(
                Product.class,
                R.layout.date_layout,
                DateViewHolder.class,
                products.orderByChild("bestBeforeEnd")
                        .equalTo("March")
        ) {


            @Override
            protected void populateViewHolder(DateViewHolder viewHolder, final Product model, final int position) {

                viewHolder.txtProductName.setText(model.getName());
                viewHolder.txtProductBbe.setText(model.getBestBeforeEnd());
                viewHolder.txtProductQty.setText(model.getWarehouseQty());


                viewHolder.btndiscount.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showUpdateProductDialog(adapter.getRef(position).getKey(), adapter.getItem(position));
                    }
                });

                viewHolder.btnwaste.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        deleteDate(adapter.getRef(position).getKey());
                    }
                });
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int posistion, boolean isLongClick) {
                        //fix crash
                        Intent myIntent = new Intent(DateStatus.this, DateDetail.class);
                        DateStatus.this.startActivity(myIntent);
                    }
                });

            }
        };
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }

    private void loadDatesApril() {
        adapter = new FirebaseRecyclerAdapter<Product, DateViewHolder>(
                Product.class,
                R.layout.date_layout,
                DateViewHolder.class,
                products.orderByChild("bestBeforeEnd")
                        .equalTo("April")
        ) {


            @Override
            protected void populateViewHolder(DateViewHolder viewHolder, final Product model, final int position) {

                viewHolder.txtProductName.setText(model.getName());
                viewHolder.txtProductBbe.setText(model.getBestBeforeEnd());
                viewHolder.txtProductQty.setText(model.getWarehouseQty());


                viewHolder.btndiscount.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showUpdateProductDialog(adapter.getRef(position).getKey(), adapter.getItem(position));
                    }
                });

                viewHolder.btnwaste.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        deleteDate(adapter.getRef(position).getKey());
                    }
                });
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int posistion, boolean isLongClick) {
                        //fix crash
                        Intent myIntent = new Intent(DateStatus.this, DateDetail.class);
                        DateStatus.this.startActivity(myIntent);
                    }
                });

            }
        };
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }

    private void loadDatesMay() {
        adapter = new FirebaseRecyclerAdapter<Product, DateViewHolder>(
                Product.class,
                R.layout.date_layout,
                DateViewHolder.class,
                products.orderByChild("bestBeforeEnd")
                        .equalTo("May")
        ) {


            @Override
            protected void populateViewHolder(DateViewHolder viewHolder, final Product model, final int position) {

                viewHolder.txtProductName.setText(model.getName());
                viewHolder.txtProductBbe.setText(model.getBestBeforeEnd());
                viewHolder.txtProductQty.setText(model.getWarehouseQty());


                viewHolder.btndiscount.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showUpdateProductDialog(adapter.getRef(position).getKey(), adapter.getItem(position));
                    }
                });

                viewHolder.btnwaste.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        deleteDate(adapter.getRef(position).getKey());
                    }
                });
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int posistion, boolean isLongClick) {
                        //fix crash
                        Intent myIntent = new Intent(DateStatus.this, DateDetail.class);
                        DateStatus.this.startActivity(myIntent);
                    }
                });
            }
        };
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }

    private void loadDatesJune() {
        adapter = new FirebaseRecyclerAdapter<Product, DateViewHolder>(
                Product.class,
                R.layout.date_layout,
                DateViewHolder.class,
                products.orderByChild("bestBeforeEnd")
                        .equalTo("June")
        ) {


            @Override
            protected void populateViewHolder(DateViewHolder viewHolder, final Product model, final int position) {

                viewHolder.txtProductName.setText(model.getName());
                viewHolder.txtProductBbe.setText(model.getBestBeforeEnd());
                viewHolder.txtProductQty.setText(model.getWarehouseQty());


                viewHolder.btndiscount.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showUpdateProductDialog(adapter.getRef(position).getKey(), adapter.getItem(position));
                    }
                });

                viewHolder.btnwaste.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        deleteDate(adapter.getRef(position).getKey());
                    }
                });
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int posistion, boolean isLongClick) {
                        //fix crash
                        Intent myIntent = new Intent(DateStatus.this, DateDetail.class);
                        DateStatus.this.startActivity(myIntent);
                    }
                });

            }
        };
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }

    private void loadDatesJuly() {
        adapter = new FirebaseRecyclerAdapter<Product, DateViewHolder>(
                Product.class,
                R.layout.date_layout,
                DateViewHolder.class,
                products.orderByChild("bestBeforeEnd")
                        .equalTo("July")
        ) {


            @Override
            protected void populateViewHolder(DateViewHolder viewHolder, final Product model, final int position) {

                viewHolder.txtProductName.setText(model.getName());
                viewHolder.txtProductBbe.setText(model.getBestBeforeEnd());
                viewHolder.txtProductQty.setText(model.getWarehouseQty());


                viewHolder.btndiscount.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showUpdateProductDialog(adapter.getRef(position).getKey(), adapter.getItem(position));
                    }
                });

                viewHolder.btnwaste.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        deleteDate(adapter.getRef(position).getKey());
                    }
                });
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int posistion, boolean isLongClick) {
                        //fix crash
                        Intent myIntent = new Intent(DateStatus.this, DateDetail.class);
                        DateStatus.this.startActivity(myIntent);
                    }
                });

            }
        };
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }

    private void loadDatesAugust() {
        adapter = new FirebaseRecyclerAdapter<Product, DateViewHolder>(
                Product.class,
                R.layout.date_layout,
                DateViewHolder.class,
                products.orderByChild("bestBeforeEnd")
                        .equalTo("August")
        ) {


            @Override
            protected void populateViewHolder(DateViewHolder viewHolder, final Product model, final int position) {

                viewHolder.txtProductName.setText(model.getName());
                viewHolder.txtProductBbe.setText(model.getBestBeforeEnd());
                viewHolder.txtProductQty.setText(model.getWarehouseQty());


                viewHolder.btndiscount.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showUpdateProductDialog(adapter.getRef(position).getKey(), adapter.getItem(position));
                    }
                });

                viewHolder.btnwaste.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        deleteDate(adapter.getRef(position).getKey());
                    }
                });
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int posistion, boolean isLongClick) {
                        //fix crash
                        Intent myIntent = new Intent(DateStatus.this, DateDetail.class);
                        DateStatus.this.startActivity(myIntent);
                    }
                });

            }
        };
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }

    private void loadDatesSeptember() {
        adapter = new FirebaseRecyclerAdapter<Product, DateViewHolder>(
                Product.class,
                R.layout.date_layout,
                DateViewHolder.class,
                products.orderByChild("bestBeforeEnd")
                        .equalTo("September")
        ) {


            @Override
            protected void populateViewHolder(DateViewHolder viewHolder, final Product model, final int position) {

                viewHolder.txtProductName.setText(model.getName());
                viewHolder.txtProductBbe.setText(model.getBestBeforeEnd());
                viewHolder.txtProductQty.setText(model.getWarehouseQty());


                viewHolder.btndiscount.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showUpdateProductDialog(adapter.getRef(position).getKey(), adapter.getItem(position));
                    }
                });

                viewHolder.btnwaste.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        deleteDate(adapter.getRef(position).getKey());
                    }
                });
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int posistion, boolean isLongClick) {
                        //fix crash
                        Intent myIntent = new Intent(DateStatus.this, DateDetail.class);
                        DateStatus.this.startActivity(myIntent);
                    }
                });

            }
        };
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }

    private void loadDatesOctober() {
        adapter = new FirebaseRecyclerAdapter<Product, DateViewHolder>(
                Product.class,
                R.layout.date_layout,
                DateViewHolder.class,
                products.orderByChild("bestBeforeEnd")
                        .equalTo("October")
        ) {


            @Override
            protected void populateViewHolder(DateViewHolder viewHolder, final Product model, final int position) {

                viewHolder.txtProductName.setText(model.getName());
                viewHolder.txtProductBbe.setText(model.getBestBeforeEnd());
                viewHolder.txtProductQty.setText(model.getWarehouseQty());


                viewHolder.btndiscount.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showUpdateProductDialog(adapter.getRef(position).getKey(), adapter.getItem(position));
                    }
                });

                viewHolder.btnwaste.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        deleteDate(adapter.getRef(position).getKey());
                    }
                });
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int posistion, boolean isLongClick) {
                        //fix crash
                        Intent myIntent = new Intent(DateStatus.this, DateDetail.class);
                        DateStatus.this.startActivity(myIntent);
                    }
                });

            }
        };
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }

    private void loadDatesNovember() {
        adapter = new FirebaseRecyclerAdapter<Product, DateViewHolder>(
                Product.class,
                R.layout.date_layout,
                DateViewHolder.class,
                products.orderByChild("bestBeforeEnd")
                        .equalTo("November")
        ) {


            @Override
            protected void populateViewHolder(DateViewHolder viewHolder, final Product model, final int position) {

                viewHolder.txtProductName.setText(model.getName());
                viewHolder.txtProductBbe.setText(model.getBestBeforeEnd());
                viewHolder.txtProductQty.setText(model.getWarehouseQty());


                viewHolder.btndiscount.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showUpdateProductDialog(adapter.getRef(position).getKey(), adapter.getItem(position));
                    }
                });

                viewHolder.btnwaste.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        deleteDate(adapter.getRef(position).getKey());
                    }
                });
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int posistion, boolean isLongClick) {
                        //fix crash
                        Intent myIntent = new Intent(DateStatus.this, DateDetail.class);
                        DateStatus.this.startActivity(myIntent);
                    }
                });

            }
        };
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }

    private void loadDatesDecember() {
        adapter = new FirebaseRecyclerAdapter<Product, DateViewHolder>(
                Product.class,
                R.layout.date_layout,
                DateViewHolder.class,
                products.orderByChild("bestBeforeEnd")
                        .equalTo("December")
        ) {


            @Override
            protected void populateViewHolder(DateViewHolder viewHolder, final Product model, final int position) {

                viewHolder.txtProductName.setText(model.getName());
                viewHolder.txtProductBbe.setText(model.getBestBeforeEnd());
                viewHolder.txtProductQty.setText(model.getWarehouseQty());


                viewHolder.btndiscount.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showUpdateProductDialog(adapter.getRef(position).getKey(), adapter.getItem(position));
                    }
                });

                viewHolder.btnwaste.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        deleteDate(adapter.getRef(position).getKey());
                    }
                });
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int posistion, boolean isLongClick) {
                        //fix crash
                        Intent myIntent = new Intent(DateStatus.this, DateDetail.class);
                        DateStatus.this.startActivity(myIntent);
                    }
                });

            }
        };
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }

   // @Override
    //public boolean onCreateOptionsMenu(Menu menu) {

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getTitle().equals(Common.Discount)) {
            showUpdateProductDialog(adapter.getRef(item.getOrder()).getKey(), adapter.getItem(item.getOrder()));
        }else if(item.getTitle().equals(Common.Waste))
        {
            deleteDate(adapter.getRef(item.getOrder()).getKey());
        }
        return super.onContextItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

            getMenuInflater().inflate(R.menu.sort_dates, menu);
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.jan)
            loadDatesJanuary();
        else if(item.getItemId() == R.id.feb){
            loadDatesFebruary();
        }else if(item.getItemId() == R.id.march){
            loadDatesMarch();
        }else if(item.getItemId() == R.id.april){
            loadDatesApril();
        }else if(item.getItemId() == R.id.may){
            loadDatesMay();
        }else if(item.getItemId() == R.id.june){
            loadDatesJune();
        }else if(item.getItemId() == R.id.july){
            loadDatesJuly();
        }else if(item.getItemId() == R.id.aug){
            loadDatesAugust();
        }else if(item.getItemId() == R.id.sept){
            loadDatesSeptember();
        }else if(item.getItemId() == R.id.oct){
            loadDatesOctober();
        }else if(item.getItemId() == R.id.nov){
            loadDatesNovember();
        }else if(item.getItemId() == R.id.dec) {
            loadDatesDecember();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showUpdateProductDialog(final String key, final Product item) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(DateStatus.this);
        alertDialog.setTitle("Edit Product");
        alertDialog.setMessage("Please fill details");

        LayoutInflater inflater = this.getLayoutInflater();
        View add_menu_layout = inflater.inflate(R.layout.add_new_product_layout,null);

        edtName = add_menu_layout.findViewById(R.id.edtName);
        edtDescription = add_menu_layout.findViewById(R.id.edtDescription);
        edtPrice = add_menu_layout.findViewById(R.id.edtPrice);
        edtBestBeforeEnd = add_menu_layout.findViewById(R.id.edtBestBeforeEnd);
        edtWarehouseQty = add_menu_layout.findViewById(R.id.edtWarehouseQty);
        edtBarcode = add_menu_layout.findViewById(R.id.edtBarcode);

        //set default value for view
        edtName.setText(item.getName());
        edtDescription.setText(item.getDescription());
        edtPrice.setText(item.getPrice());
        edtBestBeforeEnd.setText(item.getBestBeforeEnd());
        edtWarehouseQty.setText(item.getWarehouseQty());
        edtBarcode.setText(item.getBarcode());



        alertDialog.setView(add_menu_layout);
        alertDialog.setIcon(R.drawable.ic_shopping_cart_black_24dp);

        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();


                item.setName(edtName.getText().toString());
                item.setBestBeforeEnd(edtBestBeforeEnd.getText().toString());
                item.setDescription(edtDescription.getText().toString());
                item.setPrice(edtPrice.getText().toString());
                item.setWarehouseQty(edtWarehouseQty.getText().toString());
                item.setBarcode(edtBarcode.getText().toString());


                productList.child(key).setValue(item);
                adapter.notifyDataSetChanged();

                Toast.makeText(DateStatus.this, "Product Updated ", Toast.LENGTH_SHORT).show();



            }
        });
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();
            }
        });
        alertDialog.show();
    }

    private void deleteDate(String key) {

        products.child(key).removeValue();
        adapter.notifyDataSetChanged();
    }



}
