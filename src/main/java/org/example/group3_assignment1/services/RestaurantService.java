package org.example.group3_assignment1.services;

import org.example.group3_assignment1.models.Chef;
import org.example.group3_assignment1.models.Customer;
import org.example.group3_assignment1.models.Dish;
import org.example.group3_assignment1.models.Waiter;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {
    private List<Waiter> waiterList= new ArrayList<>();
    private Chef mainChef = new Chef(1, "Gordon", "Ramsey", 40000.0, "British", 12);
    private List<Customer> customerList = new ArrayList<>();
    private List<Dish> dishList = new ArrayList<>();


    public RestaurantService(){
        Waiter waiter1 = new Waiter(1, "John", "Doe", 20000.0);
        Waiter waiter2 = new Waiter(2, "Jane", "Doe", 19000.0);
        waiterList.add(waiter1);
        waiterList.add(waiter2);

        Customer cus1 = new Customer(waiter1, 1, "Ahmed", "Badr", "Mexican");
        Customer cus2 = new Customer(waiter2, 2, "Maryam", "Bassem", "Arabic");
        Customer cus3 = new Customer(waiter2, 3, "Jason", "Snow", "Mexican");
        customerList.add(cus1);
        customerList.add(cus2);
        customerList.add(cus3);

        Dish dish1 = new Dish(true, "Mexican", mainChef, "Beef, Lettuce, Tomato put in hard taco shell", "Taco",20);
        Dish dish2 = new Dish(true, "Italian", mainChef, "Spaghetti and tomato sauce with shredded cheese", "Spaghetti",20);
        dishList.add(dish1);
        dishList.add(dish2);

    }

    public List<Waiter> findAllWaiters(){
        return this.waiterList;
    }
    public List<Customer> findAllCustomers(){
        return this.customerList;
    }
    public List<Dish> findAllDishes(){
        return this.dishList;
    }

    public Chef getChef(){
        return this.mainChef;
    }

    public void addCustomer(Customer newCus){
        this.customerList.add(newCus);
    }

    public void addDish(Dish newDish){
        this.dishList.add(newDish);
    }


}
