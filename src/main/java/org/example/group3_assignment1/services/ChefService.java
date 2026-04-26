//Adham Khalifa -- 418006637

package org.example.group3_assignment1.services;
import jakarta.transaction.Transactional;
import org.example.group3_assignment1.models.Chef;
import org.example.group3_assignment1.models.Dish;
import org.example.group3_assignment1.repositories.ChefDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Transactional
@Service
public class ChefService {

    @Autowired
    private ChefDAO chefDao;


    public List<Chef> getAllChefs(){
        return chefDao.findAll();
    }

    public List<String> getAllSpecialties(){
        List<String> specialtyList = chefDao.findAllSpecialty();
        if(specialtyList.isEmpty()){
            throw new RuntimeException("No available chefs can make this at the moment");
        }
        return specialtyList;
    }

    public Optional<Chef> getChefById(Long id){
        if(!chefDao.existsById(id)){
            throw new RuntimeException("Chef with that ID does not exist");
        }
        return chefDao.findByChefId(id);
    }

    public List<Chef> getChefByFullName(String fullName){

        String[] name = fullName.split(" ");
        if (name.length > 2) {
            throw new RuntimeException("Format should be \"first name last name\"");
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
        Set<Dish> associatedDishes = new LinkedHashSet<>(chefToSave.getDishList());
        for (Dish name : associatedDishes) {
            System.out.println(name.getDishName());
        }
        if(associatedDishes == null){
            throw new RuntimeException("Chef list is null");
        }
        if(!associatedDishes.isEmpty()){
            for (Dish associatedDish : associatedDishes) {
                associatedDish.setChef(chefToSave);
                associatedDish.setCategory(chefToSave.getSpecialty());
            }
        }
        chefToSave.setDishList(new ArrayList<>(associatedDishes));
        return chefDao.save(chefToSave);

    }
    
    public Optional<Chef> updateChefById(Long chefId, Chef chefToUpdate){
        System.out.println("it reached this point");
        chefDao.findById(chefId).orElseThrow(()->new RuntimeException("Chef doesn't Exist"));
        chefDao.updateChefById(chefId, chefToUpdate.getFirstName(), chefToUpdate.getLastName(), chefToUpdate.getEmail(), chefToUpdate.getSalary(), chefToUpdate.getSpecialty(), chefToUpdate.getYrsOfExperience());

        return getChefById(chefId);

    }

    public String deleteChefById(Long id){
        if(!chefDao.existsById(id)){
            throw new RuntimeException("Chef with that ID does not exist");
        }
        chefDao.deleteByChefId(id);
        return "Successfully deleted chef";
    }

}
