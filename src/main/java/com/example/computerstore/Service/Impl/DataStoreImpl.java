package com.example.computerstore.Service.Impl;

import com.example.computerstore.Model.Category;
import com.example.computerstore.Model.Product;
import com.example.computerstore.Service.DataStore;

import java.util.ArrayList;
import java.util.List;

public class DataStoreImpl implements DataStore {

        private static final List<Category> categoryList = new ArrayList<>();
        private static final List<Product> productList = new ArrayList<>();

    static {
        initializeStaticCategories();
        initializeStaticProducts();
    }


    private static void initializeStaticCategories() {
            categoryList.add(Category.of("키보드,마우스"));
            categoryList.add(Category.of("모니터"));
            categoryList.add(Category.of("저장장치"));
            categoryList.add(Category.of("노트북"));
            categoryList.add(Category.of("액세서리"));
        }


    private static void initializeStaticProducts() {

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


        Category laptopCategory = categoryList.get(3);
        productList.add(Product.of(laptopCategory, "울트라북", "휴대성이 뛰어난 울트라북", 1500000, 10));
        productList.add(Product.of(laptopCategory, "게이밍 노트북", "강력한 성능의 게이밍 노트북", 2500000, 5));
        productList.add(Product.of(laptopCategory, "2-in-1 노트북", "변형 가능한 2-in-1 노트북", 1200000, 15));


        Category accessoryCategory = categoryList.get(4);
        productList.add(Product.of(accessoryCategory, "헤드셋", "고음질 헤드셋", 100000, 50));
        productList.add(Product.of(accessoryCategory, "마우스 패드", "사용감 좋은 마우스 패드", 20000, 100));
        productList.add(Product.of(accessoryCategory, "키보드 커버", "키보드 보호 커버", 15000, 150));
    }

    @Override
    public void initializeCategories() {

    }

    @Override
    public void initializeProducts() {

    }
    public static List<Category> getInternalCategoryList() {
        return categoryList;
    }

    public static List<Product> getInternalProductList() {
        return productList;
    }
}
