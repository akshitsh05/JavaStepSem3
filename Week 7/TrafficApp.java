import java.util.Scanner;

class TrafficLight {
    private String color;
    private final String lightId;

    TrafficLight(String lightId) {
        this.lightId = lightId;
        this.color = "RED";
    }

    void next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else {
            color = "RED";
        }
    }

    String getColor() {
        return color;
    }

    String getLightId() {
        return lightId;
    }
}

class TrafficApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter traffic light ID: ");
        String id = sc.nextLine();

        TrafficLight t = new TrafficLight(id);

        System.out.println("Traffic light ID: " + t.getLightId());
        System.out.println("Initial color: " + t.getColor());

        System.out.print("How many times should the light change? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            t.next();
            System.out.println("Current color: " + t.getColor());
        }

        sc.close();
    }
}