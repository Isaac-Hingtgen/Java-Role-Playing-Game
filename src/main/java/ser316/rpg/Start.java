package main.java.ser316.rpg;

import main.java.ser316.rpg.characters.*;
import main.java.ser316.rpg.characters.Character;
import main.java.ser316.rpg.characters.affinities.*;
import main.java.ser316.rpg.characters.enemies.Enemy;
import main.java.ser316.rpg.characters.heroes.*;

import java.util.Scanner;

public class Start {
    public static void main(String [] argv) {
        System.out.println("Descend the tower!\n");

        Scanner input = new Scanner(System.in);

        CharacterFactory characterFactory = new ConcreteCharacterFactory();
//        Hero myHero = characterFactory.createHero(Hero.DARK_ELF);
        Hero myHero = null;

        do {
            System.out.println("Select character type:");
            System.out.println((Hero.OGRE + 1) + ": Ogre, \n\t" + Ogre.PASSIVE);
            System.out.println((Hero.ELF + 1) + ": Elf, \n\t" + Elf.PASSIVE);
            System.out.println((Hero.DARK_ELF + 1) + ": Dark Elf, \n\t" + DarkElf.PASSIVE);

            int selection = input.nextInt();
            input.nextLine();
            selection--;
            myHero = characterFactory.createHero(selection);

        } while (myHero == null);

        System.out.println(myHero + " selected.\n");

        do {
            System.out.println("Select affinity:");
            System.out.println((Affinity.ASSASSIN + 1) + ": Assassin \n" + Assassin.DESCRIPTION);
            System.out.println((Affinity.WARLOCK + 1) + ": Warlock \n" + Warlock.DESCRIPTION);
            System.out.println((Affinity.WARRIOR + 1) + ": Warrior \n" + Warrior.DESCRIPTION);

            int selection = input.nextInt();
            input.nextLine();
            selection--;

            myHero.setAffinity(selection);

        } while (myHero.getAffinity() == null);

        System.out.println("Welcome " + myHero.getAffinity() + " " + myHero + "!\n");

        Shop shop = new Shop(input, myHero);
        Seasons seasons = new Seasons();
        int curFloor = 1;
        Seasons curSeason = seasons.getCurSeason(curFloor);
        String in;

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
                    System.out.println("You have died...");
                    myHero.removeGold((int) Math.ceil(0.25 * myHero.getGold()));
                    System.out.println("Resurrecting on the 1st level.");
                    curFloor = 1;
                    myHero.birth();
                }

                if (myHero.getCurHealth() < 0.15 * myHero.getMaxHealth()) {
                    System.out.println("You are gravely wounded and returned to the top floor to rest.");
                    System.out.println("Zzzzzz...");
                    myHero.birth();

                    if(Math.random() < 0.90) {
                        System.out.println("You wake up feeling well rested.");
                    } else if (Math.random() > 0.5) {
                        System.out.println("You did not sleep well last night and wake up with a headache.");
                        myHero.removeMana(5);
                    } else {
                        System.out.println("One of your wounds opened during your sleep so you did not recover fully.");
                        myHero.removeHealth(5);
                    }

                    myHero.displayStatus();
                }
                seasons.getCurSeason(curFloor);
                myHero.addMana(5);
                myHero.usePassive();
            }


            if(myHero.getExperience() > 500) {
                do {
                    System.out.println("Select ascended affinity:");
                    System.out.println((AscendedAffinity.PHANTOM + 1) + ": Phantom \n\tAbilities unknown");
                    System.out.println((AscendedAffinity.SAGE + 1) + ": Sage \n\tAbilities unknown");
                    System.out.println((AscendedAffinity.BERSERKER + 1) + ": Berserker \n\tAbilities unknown");

                    int selection = input.nextInt();
                    input.nextLine();

                    myHero.setAscendedAffinity(selection);
                } while (!(myHero.getAffinity() instanceof AscendedAffinity));
            }

        } while (!in.equals("q"));
        System.out.println("Goodbye.");
    }

    public int foo(int num) {
        return num;
    }
}
