package org.example.group3_assignment1.services;


import org.example.group3_assignment1.models.Chef;
import org.example.group3_assignment1.models.Dish;
import org.example.group3_assignment1.repositories.ChefDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class ChefService {

    @Autowired
    private ChefDAO chefDao;


    public List<Chef> getAllChefs(){
        return chefDao.findAll();
    }

    public Optional<Chef> getChefById(Long id){
        if(!chefDao.existsById(id)){
            throw new RuntimeException("Chef with that ID does not exist");
        }
        return chefDao.findByChefId(id);
    }

    public List<Chef> getChefByFullName(String fullName){
        fullName = fullName.replace(" ", "");
        if(!fullName.contains(",")){
            throw new RuntimeException("First name and last name should be separated by a single comma");
        }
        String[] name = fullName.split(",");
        if (name.length > 2) {
            throw new RuntimeException("Format should be \"first name,last name\"");
        }
        String firstName = name[0];
        String lastName = name[1];
        System.out.println(firstName + lastName);
        if(!chefDao.existsByFirstName(firstName) && !chefDao.existsByLastName(lastName)){
            throw new RuntimeException("Chef with that name does not exist");
        }
        return chefDao.findByFullName(firstName, lastName);
    }


    public List<Chef> getChefBySpecialty(String specialty){
        if(!chefDao.existsBySpecialty(specialty)){
            throw new RuntimeException("Chef with that specialty does not exist");
        }

        return chefDao.findBySpecialty(specialty);
    }

    public Chef saveChef(Chef chefToSave){
        System.out.println("it reached");
        if(chefDao.existsByEmail(chefToSave.getEmail())){
            throw new RuntimeException("Chef already exists!!!");
        }
        if(chefToSave.getEmail() == null || chefToSave.getEmail().isEmpty()){
            throw new IllegalArgumentException("Chef email cannot be null or empty");
        }
        List<Dish> associatedDishes = chefToSave.getDishList();

        if(associatedDishes == null){
            throw new RuntimeException("Chef list is null");
        }
        if(!associatedDishes.isEmpty()){
            for (Dish associatedDish : associatedDishes) {
                associatedDish.setChef(chefToSave);
                associatedDish.setCategory(chefToSave.getSpecialty());
            }
        }
        return chefDao.save(chefToSave);

    }
    
    public Chef updateChefById(Long id, String email, Double salary, Double yrsOfExperience){
        System.out.println("it reached this point");
        Chef existingChef = chefDao.findById(id).orElseThrow(()->new RuntimeException("Chef doesn't Exist"));
        existingChef.setEmail(email);
        existingChef.setSalary(salary);
        existingChef.setYrsOfExperience(yrsOfExperience);
        return (saveChef(existingChef));

    }

    public String deleteChefById(Long id){
        if(!chefDao.existsById(id)){
            throw new RuntimeException("Chef with that ID does not exist");
        }
        chefDao.deleteById(id);
        return "Successfully deleted chef";
    }

}
