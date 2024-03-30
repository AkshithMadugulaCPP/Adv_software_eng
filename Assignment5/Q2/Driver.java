package Assignment5.Q2;
import Assignment5.Q2.FoodItems.*;
import Assignment5.Q2.AddOns.*;
import Assignment5.Q2.CustomerTypes.*;

import java.text.DecimalFormat;


public class Driver {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        Food fries = new Fries();
        Food burger = new Burger();
        Food hotdog = new HotDogs();

        // adding toppings to fries
        Toppings cheeseFries = new Cheese(fries);
        Toppings cheeseAndKetchupFries = new Ketchup(cheeseFries);


        // adding toppings to burger
        Toppings cheeseBurger = new Cheese(burger);

        // adding toppings for hotdog
        Toppings mustardHotDog = new Mustard(hotdog);
        Toppings ketchupMustardHotDog = new Ketchup(mustardHotDog);


        Customer customer1 = new Customer(false);
        customer1.addOrder(burger);
        customer1.showOrder();
        LoyalCustomer nonLoyalCustomer = new LoyalCustomer(customer1);
        System.out.println("Final Cost: $" + decimalFormat.format(nonLoyalCustomer.applyDiscountAndCalculatePrice()));
        System.out.println("-------------------------------------------------------------");

        // customer with 2 orders
        Customer customer2 = new Customer(true);
        customer2.addOrder(cheeseAndKetchupFries);
        customer2.addOrder(cheeseBurger);
        customer2.showOrder();
        LoyalCustomer loyalCustomer = new LoyalCustomer(customer2);
        System.out.println("Final Cost: $" + decimalFormat.format(loyalCustomer.applyDiscountAndCalculatePrice()));
        System.out.println("-------------------------------------------------------------");

        // customer with same order, but the customer is loyal customer so discount will be applied
        Customer customer3 = new Customer(false);
        customer3.addOrder(cheeseAndKetchupFries);
        customer3.addOrder(cheeseBurger);
        customer3.showOrder();
        LoyalCustomer nonLoyalCustomer1 = new LoyalCustomer(customer3);
        System.out.println("Final Cost: $" + decimalFormat.format(nonLoyalCustomer1.applyDiscountAndCalculatePrice()));
        System.out.println("-------------------------------------------------------------");

        // customer 4 and loyal customer
        Customer customer4 = new Customer(true);
        customer4.addOrder(cheeseBurger);
        customer4.addOrder(ketchupMustardHotDog);
        customer4.addOrder(cheeseAndKetchupFries);
        customer4.showOrder();
        LoyalCustomer loyalCustomer1 = new LoyalCustomer(customer4);
        System.out.println("Final Cost: $" + decimalFormat.format(loyalCustomer1.applyDiscountAndCalculatePrice()));
        System.out.println("-------------------------------------------------------------");

    }
}
