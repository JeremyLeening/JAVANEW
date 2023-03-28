package Model;


import java.util.ArrayList;
import java.util.HashMap;

public class Basket {
    StoreProducts storeProducts = new StoreProducts();
    ArrayList<Product> productArray = storeProducts.populateStore("_resources/PhotoShop_PriceList.csv");
                    
    //Class which represents a basket in which products can be held with their quantities
    //ArrayList within ArrayList of products and their quantities
    ArrayList<ArrayList<Integer>> productBasket = new ArrayList<ArrayList<Integer>>();{

    for(int i = 0; i < productBasket.size(); i++)  {
        productBasket.add(new ArrayList<Integer>());
    }}
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
            System.out.println();
        }
    }
    public Double totalPrice(){
        Double totalPrice = 0.0;
        for (int i = 0; i < productBasket.size(); i++) {
                
                Double price = productArray.get(productBasket.get(i).get(0)).getProductPrice() * productBasket.get(i).get(1);
                totalPrice += price;
        }
        return totalPrice;
        
    }
}
