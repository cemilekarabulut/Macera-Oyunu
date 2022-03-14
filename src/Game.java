import hero.Player;
import place.Location;
import place.dangerzone.Cave;
import place.dangerzone.Forest;
import place.dangerzone.River;
import place.safezone.SafeHouse;
import place.safezone.Store;

import java.util.Scanner;

public class Game {
    private final Scanner input = new Scanner(System.in);

    private Player player;
    private Location location;

    public void start() {
        System.out.println("Welcome to the Adventure Game!");
        System.out.print("Tell us your name: ");
        String playerName = input.nextLine();
        player = new Player(playerName);
        System.out.println("Pleasure to meet you " + player.getName() + "!");
        System.out.println("Get ready! From now on, things are getting serious.");
        System.out.println("Let's choose a character before you get started");
        player.selectChar();
        boolean isGameEnded = false;
        while (!isGameEnded) {
            player.printInfo();
            isGameEnded = selectLoc();
        }
    }

    public boolean selectLoc() {
        Location location = null;
        SafeHouse safeHouse = new SafeHouse(player);
        Store store = new Store(player);
        Cave cave = new Cave(player);
        Forest forest = new Forest(player);
        River river = new River(player);
        System.out.println("Where to next?");
        safeHouse.printFeatures();
        store.printFeatures();
        cave.printFeatures();
        forest.printFeatures();
        river.printFeatures();
        System.out.println("0 - Exit the game");
        System.out.print("Enter a number 0-5 to select a place to go:");
        int selectedLoc = input.nextInt();
        while (selectedLoc < 0 || selectedLoc > 5) {
            System.out.print("Invalid choice. Make it again: ");
            selectedLoc = input.nextInt();
        }
        switch (selectedLoc) {
            case 0 -> {
                System.out.println("Gave up? Your funeral.");
                return true;
            }
            case 1 -> location = safeHouse;
            case 2 -> location = store;
            case 3 -> {
                if (!player.getInventory().getRewards().contains("Food")) {
                    location = cave;
                } else {
                    System.out.println("You have Food. There is nothing to do in the Cave. Go somewhere else.");
                    return false;
                }
            }
            case 4 -> {
                if (!player.getInventory().getRewards().contains("Firewood")) {
                    location = forest;
                } else {
                    System.out.println("You have Firewood. There is nothing to do in the Forest. Go somewhere else.");
                    return false;
                }
            }
            case 5 -> {
                if (!player.getInventory().getRewards().contains("Water")) {
                    location = river;
                } else {
                    System.out.println("You have Water. There is nothing to do in the River. Go somewhere else.");
                    return false;
                }
            }
        }
        return !location.onLocation();
    }
}