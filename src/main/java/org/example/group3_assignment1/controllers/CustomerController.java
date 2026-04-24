// Student Name: Munzier Kashef | Student ID: 761008741
package org.example.group3_assignment1.controllers;

import org.example.group3_assignment1.services.CustomerService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
}
