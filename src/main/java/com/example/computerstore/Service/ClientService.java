package com.example.computerstore.Service;

import com.example.computerstore.Exception.CertifiedUserException;
import com.example.computerstore.Exception.ProductMatchException;
import com.example.computerstore.Model.Category;
import com.example.computerstore.Model.Customer;
import com.example.computerstore.Model.OrderHistory;
import com.example.computerstore.Model.Product;

import java.util.List;

public interface ClientService {
 List<Category> getCategory();
 List<Product> getProductDetail(int categoryId);
 void createUser(Customer customer);

 OrderHistory createOrder(String userId, String userPw, int productId, int quantity) throws CertifiedUserException, ProductMatchException;


}
