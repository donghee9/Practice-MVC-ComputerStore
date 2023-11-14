package com.example.computerstore.Controller;

import com.example.computerstore.Exception.InputException;
import com.example.computerstore.Exception.ProductMatchException;
import com.example.computerstore.Model.*;
import com.example.computerstore.Service.DataStore;
import com.example.computerstore.Service.Impl.ClientServiceImpl;
import com.example.computerstore.Service.ClientService;
import com.example.computerstore.Exception.CertifiedUserException;


import java.util.List;

public class ClientController {
    private ClientService clientService;

    public ClientController() {
        this.clientService = new ClientServiceImpl();
    }

    public List showCategories() {
        try {
            List<Category> categories = DataStore.getCategoryList();
            if (categories.isEmpty()) {
                System.out.println("카테고리가 존재하지 않습니다.");
            }
            return categories;
        } catch (Exception e) {
            System.out.println("카테고리를 불러오는 중 오류가 발생했습니다: " + e.getMessage());
        }

        return null;
    }
        public List showProductDetail(int categoryId) {
            try {
                if (categoryId <= 0) {
                    throw InputException.invalidInput();
                }

                List<Product> products = clientService.getProductDetail(categoryId);
                if (products.isEmpty()) {
                    System.out.println("해당 카테고리에 상품이 없습니다.");
                }
                return products;
            } catch (Exception e) {
                System.out.println("상품 상세정보를 불러오는 중 오류가 발생했습니다: " + e.getMessage());
            }
            return null;
        }

        public String createUser(Customer customer) {
            try {
                // 고객 정보 검증
                if (customer == null || customer.getName() == null || customer.getName().trim().isEmpty()) {
                    throw InputException.invalidInput();
                }

                clientService.createUser(customer);
                return "고객 생성이 완료되었습니다.";
            } catch (Exception e) {
                return "고객 생성 실패: " + e.getMessage();
            }
        }

        public String createOrder(String userId, String userPw, int productId, int quantity) {
            try {
                // 주문 정보 검증
                if (userId == null || userId.trim().isEmpty() || userPw == null || userPw.trim().isEmpty() || productId <= 0 || quantity <= 0) {
                    throw InputException.invalidInput();
                }

                OrderHistory orderHistory = clientService.createOrder(userId, userPw, productId, quantity);
                return "제품 주문이 완료되었습니다. 주문 내역: " + orderHistory;
            } catch (CertifiedUserException | ProductMatchException | InputException e) {
                return "주문 실패: " + e.getMessage();
            }
        }
    }


