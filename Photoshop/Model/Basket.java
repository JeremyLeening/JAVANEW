package Model;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Basket {
    //Class which represents a basket in which products can be held with their quantities

    //Creating a storeProducts Object
    StoreProducts storeProducts = new StoreProducts();
    //Creating a Arraylist to store the products from the CSV file
    ArrayList<Product> productArray = storeProducts.populateStore("_resources/PhotoShop_PriceList.csv");
    //Creating a storeTime Object
    StoreTime storeTime = new StoreTime();
    //Creating a Arraylist to store the times from the CSV file
    ArrayList<Open> openArray = storeTime.populateStore("_resources/PhotoShop_OpeningHours.csv");
                    
    
    //ArrayList within ArrayList of products 
    ArrayList<ArrayList<Integer>> productBasket = new ArrayList<ArrayList<Integer>>();

    //Function to add a product and a quantity to the basket
    public void addToBasket(Integer productId, int quantity) {
        ArrayList<Integer> order = new ArrayList<Integer>();
        order.add(productId);
        order.add(quantity);
        productBasket.add(order);

    }
    //Function to show the basket
    public void showBasket(){
        for (int i = 0; i < productBasket.size(); i++) {
            for (int j = 0; j < productBasket.get(i).size(); j++) {
                if(j==0){
                    System.out.print("ID: ");
                    System.out.print(productBasket.get(i).get(j) + " ");
                }
                if(j==1){
                    System.out.print(" Quantity: ");
                    System.out.print(productBasket.get(i).get(j) + " ");
                }            
            }
            System.out.print(" Price: ");
            System.out.print(itemPrice(productBasket.get(i).get(0),productBasket.get(i).get(1)) + " ");
            System.out.println();
        }
    }
    // Function to return the time at wich the order will be ready
    public String pickupTime(){
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime pickup = now.plusHours(Double.valueOf(totalWorkHours()).longValue());  
          
        String pickupTime = dtf.format(pickup);
        
        
        return pickupTime;
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
    //Function to return the total work hours of the basket
    public Double totalWorkHours(){
        Double totalHours = 0.0;
        for (int i = 0; i < productBasket.size(); i++) {
                
                Double hours = productArray.get((productBasket.get(i).get(0)-1)).getWorkingHours() * productBasket.get(i).get(1);
                totalHours += hours;
        }
        return totalHours;
    }
    //Function to return the basket as a 2d array
    public String[][] getBasket(){
        String[][] basket = new String[productBasket.size()][2];
        for (int i = 0; i < productBasket.size(); i++) {
            
            for (int j = 0; j < 2; j++) {
                if(j==0){
                basket[i][j] = String.valueOf(productBasket.get(i).get(0));
                //productArray.get((productBasket.get(i).get(0)-1)).getProductName();
                }
                if(j==1){
                basket[i][j] = String.valueOf(productBasket.get(i).get(1));
                }
            }
        }
        return basket;
    }

}
