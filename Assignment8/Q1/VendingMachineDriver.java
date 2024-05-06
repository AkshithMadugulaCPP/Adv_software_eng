package Assignment8.Q1;

import Assignment8.Q1.SnacksDispenseHandler.*;
import Assignment8.Q1.SnacksDispenseHandler.SnackDispenseHandler;

import java.util.*;

public class VendingMachineDriver {
 
    public static void main(String[] args){

        // Create driver with 6 different snacks -> Coke, Pepsi, Cheetos, Doritos, KitKat, and Snickers.
        Snack kitKat = new Snack("KitKat", 1.00, 5);
        Snack snickers = new Snack("Snickers", 1.50, 1);
        Snack cheetos = new Snack("Cheetos", 2.00, 5);
        Snack doritos = new Snack("Doritos", 2.50, 5);
        Snack coke = new Snack("Coke", 3.00, 5);
        Snack pepsi = new Snack("Pepsi", 3.50, 5);

        ArrayList<Snack> snacks = new ArrayList<Snack>(Arrays.asList(coke, pepsi, 
                                                                     cheetos, doritos,
                                                                     kitKat, snickers));
        SnackDispenseHandler snackDispenseHandler = new Coke(
                                                    new Pepsi(
                                                    new Cheetos(
                                                    new Doritos(
                                                    new KitKat(
                                                    new Snickers(null))))));
        VendingMachine vendingMachine = new VendingMachine(snackDispenseHandler, snacks);

        System.out.println("\n#############################################");
        System.out.println("\n# CASE 1:- where is not enough money:");

        vendingMachine.idle();
        vendingMachine.selectSnack(doritos);
        vendingMachine.insertMoney(2.00);
        vendingMachine.dispenseSnack();
        System.out.println(vendingMachine);

        System.out.println("\n#############################################");
        System.out.println("\n# CASE 2:- where there is enough money and quantity:");

        vendingMachine.idle();
        vendingMachine.selectSnack(pepsi);
        vendingMachine.insertMoney(5.00);
        vendingMachine.dispenseSnack();
        System.out.println(vendingMachine);



        System.out.println("\n#############################################");
        System.out.println("\n# CASE 3:- where quantity hits 0 with snickers:");

        vendingMachine.idle();
        vendingMachine.selectSnack(snickers);
        vendingMachine.insertMoney(4.00);
        vendingMachine.dispenseSnack();
        System.out.println(vendingMachine);

        System.out.println("\n#############################################");
        System.out.println("\n# CASE 4:- Where there is no more quantity:");

        vendingMachine.idle();
        vendingMachine.selectSnack(snickers);
        vendingMachine.insertMoney(4.00);
        vendingMachine.dispenseSnack();
        System.out.println(vendingMachine);
        
    }

}
