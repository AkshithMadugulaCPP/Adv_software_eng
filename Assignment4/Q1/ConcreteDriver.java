package Assignment4.Q1;

import Assignment4.Q1.enums.PizzaChainType;
import Assignment4.Q1.enums.PizzaSize;

public abstract class ConcreteDriver implements PizzaChain {
    public static class PizzaHut implements PizzaChain {

        public PizzaHut(){

        }

        @Override
        public Pizza.PizzaBuilder pizzaBuilder(PizzaSize size) {
            return new Pizza.PizzaBuilder(size, PizzaChainType.PIZZA_HUT);
        }
    }

    public static class Dominos implements PizzaChain {

        public Dominos() {

        }

        @Override
        public Pizza.PizzaBuilder pizzaBuilder(PizzaSize size) {
            return new Pizza.PizzaBuilder(size, PizzaChainType.DOMINOS);
        }
    }

    public static class LittleCaesars implements PizzaChain {

        public LittleCaesars(){

        }

        @Override
        public Pizza.PizzaBuilder pizzaBuilder(PizzaSize size) {
            return new Pizza.PizzaBuilder(size, PizzaChainType.LITTLE_CAESARS);
        }
    }

}
