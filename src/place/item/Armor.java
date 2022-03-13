package place.item;

public class Armor {
    private String name;
    private int id;
    private int block;
    private int price;

    public static Armor[] getAllArmors() {
        Armor[] armors = new Armor[3];
        armors[0] = new Armor("Light armor", 1, 1, 15);
        armors[1] = new Armor("Middle armor", 2, 3, 25);
        armors[2] = new Armor("Heavy armor", 3, 5, 40);
        return armors;
    }

    public static Armor getArmorById(int id) {
        for (Armor a : Armor.getAllArmors()) {
            if (id == a.getId())
                return a;
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

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Armor(String name, int id, int block, int price) {
        this.name = name;
        this.id = id;
        this.block = block;
        this.price = price;
    }
}
