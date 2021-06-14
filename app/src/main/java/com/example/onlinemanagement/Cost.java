package com.example.onlinemanagement;

public class Cost {
    public Cost() {
    }
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGrouping() {
        return grouping;
    }

    public void setGrouping(String grouping) {
        this.grouping = grouping;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDiscription() {
        return discription;
    }

    public Cost(String price, String grouping, String account, String date, String discription) {
        this.price = price;
        this.grouping = grouping;
        this.account = account;
        this.date = date;
        this.discription = discription;
    }

    private String price,grouping,account,date,discription;
}
