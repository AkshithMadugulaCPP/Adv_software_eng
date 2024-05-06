package Assignment8.Q1.SnacksDispenseHandler;

import Assignment8.Q1.Snack;

public class Pepsi extends SnackDispenseHandler {

    public Pepsi(SnackDispenseHandler next){
        super(next);
    }

    public void dispenseSnack(Snack snack){
        if(snack.getName() == "Pepsi"){
            System.out.println("Dispensing Pepsi.");
            snack.setQuantity(snack.getQuantity() - 1);
        }
        else{
            super.dispenseSnack(snack);
        }
    }
}