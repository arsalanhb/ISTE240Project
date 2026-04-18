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

    public List<Dish> decision(String value, String option){
        List<Dish> dishList = new ArrayList<Dish>();
        if (value.isEmpty()){
            throw new IllegalArgumentException("Cannot accept empty values");
        }
        if(option.equals("dishId")){
            dishList.add(findByDishId(Long.parseLong(value)));
        }
        else if (option.equals("dishName")){
             dishList.add(findByDishName(value));
        }
        else if (option.equals("category")){
            return findByCategory(value);
        }
        else if (option.equals("price")){
            return findByPrice(Double.parseDouble(value));
        }
        return dishList;
    }

    public List<Dish> findAll(){
        return dishDao.findAll();
    }

    public Dish findByDishId(Long id){
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
