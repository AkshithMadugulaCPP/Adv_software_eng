package Assignment5.Q2.UnitTest;

import Assignment5.Q2.FoodItems.Fries;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class FriesTest {

    private Fries fries;

    @BeforeEach
    void setUp() {
        fries = new Fries();
    }

    @Test
    void calculatePrice() {
        double expectedPrice = 3.99;
        assertEquals(expectedPrice, fries.calculatePrice());
    }

    @Test
    void getDescription() {
        String expectedDescription = "Fries";
        assertEquals(expectedDescription, fries.getDescription());
    }
}