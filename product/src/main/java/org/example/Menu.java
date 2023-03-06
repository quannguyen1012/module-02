package org.example;

import java.util.Scanner;

public abstract class Menu implements Managable {
    public void showMenu(String displayMenu) {
        System.out.println("======"+displayMenu+"=======");
        System.out.println("1.Add : ");
        System.out.println("2.Update :");
        System.out.println("3.Search: ");
        System.out.println("4.Remove :");
        System.out.println("5.Display: ");
        System.out.println("0.Exit:");
        System.out.println("======"+displayMenu+"========");
        System.out.println("Select option: ");
    }


    public void menu(String displayMenu) {
        String option = "-1";


        while (!option.equals("0")) {
            showMenu(displayMenu);
            Scanner sc = new Scanner(System.in);
            option = sc.nextLine();
            switch (option) {
                case "1":
                    add();
                    break;
                case "2":
                    update();
                    break;
                case "3":
                    search();
                    break;
                case "4":
                    remove();
                    break;
                case "5":
                    displayAll();
                    break;
                default:
                    System.out.println("Please choice again");
            }
        }
    }
}
