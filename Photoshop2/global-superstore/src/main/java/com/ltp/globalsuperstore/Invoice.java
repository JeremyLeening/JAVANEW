package com.ltp.globalsuperstore;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Invoice {
    public String invoiceNumber;
    public Customer customer;
    public Basket basket;
    public String name;
    public String address;
    public String postalCode;
    public String city;
    public String email;
    public String phone;
    
    
    public Invoice(String invoiceNumber, String name, String address, String city, String postalCode, String phone, String email, Basket basket) {
        this.invoiceNumber = invoiceNumber;
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.email = email;
        this.phone = phone;
        this.basket = basket;
    }
    
    public void generateInvoiceFile() {
        try {
            // create a new file named "invoicenumber.txt"
            File invoiceFile = new File(this.invoiceNumber+".txt");
            
            // create a new FileWriter object to write to the file
            FileWriter fw = new FileWriter(invoiceFile);
            
            // create a new BufferedWriter object to write to the file
            BufferedWriter bw = new BufferedWriter(fw);
            
            // write the contents of the invoice to the file
            bw.write("Invoice Number: " + invoiceNumber + "\n\n");
            bw.write("Customer:\n" + this.name + "\n"
                                    + this.address + "\n"
                                    + this.postalCode + "\n"
                                    + this.city + "\n"
                                    + this.email + "\n"
                                    + this.phone + "\n");
            bw.write("\nYour order will take ");
            basket.writeTotalWorkHours(bw);
            bw.write(" hours to complete\n");
            bw.write("\nYou can pick your order up on: ");
            basket.writePickupTime(bw);
            bw.write("\n\nOrder Details:\n");
            basket.writeBasket(bw);
            bw.write("\nYour total price comes out to:                 ");
            basket.writeTotalPrice(bw);
           
            
            
            // close the BufferedWriter object
            bw.close();
            
            System.out.println("Invoice file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}