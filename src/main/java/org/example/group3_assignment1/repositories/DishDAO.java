package org.example.group3_assignment1.repositories;


import org.example.group3_assignment1.models.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishDAO extends JpaRepository<Dish, Long> {

//    boolean existsByDishId(Long dishId);

    List<Dish> findAll();

    Dish findByDishId(long id);

    Dish findByDishName(String dishName);

    List<Dish> findByCategory(String category);

    @Query("Select d from Dish d where d.price <= :requestedPrice")
    List<Dish> findByPrice(@Param("requestedPrice") double price);

    @Modifying
    @Query("Update Dish d set d.available = :available where d.dishId = :id")
    int updateAvailableByDishId(@Param("available") boolean availability, @Param("id") Long dishId);

    @Modifying
    void deleteByDishId(long dishId);

}
