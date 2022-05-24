package com.areportapplication.model;

public class TotalOrder {
    public TotalOrder(double amount, double price) {
        this.amount = amount;
        this.price = price;
    }

    private double amount;

//    List<Order> order;
    private double price;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
