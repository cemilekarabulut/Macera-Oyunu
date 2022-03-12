package place.item;

public class Weapon {
    private String name;
    private int id;
    private int damege;
    private int price;

    public Weapon(String name, int id, int damege, int money) {
        this.name = name;
        this.id = id;
        this.damege = damege;
        this.price = money;
    }

    public static Weapon[] getAllWeapons() {
        Weapon[] weapons = new Weapon[3];
        weapons[0] = new Weapon("Handgun", 1, 2, 5);
        weapons[1] = new Weapon("Sword", 2, 3, 35);
        weapons[2] = new Weapon("Rifle", 3, 7, 45);
        return weapons;
    }

    public static Weapon getWeaponById(int id) {
        for (Weapon w : Weapon.getAllWeapons()) {
            if (id == w.getId())
                return w;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamege() {
        return damege;
    }

    public void setDamege(int damege) {
        this.damege = damege;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
