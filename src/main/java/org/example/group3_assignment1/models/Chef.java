package org.example.group3_assignment1.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "chefs")
public class Chef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chefId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String specialty;

    @Column(nullable = false)
    private double yrsOfExperience;

    @Column(nullable = false)
    private double salary;



    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "chef")
    private List<Dish> dishList;

    public Chef(){};

    public Chef(String firstName, String lastName, String email,double salary, String specialty,double yrsOfExperience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.salary = salary;
        this.specialty = specialty;
        this.yrsOfExperience = yrsOfExperience;
    }

    public Long getChefId() {
        return chefId;
    }

    public void setChefId(Long chefId) {
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

    public List<Dish> getDishList() {
        return dishList;
    }
    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
