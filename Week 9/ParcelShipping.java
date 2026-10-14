import java.util.Scanner;

interface Insurable {
    double calculateInsurance();
}

abstract class Parcel {
    double weight;
    double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();

    double calculateInsurance() {
        return 0;
    }

    double calculateTotal() {
        return calculateCharge() + calculateInsurance();
    }
}

class StandardParcel extends Parcel {
    StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 40 + 10 * weight;
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 80 + 15 * weight;
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 40 + 10 * weight + 50;
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

public class ParcelShipping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of parcels: ");
        int n = sc.nextInt();

        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter parcel type (STANDARD/EXPRESS/FRAGILE): ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter weight in kg: ");
            double weight = sc.nextDouble();

            System.out.print("Enter declared value: ");
            double value = sc.nextDouble();

            Parcel parcel;

            switch (type) {
                case "STANDARD":
                    parcel = new StandardParcel(weight, value);
                    break;
                case "EXPRESS":
                    parcel = new ExpressParcel(weight, value);
                    break;
                case "FRAGILE":
                    parcel = new FragileParcel(weight, value);
                    break;
                default:
                    System.out.println("Invalid parcel type.");
                    i--;
                    continue;
            }

            double charge = parcel.calculateCharge();
            double insurance = parcel.calculateInsurance();
            double amount = charge + insurance;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, amount
            );

            grandTotal += amount;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}