import hero.Player;
import place.Location;
import place.SafeHouse;
import place.Store;

import java.util.Scanner;

public class Game {
    private final Scanner input = new Scanner(System.in);

    private Player player;
    private Location location;

    public void start(){
        System.out.println("Welcome to the Adventure Game!");
        System.out.print("Tell us your name: ");
        String playerName = input.nextLine();
        player = new Player(playerName);
        System.out.println("Pleasure to meet you " + player.getName() + "!");
        System.out.println("Get ready! From now on, things are getting serious.");
        System.out.println("Let's choose a character before you get started");
        player.selectChar();
        boolean isGameEnded = false;
        while(!isGameEnded){
            player.printInfo();
            isGameEnded = selectLoc();
        }
    }
    public boolean selectLoc(){
        Location location = null;
        SafeHouse safeHouse = new SafeHouse(player);
        Store store = new Store(player);
        System.out.println("Where to next?");
        safeHouse.printFeatures();
        store.printFeatures();
        System.out.print("Enter a number 1-2 to select a place to go:");
        int selectedLoc = input.nextInt();
        if (selectedLoc == 2) {
            location = store;
        } else {
            location = safeHouse;
        }
        return !location.onLocation();
    }
}