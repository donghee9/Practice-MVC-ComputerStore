package com.example.computerstore.Presentation;
import com.example.computerstore.Controller.AdminController;
import com.example.computerstore.Model.Category;
import com.example.computerstore.Model.Product;
import com.example.computerstore.Service.DataStore;
import com.example.computerstore.Service.Helper;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AdminCLI {
    private AdminController adminController;
    private Scanner scanner;

    public AdminCLI() {
        this.adminController = new AdminController();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        showProductListByCategory();
        while (true) {
            System.out.println("\n1. 제품 등록");
            System.out.println("2. 제품 가격 수정");
            System.out.println("3. 제품 삭제");
            System.out.println("4. 종료");
            System.out.print("선택: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerProduct();
                    break;
                case 2:
                    updateProductPrice();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    System.out.println("프로그램 종료");
                    return;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }

    private void showProductListByCategory() {
        List<Category> categories = adminController.showCategories();
        if (categories.isEmpty()) {
            System.out.println("카테고리가 존재하지 않습니다.");
            return;
        }

        for (Category category : categories) {
            System.out.println("-" + category.getId() + " " + category.getCategoryName());
            List<Product> products = adminController.showProductDetail(category.getId());
            if (products.isEmpty()) {
                System.out.println("   이 카테고리에는 상품이 없습니다.");
                continue;
            }

            System.out.println("--------------------------------------------------------------");
            System.out.printf("%-3s %-10s %-15s %-10s %-10s\n", "ID", "제품명", "설명", "가격", "재고수량");
            System.out.println("---------------------------------------------------------");
            for (Product product : products) {
                System.out.printf("%-3d %-10s %-15s %-10.2f %-10d\n",
                        product.getId(), product.getName(), product.getDescription(),
                        product.getPrice(), product.getStockQuantity());
            }
            System.out.println("--------------------------------------------------------------");
        }
    }

        private void registerProduct() {
        System.out.print("관리자 ID: ");
        String adminId = scanner.nextLine();

        System.out.print("관리자 비밀번호: ");
        String adminPw = scanner.nextLine();

        System.out.print("카테고리 ID: ");
        int categoryId = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기


        Optional<Category> optionalCategory = Helper.isFindCategoryById(categoryId);
        if (!optionalCategory.isPresent()) {
            System.out.println("해당 ID를 가진 카테고리가 존재하지 않습니다.");
            return;
        }
        Category category = optionalCategory.get();

        System.out.print("제품 이름: ");
        String name = scanner.nextLine();

        System.out.print("제품 설명: ");
        String description = scanner.nextLine();

        System.out.print("가격: ");
        double price = scanner.nextDouble();

        System.out.print("재고 수량: ");
        int stockQuantity = scanner.nextInt();
        scanner.nextLine();

        Product product = Product.of(category, name, description, price, stockQuantity);

        String response = adminController.registerProduct(adminId, adminPw, product);
        System.out.println(response);
    }


    private void updateProductPrice() {
        System.out.print("관리자 ID: ");
        String adminId = scanner.nextLine();

        System.out.print("관리자 비밀번호: ");
        String adminPw = scanner.nextLine();

        System.out.print("제품 이름: ");
        String productName = scanner.nextLine();

        System.out.print("새 가격: ");
        double newPrice = scanner.nextDouble();
        scanner.nextLine(); // 버퍼 비우기

        String response = adminController.updateProductPrice(adminId, adminPw, productName, newPrice);
        System.out.println(response);
    }

    private void deleteProduct() {
        System.out.print("관리자 ID: ");
        String adminId = scanner.nextLine();

        System.out.print("관리자 비밀번호: ");
        String adminPw = scanner.nextLine();

        System.out.print("삭제할 제품 이름: ");
        String productName = scanner.nextLine();

        String response = adminController.deleteProduct(adminId, adminPw, productName);
        System.out.println(response);
    }

    public static void main(String[] args) {
        new AdminCLI().run();
    }
}