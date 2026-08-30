package com.powerwise.model;

public class User {

    private int userId;
    private String userName;
    private String email;
    private String phone;
    private String address;
    private String password;


    // Default constructor
    public User() {
    }


    // Constructor for INSERT
    public User(String userName,
                String email,
                String phone,
                String address,
                String password) {

        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
    }


    // Constructor for UPDATE
    public User(int userId,
                String userName,
                String email,
                String phone,
                String address,
                String password) {

        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {

        return "ID: " + userId
                + " | Name: " + userName
                + " | Email: " + email
                + " | Phone: " + phone
                + " | Address: " + address;
    }
}
