import java.util.Scanner;

class Cart {
    private double[] prices;
    private int itemCount;
    private final String cartId;

    Cart(String cartId, int capacity) {
        this.cartId = cartId;
        this.prices = new double[Math.max(0, capacity)];
        this.itemCount = 0;
    }

    void addItem(double price) {
        if (price < 0) {
            System.out.println("Invalid price.");
        } else if (itemCount >= prices.length) {
            System.out.println("Shopping cart is full.");
        } else {
            prices[itemCount] = price;
            itemCount++;
            System.out.println("Item added successfully.");
        }
    }

    double getTotal() {
        double total = 0;

        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }

        return total;
    }

    int getItemCount() {
        return itemCount;
    }

    String getCartId() {
        return cartId;
    }
}

class ShoppingCart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter cart ID: ");
        String id = sc.nextLine();

        System.out.print("Enter maximum cart capacity: ");
        int capacity = sc.nextInt();

        Cart cart = new Cart(id, capacity);

        System.out.print("How many items do you want to add? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter price of item " + (i + 1) + ": ");
            double price = sc.nextDouble();
            cart.addItem(price);
        }

        System.out.println("\nCart ID: " + cart.getCartId());
        System.out.println("Total amount: Rs " + cart.getTotal());
        System.out.println("Number of items: " + cart.getItemCount());

        sc.close();
    }
}