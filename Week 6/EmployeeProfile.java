import java.util.Scanner;

class Employee {
    String empId, empName;
    double salary;
    boolean isIntern;

    Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        isIntern = false;
    }

    Employee(String empId, String empName) {
        this(empId, empName, 0);
        isIntern = true;
    }

    void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs "
                + salary + " | Intern: " + isIntern);
    }
}

class EmployeeProfile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter permanent employee ID: ");
        String id1 = sc.nextLine();

        System.out.print("Enter permanent employee name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter permanent employee salary: ");
        double salary = Double.parseDouble(sc.nextLine());

        System.out.print("Enter intern ID: ");
        String id2 = sc.nextLine();

        System.out.print("Enter intern name: ");
        String name2 = sc.nextLine();

        Employee permanent = new Employee(id1, name1, salary);
        Employee intern = new Employee(id2, name2);

        System.out.println("\nEmployee Profiles:");
        permanent.printProfile();
        intern.printProfile();

        sc.close();
    }
}