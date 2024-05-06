package Assignment8.Q1.SnacksDispenseHandler;

import Assignment8.Q1.Snack;

public class Coke extends SnackDispenseHandler {

    public Coke(SnackDispenseHandler next){
        super(next);
    }

    public void dispenseSnack(Snack snack){
        if(snack.getName() == "Coke"){
            System.out.println("Dispensing Coke.");
            snack.setQuantity(snack.getQuantity() - 1);
        }
        else{
            super.dispenseSnack(snack);
        }
    }
}