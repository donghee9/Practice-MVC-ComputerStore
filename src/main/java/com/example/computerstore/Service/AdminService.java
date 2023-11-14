package com.example.computerstore.Service;

import com.example.computerstore.Exception.ProductMatchException;
import com.example.computerstore.Exception.AdminMatchException;
import com.example.computerstore.Model.Category;
import com.example.computerstore.Model.Product;

import java.util.List;

public interface AdminService {
      List<Category> getCategory();

      List<Product> getProductDetail(int categoryId);

    void registerProduct(String inputId,String inputPw,Product product) throws AdminMatchException;
    void updateProductPrice(String inputId,String inputPw,String productName,double newPrice) throws ProductMatchException, AdminMatchException;
    void deleteProduct(String inputId,String inputPw,String productName) throws  ProductMatchException, AdminMatchException;
}
