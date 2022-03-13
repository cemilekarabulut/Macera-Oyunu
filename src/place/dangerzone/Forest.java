package place.dangerzone;

import hero.Player;
import place.enemy.Vampire;

public class Forest extends BattleLoc {
    public Forest(Player player) {
        super(4, player, "Forest", new Vampire(), "Firewood",3);
    }
}
