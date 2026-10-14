import java.util.Scanner;

abstract class Room {
    int units;

    Room(int units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class SingleRoom extends Room {
    SingleRoom(int units) {
        super(units);
    }

    double calculateBill() {
        return units * 8.0;
    }
}

class SharedRoom extends Room {
    int occupants;

    SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    double calculateBill() {
        return units * 6.0;
    }

    double calculateShare() {
        return calculateBill() / occupants;
    }
}

class AcRoom extends Room {
    AcRoom(int units) {
        super(units);
    }

    double calculateBill() {
        return units * 10.0 + 200;
    }
}

public class HostelElectricity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rooms: ");
        int n = sc.nextInt();

        Room[] rooms = new Room[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("\nRoom " + (i + 1));
            System.out.print("Enter room type (SINGLE/SHARED/AC): ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter electricity units consumed: ");
            int units = sc.nextInt();

            switch (type) {
                case "SINGLE":
                    rooms[i] = new SingleRoom(units);
                    break;

                case "SHARED":
                    System.out.print("Enter number of occupants: ");
                    int occupants = sc.nextInt();

                    if (occupants <= 0) {
                        System.out.println("Occupants must be greater than zero.");
                        i--;
                        continue;
                    }

                    rooms[i] = new SharedRoom(units, occupants);
                    break;

                case "AC":
                    rooms[i] = new AcRoom(units);
                    break;

                default:
                    System.out.println("Invalid room type. Try again.");
                    i--;
                    continue;
            }

            double bill = rooms[i].calculateBill();
            System.out.printf("Room bill: Rs. %.2f%n", bill);

            if (rooms[i] instanceof SharedRoom) {
                SharedRoom shared = (SharedRoom) rooms[i];
                System.out.printf("Bill per occupant: Rs. %.2f%n",
                        shared.calculateShare());
            }

            total += bill;
        }

        System.out.printf("%nTotal electricity bill: Rs. %.2f%n", total);
        sc.close();
    }
}