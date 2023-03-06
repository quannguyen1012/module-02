package org.example;

import java.util.Date;
import java.util.HashMap;

public class Invoice {

    private String invoiceID;
    private String customerID;
    private Date date;
    private HashMap<String,Integer> products;

    public Invoice(String invoiceID, String customerID, Date date,HashMap<String,Integer> products) {
        this.invoiceID = invoiceID;
        this.customerID = customerID;
        this.date = date;
        this.products = products;

    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public HashMap<String, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<String, Integer> products) {
        this.products = products;
    }
    public String getNameCustomer() {
        CustomerManager customerManager = new CustomerManager();
        Customer customer = customerManager.searchByID(customerID);
        if(this.customerID.equals(customer.getCusID())) {
            String name = customer.getName();
            return name;
        }
        return null;
    }
    public double getSubTotal(String productID, int quantity) {
        ProductManagement productManagement =new ProductManagement();
        Product p = productManagement.searchByID(productID);
        double price = p.getPrice();
        return price*quantity;
    }
    public double getTotal(){
        double total = 0.0;
        for (String productID: products.keySet()) {
            int quantity = products.get(productID);
            total += getSubTotal(productID,quantity);
        }
        return total;
    }
    public String displayAll(){
        ProductManagement productManagement =new ProductManagement();
        String sout = "";
        sout = "Invoice Number: " + this.invoiceID+"\n"
                + "Customer: " + getNameCustomer() +"\n"
                +"Date: " +this.date + "\n";
        sout += "======="+"\n";
        for (String productID: products.keySet()) {
            Product p  = productManagement.searchByID(productID);
            int quantity = products.get(productID);
            sout += p.getName()+" - " +p.getPrice()+"$ - "+"SL: "+quantity+" - "+getSubTotal(productID,quantity) + "$" + "\n";
        }
        sout += "======="+"\n";
        sout += "Total: " +getTotal()+"$\n\n";
        return sout;
    }

}
