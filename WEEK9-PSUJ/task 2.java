import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Base Class
abstract class Vehicle {
    int vehicleId;
    String modelName;
    double baseRent;

    public Vehicle(int vehicleId, String modelName, double baseRent) {
        this.vehicleId = vehicleId;
        this.modelName = modelName;
        this.baseRent = baseRent;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateTotalRent();

    public void display() {
        System.out.println("Vehicle ID: " + vehicleId + 
                           ", Model: " + modelName + 
                           ", Total Rent: " + calculateTotalRent());
    }
}

// Subclass for Cars
class Car extends Vehicle {
    int seats;

    public Car(int vehicleId, String modelName, double baseRent, int seats) {
        super(vehicleId, modelName, baseRent);
        this.seats = seats;
    }

    @Override
    public double calculateTotalRent() {
        return baseRent + (seats * 100);
    }
}

// Subclass for Bikes
class Bike extends Vehicle {
    int engineCapacity;

    public Bike(int vehicleId, String modelName, double baseRent, int engineCapacity) {
        super(vehicleId, modelName, baseRent);
        this.engineCapacity = engineCapacity;
    }

    @Override
    public double calculateTotalRent() {
        return baseRent + (engineCapacity * 2);
    }
}

public class VHCL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Vehicle> inventory = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                String type = sc.next();
                int id = sc.nextInt();
                String name = sc.next();
                double rent = sc.nextDouble();

                if (type.equalsIgnoreCase("C")) {
                    int seats = sc.nextInt();
                    inventory.add(new Car(id, name, rent, seats));
                } else if (type.equalsIgnoreCase("B")) {
                    int capacity = sc.nextInt();
                    inventory.add(new Bike(id, name, rent, capacity));
                }
            }

            // Display all vehicles using polymorphism
            for (Vehicle v : inventory) {
                v.display();
            }
        }
        sc.close();
    }
}
