package Assignment5.Q2.UnitTest;

import Assignment5.Q2.AddOns.Ketchup;
import Assignment5.Q2.FoodItems.Burger;
import Assignment5.Q2.FoodItems.Food;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KetchupTest {

    private Food burger;

    @BeforeEach
    void setUp() {
        burger = new Burger();
    }

    @Test
    void calculatePrice() {
        Ketchup ketchup = new Ketchup(burger);
        double expectedPrice = burger.calculatePrice() + 0.25; // Base price of burger + ketchup topping price
        assertEquals(expectedPrice, ketchup.calculatePrice());
    }

    @Test
    void getDescription() {
        Ketchup ketchup = new Ketchup(burger);
        String expectedDescription = burger.getDescription() + ", Ketchup"; // Description of burger + ", Ketchup"
        assertEquals(expectedDescription, ketchup.getDescription());
    }
}