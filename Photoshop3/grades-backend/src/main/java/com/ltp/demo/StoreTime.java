package com.ltp.demo;

import java.util.ArrayList;
import com.ltp.demo.pojo.*;

public class StoreTime {
    public ArrayList<Open> populateStore(String filePath){
        //Assigns the CSV file
        CSVFileReader reader = new CSVFileReader(filePath);
        //Makes a arraylist of the contents of the CSV file
        ArrayList<String> array = reader.toArray();
        //Creates a new arraylist to store open objects 
        ArrayList<Open> openArray = new ArrayList<Open>();
        //Turns the arraylist into an array
        String [] simpleArray = array.toArray(new String[0]);
        //Loops through the array and creates open objects and adds them to the openArray arraylist
        for(int i = 1; i < simpleArray.length; i++) {
            String [] data = simpleArray[i].split(";");
            int dayId = Integer.parseInt(data[0]);
            String dayName = data[1];
            String openingTime = data[2];
            String closingTime = data[3];
            openArray.add(new Open(dayId, dayName, openingTime, closingTime));
            }
        return openArray;
        }
}
