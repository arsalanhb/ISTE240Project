// Student Name: Munzier Kashef | Student ID: 761008741
package org.example.group3_assignment1.controllers;

import org.example.group3_assignment1.models.Customer;
import org.example.group3_assignment1.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/search")
    public List<Customer> searchByFirstName(@RequestParam String firstName) {
        return customerService.getByFirstName(firstName);
    }

    @GetMapping("/waiter/{waiterId}")
    public List<Customer> getCustomersByWaiterId(@PathVariable int waiterId) {
        return customerService.getByWaiterId(waiterId);
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @PutMapping("/{customerId}/waiter/{waiterId}")
    public void updateCustomerWaiter(@PathVariable int customerId, @PathVariable int waiterId) {
        customerService.updateCustomerWaiter(customerId, waiterId);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer updatedCustomer) {
        Customer existingCustomer = customerService.getCustomerById(id);

        existingCustomer.setFirstName(updatedCustomer.getFirstName());
        existingCustomer.setLastName(updatedCustomer.getLastName());
        existingCustomer.setPreference(updatedCustomer.getPreference());

        return customerService.addCustomer(existingCustomer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
    }
}
