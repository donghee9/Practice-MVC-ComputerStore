package com.example.computerstore.Service.Impl;

import com.example.computerstore.Exception.ProductMatchException;
import com.example.computerstore.Exception.AdminMatchException;
import com.example.computerstore.Model.Admin;
import com.example.computerstore.Model.Category;
import com.example.computerstore.Model.Product;
import com.example.computerstore.Service.AdminService;
import com.example.computerstore.Service.DataStore;
import com.example.computerstore.Service.Helper;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



public class AdminServiceImpl implements AdminService {
    public static List<Admin> adminList = new ArrayList<>();
    List<Category> categoryList = DataStore.getCategoryList();
    List<Product> productList = DataStore.getProductList();

    public AdminServiceImpl() {
        initializeList();
    }

    private void initializeList() {
        adminList.add(Admin.of("123", "123"));

    }

    @Override
    public  List<Category> getCategory() {
        return categoryList;
    }

    @Override
    public List<Product> getProductDetail(int categoryId) {
        List<Product> matchedProducts = new ArrayList<>();
        for (Product product : productList) {
            if (product.getCategoryId().getId() == categoryId) {
                matchedProducts.add(product);
            }
        }
        return matchedProducts;
    }

    @Override
    public void registerProduct(String inputId, String inputPw, Product product) throws AdminMatchException {
        if (!Helper.matchAdmin(inputId, inputPw)) {
            throw AdminMatchException.forId(inputId);
        } else {
            productList.add(product);
        }
    }
 @Override
    public void updateProductPrice(String inputId, String inputPw, String productName, double newPrice) throws ProductMatchException, AdminMatchException {
        if (!Helper.matchAdmin(inputId, inputPw)) {
            throw AdminMatchException.forId(inputId);
        }

        Optional<Product> optionalProduct = Helper.isFindProductByName(productName);
        if (optionalProduct.isPresent()) {
            optionalProduct.get().setPrice(newPrice);
        } else {
            throw ProductMatchException.forName(productName);
        }
    }

    @Override
    public void deleteProduct(String inputId, String inputPw, String productName) throws ProductMatchException, AdminMatchException {
        if (!Helper.matchAdmin(inputId, inputPw)) {
            throw AdminMatchException.forId(inputId);
        }

        Optional<Product> optionalProduct = Helper.isFindProductByName(productName);
        if (optionalProduct.isPresent()) {
            productList.remove(optionalProduct.get());
        } else {
            throw ProductMatchException.forName(productName);
        }
    }
}