package com.example.computerstore.Service;

import com.example.computerstore.Exception.ProductMatchException;
import com.example.computerstore.Exception.AdminMatchException;
import com.example.computerstore.Model.Product;

public interface AdminService {

    //추후 토큰 기능 추가 예정
    void registerProduct(String inputId,String inputPw,Product product) throws AdminMatchException;
    void updateProductPrice(String inputId,String inputPw,String productName,double newPrice) throws ProductMatchException, AdminMatchException;
    void deleteProduct(String inputId,String inputPw,String productName) throws  ProductMatchException, AdminMatchException;
}
