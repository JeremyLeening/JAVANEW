package com.ltp.globalsuperstore;

public class Employee {
    
    public String name;
    public String number;
    
    public Employee(){   
    }

    public Employee(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
