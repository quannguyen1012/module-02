package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManagement extends Menu implements Managable {
    List<Product> products;


    public ProductManagement() {
        products = new ArrayList<>();

        Product product1 =  new Product("p0001","Bánh gạo",15.2,true);
        Product product2 =  new Product("p0002","Kem",5.5,true);
        Product product3 =  new Product("p0003","Trái cây",6.9,true);
        Product product4 =  new Product("p0004","Nước",2.5,true);

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
    }
    public Product input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Product ID: ");
        String productID = scanner.nextLine();
        System.out.println("Input Product Name: ");
        String name = scanner.nextLine();
        System.out.println("Input Product Price: ");
        Double price = scanner.nextDouble();
        System.out.println("Input Product Price: ");
        Boolean status = true;

        Product newProduct = new Product(productID,name,price,status);
        return newProduct;
    }

    @Override
    public void add() {
        Product newProduct = input();
        products.add(newProduct);
    }

    @Override
    public void search() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input id to search: ");
        String searchID = scanner.next();

        Product searchProduct = searchByID(searchID);
        if (searchProduct!=null)
            System.out.println(searchProduct);
        else
            System.out.println("Product not found");
    }

    public Product searchByID(String searchID){
        for (Product p: products) {
            if(p.getProductID().equals(searchID)){
                return p;
            }
        }
        return null;
    }

    @Override
    public void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input id to update: ");
        String updateID = scanner.next();

        Product updateProduct = searchByID(updateID);
        if (updateProduct!=null){
            System.out.println("Please enter new name: ");
            String newName = scanner.nextLine();
            updateProduct.setName(newName);
            System.out.println(updateProduct);
        }
        else
            System.out.println("Product not found");
    }

    @Override
    public void remove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input id to remove: ");
        String removeID = scanner.next();
        Product removeProduct = searchByID(removeID);
        if (removeProduct != null){
            products.remove(removeProduct);
        }
        else
            System.out.println("Product not found");
    }

    @Override
    public void displayAll() {
        for (Product p: products) {
            System.out.println(p);
        }
    }
}
