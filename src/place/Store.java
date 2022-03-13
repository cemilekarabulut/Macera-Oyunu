package place;

import hero.Player;
import place.item.Armor;
import place.item.Weapon;

public class Store extends NormalLocation {
    public Store(Player player) {
        super(2, player, "Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to the store!");
        System.out.println("1 - Weapons");
        System.out.println("2 - Armors");
        System.out.println("3 - Exit");
        System.out.print("What would you like to purchase?");
        int selectItem = input.nextInt();
        boolean exitFlag = true;
        while (selectItem < 1 || selectItem > 3) {
            System.out.print("Invalid choice. Make it again: ");
            selectItem = input.nextInt();
        }
        while (exitFlag) {
            switch (selectItem) {
                case 1 -> exitFlag = selectWeapon();
                case 2 -> exitFlag = selectArmor();
                case 3 -> {
                    System.out.println("Good day, have fun!");
                    exitFlag = false;
                }
            }
        }
        return true;
    }

    private boolean selectArmor() {
        System.out.println("---------- Armors ----------");
        for (Armor a : Armor.getAllArmors()) {
            System.out.println(a.getId() + ". " + a.getName() + " Price: " + a.getPrice() + " Blocked damage: " + a.getBlock());
        }
        System.out.println("4 - Exit");
        System.out.print("Your choice: ");
        int selectedArmorID = input.nextInt();
        while (selectedArmorID < 1 || selectedArmorID > 4) {
            System.out.print("Invalid choice. Make it again: ");
            selectedArmorID = input.nextInt();
        }
        Armor armor = null;
        switch (selectedArmorID) {
            case 1, 2, 3 -> armor = Armor.getArmorById(selectedArmorID);
            case 4 -> {
                System.out.println("Good day, have fun!");
                return false;
            }
        }
        if (armor != null) {
            if (armor.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("You cannot afford this armor. Please choose another one!");

            } else {
                this.getPlayer().getInventory().setArmor(armor);
                this.getPlayer().setMoney(this.getPlayer().getMoney() - armor.getPrice());
                System.out.println("You purchased " + armor.getName() + ". Your balance is now " + this.getPlayer().getMoney());
            }
        }
        return true;
    }

    private boolean selectWeapon() {
        System.out.println("---------- Weapons ----------");
        for (Weapon w : Weapon.getAllWeapons()) {
            System.out.println(w.getId() + ". " + w.getName() + " Price: " + w.getPrice() + " Damage: " + w.getDamege());
        }
        System.out.println("4 - Exit");
        System.out.print("Your choice: ");
        int selectedWeaponID = input.nextInt();
        while (selectedWeaponID < 1 || selectedWeaponID > 4) {
            System.out.print("Invalid choice. Make it again: ");
            selectedWeaponID = input.nextInt();
        }
        Weapon weapon = null;
        switch (selectedWeaponID) {
            case 1, 2, 3 -> weapon = Weapon.getWeaponById(selectedWeaponID);
            case 4 -> {
                System.out.println("Good day, have fun!");
                return false;
            }
        }
        if (weapon != null) {
            if (weapon.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("You cannot afford this weapon. Please choose another one!");
            } else {
                this.getPlayer().getInventory().setWeapon(weapon);
                this.getPlayer().setMoney(this.getPlayer().getMoney() - weapon.getPrice());
                System.out.println("You purchased " + weapon.getName() + ". Your balance is now " + this.getPlayer().getMoney());
            }
        }
        return true;
    }
}
