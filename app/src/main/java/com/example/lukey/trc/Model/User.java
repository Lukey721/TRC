package com.example.lukey.trc.Model;

/**
 * Created by lukey on 30/01/2018.
 */

public class User {

    private String StoreName;
    private String Password;
    private String IsStaff;
    private String IsAdmin;
    private String Email;
    private String UserId;


    public User() {

    }

    public User(String storeName, String password, String email,String userId) {
        StoreName = storeName;
        Password = password;
        IsStaff = "false";
        IsAdmin = "false";
        Email = email;
        UserId = userId;

    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getIsStaff() {
        return IsStaff;
    }

    public void setIsStaff(String isStaff) {
        IsStaff = isStaff;
    }

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String storeName) {
        StoreName = storeName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getIsAdmin() {
        return IsAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        IsAdmin = isAdmin;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
