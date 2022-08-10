package com.example.myusercontrollers.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class Customer {
    private int ID;
    private String Username;
    private int Balance;

}
