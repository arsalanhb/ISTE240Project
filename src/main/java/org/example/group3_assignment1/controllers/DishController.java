//Adham Khalifa -- 418006637

package org.example.group3_assignment1.controllers;
import org.example.group3_assignment1.models.Dish;
import org.example.group3_assignment1.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class DishController {
    @Autowired
    private DishService dishService;


    @GetMapping("/api/dished")
    public List<Dish> dishes(){
        return dishService.findAll();
    }

    @GetMapping("/api/dished/dishId/{requested}")
    public ResponseEntity<List<Optional<Dish>>> specificDishId(@PathVariable Long requested){
        HttpHeaders header = new HttpHeaders();
        header.add("Custom-Header", "Dish-Details");
        return ResponseEntity.ok().headers(header).body(List.of(dishService.findByDishId(requested)));
    }
    @GetMapping("/api/dished/dishName/{requested}")
    public ResponseEntity<List<Dish>> specificDishName(@PathVariable String requested){
        HttpHeaders header = new HttpHeaders();
        header.add("Custom-Header", "Dish-Details");
        return ResponseEntity.ok().headers(header).headers(header).body(dishService.findByDishName(requested));
    }
    @GetMapping("/api/dished/category/{requested}")
    public ResponseEntity<List<Dish>> specificDishCategory(@PathVariable String requested){
        HttpHeaders header = new HttpHeaders();
        header.add("Custom-Header", "Dish-Details");
        return ResponseEntity.ok().headers(header).body(dishService.findByCategory(requested));
    }

    @GetMapping("/api/dished/price/{requested}")
    public ResponseEntity<List<Dish>> specificDishPrice(@PathVariable double requested){
        HttpHeaders header = new HttpHeaders();
        header.add("Custom-Header", "Dish-Details");
        return ResponseEntity.ok().headers(header).body((dishService.findByPrice(requested)));
    }
    @PostMapping("/api/addDish")
    public ResponseEntity<List<Dish>> saveDish(@RequestBody Dish newDish){
        System.out.println("It reached controller save");
        HttpHeaders header = new HttpHeaders();
        header.add("Custom-Header", "Save-Dish");
        return ResponseEntity.ok().headers(header).body(List.of(dishService.saveDish(newDish)));
    }

    @PutMapping("/api/dished/update")
    public ResponseEntity<List<Optional<Dish>>> updDish(@RequestBody Dish updatedDish){
        HttpHeaders header = new HttpHeaders();
        header.add("Custom-Header", "Update-Description");
        return ResponseEntity.ok().headers(header).body(List.of(dishService.updateDishById(updatedDish.getDishId(),updatedDish)));
    }

    @DeleteMapping("/api/delDish")
    public ResponseEntity<String> delDish(@RequestParam Long dishId){
        HttpHeaders header = new HttpHeaders();
        header.add("Custom-Header", "Delete-Dish");
        return ResponseEntity.ok().headers(header).body(dishService.deleteByDishId(dishId));

    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> incorrectDataType(Exception msg){
        System.out.println(msg.getMessage());
        return new ResponseEntity<>(msg.getMessage(),HttpStatus.NOT_ACCEPTABLE);
    }








}
