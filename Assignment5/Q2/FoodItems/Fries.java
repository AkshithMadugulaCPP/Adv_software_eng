package Assignment5.Q2.FoodItems;
import Assignment5.Q2.FoodItems.Food;


public class Fries implements Food {

    private double foodBasePrice;

    public Fries() {
        this.foodBasePrice = 3.99;
    }

    @Override
    public double calculatePrice() {
        return foodBasePrice;
    }

    @Override
    public String getDescription() { return "Fries"; }
}
