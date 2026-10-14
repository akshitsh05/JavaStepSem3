import java.util.Scanner;

class HallTicket {
    String studentName;
    int seatNumber;

    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

class HallTicketApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HallTicket priya = new HallTicket("Priya", 0);
        HallTicket copy = priya;

        System.out.print("Enter new seat number for Priya: ");
        copy.seatNumber = sc.nextInt();

        System.out.println("\nPriya's seat number: " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));

        HallTicket separate = new HallTicket("Priya", priya.seatNumber);

        System.out.println("separate == priya: " + (separate == priya));

        sc.close();
    }
}