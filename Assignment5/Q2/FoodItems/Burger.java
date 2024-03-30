package Assignment5.Q2.FoodItems;
import Assignment5.Q2.FoodItems.Food;


public class Burger implements Food {

    private double foodBasePrice;

    public Burger() {
        this.foodBasePrice = 10.00;
    }

    @Override
    public double calculatePrice() {
        return foodBasePrice;
    }

    @Override
    public String getDescription() { return "Burger"; }
}
