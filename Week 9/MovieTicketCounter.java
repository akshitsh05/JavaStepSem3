import java.util.Scanner;

abstract class MovieTicket {
    static final double CONVENIENCE_FEE = 20.0;
    int count;

    MovieTicket(int count) {
        this.count = count;
    }

    abstract double calculateAmount();
}

class RegularTicket extends MovieTicket {
    RegularTicket(int count) {
        super(count);
    }

    double calculateAmount() {
        return count * (150 + CONVENIENCE_FEE);
    }
}

class PremiumTicket extends MovieTicket {
    PremiumTicket(int count) {
        super(count);
    }

    double calculateAmount() {
        return count * (250 + CONVENIENCE_FEE);
    }
}

class ReclinerTicket extends MovieTicket {
    ReclinerTicket(int count) {
        super(count);
    }

    double calculateAmount() {
        return count * (400 + CONVENIENCE_FEE);
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bookings: ");
        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter seat type (REGULAR/PREMIUM/RECLINER): ");
            String seat = sc.next().toUpperCase();

            System.out.print("Enter number of tickets: ");
            int count = sc.nextInt();

            MovieTicket ticket;

            switch (seat) {
                case "REGULAR":
                    ticket = new RegularTicket(count);
                    break;
                case "PREMIUM":
                    ticket = new PremiumTicket(count);
                    break;
                case "RECLINER":
                    ticket = new ReclinerTicket(count);
                    break;
                default:
                    System.out.println("Invalid seat type.");
                    i--;
                    continue;
            }

            double amount = ticket.calculateAmount();
            System.out.printf("%s: %.2f%n", seat, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}