package Assignment5.Q2.UnitTest;

import Assignment5.Q2.FoodItems.Burger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BurgerTest {
    private Burger burger;
    @BeforeEach
    void setUp(){
        burger = new Burger();
    }
    @Test
    public void testCalculatePrice() {
        double expectedPrice = 10.00;
        assertEquals(expectedPrice, burger.calculatePrice());
    }

    @Test
    public void testGetDescription() {
        String expectedDescription = "Burger";
        assertEquals(expectedDescription, burger.getDescription());
    }
}