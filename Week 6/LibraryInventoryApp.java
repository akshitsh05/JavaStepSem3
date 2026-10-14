import java.util.Scanner;

class BookInventory {
    String title, author;
    int copiesAvailable;

    BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    void printEntry() {
        System.out.println(title + " by " + author + " - "
                + copiesAvailable + " copies available");
    }
}

class LibraryInventoryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookInventory[] books = new BookInventory[4];

        for (int i = 0; i < 4; i++) {
            System.out.println("Enter details for book " + (i + 1) + ":");

            System.out.print("Enter book title: ");
            String title = sc.nextLine();

            System.out.print("Enter author name: ");
            String author = sc.nextLine();

            System.out.print("Enter available copies: ");
            int copies = Integer.parseInt(sc.nextLine());

            books[i] = new BookInventory(title, author, copies);
        }

        System.out.println("\nLibrary Inventory:");
        for (int i = 0; i < 4; i++) {
            books[i].printEntry();
        }

        sc.close();
    }
}