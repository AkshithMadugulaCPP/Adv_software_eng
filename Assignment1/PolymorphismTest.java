package Assignment1;

class Ship {
    private String name;
    private String yearBuilt;

    public Ship(String name, String yearBuilt) {
        this.name = name;
        this.yearBuilt = yearBuilt;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(String yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    // Print function
    public void print() {
        System.out.println("Ship Name: " + name);
        System.out.println("Year Built: " + yearBuilt);
    }
}

class CruiseShip extends Ship {
    private int maxPassengers;

    public CruiseShip(String name, String yearBuilt, int maxPassengers) {
        super(name, yearBuilt);
        this.maxPassengers = maxPassengers;
    }

    // Getter and setter
    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    // Override print function
    @Override
    public void print() {
        System.out.println("Ship Name: " + getName());
        System.out.println("Max Passengers: " + maxPassengers);
    }
}

class CargoShip extends Ship {
    private int cargoCapacity;

    public CargoShip(String name, String yearBuilt, int cargoCapacity) {
        super(name, yearBuilt);
        this.cargoCapacity = cargoCapacity;
    }

    // Getter and setter
    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    // Override print function
    @Override
    public void print() {
        System.out.println("Ship Name: " + getName());
        System.out.println("Cargo Capacity: " + cargoCapacity + " tons");
    }
}

public class PolymorphismTest {
    public static void main(String[] args) {
        Ship[] ships = new Ship[3];
        ships[0] = new Ship("FriendShip", "2000");
        ships[1] = new CruiseShip("CruiseFriendShip", "2010", 2000);
        ships[2] = new CargoShip("CargoFriendShip", "2020", 5000);

        for (Ship ship : ships) {
            ship.print();
            System.out.println();
        }
    }
}
