package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void showMenu() {
        System.out.println("1. Product Management");
        System.out.println("2. Customer Management");
        System.out.println("3. Invoice Management");
        System.out.println("0. exit");
        System.out.println("Enter option: ");
    }

    public static void menu() {

        Managable productManagement = new ProductManagement();
        Managable customerManagement = new CustomerManager();
        Managable invoiceManagement = new InvoiceManagement();

        String option = "";
        Scanner scanner = new Scanner(System.in);
        while (!option.equals("0")) {
            showMenu();
            option = scanner.next();
            scanner.nextLine();
            switch (option) {
                case "1":
                    productManagement.menu("Product Management");
                    break;
                case "2":
                    customerManagement.menu("Customer Management");
                    break;
                case "3":
                    invoiceManagement.menu("Invoice Management");
                    break;
                case "0":
                    System.exit(0);
                default:
                    System.out.println("The word entered is incorrect, please re-enter");
                    break;
            }
        }
    }
}