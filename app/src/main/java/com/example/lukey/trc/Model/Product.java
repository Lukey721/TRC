package com.example.lukey.trc.Model;

/**
 * Created by lukey on 31/01/2018.
 */

public class Product {

    private String BestBeforeEnd;
    private String Description;
    private String Image;
    private String MenuId;
    private String Name;
    private String Price;
    private String WarehouseQty;
    private String Barcode;
    private String QtyOrdered;

    public Product() {
    }

    public Product(String bestBeforeEnd, String description, String image, String menuId, String name, String price, String warehouseQty, String barcode, String qtyOrdered) {
        BestBeforeEnd = bestBeforeEnd;
        Description = description;
        Image = image;
        MenuId = menuId;
        Name = name;
        Price = price;
        WarehouseQty = warehouseQty;
        Barcode = barcode;
        QtyOrdered = qtyOrdered;
    }

    public String getBestBeforeEnd() {
        return BestBeforeEnd;
    }

    public void setBestBeforeEnd(String bestBeforeEnd) {
        BestBeforeEnd = bestBeforeEnd;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getWarehouseQty() {
        return WarehouseQty;
    }

    public void setWarehouseQty(String warehouseQty) {
        WarehouseQty = warehouseQty;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String barcode) {
        Barcode = barcode;
    }

    public String getQtyOrdered() {
        return QtyOrdered;
    }

    public void setQtyOrdered(String qtyOrdered) {
        QtyOrdered = qtyOrdered;
    }
}
