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

    public List<Chef> getChefById(Long id){
        if(!chefDao.existsById(id)){
            throw new RuntimeException("Dish with that ID does not exist");
        }
        return (List.of(chefDao.findByChefId(id)));
    }

    public List<Chef> getChefByFirstName(String firstName){
        if(!chefDao.existsByFirstName(firstName)){
            throw new RuntimeException("Dish with that ID does not exist");
        }
        return chefDao.findByFirstName(firstName);
    }


    public List<Chef> getChefBySpecialty(String specialty){
        if(!chefDao.existsBySpecialty(specialty)){
            throw new RuntimeException("Dish with that category does not exist");
        }

        return chefDao.findBySpecialty(specialty);
    }

    public List<Chef> saveChef(Chef chefToSave){
        System.out.println("it reached");
        if(chefDao.existsByEmail(chefToSave.getEmail())){
            throw new RuntimeException("Chef already exists!!!");
        }

        if(chefToSave.getEmail() == null || chefToSave.getEmail().isEmpty()){
            throw new IllegalArgumentException("Dish cannot be null or empty");
        }
        System.out.println(chefDao.save(chefToSave).getFirstName());
        return List.of(chefDao.save(chefToSave));

    }
    
    public List<Chef> updateChefById(Long id, Chef updatedChef){
        System.out.println("it reached this point");

        Chef existingChef = chefDao.findById(id).orElseThrow(()->new RuntimeException("Dish doesn't Exist"));
        existingChef.setFirstName(updatedChef.getFirstName());
        existingChef.setLastName(updatedChef.getLastName());
        existingChef.setSpecialty(updatedChef.getSpecialty());
        existingChef.setEmail(updatedChef.getEmail());
        existingChef.setSalary(updatedChef.getSalary());
        existingChef.setYrsOfExperience(updatedChef.getYrsOfExperience());
        return (saveChef(existingChef));

    }

    public String deleteChefById(Long id){
        if(!chefDao.existsById(id)){
            throw new RuntimeException("Dish with that ID does not exist");
        }
        chefDao.deleteById(id);
        return "Successfully deleted dish";
    }

}
