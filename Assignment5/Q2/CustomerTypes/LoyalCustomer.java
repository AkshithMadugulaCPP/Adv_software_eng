package Assignment5.Q2.CustomerTypes;

public class LoyalCustomer {

    private double discountRate = 0.25;
    private Customer customer;

    public LoyalCustomer(Customer customer) {
        this.customer = customer;
    }

    public double applyDiscountAndCalculatePrice() {
        double lvTotalCost = customer.calculatePriceForOrders();
        return customer.isDiscountable() ? lvTotalCost - (lvTotalCost * discountRate) : lvTotalCost;
    }
}
