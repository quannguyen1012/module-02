package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerManager extends Menu implements Managable{
    List<Customer> customers;

    public CustomerManager(){
        customers = new ArrayList<>();
        Customer customer1 =new Customer("cus001","Nguyen Van Linh","0932631603","163 Quang Trung");
        Customer customer2 =new Customer("cus002","Thuận","0932631606","5 Tân Sơn");
        Customer customer3 =new Customer("cus003","Tính","1651665615","15 Kha Vạn Cân");
        Customer customer4 =new Customer("cus004","Tiên","0932631603","80 Tân Kỳ Tân Quý");

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
    }

    public Customer input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Customer ID: ");
        String customerID = scanner.nextLine();
        System.out.println("Input Customer Name: ");
        String name = scanner.nextLine();
        System.out.println("Input Customer Phone: ");
        String phone = scanner.nextLine();
        System.out.println("Input Customer Address : ");
        String address = scanner.nextLine();

        Customer newCustomer = new Customer(customerID,name,phone,address);
        return newCustomer;
    }
    @Override
    public void add() {
        Customer newCustomer = input();
        customers.add(newCustomer);
    }
    public Customer searchByID(String searchID) {
        for (Customer customer: customers) {
            if(customer.getCusID().equals(searchID)){
                return customer;
            }
        }
        return null;
    }
    @Override
    public void search() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input id to search: ");
        String searchID = scanner.next();

        Customer searchCustomer =searchByID(searchID);
        if (searchCustomer!=null){
            System.out.println(searchCustomer);

        }
        else
            System.out.println("Customer not found");
    }

    @Override
    public void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input id to update: ");
        String updateID = scanner.next();

        Customer updateCustomer = searchByID(updateID);
        if (updateCustomer!=null){
            System.out.println("Please enter new name: ");
            String newName = scanner.nextLine();
            updateCustomer.setName(newName);
            System.out.println(updateCustomer);
        }
        else
            System.out.println("Customer not found");
    }

    @Override
    public void remove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input id to remove: ");
        String removeID = scanner.next();

        Customer removeCustomer = searchByID(removeID);
        if (removeCustomer!=null){
            customers.remove(removeCustomer);
        }
        else
            System.out.println("Customer not found");
    }

    @Override
    public void displayAll() {
        for (Customer c:customers) {
            System.out.println(c);
        }
    }

}
