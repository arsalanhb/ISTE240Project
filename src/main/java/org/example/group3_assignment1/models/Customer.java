package org.example.group3_assignment1.models;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;
    @Column(name = "preference", length = 100, nullable = false)
    private String preference;

    @ManyToOne
    private Waiter assignedWaiter;

    public Customer(Waiter assignedWaiter, String firstName, String lastName, String preference) {
        this.assignedWaiter = assignedWaiter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.preference = preference;
    }

    public Customer() {}

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int CustomerId) {
        this.customerId = CustomerId;
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



}
