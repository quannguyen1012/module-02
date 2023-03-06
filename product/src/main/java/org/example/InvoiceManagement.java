package org.example;

import java.io.FileWriter;
import java.util.*;

public class InvoiceManagement extends Menu implements Managable {
    List<Invoice> invoices;


    public InvoiceManagement(){
        invoices = new ArrayList<>();

    }
    public Invoice input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Invoice ID: ");
        String invoiceID = scanner.nextLine();
        System.out.println("Enter Customer ID: ");
        String customerID = scanner.nextLine();
        Date date = new Date();
        HashMap<String, Integer> products = new HashMap<>();

        String productID ="";
        do {
            System.out.println("Enter ProductID:");
            productID = scanner.nextLine();
            if(productID != "") {
                System.out.println("Enter Product Number: ");
                Integer number = scanner.nextInt();
                scanner.nextLine();
                products.put(productID, number);
            }
        }while (productID !="");

        Invoice invoice1 = new Invoice(invoiceID,customerID,date,products);
        return invoice1;
    }
    public void add(){
        try {
            Invoice newInvoice = input();
            invoices.add(newInvoice);
            FileWriter newFile = new FileWriter(newInvoice.getInvoiceID(),true);
            newFile.write(newInvoice.displayAll());
            newFile.close();
        }catch (Exception e){
            System.err.println(e);
        }


    }
    public Invoice searchById(String searchID) {
        for (Invoice inv: invoices) {
            if(inv.getInvoiceID().equals(searchID)){
                return inv;
            }
        }
        return null;
    }
    public void search() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input id to search: ");
        String searchID = scanner.next();

        Invoice searchInvoice =searchById(searchID);
        if (searchInvoice!=null){
            System.out.println(searchInvoice);

        }
        else
            System.out.println("Invoice not found");
    }

    @Override
    public void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input id to update: ");
        String updateID = scanner.next();

        Invoice updateInvoice = searchById(updateID);
        if (updateInvoice!=null){
            System.out.println("Please enter new ID : ");
            String newCustomerID = scanner.nextLine();
            updateInvoice.setCustomerID(newCustomerID);
            System.out.println(updateInvoice);
        }
        else
            System.out.println("Invoice not found");
    }

    @Override
    public void remove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input id to remove: ");
        String removeID = scanner.next();

        Invoice removeInvoice = searchById(removeID);
        if (removeInvoice!=null){
            invoices.remove(removeInvoice);
        }
        else
            System.out.println("Invoice not found");
    }

    public void displayAll() {
        for (Invoice inv: invoices) {
            System.out.println(inv.displayAll());
        }
    }

}
