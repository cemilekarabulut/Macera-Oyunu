package hero;

import place.item.Armor;
import place.item.Weapon;

public class Inventory {
    private Weapon weapon;
    private Armor armor;

    public Inventory() {
        this.weapon = new Weapon("Punch", 0, 0, 0);
        this.armor = new Armor("Your prays to the God", 0, 0, 0);
    }

    public Armor getArmor() {
        return armor;
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
