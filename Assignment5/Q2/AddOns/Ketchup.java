package Assignment5.Q2.AddOns;
import Assignment5.Q2.FoodItems.Food;

public class Ketchup extends Toppings {
    public Ketchup(Food food) {
        super(food);
        super.toppingPrice = 0.25;
    }

    @Override
    public double calculatePrice() {
        return food.calculatePrice() + super.toppingPrice;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Ketchup";
    }
}