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
        Seasons seasons = new Seasons();


        int curFloor = 1;
        Seasons curSeason = seasons.getCurSeason(curFloor);
        String in = "";

        do {

            System.out.println("Currently on floor " + curFloor + ". It is " + curSeason + ".\n");

            System.out.println("What would you like to do? (s)hop, (c)haracter stats, (f)ight, check (e)quipment, season (i)nformation, (q)uit");
            in = input.nextLine().toLowerCase();
            if (in.equals("s")) {
                shop.goToShop(curFloor);
            } else if (in.equals("c")) {
                myHero.displayStats(curSeason);
            } else if (in.equals("e")) {
                myHero.displayEquipment();
            } else if (in.equals("i")) {
                System.out.println(curSeason.getDescription());
            } else if (in.equals("f") || in.equals("1")) {
                Enemy myOpponent = characterFactory.getRandomEnemy(curFloor);

                Fight fight = new Fight(myHero, myOpponent, curSeason);
                fight.init(input);
                curFloor++;

                if (myHero.isDead()) {
                    System.out.println("You have died.");
                    curFloor = 1;
                    myHero.removeGold((int) Math.ceil(0.25 * myHero.getGold()));
                }

                if (myHero.getCurHealth() < 0.15 * myHero.getMaxHealth()) {
                    System.out.println("You are gravely wounded and returned to the top floor to rest.");
                    System.out.println("Zzzzzz...");
                    myHero.addMana(myHero.getMaxMana());
                    myHero.addHealth(myHero.getMaxHealth());

                    if(Math.random() < 0.90) {
                        System.out.println("You wake up feeling well rested.");
                    } else if (Math.random() > 0.5) {
                        System.out.println("You did not sleep well last night and wake up with a headache.");
                        myHero.removeMana(10);
                    } else {
                        System.out.println("One of your wounds opened during your sleep so you did not recover fully.");
                        myHero.removeHealth(5);
                    }

                    myHero.displayStatus();
                }
                seasons.getCurSeason(curFloor);
                myHero.usePassive();
            }
        } while (!in.equals("q"));
        System.out.println("Goodbye.");
    }

    public int foo(int num) {
        return num;
    }
}
