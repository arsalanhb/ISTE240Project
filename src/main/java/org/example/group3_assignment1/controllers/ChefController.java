package org.example.group3_assignment1.controllers;


import org.example.group3_assignment1.models.Chef;
import org.example.group3_assignment1.services.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ChefController {

    @Autowired
    ChefService chefService;

    @GetMapping("/api/chefed")
    public ResponseEntity<List<Chef>> getAllChefs(){
        return ResponseEntity.ok().body((chefService.getAllChefs()));
    }

    @GetMapping("/api/chefed/chefId/{requested}")
    public ResponseEntity<List<Chef>> getChefById(@PathVariable Long requested){
        HttpHeaders header = new HttpHeaders();
        header.add("Custom - Header", "Details");
        return ResponseEntity.ok().body(chefService.getChefById(requested));
    }

    @GetMapping("/api/chefed/firstName/{requested}")
    public ResponseEntity<List<Chef>> getChefByFirstName(@PathVariable String requested){
        HttpHeaders header = new HttpHeaders();
        header.add("Custom - Header", "Details");
        return ResponseEntity.ok().body(chefService.getChefByFirstName(requested));
    }

    @GetMapping("/api/chefed/specialty/{requested}")
    public ResponseEntity<List<Chef>> getChefBySpecialty(@PathVariable String requested){
        HttpHeaders header = new HttpHeaders();
        header.add("Custom - Header", "Details");
        return ResponseEntity.ok().body(chefService.getChefBySpecialty(requested));
    }

    @PostMapping("/api/addChef")
    public ResponseEntity<List<Chef>> saveChef(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String specialty, @RequestParam double salary, @RequestParam double yrsOfExperience){
        System.out.println("It reached here");
        HttpHeaders header = new HttpHeaders();
        header.add("Custom - Header", "Details");
        return ResponseEntity.ok().body((chefService.saveChef(new Chef(firstName, lastName, email, salary, specialty, yrsOfExperience))));
    }

    @PostMapping("/api/updChef")
    public ResponseEntity<List<Chef>> updChef(@RequestParam Long chefId, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String specialty, @RequestParam double salary, @RequestParam double yrsOfExperience){
        System.out.print("Amazing");
        HttpHeaders header = new HttpHeaders();
        header.add("Custom - Header", "Details");
        return ResponseEntity.ok().body((chefService.updateChefById(chefId,new Chef(firstName, lastName, email, salary,specialty, yrsOfExperience))));
    }

    @PostMapping("/api/delChef")
    public ResponseEntity<String> delChef(@RequestParam Long chefId){
        HttpHeaders header = new HttpHeaders();
        header.add("Custom - Header", "Details");
        return ResponseEntity.ok().body(chefService.deleteChefById(chefId));
    }


}
