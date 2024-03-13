package Assignment4.Q1.enums;

public enum PizzaChainType {

    PIZZA_HUT("Pizza Hut"),
    DOMINOS("Dominos"),
    LITTLE_CAESARS("Little Caesars");
    public final String name;

    PizzaChainType(String name) {
        this.name = name;
    }
}
