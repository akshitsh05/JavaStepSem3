import java.util.Scanner;

abstract class Vehicle {
    int hours;

    Vehicle(int hours) {
        this.hours = hours;
    }

    abstract double calculateCharge();
}

class Bike extends Vehicle {
    Bike(int hours) {
        super(hours);
    }

    double calculateCharge() {
        return hours * 10.0;
    }
}

class Car extends Vehicle {
    Car(int hours) {
        super(hours);
    }

    double calculateCharge() {
        if (hours <= 0) {
            return 0;
        }
        return 30 + (hours - 1) * 20.0;
    }
}

class Truck extends Vehicle {
    Truck(int hours) {
        super(hours);
    }

    double calculateCharge() {
        return Math.max(100, hours * 50.0);
    }
}

public class ParkingChargeApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vehicles: ");
        int n = sc.nextInt();

        Vehicle[] vehicles = new Vehicle[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("\nVehicle " + (i + 1));
            System.out.print("Enter type (BIKE/CAR/TRUCK): ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter parking hours: ");
            int hours = sc.nextInt();

            switch (type) {
                case "BIKE":
                    vehicles[i] = new Bike(hours);
                    break;
                case "CAR":
                    vehicles[i] = new Car(hours);
                    break;
                case "TRUCK":
                    vehicles[i] = new Truck(hours);
                    break;
                default:
                    System.out.println("Invalid vehicle type. Try again.");
                    i--;
                    continue;
            }

            double charge = vehicles[i].calculateCharge();
            System.out.printf("Parking charge: Rs. %.2f%n", charge);
            total += charge;
        }

        System.out.printf("%nTotal parking collection: Rs. %.2f%n", total);
        sc.close();
    }
}