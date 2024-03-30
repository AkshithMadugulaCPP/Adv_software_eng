package Assignment5.Q2.UnitTest;

import Assignment5.Q2.FoodItems.HotDogs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotDogsTest {

    private HotDogs hotDogs;

    @BeforeEach
    public void setup() {
        hotDogs = new HotDogs();
    }

    @Test
    public void testHotDogsCalculatePrice() {
        assertEquals(7.99, hotDogs.calculatePrice());
    }

    @Test
    public void testHotDogsDescription() {
        assertEquals("HotDogs", hotDogs.getDescription());
    }
}