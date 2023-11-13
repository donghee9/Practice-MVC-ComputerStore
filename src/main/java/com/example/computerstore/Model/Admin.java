package com.example.computerstore.Model;

import lombok.Getter;

@Getter
public class Admin {
    private String id;
    private String pw;

    private Admin (String id,String pw){
        this.id=id;
        this.pw=pw;
    }
    public static Admin of(String id,String pw){
        return new Admin(id, pw);
    }
}
