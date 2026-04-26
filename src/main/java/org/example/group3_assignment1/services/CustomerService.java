//Student Name: Munzier Kashef | Student ID: 761008741
package org.example.group3_assignment1.services;

import org.example.group3_assignment1.models.Customer;
import org.example.group3_assignment1.repositories.CustomerDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
    }

    public Customer getCustomerById(int id) {
        return customerDAO.findById(id).orElse(null);
    }

    public List<Customer> getByFirstName(String firstName) {
        return customerDAO.findByFirstName(firstName);
    }

    public List<Customer> getByWaiterId(int waiterId) {
        return customerDAO.findByWaiterId(waiterId);
    }

    public Customer addCustomer(Customer customer) {
        return customerDAO.save(customer);
    }

    public void updateCustomerWaiter(int customerId, int waiterId) {
        customerDAO.updateCustomerWaiter(customerId, waiterId);
    }

    public void deleteCustomer(int id) {
        customerDAO.deleteById(id);
    }
}
