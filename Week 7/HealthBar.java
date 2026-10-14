import java.util.Scanner;

class Character {
    private int health;
    private final int maxHealth;

    Character(int maxHealth) {
        this.maxHealth = Math.max(0, maxHealth);
        this.health = this.maxHealth;
    }

    void takeDamage(int amount) {
        if (amount > 0) {
            health = Math.max(0, health - amount);
        }
    }

    void heal(int amount) {
        if (amount > 0) {
            health = Math.min(maxHealth, health + amount);
        }
    }

    int getHealth() {
        return health;
    }
}

class HealthBar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum health: ");
        int max = sc.nextInt();

        Character c = new Character(max);

        System.out.print("Enter damage amount: ");
        int damage = sc.nextInt();
        c.takeDamage(damage);
        System.out.println("Health after damage: " + c.getHealth());

        System.out.print("Enter healing amount: ");
        int healing = sc.nextInt();
        c.heal(healing);
        System.out.println("Health after healing: " + c.getHealth());

        sc.close();
    }
}