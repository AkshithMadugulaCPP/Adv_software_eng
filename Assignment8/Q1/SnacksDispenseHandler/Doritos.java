package Assignment8.Q1.SnacksDispenseHandler;

import Assignment8.Q1.Snack;

public class Doritos extends SnackDispenseHandler {

    public Doritos(SnackDispenseHandler next){
        super(next);
    }

    public void dispenseSnack(Snack snack,int quantity){
        if(snack.getName() == "Doritos"){
            System.out.println("Dispensing Doritos.");
            snack.setQuantity(snack.getQuantity() - quantity);
        }
        else{
            super.dispenseSnack(snack, quantity);
        }
    }
}