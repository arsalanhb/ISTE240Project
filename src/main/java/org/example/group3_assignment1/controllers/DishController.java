package org.example.group3_assignment1.controllers;


import org.example.group3_assignment1.models.Dish;
import org.example.group3_assignment1.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DishController {
    @Autowired
    private DishService dishService;


    @GetMapping("/api/dished")
    public List<Dish> dishes(){
        return dishService.findAll();
    }

    @GetMapping("/api/dished/{searchOption}/{requested}")
    public List<Dish> specificDish(@PathVariable String searchOption, @PathVariable String requested){
        return dishService.decision(requested, searchOption);
    }
//    @GetMapping("/api/dished/{searchMOption}/{requestedM}")
//    public List<Dish> specificDishMulti(@PathVariable String searchMOption, @PathVariable String requestedM){
//        return dishService.multiDecision(requestedM, searchMOption);
//    }






}
