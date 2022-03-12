package place;

import hero.Player;

import java.util.Scanner;

public abstract class Location {
    private int id;
    private Player player;
    private String name;
    public Scanner input = new Scanner(System.in);

    public Location(int id, Player player, String name) {
        this.id = id;
        this.player = player;
        this.name = name;
    }

    public void printFeatures(){
        System.out.println("Place  " + id + ": " + name);
    }

    public abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
