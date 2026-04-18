package org.example.group3_assignment1.controllers;


import org.example.group3_assignment1.models.Dish;
import org.example.group3_assignment1.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DishController {
    @Autowired
    private DishService dishService;


    @GetMapping("/dished")
    public List<Dish> dishes(){
        return dishService.findAll();
    }


}
