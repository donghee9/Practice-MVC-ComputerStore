package com.example.computerstore.Model;


import lombok.ToString;

@ToString
public class OrderHistory {
    private int id;
    private int customerId;
    private String customerName;
    private String customerAddress;
    private String productName;
    private double productPrice;
    private int quantity;
    private double totalAmount;

    private OrderHistory(int customerId, String customerName, String customerAddress,
                         String productName, double productPrice, int quantity, double totalAmount) {
        this.id = IdGenerator.getNextOrderHistoryId();
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    public static OrderHistory of(int customerId, String customerName, String customerAddress,
                                  String productName, double productPrice, int quantity, double totalAmount) {
        return new OrderHistory(customerId, customerName, customerAddress, productName, productPrice, quantity, totalAmount);
    }
}
