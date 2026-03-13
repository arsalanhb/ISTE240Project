package org.example.group3_assignment1.models;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

public class Chef {
    private int chefId;
    private String firstName;
    private String lastName;
    private String specialty;
    private double yrsOfExperience;
    private double salary;

    public Chef(int chefId, String firstName, String lastName, double salary, String specialty, double yrsOfExperience) {
        this.chefId = chefId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.specialty = specialty;
        this.yrsOfExperience = yrsOfExperience;
    }

    public int getChefId() {
        return chefId;
    }

    public void setChefId(int chefId) {
        this.chefId = chefId;
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public double getYrsOfExperience() {
        return yrsOfExperience;
    }

    public void setYrsOfExperience(double yrsOfExperience) {
        this.yrsOfExperience = yrsOfExperience;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


}
