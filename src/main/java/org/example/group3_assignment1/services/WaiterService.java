//Muhammad Arsalan Habib - 403000286
package org.example.group3_assignment1.services;

import org.example.group3_assignment1.models.Waiter;
import org.example.group3_assignment1.repositories.WaiterDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.group3_assignment1.repositories.CustomerDAO;

import java.util.List;

@Service
public class WaiterService {

    @Autowired
    private WaiterDAO waiterDao;

    @Autowired
    private CustomerDAO customerDao;

    public List<Waiter> getAllWaiters() {
        return waiterDao.findAll();
    }
    public List<Waiter> getWaiterById(int id) {
        if (!waiterDao.existsById(id)) {
            throw new RuntimeException("Waiter with that ID does not exist");
        }
        return List.of(waiterDao.findById(id).orElseThrow(() -> new RuntimeException("Waiter not found")));
    }
    public List<Waiter> getWaiterByFirstName(String firstName) {
        if (!waiterDao.existsByFirstName(firstName)) {
            throw new RuntimeException("Waiter with that first name does not exist");
        }
        return waiterDao.findByFirstName(firstName);
    }
    public List<Waiter> getWaitersBySalary(double minSalary) {
        return waiterDao.findBySalaryGreaterThanEqual(minSalary);
    }
    public List<Waiter> saveWaiter(Waiter waiterToSave) {
        System.out.print("Reached Service");
        if (waiterToSave.getFirstName() == null || waiterToSave.getFirstName().isEmpty()) {
            throw new IllegalArgumentException("Waiter first name cannot be null or empty");
        }
        return List.of(waiterDao.save(waiterToSave));
    }
    public List<Waiter> updateWaiterById(int id, Waiter updatedWaiter) {
        Waiter existingWaiter = waiterDao.findById(id).orElseThrow(() -> new RuntimeException("Waiter doesn't exist"));
        existingWaiter.setFirstName(updatedWaiter.getFirstName());
        existingWaiter.setLastName(updatedWaiter.getLastName());
        existingWaiter.setSalary(updatedWaiter.getSalary());

        return List.of(waiterDao.save(existingWaiter));
    }
    public String deleteWaiterById(int id) {
        if (!waiterDao.existsById(id)) {
            throw new RuntimeException("Waiter with that ID does not exist");
        }
        customerDao.unassignWaiterFromCustomers(id);
        waiterDao.deleteById(id);
        return "Successfully deleted waiter";
    }

}