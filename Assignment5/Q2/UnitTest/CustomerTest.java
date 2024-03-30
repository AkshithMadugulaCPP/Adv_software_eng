package Assignment5.Q2.UnitTest;

import Assignment5.Q2.AddOns.Cheese;
import Assignment5.Q2.CustomerTypes.Customer;
import Assignment5.Q2.FoodItems.Burger;
import Assignment5.Q2.FoodItems.Food;
import Assignment5.Q2.FoodItems.Fries;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer loyalCustomer;
    private Customer regularCustomer;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final DecimalFormat decimalFormat = new DecimalFormat("0.00");

    @BeforeEach
    void setUp() {
        loyalCustomer = new Customer(true);
        regularCustomer = new Customer(false);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testAddOrder() {
        Food burger = new Burger();
        loyalCustomer.addOrder(burger);

        List<Food> loyalOrders = loyalCustomer.getOrders();
        assertEquals(1, loyalOrders.size());
        assertEquals(burger, loyalOrders.getFirst());
    }

    @Test
    void testCalculatePriceForOrders() {
        Food fries = new Fries();
        Food cheeseFries = new Cheese(new Fries());

        loyalCustomer.addOrder(fries);
        loyalCustomer.addOrder(cheeseFries);

        assertEquals(8.97, loyalCustomer.calculatePriceForOrders());
    }

    @Test
    void testIsDiscountable() {
        assertEquals(true, loyalCustomer.isDiscountable());
        assertEquals(false, regularCustomer.isDiscountable());
    }


    @Test
    void testShowOrder() {
        Food burger = new Burger();
        Food cheeseBurger = new Cheese(new Burger());

        loyalCustomer.addOrder(burger);
        loyalCustomer.addOrder(cheeseBurger);

        double burgerPrice = burger.calculatePrice();
        double cheeseBurgerPrice = cheeseBurger.calculatePrice();
        double totalCost = burgerPrice + cheeseBurgerPrice;

        String expectedOutput = "Item: " + burger.getDescription() + " and its Cost: $" + String.format("%,.1f", burgerPrice) + System.lineSeparator() +
                "Item: " + cheeseBurger.getDescription() + " and its Cost: $" + String.format("%,.2f", cheeseBurgerPrice) + System.lineSeparator() +
                "Total Cost: $" + String.format("%,.2f", totalCost) + System.lineSeparator() +
                "Is a Loyal Customer" + System.lineSeparator();

        loyalCustomer.showOrder();
        assertEquals(expectedOutput, outContent.toString());
    }
}