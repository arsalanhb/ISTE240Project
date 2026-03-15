package org.example.group3_assignment1.services;

import org.example.group3_assignment1.models.Chef;
import org.example.group3_assignment1.models.Customer;
import org.example.group3_assignment1.models.Dish;
import org.example.group3_assignment1.models.Waiter;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RestaurantService {
    private List<Waiter> waiterList= new ArrayList<>();
    private List<Chef> chefList = new ArrayList<>();
    private List<Customer> customerList = new ArrayList<>();
    private List<Dish> allDishes = new ArrayList<>();
    private List<Dish> mexDishList = new ArrayList<>();
    private List<Dish> italDishList = new ArrayList<>();
    private List<Dish> pakDishList = new ArrayList<>();
    private HashMap<String, List<Dish>> link = new HashMap<>();


    public RestaurantService(){
        Waiter waiter1 = new Waiter(1, "John", "Doe", 20000.0);
        Waiter waiter2 = new Waiter(2, "Jane", "Doe", 19000.0);
        Waiter waiter3 = new Waiter(2, "Jack", "Doe", 19000.0);
        Waiter waiter4 = new Waiter(2, "Jenny", "Doe", 19000.0);
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

        Dish dish1 = new Dish(true, "Mexican","Beef, Lettuce, Tomato put in hard taco shell", "Taco",20);
        Dish dish2 = new Dish(true, "Mexican", "Rolled tortillas stuffed with chicken, beef, or cheese, topped with red or green sauce", "Enchiladas", 22);
        Dish dish3 = new Dish(true, "Mexican","Flour tortilla filled with melted cheese and your choice of meat, folded in half and grilled", "Quesadilla", 15);
        Dish dish4 = new Dish(true, "Mexican", "Sizzling grilled meat, peppers, and onions, served with tortillas and various toppings", "Fajitas", 25);

        mexDishList.add(dish1);
        mexDishList.add(dish2);
        mexDishList.add(dish3);
        mexDishList.add(dish4);

        Dish dish5 = new Dish(true, "Italian","Pasta served with a rich meat sauce made from ground beef, tomatoes, onions, and garlic", "Spaghetti Bolognese", 18);
        Dish dish6 = new Dish(true, "Italian", "Layered pasta sheets with a combination of meat sauce, béchamel, and cheese", "Lasagna", 22);
        Dish dish7 = new Dish(true, "Italian", "Thin crust pizza topped with fresh mozzarella, basil, and tomato sauce", "Margherita Pizza", 15);

        italDishList.add(dish5);
        italDishList.add(dish6);
        italDishList.add(dish7);

        Chef mexChef = new Chef(1, "Gordon", "Ramsey", 40000.0, "Mexican", mexDishList,12);
        Chef italChef = new Chef(2, "Francesco", "Ritza", 40000.0, "Italian", italDishList,12);
        chefList.add(mexChef);
        chefList.add(italChef);

        link.put("Mexican", mexDishList);
        link.put("Italian", italDishList);
        link.put("Pakistani", pakDishList);


        allDishes.addAll(this.mexDishList);
        allDishes.addAll(this.italDishList);
        allDishes.addAll(this.pakDishList);



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
        if(newDish.getCategory().equalsIgnoreCase("Mexican")){
            this.mexDishList.add(newDish);
        }
        else if(newDish.getCategory().equalsIgnoreCase("Italian")){
            this.italDishList.add(newDish);
        }
        else if(newDish.getCategory().equalsIgnoreCase("Pakistani")){
            this.pakDishList.add(newDish);
        }
    }




}
