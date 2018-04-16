package com.example.lukey.trc.Model;

import java.util.List;

/**
 * Created by lukey on 02/02/2018.
 */

public class Request {

    private String userId;
    private String storeName;
    private String requestedDeliveryDate;
    private String total;
    private String status;
    private String comment;
    private List<Order> products;

    public Request() {
    }

    public Request(String storeName, String requestedDeliveryDate, String total, String status, String comment, List<Order> products) {
        this.storeName = storeName;
        this.requestedDeliveryDate = requestedDeliveryDate;
        this.total = total;
        this.status = status;
        this.comment = comment;
        this.products = products;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getRequestedDeliveryDate() {
        return requestedDeliveryDate;
    }

    public void setRequestedDeliveryDate(String requestedDeliveryDate) {
        this.requestedDeliveryDate = requestedDeliveryDate;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Order> getProducts() {
        return products;
    }

    public void setProducts(List<Order> products) {
        this.products = products;
    }
}
