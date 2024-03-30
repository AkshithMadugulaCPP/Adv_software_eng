package Assignment5.Q2.UnitTest;

import Assignment5.Q2.AddOns.Cheese;
import Assignment5.Q2.FoodItems.Burger;
import Assignment5.Q2.FoodItems.Food;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheeseTest {

    private Food burger;

    @BeforeEach
    void setUp() {
        burger = new Burger();
    }

    @Test
    void calculatePrice() {
        Cheese cheese = new Cheese(burger);
        double expectedPrice = burger.calculatePrice() + 0.99; // Base price of burger + cheese topping price
        assertEquals(expectedPrice, cheese.calculatePrice());
    }

    @Test
    void getDescription() {
        Cheese cheese = new Cheese(burger);
        String expectedDescription = burger.getDescription() + ", Cheese"; // Description of burger + ", Cheese"
        assertEquals(expectedDescription, cheese.getDescription());
    }
}