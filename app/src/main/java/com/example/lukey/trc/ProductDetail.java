package com.example.lukey.trc;

import android.content.Context;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.lukey.trc.Common.Common;
import com.example.lukey.trc.Database.Database;
import com.example.lukey.trc.Model.Order;
import com.example.lukey.trc.Model.Product;
import com.example.lukey.trc.ViewHolder.OrderDetailAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductDetail extends AppCompatActivity {

    TextView product_name,product_price,product_description,product_bestBeforeEnd,product_warehouseQty,product_barcode,product_qtyOrdered;
    ImageView product_image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnCart;
    ElegantNumberButton numberButton;

    String productId="";

    FirebaseDatabase database;
    DatabaseReference products;

    Product currentProduct;
    Order currentOrder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        //FirebaseDatabase
        database = FirebaseDatabase.getInstance();
        products = database.getReference("Products");

        //View
        numberButton = (ElegantNumberButton)findViewById(R.id.number_button);
        btnCart = (FloatingActionButton)findViewById(R.id.btnCart);

        //Funtion for add to cart
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Database(getBaseContext()).addToCart(new Order(

                        productId,
                        currentProduct.getName(),
                        numberButton.getNumber(),
                        currentProduct.getPrice(),
                        currentProduct.getWarehouseQty()



                ));

                Toast.makeText(ProductDetail.this,"Added To Cart",Toast.LENGTH_SHORT).show();
            }
        });

        product_bestBeforeEnd = (TextView)findViewById(R.id.product_bestBeforeEnd);
        product_description = (TextView)findViewById(R.id.product_description);
        product_warehouseQty = (TextView)findViewById(R.id.product_warehouseQty);
        product_barcode = (TextView)findViewById(R.id.product_barcode);
        product_qtyOrdered = (TextView)findViewById(R.id.product_qtyOrdered);
        product_name = (TextView)findViewById(R.id.product_name);
        product_price = (TextView)findViewById(R.id.product_price);
        product_image = (ImageView) findViewById(R.id.img_product);

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);

        if(getIntent() != null)
            productId = getIntent().getStringExtra("productId");
        if(!productId.isEmpty())
        {
            if(Common.isConnectedToInternet(getBaseContext()))
                getDetailProduct(productId);
            else
            {
                Toast.makeText(ProductDetail.this, "Please Check Your Connection", Toast.LENGTH_SHORT).show();
                return;
            }

        }


    }
    private void getDetailProduct(String productId) {
        products.child(productId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                currentProduct = dataSnapshot.getValue(Product.class);



                //bind image

                Picasso.with(getBaseContext()).load(currentProduct.getImage())
                        .into(product_image);

                collapsingToolbarLayout.setTitle(currentProduct.getName());


                product_price.setText(currentProduct.getPrice());
                product_name.setText(currentProduct.getName());
                product_warehouseQty.setText(String.format("Quantity in Warehouse : %s",currentProduct.getWarehouseQty()));
                product_description.setText(String.format("Product Description : %s",currentProduct.getDescription()));
                product_bestBeforeEnd.setText(String.format("Best Before End : %s",currentProduct.getBestBeforeEnd()));
                product_barcode.setText(String.format("Barcode : %s",currentProduct.getBarcode()));
                product_qtyOrdered.setText(String.format("QTY Sold : %s",currentProduct.getQtyOrdered()));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }




}
