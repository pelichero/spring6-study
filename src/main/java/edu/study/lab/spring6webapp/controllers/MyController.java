package edu.study.lab.spring6webapp.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    public String sayHi(){
        System.out.println("Hello World.");
        return "Hello Everyone";
    }
}
