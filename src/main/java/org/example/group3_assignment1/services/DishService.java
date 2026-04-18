package org.example.group3_assignment1.services;


import jakarta.transaction.Transactional;
import org.example.group3_assignment1.models.Dish;
import org.example.group3_assignment1.repositories.DishDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DishService {

    @Autowired
    private DishDAO dishDao;

    public List<Dish> findAll(){
        return dishDao.findAll();
    }

    public Dish findByDishId(long id){
        return dishDao.findByDishId(id);
    }

    public Dish findByDishName(String dishName){
        return dishDao.findByDishName(dishName);
    }

    public List<Dish> findByCategory(String category){
        return dishDao.findByCategory(category);
    }

    public List<Dish> findByPrice(double price){
        return dishDao.findByPrice(price);
    }





}
