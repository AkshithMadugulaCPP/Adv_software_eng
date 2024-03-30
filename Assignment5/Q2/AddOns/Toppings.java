package Assignment5.Q2.AddOns;
import Assignment5.Q2.FoodItems.Food;
public abstract class Toppings implements Food {
    protected Food food;
    protected double toppingPrice;

    public Toppings(Food food) {
        this.food = food;
    }

    public double calculatePrice() {
        return food.calculatePrice();
    }


    public String getDescription() {
        return food.getDescription();
    }
}


