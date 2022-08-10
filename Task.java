package com.example.week2day2.Model;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class Task {
    // : ID , title , description , status
    private  String ID ;
    private  String title;
    private  String description;
    private  String status;
}
