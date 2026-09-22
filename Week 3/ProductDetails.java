import java.util.Scanner;

class Product {
    String productId;
    String productName;

    public Product(String productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }
}

public class ProductDetails {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter product ID: ");
        String productId = sc.nextLine();

        System.out.print("Enter product name: ");
        String productName = sc.nextLine();

        Product product = new Product(productId, productName);

        System.out.println(product.productId + " - " + product.productName);

        sc.close();
    }
}