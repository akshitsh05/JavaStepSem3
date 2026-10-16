import java.util.Scanner;

class SecondBestScore {
    public static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > highest) {
                second = highest;
                highest = scores[i];
            } else if (scores[i] < highest && scores[i] > second) {
                second = scores[i];
            }
        }

        return second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter the scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        System.out.println("Second-highest distinct score: "
                + secondHighest(scores));

        sc.close();
    }
}