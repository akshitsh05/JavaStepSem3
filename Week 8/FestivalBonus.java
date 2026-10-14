import java.util.Scanner;

abstract class BonusEmployee {
    String name;
    double salary;

    BonusEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateBonus();
}

class FullTimeEmployee extends BonusEmployee {
    FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTimeEmployee extends BonusEmployee {
    PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return salary * 0.05;
    }
}

class InternEmployee extends BonusEmployee {
    InternEmployee(String name) {
        super(name, 0);
    }

    double calculateBonus() {
        return 2000;
    }
}

public class FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        BonusEmployee[] employees = new BonusEmployee[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("\nEmployee " + (i + 1));
            System.out.print("Enter employee type (FULLTIME/PARTTIME/INTERN): ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter employee name: ");
            String name = sc.next();

            switch (type) {
                case "FULLTIME":
                    System.out.print("Enter monthly salary: ");
                    double fullSalary = sc.nextDouble();
                    employees[i] = new FullTimeEmployee(name, fullSalary);
                    break;

                case "PARTTIME":
                    System.out.print("Enter monthly salary: ");
                    double partSalary = sc.nextDouble();
                    employees[i] = new PartTimeEmployee(name, partSalary);
                    break;

                case "INTERN":
                    employees[i] = new InternEmployee(name);
                    break;

                default:
                    System.out.println("Invalid employee type. Try again.");
                    i--;
                    continue;
            }

            double bonus = employees[i].calculateBonus();
            System.out.printf("Employee name: %s%n", employees[i].name);
            System.out.printf("Bonus: Rs. %.2f%n", bonus);
            total += bonus;
        }

        System.out.printf("%nTotal bonus: Rs. %.2f%n", total);
        sc.close();
    }
}