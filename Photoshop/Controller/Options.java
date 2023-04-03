package Controller;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Model.Basket;
import Model.Customer;
import Model.Open;
import Model.Product;
import Model.StoreProducts;
import Model.StoreTime;

public class Options{
    //Class that manages the options menu items

    //Creating a JSONObject object
    JSONObject JSONObject = new JSONObject();
    //Creating a JSONObject to store the customer object contents
    JSONObject customerObject = new JSONObject();
    //Creating a JSONObject to store the basket contents
    JSONObject basketObject = new JSONObject();

    //Creating a empty customer object
    Customer customer = new Customer(null, null, null, null, null, null);
    //Creating a scanner object
    Scanner scan = new Scanner(System.in);
    //Creating a basket object
    Basket basket = new Basket();
    //Creating a store products object
    StoreProducts storeProducts = new StoreProducts();
    //Filling a ArrayList with products from the CSV file
    ArrayList<Product> productArray = storeProducts.populateStore("_resources/PhotoShop_PriceList.csv");
    
    //This is where the choices are used
    public void choice(String choice){
        switch (choice){
            case "options":
            //This shows the options menu
                System.out.println("Your options are as follows:");
                System.out.println("-options\n-products\n-order\n-opening times\n-show\n-total price\n-total work hours\n-pick up time\n-checkout\n-save\n-load\n-exit");
                break;
            case "products":
            //This shows the available products
                System.out.println("We have the following products:");
                
                
                for(int i = 0; i < productArray.size(); i++){
                    System.out.println(productArray.get(i).getAll());
                }
                break;
            case "opening times":
            //This shows the available opening times
                System.out.println("We have the following opening times:");
                StoreTime storeTime = new StoreTime();
                ArrayList<Open> openArray = storeTime.populateStore("_resources/PhotoShop_OpeningHours.csv");
                
                for(int i = 0; i < openArray.size(); i++){
                    System.out.println(openArray.get(i).getAll());
                }
                break;
            case "order":
            //Here you are prompted to enter a order
                while(choice.equals("order")){
                System.out.println("What would you like to order?");
                System.out.print("Please provide the product ID: ");
                //It takes in the product ID
                int productId = scan.nextInt();
                //Checks if the product ID is valid
                while (productId < 0 || productId > productArray.size()){
                    System.out.print("Please provide a valid product ID: ");
                    productId = scan.nextInt();
                }
                System.out.print("Please provide the quantity: ");
                //It takes in the quantity
                int quantity = scan.nextInt();
                //Checks if the quantity is valid
                while (quantity < 0){
                    System.out.print("Please provide a valid quantity: ");
                    quantity = scan.nextInt();
                }
                //Add the order to the basket
                basket.addToBasket(productId, quantity);
                scan.nextLine();
                //Check if the user wants to order more
                System.out.print("If you would like to continue, type 'order' else 'exit': ");
                String choiceContinue = scan.nextLine();
                if(choiceContinue.equals("exit")){
                    choice = choiceContinue;
                    break;
                }
                //Checks if the input was valid
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
            //This shows the basket contents
                System.out.println("We are going to show your order!");
                basket.showBasket();
                break;
            case "total price":
            //This shows the total price of orders in the basket
                System.out.println("Your price total comes to: "+ basket.totalPrice());
                break;
            case "total work hours":
            //This shows the total work hours of orders in the basket
                System.out.println("Your total work hours comes to: "+ basket.totalWorkHours());
                break;
            case "pick up time":
            //This shows the pick up time of the tota order
                System.out.println("Your order will be ready to pick up on: "+ basket.pickupTime());
                break;
            case "checkout":
            //This prompts the user to enter his details
                System.out.println("We are going to checkout your order!");
                System.out.print("Please provide your credentials ");
                System.out.print("Name: ");
                String name = scan.nextLine();
                System.out.print("Address: ");
                String address = scan.nextLine();
                System.out.print("Postal Code: ");
                String postalcode = scan.nextLine();
                System.out.print("City: ");
                String city = scan.nextLine();
                System.out.print("Email: ");
                String email = scan.nextLine();
                System.out.print("Phone: ");
                String phone = scan.nextLine();
                customer.setAddress(address);
                customer.setName(name);
                customer.setPostalCode(postalcode);
                customer.setCity(city);
                customer.setEmail(email);
                customer.setPhone(phone); 
                break;
            case "save":
            //This is used to save the basket and customer to a JSON file
                System.out.println("How would you like to name your file?: ");
                String saveFileName = scan.nextLine();
                customerObject.put("name", customer.getName());
                customerObject.put("address", customer.getAddress());
                customerObject.put("postalcode", customer.getPostalCode());
                customerObject.put("city", customer.getCity());
                customerObject.put("email", customer.getEmail());
                customerObject.put("phone", customer.getPhone());

                JSONObject.put("customer", customerObject);

                String [][] basketArray = basket.getBasket();
                for(int i = 0; i < basket.getBasket().length; i++) {
                    basketObject.put(i,basketArray[i][0]+";"+basketArray[i][0]);
                }
                JSONObject.put("basket", basketObject);
                

                try {
                    FileWriter file = new FileWriter("_jsonFiles/"+ saveFileName +".json");
                    file.write(JSONObject.toString());
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("JSON file created: "+JSONObject);
                break;
            case "load":
            //This is used to load the basket and customer from a JSON file
                System.out.println("Which file do you wish to load?: ");
                String loadFileName = scan.nextLine();
                JSONParser jsonParser = new JSONParser();
            
                try (FileReader reader = new FileReader("_jsonFiles/"+ loadFileName +".json"))
                {
                    //Read JSON file
                    Object obj = jsonParser.parse(reader);
                            
                    JSONObject jsonObject = (JSONObject) obj;
                    JSONObject basketTemp = (JSONObject) jsonObject.get("basket");
                    JSONObject customerTemp = (JSONObject) jsonObject.get("customer");
                    
                    //System.out.println(customerTemp);
                    //System.out.println(basketTemp);
                    String addressTemp = (String) customerTemp.get("address");
                    String nameTemp = (String) customerTemp.get("name");
                    String postalcodeTemp = (String) customerTemp.get("postalcode");
                    String cityTemp = (String) customerTemp.get("city");
                    String emailTemp = (String) customerTemp.get("email");
                    String phoneTemp = (String) customerTemp.get("phone");
                    customer.setAddress(addressTemp);
                    customer.setName(nameTemp);
                    customer.setPostalCode(postalcodeTemp);
                    customer.setCity(cityTemp);
                    customer.setEmail(emailTemp);
                    customer.setPhone(phoneTemp);

                    for(int i = 0; i < basketTemp.size(); i++) {
                        String fromBasketTemp = (String) basketTemp.get(String.valueOf(i));
                        String[] parts = fromBasketTemp.split(";");
                        String id = parts[0]; 
                        String quantity = parts[1];
                        basket.addToBasket(Integer.parseInt(id), Integer.parseInt(quantity));
                    }

                                     
        
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            default: 
                System.out.println("That is not a valid option");
                break;
        }

    }
}
