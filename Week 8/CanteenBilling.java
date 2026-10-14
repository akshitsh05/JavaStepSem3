import java.util.Scanner;

abstract class Customer {
    double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double calculateAmount();

    String getType() {
        return getClass().getSimpleName().toUpperCase();
    }
}

class Student extends Customer {
    Student(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount * 0.90;
    }
}

class Staff extends Customer {
    Staff(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount * 0.95;
    }
}

class Guest extends Customer {
    Guest(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount + 10;
    }
}

class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bills: ");
        int n = sc.nextInt();

        Customer[] customers = new Customer[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter customer type (STUDENT/STAFF/GUEST): ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter bill amount: ");
            double amount = sc.nextDouble();

            switch (type) {
                case "STUDENT":
                    customers[i] = new Student(amount);
                    break;
                case "STAFF":
                    customers[i] = new Staff(amount);
                    break;
                case "GUEST":
                    customers[i] = new Guest(amount);
                    break;
                default:
                    System.out.println("Invalid customer type.");
                    i--;
                    continue;
            }

            double finalAmount = customers[i].calculateAmount();
            System.out.printf("%s: %.2f%n",
                    customers[i].getType(), finalAmount);
            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}