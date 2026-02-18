package org.example.group3_assignment1.models;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Dish {
    private String dishName;
    private String description;
    private double price;
    private String category;
    private boolean available;

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @PostConstruct
    public void init(){
        this.dishName = "Mulukhiya";
        this.description = "Mulukhiya is a traditional Egyptian dish made from jute leaves, " +
                "cooked with garlic and coriander, and typically served with rice and chicken.";
        this.price = 15;
        this.category = "Main Course";
        this.available = true;
    }
}
