package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Basket;
import Model.Open;
import Model.Product;
import Model.StoreProducts;
import Model.StoreTime;

public class Options{
    //Class that manages the options menu items

    Scanner scan = new Scanner(System.in);
    Basket basket = new Basket();
    //This is where the choices are made
    public void choice(String choice){
        switch (choice){
            case "options":
                System.out.println("Your options are as follows:");
                System.out.println("-options\n-products\n-order\n-opening times\n-show\n-exit");
                break;
            case "products":
                System.out.println("We have the following products:");
                StoreProducts storeProducts = new StoreProducts();
                ArrayList<Product> productArray = storeProducts.populateStore("_resources/PhotoShop_PriceList.csv");
                
                for(int i = 0; i < productArray.size(); i++){
                    System.out.println(productArray.get(i).getAll());
                }
                break;
            case "opening times":
                System.out.println("We have the following opening times:");
                StoreTime storeTime = new StoreTime();
                ArrayList<Open> openArray = storeTime.populateStore("_resources/PhotoShop_OpeningHours.csv");
                
                for(int i = 0; i < openArray.size(); i++){
                    System.out.println(openArray.get(i).getAll());
                }
                break;
            case "order":
                while(choice.equals("order")){
                System.out.println("What would you like to order?");
                System.out.print("Please provide the product ID: ");
                int productId = scan.nextInt();
                
                while (productId < 0 || productId > 13){
                    System.out.print("Please provide a valid product ID: ");
                    productId = scan.nextInt();
                }
                System.out.print("Please provide the quantity: ");
                int quantity = scan.nextInt();
                while (quantity < 0){
                    System.out.print("Please provide a valid quantity: ");
                    quantity = scan.nextInt();
                }
                basket.addToBasket(productId, quantity);
                scan.nextLine();

                System.out.print("If you would like to continue, type 'order' else 'exit': ");
                String choiceContinue = scan.nextLine();
                if(choiceContinue.equals("exit")){
                    choice = choiceContinue;
                    break;
                }
                while (!choiceContinue.equals("order")){
                    System.out.print("Please type order or exit: ");
                    choiceContinue = scan.nextLine();
                    if(choiceContinue.equals("exit")){
                        choice = choiceContinue;
                        break;
                    }
                }
                }
                break;
            case "show":
                System.out.println("We are going to show your order!");
                basket.showBasket();
                break;
            case "price":
                System.out.println("Your price total comes to: "+ basket.totalPrice());
                break;
            default: 
                System.out.println("That is not a valid option");
                break;
        }

    }
}