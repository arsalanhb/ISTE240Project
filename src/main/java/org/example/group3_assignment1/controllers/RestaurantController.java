package org.example.group3_assignment1.controllers;

import org.example.group3_assignment1.models.Chef;
import org.example.group3_assignment1.models.Customer;
import org.example.group3_assignment1.models.Dish;
import org.example.group3_assignment1.models.Waiter;
import org.example.group3_assignment1.services.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Random;

@Controller
public class RestaurantController {
    private RestaurantService restService;
    Random rand = new Random();

    public RestaurantController(RestaurantService restService){
        this.restService = restService;
    }
    @GetMapping("/")
    public String home() {
        return "redirect:/index.html";
    }


    @GetMapping("/customer")
    public String customer(Model data){
        data.addAttribute("customerList", this.restService.findAllCustomers());
        return "customer";
    }
    @GetMapping("/customer/add")
    public String newCus(){
        return "customerForm";
    }

    @GetMapping("/add/success/{entityName}")
    public String addSuccess(@PathVariable String entityName, Model model) {
        model.addAttribute("entityName", entityName);
        return "success";
    }

    @PostMapping("/customer/add")
    public String addCustomer(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String preference) {
        Customer newCus = new Customer(
                restService.findAllWaiters().get(rand.nextInt(restService.findAllWaiters().size())),
                firstName, lastName, preference
        );
        this.restService.addCustomer(newCus);
        return "redirect:/add/success/customer";
    }

    @GetMapping("/chef")
    public String Chef(Model data){
        data.addAttribute("chefList", restService.findAllChefs());
        return "chefDish";
    }

    @GetMapping("/chef/add")
    public String newChef(){
        return "chefForm";
    }

    @PostMapping("/chef/add")
    public String addChef(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String specialty, @RequestParam double salary, @RequestParam double yrsOfExperience){
        Chef newChef = new Chef(firstName, lastName, firstName.toLowerCase() + "." + lastName.toLowerCase() + "@kebabshop.com", salary, specialty, yrsOfExperience);
        this.restService.addChef(newChef);
        return "redirect:/add/success/chef";
    }

    @GetMapping("/dish") String Dish(Model data){
        data.addAttribute("dishList", this.restService.findAllDishes());
        return "dish";
    }

    @GetMapping("/dish/add")
    public String newDish() {
        return "dishForm";
    }

    @PostMapping("/dish/add")
    public String addDish(@RequestParam boolean available, @RequestParam String category, @RequestParam String description, @RequestParam String dishName, @RequestParam double price){
        Dish newDish = new Dish(dishName, description, category, price);
        this.restService.addDish(newDish);
        return "redirect:/add/success/dish";
    }

    @GetMapping("/waiter")
    public String waiter(Model data) {
        data.addAttribute("waiterList", restService.findAllWaiters());
        return "waiter";
    }

    @GetMapping("/waiter/add")
    public String newWaiter() {
        return "waiterForm";
    }

    @PostMapping("/waiter/add")
    public String addWaiter(@RequestParam String firstName, @RequestParam String lastName, @RequestParam double salary) {
        Waiter newWaiter = new Waiter(firstName, lastName, salary);
        restService.addWaiter(newWaiter);
        return "redirect:/add/success/waiter";
    }



}