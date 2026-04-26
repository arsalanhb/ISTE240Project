package org.example.group3_assignment1.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestaurantController {

    @GetMapping("/")
    public String home() {
        return "redirect:/index.html";
    }

    @GetMapping("/dish") String Dish(){
        return "dish.html";
    }

    @GetMapping("/chef") String Chef(){
        return "chef.html";
    }

    @GetMapping("/waiter") String Waiter(){
        return "waiter.html";
    }

    @GetMapping("/customer") String Customer(){
        return "customer.html";
    }

    }



