package org.example.group3_assignment1.controllers;


import org.example.group3_assignment1.models.Dish;
import org.example.group3_assignment1.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
        return ResponseEntity.ok().body(List.of(dishService.findByDishId(requested)));
    }
    @GetMapping("/api/dished/dishName/{requested}")
    public ResponseEntity<List<Dish>> specificDishName(@PathVariable String requested){
        HttpHeaders header = new HttpHeaders();
        header.add("Custom - Header", "Details");
        return ResponseEntity.ok().body(List.of(dishService.findByDishName(requested)));
    }
    @GetMapping("/api/dished/category/{requested}")
    public ResponseEntity<List<Dish>> specificDishCategory(@PathVariable String requested){
        HttpHeaders header = new HttpHeaders();
        header.add("Custom - Header", "Details");
        return ResponseEntity.ok().body(dishService.findByCategory(requested));
    }

    @GetMapping("/api/dished/price/{requested}")
    public ResponseEntity<List<Dish>> specificDishPrice(@PathVariable double requested){
        HttpHeaders header = new HttpHeaders();
        header.add("Custom - Header", "Details");
        return ResponseEntity.ok().body((dishService.findByPrice(requested)));
    }
    @PostMapping("/api/addDish")
    public ResponseEntity<List<Dish>> saveDish(@RequestBody Dish newDish){
        System.out.println("It reached controller save");
        HttpHeaders header = new HttpHeaders();
        header.add("Custom - Header", "Details");
        return new ResponseEntity<>(List.of(dishService.saveDish(newDish)), HttpStatus.OK);
    }

    @PostMapping("/api/updDish")
    public ResponseEntity<List<Dish>> updDish(@RequestParam Long dishId, @RequestBody Dish updatedDish){
        System.out.print("Amazing");
        HttpHeaders header = new HttpHeaders();
        header.add("Custom - Header", "Details");
        return ResponseEntity.ok().body(List.of(dishService.updateById(dishId,updatedDish)));
    }

    @PostMapping("/api/delDish")
    public ResponseEntity<String> delDish(@RequestParam Long dishId){
        HttpHeaders header = new HttpHeaders();
        header.add("Custom - Header", "Details");
        System.out.print("Amazing");
        return ResponseEntity.ok().body(dishService.deleteByDishId(dishId));

    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> incorrectDataType(RuntimeException msg){
        System.out.println(msg.getMessage());
        return new ResponseEntity<>(msg.getMessage(),HttpStatus.BAD_REQUEST);
    }
//
//







}
