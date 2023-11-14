package com.example.computerstore.Service;

import com.example.computerstore.Model.Admin;
import com.example.computerstore.Model.Category;
import com.example.computerstore.Model.Customer;
import com.example.computerstore.Model.Product;


import java.util.List;
import java.util.Optional;


import static com.example.computerstore.Service.Impl.AdminServiceImpl.adminList;

import static com.example.computerstore.Service.Impl.ClientServiceImpl.customerList;



public class Helper {
    static List<Category> categoryList = DataStore.getCategoryList();
    static List<Product> productList = DataStore.getProductList();

    public static boolean matchAdmin(String inputId, String inputPw) {
        boolean matched = idAndPwCheck(inputId, inputPw);
        return matched;
    }
    public static boolean idAndPwCheck(String inputId, String inputPw) {
        for (Admin admin : adminList) {
            if (admin.getId().equals(inputId) && admin.getPw().equals(inputPw)) {
                return true;
            }
        }
        return false;
    }
    public static Optional<Customer> matchCertifiedUser(String userId, String userPw) {
        return findCustomerByCredentials(userId, userPw);
    }

    private static Optional<Customer> findCustomerByCredentials(String userId, String userPw) {
        for (Customer customer : customerList) {
            if (customer.getUserId().equals(userId) && customer.getPw().equals(userPw)) {
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

    public static Optional<Product> isFindProductByName(String productName) {
        for (Product product : productList) {
            if (product.getName().equals(productName)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public static Optional<Product> isFindProductById(int productId) {
        for (Product product : productList) {
            if (product.getId() == productId) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public static Optional<Category> isFindCategoryById(int categoryId) {
        for (Category category : categoryList) {
            if (category.getId() == categoryId) {
                return Optional.of(category);
            }
        }
        return Optional.empty();
    }


}



