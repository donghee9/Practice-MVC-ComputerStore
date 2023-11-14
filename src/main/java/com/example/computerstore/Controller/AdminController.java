package com.example.computerstore.Controller;
import com.example.computerstore.Exception.AdminMatchException;
import com.example.computerstore.Exception.InputException;
import com.example.computerstore.Exception.ProductMatchException;
import com.example.computerstore.Model.Category;
import com.example.computerstore.Model.Product;
import com.example.computerstore.Service.Impl.AdminServiceImpl;
import com.example.computerstore.Service.AdminService;


import java.util.Collections;
import java.util.List;


public class AdminController {
    private AdminService adminService;

    public AdminController() {
        this.adminService = new AdminServiceImpl();
    }

    public List<Category> showCategories() {
        try {
            List<Category> categories = adminService.getCategory();
            return categories.isEmpty() ? Collections.emptyList() : categories;
        } catch (Exception e) {
            System.out.println("카테고리를 불러오는 중 오류가 발생했습니다: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<Product> showProductDetail(int categoryId) {
        try {
            List<Product> products = adminService.getProductDetail(categoryId);
            return products.isEmpty() ? Collections.emptyList() : products;
        } catch (Exception e) {
            System.out.println("상품 상세정보를 불러오는 중 오류가 발생했습니다: " + e.getMessage());
            return Collections.emptyList();
        }
    }


    public String registerProduct(String adminId, String adminPw, Product product) {
        try {
            if (adminId == null || adminId.trim().isEmpty() || adminPw == null || adminPw.trim().isEmpty() || product == null) {
                throw InputException.invalidInput();
            }

            adminService.registerProduct(adminId, adminPw, product);
            return "제품이 성공적으로 등록되었습니다.";
        } catch (AdminMatchException | InputException e) {
            return "제품 등록 실패: " + e.getMessage();
        }
    }

    public String updateProductPrice(String adminId, String adminPw, String productName, double newPrice) {
        try {
            if (adminId == null || adminId.trim().isEmpty() || adminPw == null || adminPw.trim().isEmpty() || productName == null || productName.trim().isEmpty() || newPrice < 0) {
                throw InputException.invalidInput();
            }

            adminService.updateProductPrice(adminId, adminPw, productName, newPrice);
            return "제품 가격이 업데이트되었습니다.";
        } catch (AdminMatchException | ProductMatchException | InputException e) {
            return "가격 업데이트 실패: " + e.getMessage();
        }
    }

    public String deleteProduct(String adminId, String adminPw, String productName) {
        try {
            if (adminId == null || adminId.trim().isEmpty() || adminPw == null || adminPw.trim().isEmpty() || productName == null || productName.trim().isEmpty()) {
                throw InputException.invalidInput();
            }

            adminService.deleteProduct(adminId, adminPw, productName);
            return "제품이 성공적으로 삭제되었습니다.";
        } catch (AdminMatchException | ProductMatchException | InputException e) {
            return "제품 삭제 실패: " + e.getMessage();
        }
    }
}

