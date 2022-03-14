package hero;

import place.item.Armor;
import place.item.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private List<String> rewards;

    public Inventory() {
        this.weapon = new Weapon("Punch", 0, 0, 0);
        this.armor = new Armor("Your prays to the God", 0, 0, 0);
        this.rewards = new ArrayList<>();
    }

    public Armor getArmor() {
        return armor;
    }

    public List<String> getRewards() {
        return rewards;
    }

    public void setRewards(List<String> rewards) {
        this.rewards = rewards;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Inventory(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
