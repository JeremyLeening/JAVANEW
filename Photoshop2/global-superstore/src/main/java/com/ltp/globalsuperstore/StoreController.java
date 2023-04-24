package com.ltp.globalsuperstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StoreController {

    List<Item> items = new ArrayList<>();
    List<Customer> customers = new ArrayList<>();
    List<Employee> employees = new ArrayList<>();
    StoreProducts storeProducts = new StoreProducts();
    StoreTime storeTime = new StoreTime();
    List<Product> products = storeProducts.populateStore("src/main/resources/PhotoShop_PriceList.csv");
    List<Open> openingDays = storeTime.populateStore("src/main/resources/PhotoShop_OpeningHours.csv");

    Basket basket = new Basket();

    @GetMapping("/")
    public String getForm(Model model) {
    model.addAttribute("item", new Item());
    model.addAttribute("products", products);
    return "form";
    }

    @PostMapping("/subitem")
    public String addItem(Item item) {
        
        items.add(item);
        basket.addToBasket(item);
    
        return "redirect:/basket";
    }

    @PostMapping("/subcustomer")
    public String addCustomer(Customer customer) {
        
        customers.add(customer);
    
        return "redirect:/basket";
    }

    @PostMapping("/subemployee")
    public String addEmployee(Employee employee) {
        
        employees.add(employee);
    
        return "redirect:/basket";
    }
    
    @GetMapping("/info")
    public String getInfo(Model model) {

        model.addAttribute("products", products);
        model.addAttribute("openingdays", openingDays);
        
        return "info";
    }

    @GetMapping("/basket")
    public String getBasket(Model model) {
        model.addAttribute("products", products);
        model.addAttribute("items", items);
        model.addAttribute("customers", customers);
        model.addAttribute("employees", employees);
        String myVariable = "Hello, Thymeleaf!";
        model.addAttribute("message", myVariable);
        String totalPrice = Double.toString(basket.totalPrice());
        model.addAttribute("totalprice", totalPrice);
        String totalHours = Double.toString(basket.totalWorkHours());
        model.addAttribute("totalhours", totalHours);
        String pickupTime = basket.pickupTime();
        model.addAttribute("pickuptime", pickupTime);
        return "basket";
    }

    @GetMapping("/customer")
    public String getCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer";
    }
    @GetMapping("/employee")
    public String getEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee";
    }

    @GetMapping("/delete")
    public String deleteItem(@RequestParam(required = false) int index) {
        items.remove(index);
        return "redirect:/basket";
    }



}
