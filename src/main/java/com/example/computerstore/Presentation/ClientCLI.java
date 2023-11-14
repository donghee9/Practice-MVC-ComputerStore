package com.example.computerstore.Presentation;
import com.example.computerstore.Controller.ClientController;
import com.example.computerstore.Model.Category;
import com.example.computerstore.Model.Customer;
import com.example.computerstore.Model.Product;
import com.example.computerstore.Service.DataStore;
import com.example.computerstore.Service.Impl.DataStoreImpl;

import java.util.List;
import java.util.Scanner;


public class ClientCLI {
    private ClientController clientController;
    private Scanner scanner;

    List<Category> categoryList = DataStore.getCategoryList();

    public ClientCLI() {
        this.clientController = new ClientController();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\n1. 카테고리 보기");
            System.out.println("2. 고객 생성");
            System.out.println("3. 주문 생성");
            System.out.println("4. 종료");
            System.out.print("선택: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    viewCategories();
                    break;
                case 2:
                    createUser();
                    break;
                case 3:
                    createOrder();
                    break;
                case 4:
                    System.out.println("프로그램 종료");
                    return;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }



    private void viewCategories() {
        List<Category> categories = clientController.showCategories();
        if (categories.isEmpty()) {
            System.out.println("카테고리가 존재하지 않습니다.");
        } else {
            System.out.println("카테고리 목록:");
            for (Category category : categories) {
                System.out.println("- id=" + category.getId() + ", " + category.getCategoryName());
            }
        }

        System.out.print("상품 상세정보를 보고 싶은 카테고리 번호를 입력하세요 (취소하려면 0을 입력): ");
        int categoryId = scanner.nextInt();

        if (categoryId > 0 && categoryId <= categories.size()) {
            List<Product> products = clientController.showProductDetail(categoryId);
            if (products.isEmpty()) {
                System.out.println("이 카테고리에는 상품이 없습니다.");
            } else {
                System.out.println("\n상품 목록:");
                System.out.println("---------------------------------------------------------");
                System.out.printf("%-3s %-10s %-15s %-10s %-10s\n", "ID", "제품명", "설명", "가격", "재고수량");
                System.out.println("---------------------------------------------------------");
                for (Product product : products) {
                    System.out.printf("%-3d %-10s %-15s %-10.2f %-10d\n",
                            product.getId(), product.getName(), product.getDescription(),
                            product.getPrice(), product.getStockQuantity());
                }
                System.out.println("---------------------------------------------------------");
            }
        } else if (categoryId != 0) {
            System.out.println("잘못된 카테고리 번호입니다.");
        }
    }



    private void createUser() {
        scanner.nextLine();
        System.out.print("이름: ");
        String name = scanner.nextLine();

        System.out.print("이메일: ");
        String email = scanner.nextLine();

        System.out.println("ID: ");
        String userId=scanner.nextLine();

        System.out.print("비밀번호: ");
        String pw = scanner.nextLine();

        System.out.print("주소: ");
        String shippingAddress = scanner.nextLine();

        Customer customer = new Customer(name,userId,email,pw,shippingAddress);
        String response = clientController.createUser(customer);
        System.out.println(response);
    }

    private void createOrder() {
        System.out.print("사용자 ID: ");
        String userId = scanner.next();

        System.out.print("비밀번호: ");
        String userPw = scanner.next();

        System.out.print("제품 ID: ");
        int productId = scanner.nextInt();

        System.out.print("수량: ");
        int quantity = scanner.nextInt();

        String response = clientController.createOrder(userId, userPw, productId, quantity);
        System.out.println(response);
    }

    public static void main(String[] args) {
        new ClientCLI().run();
    }
}