package Model;

public class Product {
    
    private int productId;
    private String productName;
    private double productPrice;
    private double workingHours;

    public Product(int productId, String productName, double productPrice, double workingHours){
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.workingHours = workingHours;

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

    public double getWorkingHours() {
        return this.workingHours;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }

}
