package com.example.computerstore;

import com.example.computerstore.Presentation.AdminCLI;
import com.example.computerstore.Presentation.ClientCLI;
import java.util.Scanner;

public class ComputerStoreApplication {

    public static void main(String[] args) {
        runCLI();
    }

    private static void runCLI() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nWelcome to Computer Store Application");
            System.out.println("1. Admin Interface");
            System.out.println("2. Client Interface");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    AdminCLI adminCLI = new AdminCLI();
                    adminCLI.run();
                    break;
                case 2:
                    ClientCLI clientCLI = new ClientCLI();
                    clientCLI.run();
                    break;
                case 3:
                    System.out.println("Exiting the application...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
