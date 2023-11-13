package com.example.computerstore.Service.Impl;

import com.example.computerstore.Exception.ProductMatchException;
import com.example.computerstore.Exception.AdminMatchException;
import com.example.computerstore.Model.Admin;
import com.example.computerstore.Model.Category;
import com.example.computerstore.Model.Product;
import com.example.computerstore.Service.AdminService;
import com.example.computerstore.Service.Helper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.computerstore.Service.Helper.isFindProductByName;
@Service
public class AdminServiceImpl implements AdminService {
    public static List<Admin> adminList = new ArrayList<>();
    public static List<Category> categoryList = new ArrayList<>();
    public static List<Product> productList = new ArrayList<>();

    public AdminServiceImpl() {
        initializeList();
    }

    private void initializeList() {
        adminList.add(Admin.of("123", "123"));

        categoryList.add(Category.of("키보드,마우스"));
        categoryList.add(Category.of("모니터"));
        categoryList.add(Category.of("저장장치"));

        Category keyboardMouseCategory = categoryList.get(0);
        productList.add(Product.of(keyboardMouseCategory, "게이밍 키보드", "고성능 게이밍 키보드", 99900, 50));
        productList.add(Product.of(keyboardMouseCategory, "무선 마우스", "편리한 사용감의 무선 마우스", 49900, 100));
        productList.add(Product.of(keyboardMouseCategory, "기계식 키보드", "내구성 높은 기계식 키보드", 129000, 30));


        Category monitorCategory = categoryList.get(1);
        productList.add(Product.of(monitorCategory, "4K 모니터", "고해상도 4K 모니터", 299000, 30));
        productList.add(Product.of(monitorCategory, "게이밍 모니터", "빠른 응답속도의 게이밍 모니터", 350000, 20));
        productList.add(Product.of(monitorCategory, "IPS 모니터", "넓은 시야각의 IPS 모니터", 200000, 40));


        Category storageCategory = categoryList.get(2);
        productList.add(Product.of(storageCategory, "SSD 1TB", "고속 SSD 1TB", 149000, 100));
        productList.add(Product.of(storageCategory, "외장 하드 2TB", "대용량 외장 하드 2TB", 99000, 60));
        productList.add(Product.of(storageCategory, "USB 메모리 128GB", "휴대성 좋은 USB 메모리 128GB", 29000, 200));
    }


    @Override
    public void registerProduct(String inputId, String inputPw, Product product) throws AdminMatchException {
        if (!Helper.matchAdmin(inputId , inputPw)) {
            throw AdminMatchException.forId(inputId);
        } else {
            productList.add(product);
        }
    }

    public void updateProductPrice(String inputId, String inputPw, String productName, double newPrice) throws ProductMatchException , AdminMatchException{
        if (!Helper.matchAdmin(inputId, inputPw)) {
            throw AdminMatchException.forId(inputId);
        }

        Product productToUpdate = Helper.isFindProductByName(productName);
        if (productToUpdate != null) {
            productToUpdate.setPrice(newPrice);
        } else {
            throw  ProductMatchException.forName(productName);
        }
    }

    @Override
    public void deleteProduct(String inputId, String inputPw, String productName) throws ProductMatchException,AdminMatchException {
        if (!Helper.matchAdmin(inputId, inputPw)) {
            throw  AdminMatchException.forId(inputId);
        }

        Product productToDelete = isFindProductByName(productName);
        if (productToDelete != null) {
            productList.remove(productToDelete);
        } else {
            throw ProductMatchException.forName(productName);
        }
    }
}
