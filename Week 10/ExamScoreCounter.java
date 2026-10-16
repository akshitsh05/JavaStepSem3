import java.util.Scanner;

class ExamScoreCounter {
    public static int countInBand(int[] scores, int low, int high) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] < low) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int first = left;

        left = 0;
        right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] <= high) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int last = left;

        return last - first;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter scores in ascending order:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        System.out.print("Enter lower limit: ");
        int low = sc.nextInt();

        System.out.print("Enter upper limit: ");
        int high = sc.nextInt();

        System.out.println("Number of students in band: "
                + countInBand(scores, low, high));

        sc.close();
    }
}