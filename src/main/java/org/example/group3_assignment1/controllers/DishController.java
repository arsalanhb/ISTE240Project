package org.example.group3_assignment1.controllers;


import org.example.group3_assignment1.models.Dish;
import org.example.group3_assignment1.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@RestController
public class DishController {
    @Autowired
    private DishService dishService;


    @GetMapping("/api/dished")
    public List<Dish> dishes(){
        return dishService.findAll();
    }

    @GetMapping("/api/dished/dishId/{requested}")
    public ResponseEntity<List<Dish>> specificDishId(@PathVariable Long requested){
        HttpHeaders header = new HttpHeaders();
        header.add("Custom - Header", "Details");
        return ResponseEntity.ok().body((dishService.findByDishId(requested)));
    }
    @GetMapping("/api/dished/dishName/{requested}")
    public ResponseEntity<List<Dish>> specificDishName(@PathVariable String requested){
        HttpHeaders header = new HttpHeaders();
        header.add("Custom - Header", "Details");
        return ResponseEntity.ok().body((dishService.findByDishName(requested)));
    }
    @GetMapping("/api/dished/category/{requested}")
    public ResponseEntity<List<Dish>> specificDishCategory(@PathVariable String requested){
        HttpHeaders header = new HttpHeaders();
        header.add("Custom - Header", "Details");
        return ResponseEntity.ok().body((dishService.findByCategory(requested)));    }

    @GetMapping("/api/dished/price/{requested}")
    public ResponseEntity<List<Dish>> specificDishPrice(@PathVariable double requested){
        HttpHeaders header = new HttpHeaders();
        header.add("Custom - Header", "Details");
        return ResponseEntity.ok().body((dishService.findByPrice(requested)));
    }
//
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<String> incorrectDataType(RuntimeException msg){
//        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(msg.getMessage());
//    }
//
//







}
