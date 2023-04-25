package com.ltp.demo.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltp.demo.pojo.*;
import com.ltp.demo.*;

@RestController
@CrossOrigin(origins = "*")
public class InfoController {
    
    StoreProducts storeProducts = new StoreProducts();
    StoreTime storeTime = new StoreTime();    

    List<Product> productlist = storeProducts.populateStore("src/main/resources/PhotoShop_PriceList.csv");
    List<Open> openinglist = storeTime.populateStore("src/main/resources/PhotoShop_OpeningHours.csv");



    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<List<Product>>(productlist, HttpStatus.OK);
    }
    @GetMapping("/openings")
    public ResponseEntity<List<Open>> getOpenings() {
        return new ResponseEntity<List<Open>>(openinglist, HttpStatus.OK);
    }
}
