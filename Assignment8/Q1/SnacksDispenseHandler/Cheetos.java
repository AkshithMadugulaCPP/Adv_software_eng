package Assignment8.Q1.SnacksDispenseHandler;

import Assignment8.Q1.Snack;

public class Cheetos extends SnackDispenseHandler {

    public Cheetos(SnackDispenseHandler next){
        super(next);
    }

    public void dispenseSnack(Snack snack){
        if(snack.getName() == "Cheetos"){
            System.out.println("Dispensing Cheetos.");
            snack.setQuantity(snack.getQuantity() - 1);
        }
        else{
            super.dispenseSnack(snack);
        }
    }
}