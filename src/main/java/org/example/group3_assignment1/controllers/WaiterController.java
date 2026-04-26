//Muhammad Arsalan Habib - 403000286
package org.example.group3_assignment1.controllers;

import org.example.group3_assignment1.models.Waiter;
import org.example.group3_assignment1.services.WaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WaiterController {

    @Autowired
    private WaiterService waiterService;

    @GetMapping("/api/waiters")
    public List<Waiter> waiters() {
        return waiterService.getAllWaiters();
    }

    @GetMapping("/api/waiters/{id}")
    public ResponseEntity<List<Waiter>> specificWaiterId(@PathVariable int id) {
        HttpHeaders header = new HttpHeaders();
        header.add("Custom-Header", "Details");
        return ResponseEntity.ok().body(waiterService.getWaiterById(id));
    }

    @GetMapping("/api/waiters/firstName/{requested}")
    public ResponseEntity<List<Waiter>> specificWaiterFirstName(@PathVariable String requested) {
        HttpHeaders header = new HttpHeaders();
        header.add("Custom-Header", "Details");
        return ResponseEntity.ok().body(waiterService.getWaiterByFirstName(requested));
    }

    @GetMapping("/api/waiters/salary/{requested}")
    public ResponseEntity<List<Waiter>> waitersBySalary(@PathVariable double requested) {
        HttpHeaders header = new HttpHeaders();
        header.add("Custom-Header", "Details");
        return ResponseEntity.ok().body(waiterService.getWaitersBySalary(requested));
    }

    @PostMapping("/api/waiters")
    public ResponseEntity<List<Waiter>> saveWaiter(@RequestParam String firstName,
                                                   @RequestParam String lastName,
                                                   @RequestParam double salary) {
        HttpHeaders header = new HttpHeaders();
        header.add("Custom-Header", "Details");
        return ResponseEntity.ok().body(waiterService.saveWaiter(new Waiter(firstName, lastName, salary)));
    }

    @PutMapping("/api/waiters/{id}")
    public ResponseEntity<List<Waiter>> updWaiter(@PathVariable int id,
                                                  @RequestParam String firstName,
                                                  @RequestParam String lastName,
                                                  @RequestParam double salary) {
        HttpHeaders header = new HttpHeaders();
        header.add("Custom-Header", "Details");
        return ResponseEntity.ok().body(waiterService.updateWaiterById(id, new Waiter(firstName, lastName, salary)));
    }

    @DeleteMapping("/api/waiters/{id}")
    public ResponseEntity<String> delWaiter(@PathVariable int id) {
        HttpHeaders header = new HttpHeaders();
        header.add("Custom-Header", "Details");
        return ResponseEntity.ok().body(waiterService.deleteWaiterById(id));
    }
}