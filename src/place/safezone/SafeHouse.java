package place.safezone;

import hero.Player;

public class SafeHouse extends NormalLocation{
    public SafeHouse(Player player) {
        super(1, player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in the safe house! Your health will be restored.");
        return true;
    }
}
