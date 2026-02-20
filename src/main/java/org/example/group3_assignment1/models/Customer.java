package org.example.group3_assignment1.models;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Customer {
    private int CustomerId;
    private String firstName;
    private String lastName;
    private String preference;
    private Waiter assignedWaiter;

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int CustomerId) {
        this.CustomerId = CustomerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getPreference() {
        return preference;
    }

    @Autowired
    public Customer(Waiter assignedWaiter){
        this.assignedWaiter = assignedWaiter;
    }



    @PostConstruct
    public void init(){
        this.CustomerId = 1;
        this.firstName = "Munzier";
        this.lastName = "Kashef";
        this.preference = "rice";
        
    }
}
