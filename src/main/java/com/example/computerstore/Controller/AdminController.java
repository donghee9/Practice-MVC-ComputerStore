package com.example.computerstore.Controller;

import com.example.computerstore.Exception.AdminMatchException;
import com.example.computerstore.Exception.ProductMatchException;
import com.example.computerstore.Model.Admin;
import com.example.computerstore.Model.Product;
import com.example.computerstore.Service.Impl.AdminServiceImpl;
import com.example.computerstore.Service.AdminService;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {
    private AdminService adminService;

    public AdminController() {
        this.adminService = new AdminServiceImpl();
    }

    public String registerProduct(String adminId, String adminPw, Product product) {
        try {
            adminService.registerProduct(adminId, adminPw, product);
            return "제품이 성공적으로 등록되었습니다.";
        } catch (AdminMatchException e) {
            return "제품 등록 실패: " + e.getMessage();
        }
    }

    public String updateProductPrice(String adminId, String adminPw, String productName, double newPrice) {
        try {
            adminService.updateProductPrice(adminId, adminPw, productName, newPrice);
            return "제품 가격이 업데이트되었습니다.";
        } catch (AdminMatchException | ProductMatchException e) {
            return "가격 업데이트 실패: " + e.getMessage();
        }
    }

    public String deleteProduct(String adminId, String adminPw, String productName) {
        try {
            adminService.deleteProduct(adminId, adminPw, productName);
            return "제품이 성공적으로 삭제되었습니다.";
        } catch (AdminMatchException | ProductMatchException e) {
            return "제품 삭제 실패: " + e.getMessage();
        }
    }
}

