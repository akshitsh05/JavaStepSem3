import java.util.Scanner;

class AttendanceTracker {
    public static int[] attendanceSummary(int[] days) {
        int present = 0;
        int streak = 0;
        int longestStreak = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] == 1) {
                present++;
                streak++;

                if (streak > longestStreak) {
                    longestStreak = streak;
                }
            } else {
                streak = 0;
            }
        }

        return new int[]{present, longestStreak};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] days = new int[n];

        System.out.println("Enter attendance for each day (1 = Present, 0 = Absent):");

        for (int i = 0; i < n; i++) {
            days[i] = sc.nextInt();
        }

        int[] result = attendanceSummary(days);

        System.out.println("Present: " + result[0] +
                           ", Longest streak: " + result[1]);

        sc.close();
    }
}