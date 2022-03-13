package place.dangerzone;

import hero.Player;
import place.Location;
import place.enemy.Monster;

import java.util.Locale;
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
        System.out.println("<F>ight or <R>un");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if(selectCase.equals("F")){
            System.out.println();
        } else {
            return false;
        }

        return true;
    }
}
