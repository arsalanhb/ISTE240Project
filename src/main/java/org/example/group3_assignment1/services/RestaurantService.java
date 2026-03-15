package org.example.group3_assignment1.services;

import org.example.group3_assignment1.models.Chef;
import org.example.group3_assignment1.models.Customer;
import org.example.group3_assignment1.models.Dish;
import org.example.group3_assignment1.models.Waiter;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class RestaurantService {
    private List<Waiter> waiterList= new ArrayList<>();
    private List<Chef> chefList = new ArrayList<>();
    private List<Customer> customerList = new ArrayList<>();
    private List<Dish> allDishes = new ArrayList<>();
    private List<Dish> jorDishList = new ArrayList<>();
    private List<Dish> greDishList = new ArrayList<>();
    private List<Dish> turDishList = new ArrayList<>();
    private HashMap<String, List<Dish>> link = new HashMap<>();


    public RestaurantService(){
        Waiter waiter1 = new Waiter(1, "John", "Doe", 20000.0);
        Waiter waiter2 = new Waiter(2, "Jane", "Doe", 19000.0);
        Waiter waiter3 = new Waiter(3, "Jack", "Doe", 19000.0);
        Waiter waiter4 = new Waiter(4, "Jenny", "Doe", 19000.0);
        waiterList.add(waiter1);
        waiterList.add(waiter2);
        waiterList.add(waiter3);
        waiterList.add(waiter4);

        Customer cus1 = new Customer(waiter1, 1, "Ahmed", "Badr", "Mexican");
        Customer cus2 = new Customer(waiter2, 2, "Maryam", "Bassem", "Arabic");
        Customer cus3 = new Customer(waiter2, 3, "Jason", "Snow", "Mexican");
        customerList.add(cus1);
        customerList.add(cus2);
        customerList.add(cus3);
        Dish dish1 = new Dish(true, "Jordanian", "Rice cooked with yogurt sauce and served with lamb", "Mansaf", 25);
        Dish dish2 = new Dish(true, "Jordanian", "Layered rice, meat, and vegetables baked together", "Maqluba", 22);
        Dish dish3 = new Dish(true, "Jordanian", "Chickpea patties deep-fried, served with tahini and salad", "Falafel", 15);

        jorDishList.add(dish1);
        jorDishList.add(dish2);
        jorDishList.add(dish3);

        Dish dish4 = new Dish(true, "Greek", "Grilled lamb or beef with vegetables and tzatziki sauce", "Souvlaki", 22);
        Dish dish5 = new Dish(true, "Greek", "Layered pastry with spinach and feta cheese", "Spanakopita", 18);
        Dish dish6 = new Dish(true, "Greek", "Layers of eggplant, minced meat, tomatoes, and béchamel", "Moussaka", 25);

        greDishList.add(dish4);
        greDishList.add(dish5);
        greDishList.add(dish6);

        Dish dish7 = new Dish(true, "Turkish", "Grilled minced meat or chicken on skewers, served with rice", "Kebab", 20);
        Dish dish8 = new Dish(true, "Turkish", "Thin dough topped with minced meat, vegetables, and spices, baked", "Lahmacun", 16);
        Dish dish9 = new Dish(true, "Turkish", "Grilled cheese from goat or cow milk, served with vegetables", "Grilled Halloumi", 15);

        turDishList.add(dish7);
        turDishList.add(dish8);
        turDishList.add(dish9);

        Chef jorChef = new Chef(1, "Ahmad", "Al-Khaled", 40000.0, "Jordanian", jorDishList, 12);
        Chef greChef = new Chef(2, "Francesco", "Ritza", 40000.0, "Greek", greDishList, 12);

        chefList.add(jorChef);
        chefList.add(greChef);

        link.put("Jordanian", jorDishList);
        link.put("Greek", greDishList);
        link.put("Turkish", turDishList);


        allDishes.addAll(this.jorDishList);
        allDishes.addAll(this.greDishList);
        allDishes.addAll(this.turDishList);



    }

    public List<Waiter> findAllWaiters(){
        return this.waiterList;
    }
    public List<Customer> findAllCustomers(){
        return this.customerList;
    }

    public List<Chef> findAllChefs(){
        return this.chefList;
    }
    public List<Dish> findAllDishes(){
        return this.allDishes;
    }

    public HashMap<String, List<Dish>> findMap(){
        return this.link;
    }


    public void addCustomer(Customer newCus){
        this.customerList.add(newCus);
    }

    public void addChef(Chef newChef){
        this.chefList.add(newChef);
    }

    public void addDish(Dish newDish){
        System.out.print(newDish.getCategory());
        this.allDishes.add(newDish);
        if(newDish.getCategory().equalsIgnoreCase("Jordanian")){
            this.jorDishList.add(newDish);
        }
        else if(newDish.getCategory().equalsIgnoreCase("Greek")){
            this.greDishList.add(newDish);
        }
        else if(newDish.getCategory().equalsIgnoreCase("Turkish")){
            this.turDishList.add(newDish);
        }
    }
    public void addWaiter(Waiter newWaiter) {
        this.waiterList.add(newWaiter);
    }



}
