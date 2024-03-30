package Assignment5.Q2.CustomerTypes;

import Assignment5.Q2.FoodItems.Food;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
public class Customer extends LoyaltyStatus {
    private List<Food> orders;
    private boolean loyalCustomer;

    private DecimalFormat decimalFormat = new DecimalFormat("0.00");

    public Customer(boolean loyalCustomer) {
        this.loyalCustomer = loyalCustomer;
        orders = new ArrayList<>();
    }

    public void addOrder(Food food) {
        orders.add(food);
    }

    public double calculatePriceForOrders() {
        return orders.stream().mapToDouble(Food::calculatePrice).sum();
    }

    @Override
    public boolean isDiscountable() {
        return loyalCustomer;
    }

    public void showOrder() {
        for (Food order : orders) {
            System.out.println("Item: " + order.getDescription()+ " and its Cost: $" + order.calculatePrice());
        }

        System.out.println("Total Cost: $" + decimalFormat.format(calculatePriceForOrders()));
        if (isDiscountable())
        {
            System.out.println("Is a Loyal Customer");
        }
        else{
            System.out.println("Is Not a Loyal Customer");
        }
    }
    public List<Food> getOrders() {
        return orders;
    }
}
