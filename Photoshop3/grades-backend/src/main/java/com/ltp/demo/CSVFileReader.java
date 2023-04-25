package com.ltp.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVFileReader {
   //Class that manages the reading of a CSV file
   private String filePath;
   public CSVFileReader(String filePath) {
      this.filePath = filePath;
   }

   public void read() {
      //Function that reads a CSV file
      try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
         String line;
         while ((line = br.readLine()) != null) {
            String[] data = line.split(System.lineSeparator());
            for (int i = 0; i < data.length; i++) {
               System.out.println(data[i]+ "\n");
         }
      }} catch (IOException e) {
         e.printStackTrace();
      }
   }

   public ArrayList<String> toArray() {
      //Function that reads a CSV file and returns an ArrayList filled with lines from the file
      ArrayList<String> array = new ArrayList<String>();
      try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
         String line;
         while ((line = br.readLine()) != null) {
            String[] data = line.split(System.lineSeparator());
            for (int i = 0; i < data.length; i++) {
               array.add(data[i]);
               }    
         }
         return array;
         
   } catch (IOException e) {
         e.printStackTrace();
      }
      return null;
   }

}
