//Adham Khalifa -- 418006637

package org.example.group3_assignment1.repositories;
import org.example.group3_assignment1.models.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DishDAO extends JpaRepository<Dish, Long> {

    boolean existsByDishName(String dishName);

    boolean existsByCategory(String category);

    List<Dish> findAll();

    Optional<Dish> findByDishId(long id);

    List<Dish> findByDishName(String dishName);

    List<Dish> findByCategory(String category);


    List<Dish> findByPriceLessThan(double price);

    @Modifying
    @Query("Update Dish d set d.available = :available where d.dishId = :id")
    void updateAvailableByDishId(@Param("id") Long dishId, @Param("available") boolean availability);

    @Modifying
    @Query("Update Dish d set d.price = :price where d.dishId = :id")
    void updatePriceByDishId(@Param("id") Long dishId, @Param("price") Double price);

    @Modifying
    @Query("Update Dish d set d.description = :description where d.dishId = :id")
    void updateDescriptionByDishId( @Param("id") Long dishId, @Param("description") String description);


    void deleteByDishId(long dishId);

}
