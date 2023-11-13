package com.example.computerstore.Controller;

import com.example.computerstore.Exception.ProductMatchException;
import com.example.computerstore.Model.*;
import com.example.computerstore.Service.Impl.ClientServiceImpl;
import com.example.computerstore.Service.ClientService;
import com.example.computerstore.Exception.CertifiedUserException;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class ClientController {
    private ClientService clientService;

    public ClientController() {
        this.clientService = new ClientServiceImpl();
    }

    public String showCategories() {
        try {
            List<Category> categories = clientService.getCategory();
            if (categories.isEmpty()) {
                return "카테고리가 존재하지 않습니다.";
            }
            return categories.toString();
        } catch (Exception e) {
            return "카테고리를 불러오는 중 오류가 발생했습니다: " + e.getMessage();
        }
    }


    public String showProductDetail(int categoryId) {
        try {
            List<Product> products = clientService.getProductDetail(categoryId);

            if (products.isEmpty()) {
                return "해당 카테고리에 상품이 없습니다.";
            }
            return products.toString();
        } catch (Exception e) {
            return "상품 상세정보를 불러오는 중 오류가 발생했습니다: " + e.getMessage();
        }
    }
    public String createUser(Customer customer) {
        try {
            clientService.createUser(customer);
            return "고객 생성이 완료되었습니다.";
        } catch (Exception e) {
            return "고객 생성 실패: " + e.getMessage();
        }
    }

    public String createOrder(String userId, String userPw, int productId, int quantity) {
        try {
            OrderHistory orderHistory = clientService.createOrder(userId, userPw, productId, quantity);
            return "제품 주문이 완료되었습니다. 주문 내역: " + orderHistory;
        } catch (CertifiedUserException | ProductMatchException e) {
            return "주문 실패: " + e.getMessage();
        }
    }
}