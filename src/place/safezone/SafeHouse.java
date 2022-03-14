package place.safezone;

import hero.Player;

import java.util.List;

public class SafeHouse extends NormalLocation {
    public SafeHouse(Player player) {
        super(1, player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        if (this.getPlayer().getInventory().getRewards().containsAll(List.of("Food", "Firewood", "Water"))) {
            System.out.println("******* Congrats, you gather all the treasures. You win !!! *******");
            return false;
        }
        System.out.println("You are in the safe house! Your health will be restored.");
        this.getPlayer().setHealth(this.getPlayer().getDefaultHealth());
        return true;
    }
}
