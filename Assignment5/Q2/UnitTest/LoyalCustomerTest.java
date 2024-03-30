package Assignment5.Q2.UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import Assignment5.Q2.AddOns.Cheese;
import Assignment5.Q2.CustomerTypes.Customer;
import Assignment5.Q2.CustomerTypes.LoyalCustomer;
import Assignment5.Q2.FoodItems.Burger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoyalCustomerTest {

    private Customer loyalCustomer;
    private LoyalCustomer loyalCustomerWithDiscount;

    @BeforeEach
    void setUp() {
        loyalCustomer = new Customer(true);
        loyalCustomer.addOrder(new Burger());
        loyalCustomer.addOrder(new Cheese(new Burger()));
        loyalCustomerWithDiscount = new LoyalCustomer(loyalCustomer);
    }

    @Test
    void testApplyDiscountAndCalculatePrice() {
        // Total cost without discount for loyal customer
        double totalCostWithoutDiscount = loyalCustomer.calculatePriceForOrders();

        // Expected total cost after applying discount
        double expectedTotalCost = totalCostWithoutDiscount - (totalCostWithoutDiscount * 0.25);

        // Actual total cost after applying discount
        double actualTotalCost = loyalCustomerWithDiscount.applyDiscountAndCalculatePrice();

        assertEquals(expectedTotalCost, actualTotalCost);
    }
}