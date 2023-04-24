package com.ltp.globalsuperstore;

public class Product {
    //Class to represent a product   
    private int productId;
    private String productName;
    private double productPrice;
    private Double workingHours;

    public Product(int productId, String productName, double productPrice, Double workingHours){
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.workingHours = workingHours;

    }

    public String getAll(){
        return this.productId + ": " + this.productName + " " + this.productPrice + " " + this.workingHours;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Double getWorkingHours() {
        return this.workingHours;
    }

    public void setWorkingHours(Double workingHours) {
        this.workingHours = workingHours;
    }

}
