package org.example.group3_assignment1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RestaurantController {


    @GetMapping("/")
    public String home() {
        return "forward:/index.html";
    }


    @GetMapping("/add/success/{entityName}")
    public String addSuccess(@PathVariable String entityName, Model model) {
        model.addAttribute("entityName", entityName);
        return "success";
    }
}