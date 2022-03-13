package place.safezone;

import hero.Player;
import place.Location;

public abstract class NormalLocation extends Location {


    public NormalLocation(int id, Player player, String name) {
        super(id, player, name);
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}
