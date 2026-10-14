import java.util.Scanner;

interface NightService {
    double applyNightCharge(double fare);
}

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double calculateFare();

    double applyMinimumFare(double fare) {
        return Math.max(100, fare);
    }
}

class MiniCab extends Cab {
    MiniCab(double km) {
        super(km);
    }

    double calculateFare() {
        return applyMinimumFare(km * 10);
    }
}

class SedanCab extends Cab implements NightService {
    SedanCab(double km) {
        super(km);
    }

    double calculateFare() {
        return applyMinimumFare(km * 14);
    }

    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

class SUVCab extends Cab implements NightService {
    SUVCab(double km) {
        super(km);
    }

    double calculateFare() {
        return applyMinimumFare(km * 18);
    }

    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

public class FareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of trips: ");
        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter cab type (MINI/SEDAN/SUV): ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter distance in km: ");
            double km = sc.nextDouble();

            System.out.print("Enter time (DAY/NIGHT): ");
            String time = sc.next().toUpperCase();

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new MiniCab(km);
                    break;
                case "SEDAN":
                    cab = new SedanCab(km);
                    break;
                case "SUV":
                    cab = new SUVCab(km);
                    break;
                default:
                    System.out.println("Invalid cab type.");
                    i--;
                    continue;
            }

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = cab.calculateFare();

            if (time.equals("NIGHT")) {
                NightService nightCab = (NightService) cab;
                fare = nightCab.applyNightCharge(fare);
            }

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}