package hero;

import java.util.Scanner;

public class Player {
    private String name;
    private String charName;
    private int damage;
    private int health;
    private int money;
    private int defaultHealth;
    private Inventory inventory;
    private final Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        Samurai samurai = new Samurai();
        Archer archer = new Archer();
        Knight knight = new Knight();

        System.out.println("-------------------------------");
        samurai.printFeatures();
        System.out.println("-------------------------------");
        archer.printFeatures();
        System.out.println("-------------------------------");
        knight.printFeatures();
        System.out.println("-------------------------------");
        System.out.print("Enter a number 1-3 to select your character:");
        int selectedChar = input.nextInt();
        switch (selectedChar) {
            case 2 -> initPlayer(archer);
            case 3 -> initPlayer(knight);
            default -> initPlayer(samurai);
        }
        System.out.println("Clever choice, good luck " + name + " the " + charName + "!");
    }

    private void initPlayer(GameChar gameChar) {
        this.setDefaultHealth(gameChar.getHealth());
        this.setCharName(gameChar.getCharName());
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage + inventory.getWeapon().getDamege();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public void printInfo() {
        System.out.println("Character: " + charName + ", Damage Point: " + getDamage() + ", Health: " + health + ", Money: " + money + ", Weapon: " + inventory.getWeapon().getName() + ", Armor: " + inventory.getArmor().getName());
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }
}
