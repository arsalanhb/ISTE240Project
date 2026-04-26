//Adham Khalifa -- 418006637

package org.example.group3_assignment1.controllers;
import org.example.group3_assignment1.models.Chef;
import org.example.group3_assignment1.services.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ChefController {

    @Autowired
    ChefService chefService;

    @GetMapping("/api/chefed")
    public ResponseEntity<List<Chef>> getAllChefs(){
        return ResponseEntity.ok().body(chefService.getAllChefs());
    }

    @GetMapping("/api/chefSpecialties")
    public ResponseEntity<List<String>> getAllSpecialties(){
        return ResponseEntity.ok().body(chefService.getAllSpecialties());
    }

    @GetMapping("/api/chefed/chefId/{requested}")
    public ResponseEntity<List<Optional<Chef>>> getChefById(@PathVariable Long requested){
        HttpHeaders header = new HttpHeaders();
        header.add("Custom - Header", "Chef-Details");
        return ResponseEntity.ok().body(List.of(chefService.getChefById(requested)));
    }

    @GetMapping("/api/chefed/fullName/{requested}")
    public ResponseEntity<List<Chef>> getChefFullName(@PathVariable String requested){
        System.out.println("it reached controller");
        HttpHeaders header = new HttpHeaders();
        header.add("Custom-Header", "Chef-Details");
        return ResponseEntity.ok().body(chefService.getChefByFullName(requested));
    }

    @GetMapping("/api/chefed/specialty/{requested}")
    public ResponseEntity<List<Chef>> getChefBySpecialty(@PathVariable String requested){
        HttpHeaders header = new HttpHeaders();
        header.add("Custom-Header", "Chef-Details");
        return ResponseEntity.ok().body(chefService.getChefBySpecialty(requested));
    }

    @PostMapping("/api/addChef")
    public ResponseEntity<List<Chef>> saveChef(@RequestBody Chef chefToSave){
        System.out.println("It reached here");
        HttpHeaders header = new HttpHeaders();
        header.add("Custom-Header", "Save-Chef");
        return ResponseEntity.ok().body(List.of(chefService.saveChef(chefToSave)));
    }

    @PutMapping("/api/updChef")
    public ResponseEntity<List<Optional<Chef>>> updChef(@RequestBody Chef chefToSave){
        System.out.print("Amazing");
        HttpHeaders header = new HttpHeaders();
        header.add("Custom-Header", "Update-Chef");
        return ResponseEntity.ok().body(List.of(chefService.updateChefById(chefToSave.getChefId(),chefToSave)));
    }

    @DeleteMapping("/api/delChef")
    public ResponseEntity<String> delChef(@RequestParam Long chefId){
        HttpHeaders header = new HttpHeaders();
        header.add("Custom-Header", "Delete-Chef");
        return ResponseEntity.ok().body(chefService.deleteChefById(chefId));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> incorrectInfo(Exception msg){
        if(msg instanceof DataAccessException){
            return new ResponseEntity<>("Database Error, duplicate record most likely error", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(msg.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }

}
