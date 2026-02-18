package org.example.group3_assignment1.models;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Waiter {
    private int id;
    private String firstName;
    private String lastName;
    private double salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @PostConstruct
    public void init(){
        this.id = 5;
        this.firstName = "Adham";
        this.lastName = "Khalifa";
        this.salary = 1000;

    }
}
