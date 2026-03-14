package org.example.group3_assignment1.controllers;

import org.example.group3_assignment1.models.Customer;
import org.example.group3_assignment1.services.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RestaurantController {
    private RestaurantService restService;


    public RestaurantController(RestaurantService restService){
        this.restService = restService;
    }
    @GetMapping("/")
    public String home() {
        return "forward:/index.html";
    }


    @GetMapping("/customer")
    public String customer(){
        return "customer";
    }
    @GetMapping("/customer/add")
    public String newCus(){
        return "form";
    }

    @GetMapping("/add/success/{entityName}")
    public String addSuccess(@PathVariable String entityName, Model model) {
        model.addAttribute("entityName", entityName);
        return "success";
    }

    @PostMapping("/customer/add")
    public String addCustomer(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String preference) {
        Customer newCus = new Customer(
                restService.findAllWaiters().get(restService.findAllWaiters().size() - 1),
                restService.findAllCustomers().size() + 1,
                firstName, lastName, preference
        );
        this.restService.addCustomer(newCus);
        return "redirect:/add/success/customer";
    }

}