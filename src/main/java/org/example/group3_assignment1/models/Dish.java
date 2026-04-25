//Adham Khalifa -- 418006637

package org.example.group3_assignment1.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long dishId;

    @Column(length=30, nullable=false)
    private String dishName;

    @Column(length=200, nullable = false , unique = true)
    private String description;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String category;

    @Column
    private boolean available = true;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="chef_id", nullable = false)
    private Chef chef;

    public Dish(){}

    public Dish(String dishName,String description,String category, double price) {
        this.category = category;
        this.description = description;
        this.dishName = dishName;
        this.price = price;
    }


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

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }
}
