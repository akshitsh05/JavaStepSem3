import java.util.Scanner;
import java.time.LocalDate;

abstract class SubscriptionPlan {
    String name;
    LocalDate startDate;

    SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int getValidityDays();

    LocalDate calculateRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends SubscriptionPlan {
    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends SubscriptionPlan {
    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends SubscriptionPlan {
    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 365;
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of subscriptions: ");
        int n = sc.nextInt();

        SubscriptionPlan[] plans = new SubscriptionPlan[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nSubscription " + (i + 1));

            System.out.print("Enter plan (BASIC/STANDARD/PREMIUM): ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter subscriber name: ");
            String name = sc.next();

            System.out.print("Enter subscription date (YYYY-MM-DD): ");
            String date = sc.next();

            LocalDate startDate;

            try {
                startDate = LocalDate.parse(date);
            } catch (Exception e) {
                System.out.println("Invalid date. Use YYYY-MM-DD.");
                i--;
                continue;
            }

            switch (type) {
                case "BASIC":
                    plans[i] = new BasicPlan(name, startDate);
                    break;

                case "STANDARD":
                    plans[i] = new StandardPlan(name, startDate);
                    break;

                case "PREMIUM":
                    plans[i] = new PremiumPlan(name, startDate);
                    break;

                default:
                    System.out.println("Invalid plan type. Try again.");
                    i--;
                    continue;
            }

            System.out.println("Subscriber: " + plans[i].name);
            System.out.println("Renewal date: " + plans[i].calculateRenewalDate());
        }

        sc.close();
    }
}