package com.example.computerstore.Service;

import com.example.computerstore.Model.Category;
import com.example.computerstore.Model.Product;
import com.example.computerstore.Service.Impl.DataStoreImpl;

import java.util.List;

public interface  DataStore {

    static List<Category> getCategoryList() {
        return DataStoreImpl.getInternalCategoryList();
    }

    static List<Product> getProductList() {
        return DataStoreImpl.getInternalProductList();
    }

    void initializeCategories();

    void initializeProducts();

}
