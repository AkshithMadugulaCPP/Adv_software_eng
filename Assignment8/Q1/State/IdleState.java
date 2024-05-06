package Assignment8.Q1.State;

import Assignment8.Q1.StateOfVendingMachine;
import Assignment8.Q1.VendingMachine;

public class IdleState implements StateOfVendingMachine {
    
    public void idle(VendingMachine vendingMachine){
        System.out.println("--------------------------------------");
        System.out.println("Vending machine in [IDLE STATE].");
        vendingMachine.setStateOfVendingMachine(new SelectSnackState());
        System.out.println("Transitioning -> [SELECT SNACK STATE].");
    }

    public void selectSnack(VendingMachine vendingMachine){}
    public void insertMoney(VendingMachine vendingMachine){}
    public void dispenseSnack(VendingMachine vendingMachine){}

}