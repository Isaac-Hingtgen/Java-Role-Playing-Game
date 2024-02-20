package main.java.ser316.rpg;

import java.util.Scanner;

import main.java.ser316.rpg.characters.heroes.Hero;
import main.java.ser316.rpg.consumables.Consumables;


public class Shop {
    private static final int NUM_OF_ITEMS = 5;

    private int level = 1;
    private Items[] inventory = new Items[NUM_OF_ITEMS];
    private Scanner in = null;
    private Hero customer = null;
    public Shop(Scanner in, Hero hero) {
        this.in = in;
        this.customer = hero;
    }


    public void goToShop(int level) {
        this.level = level;
        getNewInventory();
        System.out.println("Welcome to the shop:\n");

        int items = (int) (Math.random() * 2) + 1;
        int ans;
        do {
            displayInventory();
            System.out.println();
            System.out.println("Would you like to buy anything? (1-5, 0 to leave)\t Gold: " + customer.getGold());
            if (Start.demo) {
                // try to purchase 3 random items
                ans = (items < 5) ? items : 0;
                Start.displayInput(String.valueOf(ans));
                items += (int) (Math.random() * 2) + 1;
            } else {
                ans = in.nextInt();
                in.nextLine(); // clear line
            }
            if (ans > 0 && ans < 6) {
                makePurchase(ans);
            }
        } while (ans != 0);
    }

    private void makePurchase(int ans) {
        Items item = inventory[ans - 1];
        if (item.getCost() > customer.getGold()) {
            System.out.println("Not enough gold!");
        } else if (item.isSold()) {
            System.out.println("Item was already sold.");
        } else {
            if (item instanceof Consumables && !customer.hasInventorySpace()) {
                System.out.println("Not enough room in inventory.");
            } else {
                System.out.println(item + " purchased.");
                item.setSold(true);
                customer.removeGold(item.getCost());
                customer.equip(item);
            }
        }
        System.out.println();
    }

    public void getNewInventory() {
        for (int i = 0; i < NUM_OF_ITEMS; i++) {
            inventory[i] = Items.getRandomItem(level);
        }
    }

    public void displayInventory() {
        for (int i = 0; i < NUM_OF_ITEMS; i++) {
            if (inventory[i].isSold()) {
                System.out.println("\t" + (i + 1) + ": Sold out.");
            } else {
                System.out.println("\t" + (i + 1) + ": " + inventory[i].getName() + " : " + inventory[i].getCost()
                    + " gold. " + inventory[i].getDescription());
            }
        }
    }
}
