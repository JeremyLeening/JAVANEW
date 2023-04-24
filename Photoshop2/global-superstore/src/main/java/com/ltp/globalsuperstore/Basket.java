package com.ltp.globalsuperstore;

import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Basket {
    //Class which represents a basket in which products can be held with their quantities

    //Creating a storeProducts Object
    StoreProducts storeProducts = new StoreProducts();
    //Creating a Arraylist to store the products from the CSV file
    ArrayList<Product> productArray = storeProducts.populateStore("src/main/resources/PhotoShop_PriceList.csv");
    //Creating a storeTime Object
    StoreTime storeTime = new StoreTime();
    //Creating a Arraylist to store the times from the CSV file
    ArrayList<Open> openArray = storeTime.populateStore("src/main/resources/PhotoShop_OpeningHours.csv");
                    
    
    //ArrayList within ArrayList of products 
    ArrayList<ArrayList<Integer>> productBasket = new ArrayList<ArrayList<Integer>>();

    //Function to add a product and a quantity to the basket
    public void addToBasket(Item item) {
        ArrayList<Integer> order = new ArrayList<Integer>();
        order.add(item.getProduct());
        order.add(item.getQuantity());
        productBasket.add(order);

    }

    //Function to remove a product from the basket
    public void removeFromBasket(int orderId) {
        System.out.println("Order: "+ orderId + " with product ID: " + productBasket.get(orderId).get(0) + 
                           " and a quantitiy of: "+ productBasket.get(orderId).get(1) + " was removed from your order.");
        productBasket.remove(orderId);
        
    }
    
    //Function to show the basket
    public void showBasket(){
        for (int i = 0; i < productBasket.size(); i++) {
            for (int j = 0; j < productBasket.get(i).size(); j++) {
                if(j==0){
                    System.out.print("Order ID: ");
                    System.out.print(i + " ");
                    System.out.print("Product ID: ");
                    System.out.print(productBasket.get(i).get(j) + " ");
                }
                if(j==1){
                    System.out.print(" Quantity: ");
                    System.out.print(productBasket.get(i).get(j) + " ");
                }            
            }
            System.out.print(" Price: ");
            System.out.print(String.format("%.2f", (itemPrice(productBasket.get(i).get(0),productBasket.get(i).get(1)))) + " ");
            System.out.println();
        }
    }
    //Function to write the basket to a file
    public void writeBasket(BufferedWriter bw) throws IOException{
        for (int i = 0; i < productBasket.size(); i++) {
            for (int j = 0; j < productBasket.get(i).size(); j++) {
                if(j==0){
                    bw.write("Order ID: ");
                    bw.write(i + " ");
                    bw.write("Product ID: ");
                    bw.write(productBasket.get(i).get(j) + " ");
                }
                if(j==1){
                    bw.write(" Quantity: ");
                    bw.write(productBasket.get(i).get(j) + " ");
                }            
            }
            bw.write(" Price: ");
            bw.write(itemPrice(productBasket.get(i).get(0),productBasket.get(i).get(1)) + " ");
            bw.write("\n");
        }
    }
    // Function to return the time at wich the order will be ready
    public String pickupTime(){
        //Empty String Object to store the time at which the order will be ready
        String pickupTime = "";
        //LocalDateTime Object to store the system time 
        LocalDateTime now = LocalDateTime.now();
        //LocalDateTime Object to store the time at which the order will be ready 
        LocalDateTime pickup = now.plusHours(Double.valueOf(totalWorkHours()).longValue()); 
        //LocalTime Object to store the time at which the order will be ready 
        LocalTime target = pickup.toLocalTime();
        //DateTimeFormatter Object to format the data
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
        //Integer to store the index of the proposedPickUpDay
        int i = 0;   
        //String Object to store the day to check against
        String checkDay = openArray.get(i).getDayName().toLowerCase();
        //String Object to store the proposedPickUpDay
        String proposedPickUpDay = (pickup.getDayOfWeek().toString().toLowerCase());
        while(!checkDay.equals(proposedPickUpDay)){
            i++;
            checkDay = openArray.get(i).getDayName().toLowerCase();
            
        }

        while(true){ 
            LocalTime start = LocalTime.parse(openArray.get(i).getOpeningTime());
            LocalTime stop = LocalTime.parse(openArray.get(i).getClosingTime());
            Boolean check = (target.isAfter(start) && target.isBefore(stop));
            if(check){
                pickupTime = dtf.format(pickup);
                break;
            }
            
            else{
                if(i==0){
                    i = 1;
                }
                if(i==6){
                    i = 1;
                }
                String[] parts = openArray.get(i).getOpeningTime().split(":");
                    String hours = parts[0]; 
                    String minutes = parts[1];
                target = (pickup.plusDays(1).with(LocalTime.of(Integer.parseInt(hours), Integer.parseInt(minutes+1)))).toLocalTime();
                pickup = pickup.plusDays(1).with(LocalTime.of(Integer.parseInt(hours), Integer.parseInt(minutes)));
            } 
        
        }
        return pickupTime;  
        
    }
    //Function to write the pickup time to a file
    public void writePickupTime(BufferedWriter bw) throws IOException{
        bw.write(pickupTime());
    }

    //Function to return the price of a product by quantity
    public Double itemPrice(int item, int quantity){
        
        Double itemPrice = productArray.get(item-1).getProductPrice() * quantity;
        return itemPrice;
    }
    //Function to return the total price of the basket
    public Double totalPrice(){
        Double totalPrice = 0.0;
        for (int i = 0; i < productBasket.size(); i++) {
                
                Double price = productArray.get((productBasket.get(i).get(0)-1)).getProductPrice() * productBasket.get(i).get(1);
                totalPrice += price;
        }
        return totalPrice;
    }
    //Function to write the total price to a file
    public void writeTotalPrice(BufferedWriter bw) throws IOException{
        bw.write(totalPrice().toString());
    }

    //Function to return the total work hours of the basket
    public Double totalWorkHours(){
        Double totalHours = 0.0;
        for (int i = 0; i < productBasket.size(); i++) {
                
                Double hours = productArray.get((productBasket.get(i).get(0)-1)).getWorkingHours() * productBasket.get(i).get(1);
                totalHours += hours;
        }
        return totalHours;
    }
    //Function to write the total work hours to a file
    public void writeTotalWorkHours(BufferedWriter bw) throws IOException{
    bw.write(totalWorkHours().toString());
}    
    //Function to return the basket as a 2d array
    public String[][] getBasket(){
        String[][] basket = new String[productBasket.size()][2];
        for (int i = 0; i < productBasket.size(); i++) {
            
            for (int j = 0; j < 2; j++) {
                if(j==0){
                basket[i][j] = String.valueOf(productBasket.get(i).get(0));
                }
                if(j==1){
                basket[i][j] = String.valueOf(productBasket.get(i).get(1));
                }
            }
        }
        return basket;
    }

}
