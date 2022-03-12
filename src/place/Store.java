package place;

import hero.Player;
import place.item.Weapon;

public class Store extends NormalLocation{
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
        switch (selectItem) {
            case 1 -> selectWeapon();
            case 2 -> printArmors();
            case 3 -> System.out.println("Good day, have fun!");
            default -> {
                System.out.println("Invalid choice. Make it again");
                onLocation();
            }
        }

        return true;
    }

    private void printArmors() {
    }

    private void selectWeapon() {
        System.out.println("---------- Weapons ----------");
        for(Weapon w:Weapon.getAllWeapons()){
            System.out.println(w.getId()+". "+ w.getName() + " Price: "+w.getPrice()+" Damage: "+w.getDamege());
        }
        System.out.println("4 - Exit");
        System.out.print("Your choice: ");
        int selectedWeapon = input.nextInt();
        Weapon weapon = null;
        switch (selectedWeapon) {
            case 1, 2, 3 -> weapon = Weapon.getWeaponById(selectedWeapon);
            case 4 -> {
                System.out.println("Good day, have fun!");
                return;
            }
            default -> {
                System.out.println("Invalid choice. Make it again");
                selectWeapon();
            }
        }
        if(weapon != null) {
            if(weapon.getPrice() > this.getPlayer().getMoney()){
                System.out.println("You cannot afford this weapon. Please choose another one!");
                selectWeapon();
            } else{
                this.getPlayer().getInventory().setWeapon(weapon);
                this.getPlayer().setMoney(this.getPlayer().getMoney()- weapon.getPrice());
                System.out.println("You purchased " + weapon.getName()+". Your balance is now " + this.getPlayer().getMoney());
            }
        }
    }
}
