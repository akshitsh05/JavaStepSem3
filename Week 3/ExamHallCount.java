import java.util.Scanner;

class ExamHall {
    String hallName;
    int seatsFilled;
}

public class ExamHallCount {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ExamHall hallA = new ExamHall();
        ExamHall hallB = new ExamHall();

        System.out.print("Enter name of Hall A: ");
        hallA.hallName = sc.nextLine();

        System.out.print("Enter name of Hall B: ");
        hallB.hallName = sc.nextLine();

        hallA.seatsFilled++;
        hallA.seatsFilled++;
        hallA.seatsFilled++;
        hallA.seatsFilled++;

        System.out.println(hallA.hallName + " seatsFilled: " + hallA.seatsFilled);
        System.out.println(hallB.hallName + " seatsFilled: " + hallB.seatsFilled);

        sc.close();
    }
}