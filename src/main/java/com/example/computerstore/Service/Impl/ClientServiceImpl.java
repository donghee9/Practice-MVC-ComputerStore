package com.example.computerstore.Service.Impl;
import com.example.computerstore.Exception.CertifiedUserException;
import com.example.computerstore.Exception.ProductMatchException;
import com.example.computerstore.Model.*;
import com.example.computerstore.Service.ClientService;
import com.example.computerstore.Service.DataStore;
import com.example.computerstore.Service.Helper;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



public class ClientServiceImpl implements ClientService {
    public static List<Customer> customerList = new ArrayList<>();
    List<Category> categoryList = DataStore.getCategoryList();
    List<Product> productList = DataStore.getProductList();
    public static List<Order> orderList=new ArrayList<>();
    public static List<OrderHistory>orderHistoryList=new ArrayList<>();

    public ClientServiceImpl() {
        initializeList();
    }

    private void initializeList() {
        customerList.add(Customer.of("seo", "sdh", "seo12@naver.com", "12345", "경기도 성남시 분당구 판교로"));

    }


    @Override
    public List<Category> getCategory() {
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
    public void createUser(Customer customer) {
        customerList.add(customer);
    }
    @Override
    public OrderHistory createOrder(String userId, String userPw, int productId, int quantity)
            throws CertifiedUserException, ProductMatchException {

        Optional<Customer> optionalCustomer = Helper.matchCertifiedUser(userId, userPw);
        if (!optionalCustomer.isPresent()) {
            throw CertifiedUserException.forUserId(userId);
        }
        Customer customer = optionalCustomer.get();

        Optional<Product> optionalProduct = Helper.isFindProductById(productId);
        if (!optionalProduct.isPresent()) {
            throw ProductMatchException.forId(productId);
        }
        Product product = optionalProduct.get();

        if (quantity > product.getStockQuantity()) {
            throw ProductMatchException.stockShortage(productId, quantity, product.getStockQuantity());
        }

        Order newOrder = Order.of(product, quantity, customer, Status.PENDING);
        orderList.add(newOrder);

        int newStockQuantity = product.getStockQuantity() - quantity;
        product.setStockQuantity(newStockQuantity);

        OrderHistory newOrderHistory = OrderHistory.of(customer.getId(), customer.getName(),
                customer.getShippingAddress(), product.getName(),
                product.getPrice(), quantity, newOrder.getTotalAmount());
        orderHistoryList.add(newOrderHistory);

        return newOrderHistory;
    }


}

