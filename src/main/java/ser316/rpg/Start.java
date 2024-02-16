package main.java.ser316.rpg;

import main.java.ser316.rpg.characters.*;
import main.java.ser316.rpg.characters.Character;
import main.java.ser316.rpg.characters.affinities.Affinity;
import main.java.ser316.rpg.characters.affinities.AffinityFactory;
import main.java.ser316.rpg.characters.enemies.Enemy;
import main.java.ser316.rpg.characters.heroes.DarkElf;
import main.java.ser316.rpg.characters.heroes.Hero;
import main.java.ser316.rpg.characters.heroes.OPTestHero;

import java.util.Scanner;

public class Start {
    public static void main(String [] argv) {
        System.out.println("Descend the tower!\n");

        Scanner input = new Scanner(System.in);

        CharacterFactory characterFactory = new ConcreteCharacterFactory();
//        Hero myHero = characterFactory.createHero(Hero.DARK_ELF);
        Hero myHero = new OPTestHero();
        myHero.setAffinity(Affinity.ASSASSIN);
        Shop shop = new Shop(input, myHero);

        int curFloor = 1;
        String in = "";

        do {
            System.out.println("Currently on floor " + curFloor + ".\n");

            System.out.println("What would you like to do? (s)hop, (c)haracter stats, (f)ight, check (e)quipment, (q)uit");
            in = input.nextLine().toLowerCase();
            if (in.equals("s")) {
                shop.goToShop(curFloor);
            } else if (in.equals("c")) {
                myHero.displayStats();
            } else if (in.equals("e")) {
                myHero.displayEquipment();
            } else if (in.equals("f") || in.equals("1")) {
                Enemy myOpponent = characterFactory.getRandomEnemy(curFloor);

                Fight fight = new Fight(myHero, myOpponent);
                fight.init(input);
                curFloor++;

                if (myHero.isDead()) {
                    System.out.println("You have died.");
                    curFloor = 1;
                    myHero.removeGold((int) Math.ceil(0.25 * myHero.getGold()));
                }

                if (myHero.getCurHealth() < 0.15 * myHero.getMaxHealth()) {
                    System.out.println("You are gravely wounded and returned to the top floor to rest.");
                    myHero.addMana(myHero.getMaxMana());
                    myHero.addHealth(myHero.getMaxHealth());
                    myHero.displayStatus();
                }

                myHero.usePassive();
            }
        } while (!in.equals("q"));
        System.out.println("Goodbye.");
    }

    public int foo(int num) {
        return num;
    }
}
