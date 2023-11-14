package com.example.computerstore.Model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
public class Order {
    private UUID id;
    private Product orderedProduct;
    private int quantity;
    private Customer customer;
    private double totalAmount;
    private Status status;
    private Timestamp orderDate;

    private Order(Product orderedProduct, int quantity, Customer customer, Status status) {
        this.id = UUID.randomUUID();
        this.orderedProduct = orderedProduct;
        this.quantity = quantity;
        this.customer = customer;
        this.totalAmount = calculateTotalAmount();
        this.status = status;
        this.orderDate = new Timestamp(System.currentTimeMillis());
    }

    public static Order of(Product orderedProduct, int quantity, Customer customer, Status status) {
        return new Order(orderedProduct, quantity, customer, status);
    }

    private double calculateTotalAmount() { // 메서드 이름 변경
        return this.quantity * this.orderedProduct.getPrice();
    }
}
