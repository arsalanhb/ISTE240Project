//Adham Khalifa -- 418006637

package org.example.group3_assignment1.services;
import jakarta.transaction.Transactional;
import org.example.group3_assignment1.models.Chef;
import org.example.group3_assignment1.models.Dish;
import org.example.group3_assignment1.repositories.ChefDAO;
import org.example.group3_assignment1.repositories.DishDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Transactional
public class DishService {
    private Random rand = new Random();

    @Autowired
    private DishDAO dishDao;

    @Autowired
    private ChefDAO chefDao;


    public List<Dish> findAll(){
        return dishDao.findAll();
    }


    public Optional<Dish> findByDishId(Long id){
        if(!dishDao.existsById(id)){
            throw new RuntimeException("Dish with that ID does not exist");
        }
        return dishDao.findByDishId(id);
    }

    public List<Dish> findByDishName(String dishName){
        if(!dishDao.existsByDishName(dishName)){
            throw new RuntimeException("Dish with that name does not exist");
        }

        return dishDao.findByDishName(dishName);
    }

    public List<Dish> findByCategory(String category){
        if(!dishDao.existsByCategory(category)){
            throw new RuntimeException("Dish with that category does not exist");
        }

        return dishDao.findByCategory(category);
    }

    public List<Dish> findByPrice(double price){
        return dishDao.findByPriceLessThan(price);
    }


    public Optional<Dish> updateDishById(Long dishId, Dish updatedDish){
        System.out.println("it reached this point");
        System.out.println(dishId);
        Dish existingDish = dishDao.findById(dishId).orElseThrow(()->new RuntimeException("Dish doesn't Exist"));
        dishDao.updateDishById(dishId, updatedDish.getDishName(), updatedDish.getDescription(), existingDish.getCategory(),updatedDish.getPrice(), updatedDish.isAvailable());
        return findByDishId(dishId);

    }

    public String deleteByDishId(Long dishId){
        if(!dishDao.existsById(dishId)){
            throw new RuntimeException("Dish with that ID does not exist");
        }
        dishDao.deleteByDishId(dishId);
        return "Successfully deleted dish";
    }

    public Dish saveDish(Dish dishToSave){
        if(dishDao.existsByDishName(dishToSave.getDishName())){
            throw new RuntimeException("Dish already exists: " + dishToSave.getDishName());
        }

        if(dishToSave.getDishName() == null || dishToSave.getDishName().isEmpty()){
            throw new IllegalArgumentException("Dish cannot be null or empty");
        }
        System.out.println("save dish here");
        List<Chef> chefs = chefDao.findBySpecialty(dishToSave.getCategory());
        if(chefs.isEmpty()){
            throw new RuntimeException("No chef available for such a category");
        }
        dishToSave.setChef(chefs.get(rand.nextInt(chefs.size())));
        System.out.println(dishToSave.getChef());
        return dishDao.save(dishToSave);

    }







}
