package com.ltp.demo;

import java.util.ArrayList;
import com.ltp.demo.pojo.*;

public class StoreProducts{
    public ArrayList<Product> populateStore(String filePath){
        //Assigns the CSV file
        CSVFileReader reader = new CSVFileReader(filePath);
        //Makes a arraylist of the contents of the CSV file
        ArrayList<String> array = reader.toArray();
        //Creates a new arraylist to store product objects 
        ArrayList<Product> productArray = new ArrayList<Product>();
        //Turns the arraylist into an array
        String [] simpleArray = array.toArray(new String[0]);
        //Loops through the array and creates product objects and adds them to the productArray arraylist
        for(int i = 0; i < simpleArray.length; i++) {
            String [] data = simpleArray[i].split(";");
            int productId = Integer.parseInt(data[0]);
            String productName = data[1];
            double productPrice = Double.parseDouble(data[2]);
            String workingHoursString = data[3];
            String[] parts = workingHoursString.split(":");
            String hours = parts[0]; 
            String minutes = parts[1];
            Double workingHours = Double.parseDouble(hours) + (Double.parseDouble(minutes)/60);
            productArray.add(new Product(productId, productName, productPrice, workingHours));
            }
        return productArray;
    }
}