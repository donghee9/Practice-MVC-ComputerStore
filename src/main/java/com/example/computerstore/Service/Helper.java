package com.example.computerstore.Service;

import com.example.computerstore.Model.Admin;
import com.example.computerstore.Model.Category;
import com.example.computerstore.Model.Customer;
import com.example.computerstore.Model.Product;
import com.example.computerstore.Service.Impl.AdminServiceImpl;

import static com.example.computerstore.Service.Impl.AdminServiceImpl.adminList;
import static com.example.computerstore.Service.Impl.AdminServiceImpl.productList;
import static com.example.computerstore.Service.Impl.ClientServiceImpl.customerList;

public class Helper {

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

    public static Customer matchCertifiedUser(String userId, String userPw) {
        Customer matchedCustomer = findCustomerByCredentials(userId, userPw);
        return matchedCustomer;
    }

    private static Customer findCustomerByCredentials(String userId, String userPw) {
        for (Customer customer : customerList) {
            if (customer.getUserId().equals(userId) && customer.getPw().equals(userPw)) {
                return customer;
            }
        }
        return null;
    }


    public static Product isFindProductByName(String productName) {
        for (Product product : productList) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }
    public static Product isFindProductById(int productId) {
        for (Product product : productList) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    public static Category isFindCategoryById(int categoryId) {
        for (Category category : AdminServiceImpl.categoryList) {
            if (category.getId() == categoryId) {
                return category;
            }
        }
        return null;
    }

}


