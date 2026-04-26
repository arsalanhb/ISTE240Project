package org.example.group3_assignment1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestaurantController {

    @GetMapping("/")
    public String home() {
        return "redirect:/index.html";
    }

    @GetMapping("/dish")
    public String Dish() {
        return "redirect:/dish.html";
    }

    @GetMapping("/chef")
    public String Chef() {
        return "redirect:/chef.html";
    }

    @GetMapping("/waiter")
    public String Waiter() {
        return "redirect:/waiter.html";
    }

    @GetMapping("/customer")
    public String Customer() {
        return "redirect:/customer.html";
    }
}