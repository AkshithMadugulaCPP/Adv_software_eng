package Assignment5.Q2.FoodItems;
import Assignment5.Q2.FoodItems.Food;


public class HotDogs implements Food {

    private double foodBasePrice;

    public HotDogs() {
        this.foodBasePrice = 7.99;
    }

    @Override
    public double calculatePrice() {
        return foodBasePrice;
    }

    @Override
    public String getDescription() { return "HotDogs"; }
}
