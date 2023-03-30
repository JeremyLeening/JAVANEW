package Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
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
    JSONObject customerObject = new JSONObject();
    JSONObject basketObject = new JSONObject();

    //Creating a empty customer object
    Customer customer = new Customer(null, null, null, null, null, null);
    
    Scanner scan = new Scanner(System.in);
    //Creating a basket object
    Basket basket = new Basket();
    //This is where the choices are made
    public void choice(String choice){
        switch (choice){
            case "options":
                System.out.println("Your options are as follows:");
                System.out.println("-options\n-products\n-order\n-opening times\n-show\n-total price\n-total work hours\n-pick up time\n-checkout\n-save\n-load\n-exit");
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
            case "total price":
                System.out.println("Your price total comes to: "+ basket.totalPrice());
                break;
            case "total work hours":
                System.out.println("Your total work hours comes to: "+ basket.totalWorkHours());
                break;
            case "pick up time":
                System.out.println("Your order will be ready to pick up on: "+ basket.pickupTime());
                break;
            case "checkout":
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
                customerObject.put("name", customer.getName());
                customerObject.put("address", customer.getAddress());
                customerObject.put("postalcode", customer.getPostalCode());
                customerObject.put("city", customer.getCity());
                customerObject.put("email", customer.getEmail());
                customerObject.put("phone", customer.getPhone());

                JSONObject.put("customer", customerObject);

                //System.out.println(Arrays.deepToString(basket.getBasket()));
                String [][] basketArray = basket.getBasket();
                for(int i = 0; i < basket.getBasket().length; i++) {
                    basketObject.put(i,basketArray[i][0]+";"+basketArray[i][0]);
                }
                JSONObject.put("basket", basketObject);
                //JSONObject.put("basket", Arrays.deepToString(basket.getBasket()));

                try {
                    FileWriter file = new FileWriter("_jsonFiles/output.json");
                    file.write(JSONObject.toString());
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("JSON file created: "+JSONObject);
                break;
            case "load":
                JSONParser jsonParser = new JSONParser();
            
                try (FileReader reader = new FileReader("_jsonFiles/output.json"))
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
                        
                        //basket.addToBasket(Integer.parseInt(basketTemp.get(i).split(";")[0]), Integer.parseInt(basketTemp.get(i).toString().split(";")[1]));
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
