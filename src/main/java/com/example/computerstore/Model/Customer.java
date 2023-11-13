package com.example.computerstore.Model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Customer {
    private  int id;
    private  String name;
    private  String userId;
    private  String email;
    private  String pw;
    private String shippingAddress;

    public Customer(String name, String userId, String email, String pw, String shippingAddress) {
        this.id = IdGenerator.getNextCustomerId();
        this.userId=userId;
        this.name = name;
        this.email = email;
        this.pw = pw;
        // 추후에 bcrypt화 시킬예정
        this.shippingAddress = shippingAddress;
    }


    public static Customer of(String name,String userId, String email, String pw, String shippingAddress) {
        return new Customer(name, userId,email, pw, shippingAddress);
    }
}
