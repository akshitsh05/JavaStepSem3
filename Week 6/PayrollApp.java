import java.util.Scanner;

class PayrollAccount {
    private double basicSalary;
    private double bonus;

    PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Negative salary. Starting at 0.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }
        bonus = 0;
    }

    void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid bonus amount");
        } else {
            bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Invalid tax percentage");
        } else {
            basicSalary -= basicSalary * percent / 100;
            System.out.println("Tax deducted: " + percent + "%");
        }
    }

    double getNetSalary() {
        return basicSalary + bonus;
    }
}

class PayrollApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter basic salary: ");
        double salary = sc.nextDouble();

        System.out.print("Enter bonus amount: ");
        double bonus = sc.nextDouble();

        System.out.print("Enter tax percentage: ");
        double tax = sc.nextDouble();

        PayrollAccount account = new PayrollAccount(salary);
        account.creditBonus(bonus);
        account.deductTax(tax);

        System.out.println("Net salary: Rs " + account.getNetSalary());

        sc.close();
    }
}