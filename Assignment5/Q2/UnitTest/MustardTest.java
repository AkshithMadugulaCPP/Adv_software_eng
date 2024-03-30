package Assignment5.Q2.UnitTest;

import Assignment5.Q2.AddOns.Mustard;
import Assignment5.Q2.FoodItems.Burger;
import Assignment5.Q2.FoodItems.Food;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MustardTest {

    private Food burger;

    @BeforeEach
    void setUp() {
        burger = new Burger();
    }

    @Test
    void calculatePrice() {
        Mustard mustard = new Mustard(burger);
        double expectedPrice = burger.calculatePrice() + 0.49; // Base price of burger + mustard topping price
        assertEquals(expectedPrice, mustard.calculatePrice());
    }

    @Test
    void getDescription() {
        Mustard mustard = new Mustard(burger);
        String expectedDescription = burger.getDescription() + ", Mustard"; // Description of burger + ", Mustard"
        assertEquals(expectedDescription, mustard.getDescription());
    }
}