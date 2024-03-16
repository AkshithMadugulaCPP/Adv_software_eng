package Assignment4.Q2;

import Assignment4.Q2.enums.DietPlan;
import Assignment4.Q2.model.*;

public class Driver {
    public static void main(String[] args) {
        // Create customers with various diet plans
        Customer customer1 = new Customer("Akshith Madugula", DietPlan.NO_RESTRICTION);
        Customer customer2 = new Customer("Pandu", DietPlan.PALEO);
        Customer customer3 = new Customer("Lorry ", DietPlan.VEGAN);
        Customer customer4 = new Customer("Praneet", DietPlan.NUT_ALLERGY);
        Customer customer5 = new Customer("Deepakka", DietPlan.VEGAN);
        Customer customer6 = new Customer("Kavitha", DietPlan.PALEO);

        // Create an instance of the MealPlanner
        MealPlanner mealPlanner = new MealPlanner();

        // Generate meals for each customer and display them
        mealPlanner.generateAndDisplayMeal(customer1);
        mealPlanner.generateAndDisplayMeal(customer2);
        mealPlanner.generateAndDisplayMeal(customer3);
        mealPlanner.generateAndDisplayMeal(customer4);
        mealPlanner.generateAndDisplayMeal(customer5);
        mealPlanner.generateAndDisplayMeal(customer6);
    }
}    
    
