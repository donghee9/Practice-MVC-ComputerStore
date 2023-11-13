package com.example.computerstore.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
public class Product {
    private int id;
    private  Category categoryId;

    private String name;
    private String description;
    private double price;
    private int stockQuantity;

    private Product(Category categoryId,String name,String description,double price,int stockQuantity){
        this.id=IdGenerator.getNextProductId();
        this.categoryId=categoryId;
        this.name=name;
        this.description=description;
        this.price=price;
        this.stockQuantity=stockQuantity;
    }
    public static Product of(Category categoryId, String name, String description, double price, int stockQuantity){
        return new Product(categoryId, name, description, price, stockQuantity);
    }



}
