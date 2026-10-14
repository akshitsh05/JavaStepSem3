import java.util.Scanner;

interface SaverMode {
    double SAVER_FACTOR = 0.75;
}

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    double calculateUnits(boolean saver) {
        double units = getPower() * hours / 1000;

        if (saver && this instanceof SaverMode) {
            units *= SaverMode.SAVER_FACTOR;
        }

        return units;
    }

    double calculateCost(boolean saver) {
        return calculateUnits(saver) * 8;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }
}

class Television extends Appliance {
    Television(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }
}

class WashingMachine extends Appliance implements SaverMode {
    WashingMachine(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }
}

public class EnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of appliances: ");
        int n = sc.nextInt();

        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter appliance (FRIDGE/AC/TV/WASHER): ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter hours used: ");
            double hours = sc.nextDouble();

            System.out.print("Enter mode (SAVER/NONE): ");
            String mode = sc.next().toUpperCase();

            boolean saver = mode.equals("SAVER");

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;
                case "AC":
                    appliance = new AirConditioner(hours);
                    break;
                case "TV":
                    appliance = new Television(hours);
                    break;
                case "WASHER":
                    appliance = new WashingMachine(hours);
                    break;
                default:
                    System.out.println("Invalid appliance type.");
                    i--;
                    continue;
            }

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits(saver);
            double cost = appliance.calculateCost(saver);

            System.out.printf("%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost);

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}