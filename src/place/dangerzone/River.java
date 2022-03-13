package place.dangerzone;

import hero.Player;
import place.enemy.Bear;

public class River extends BattleLoc {
    public River(Player player) {
        super(5, player, "River", new Bear(), "Water",2);
    }
}
