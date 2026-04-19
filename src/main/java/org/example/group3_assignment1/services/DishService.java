package org.example.group3_assignment1.services;


import jakarta.transaction.Transactional;
import org.example.group3_assignment1.models.Dish;
import org.example.group3_assignment1.repositories.DishDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DishService {

    @Autowired
    private DishDAO dishDao;


    public List<Dish> findAll(){
        return dishDao.findAll();
    }

    public List<Dish> findByDishId(Long id){
        if(!dishDao.existsById(id)){
            throw new RuntimeException("Dish with that ID does not exist");
        }
        return List.of(dishDao.findByDishId(id));
    }

    public List<Dish> findByDishName(String dishName){
        if(!dishDao.existsByDishName(dishName)){
            throw new RuntimeException("Dish with that name does not exist");
        }

        return List.of(dishDao.findByDishName(dishName));
    }

    public List<Dish> findByCategory(String category){
        if(!dishDao.existsByCategory(category)){
            throw new RuntimeException("Dish with that category does not exist");
        }

        return dishDao.findByCategory(category);
    }

    public List<Dish> findByPrice(double price){
        return dishDao.findByPrice(price);
    }

    public int updateAvailableByDishId(boolean available, Long dishId){
        if(!dishDao.existsById(dishId)){
            throw new RuntimeException("Dish with that ID does not exist");
        }
        return dishDao.updateAvailableByDishId(available,dishId);

    }

    public void deleteByDishId(Long dishId){
        if(!dishDao.existsById(dishId)){
            throw new RuntimeException("Dish with that ID does not exist");
        }
        dishDao.deleteByDishId(dishId);
    }







}
