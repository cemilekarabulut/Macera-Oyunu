package place.dangerzone;

import hero.Player;
import place.Location;
import place.enemy.Monster;

import java.util.Random;

public abstract class BattleLoc extends Location {
    private Monster monster;
    private String reward;
    private int maxNumOfMonsters;

    public BattleLoc(int id, Player player, String name, Monster monster, String reward, int maxNumOfMonsters) {
        super(id, player, name);
        this.monster = monster;
        this.reward = reward;
        this.maxNumOfMonsters = maxNumOfMonsters;
    }

    public int getMaxNumOfMonsters() {
        return maxNumOfMonsters;
    }

    public void setMaxNumOfMonsters(int maxNumOfMonsters) {
        this.maxNumOfMonsters = maxNumOfMonsters;
    }

    public int getMonsterNum() {
        Random r = new Random();
        return r.nextInt(this.getMaxNumOfMonsters()) + 1;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    @Override
    public boolean onLocation() {
        int numOfMonsters = getMonsterNum();
        System.out.println("You are in " + this.getName());
        System.out.print("<F>ight or <R>un: ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("F")) {
            if (enterCombat(numOfMonsters)) {
                if (this.getPlayer().getHealth() <= 0) {
                    System.out.println("You died. What a tragedy!");
                    return false;
                }
                System.out.println("Congrats, you defeat the monsters!");
                return true;
            }
        }
        return true;
    }

    private boolean enterCombat(int monsNum) {
        for (int i = 0; i < monsNum && this.getPlayer().getHealth() > 0; i++) {
            System.out.println("Ready yourself. You have to fight with " + monsNum + " " + this.getMonster().getName());
            this.getMonster().setHealth(this.getMonster().getDefaultHealth());
            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                printPlayerStats();
                printMonsterStats();
                System.out.print("<H>it or <R>un: ");
                String selectCase = input.nextLine();
                selectCase = selectCase.toUpperCase();
                if (selectCase.equals("H")) {
                    System.out.println("You hit!");
                    monster.setHealth(this.getMonster().getHealth() - this.getPlayer().getDamage());
                    if (this.getMonster().getHealth() > 0) {
                        System.out.println("Monster hit you!");
                        this.getPlayer().setHealth(this.getPlayer().getHealth() + this.getPlayer().getInventory().getArmor().getBlock() - this.getMonster().getDamage());
                    }
                } else {
                    System.out.println("You ran from the fight!");
                    return false;
                }
            }
            if (monster.getHealth() <= 0) {
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
            }
        }
        return true;
    }

    private void printMonsterStats() {
        System.out.println("------ Monster Statistics ------");
        System.out.println("Health:" + this.getMonster().getHealth());
        System.out.println("Damage:" + this.getMonster().getDamage());
        System.out.println("Prize Money:" + this.getMonster().getAward());
    }

    private void printPlayerStats() {
        System.out.println("------ Player Statistics ------");
        System.out.println("Health:" + this.getPlayer().getHealth());
        System.out.println("Damage:" + this.getPlayer().getDamage());
        System.out.println("Money:" + this.getPlayer().getMoney());
        System.out.println("Weapon:" + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Armor:" + this.getPlayer().getInventory().getArmor().getName());
    }
}
