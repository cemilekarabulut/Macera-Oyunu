package place.enemy;

public class Monster {
    private String name;
    private int damage;
    private int health;
    private int id;
    private int award;
    private int defaultHealth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public Monster(String name, int damage, int health, int id, int award) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.id = id;
        this.award = award;
        this.defaultHealth = health;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }
}
