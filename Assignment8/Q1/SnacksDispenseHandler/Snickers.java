package Assignment8.Q1.SnacksDispenseHandler;

import Assignment8.Q1.Snack;

public class Snickers extends SnackDispenseHandler {

    public Snickers(SnackDispenseHandler next){
        super(next);
    }

    public void dispenseSnack(Snack snack){
        if(snack.getName() == "Snickers"){
            System.out.println("Dispensing Snickers.");
            snack.setQuantity(snack.getQuantity() - 1);
        }
        else{
            super.dispenseSnack(snack);
        }
    }
}