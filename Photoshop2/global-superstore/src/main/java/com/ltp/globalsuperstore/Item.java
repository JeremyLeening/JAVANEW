package com.ltp.globalsuperstore;

public class Item {

    private int quantity;
    private Integer productId;

    public Item() {
    }

    public Item( Integer productId, int quantity){
        this.quantity = quantity;
        this.productId = productId;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProduct() {
        return this.productId;
    }

    public void setProduct(Integer productId) {
        this.productId = productId;
    }

}
