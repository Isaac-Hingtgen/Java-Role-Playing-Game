package main.java.ser316.rpg;

import java.util.Scanner;

import main.java.ser316.rpg.characters.CharacterFactory;
import main.java.ser316.rpg.characters.ConcreteCharacterFactory;
import main.java.ser316.rpg.characters.affinities.*;
import main.java.ser316.rpg.characters.enemies.Enemy;
import main.java.ser316.rpg.characters.heroes.*;


public class Start {
    public static boolean demo = false;
    public static int curFloor = 1;
    public static void main(String [] argv) {
        System.out.println("Descend the tower!\n");

        Scanner input = new Scanner(System.in, "UTF-8");

        CharacterFactory characterFactory = new ConcreteCharacterFactory();
        Hero myHero = null;

        do {
            System.out.println("Select character type:");
            System.out.println((Hero.OGRE + 1) + ": Ogre, \n\t" + Ogre.PASSIVE);
            System.out.println((Hero.ELF + 1) + ": Elf, \n\t" + Elf.PASSIVE);
            System.out.println((Hero.DARK_ELF + 1) + ": Dark Elf, \n\t" + DarkElf.PASSIVE);
            System.out.println((4) + ": Test, \n\t(select this for demo)");


            int selection = input.nextInt();
            input.nextLine();
            selection--;
            myHero = characterFactory.createHero(selection);
            if (selection == 3) {
                demo = true;
            }

        } while (myHero == null);

        System.out.println(myHero + " selected.\n");

        do {
            System.out.println("Select affinity:");
            System.out.println((Affinity.ASSASSIN + 1) + ": Assassin \n" + Assassin.DESCRIPTION);
            System.out.println((Affinity.WARLOCK + 1) + ": Warlock \n" + Warlock.DESCRIPTION);
            System.out.println((Affinity.WARRIOR + 1) + ": Warrior \n" + Warrior.DESCRIPTION);

            int selection;
            if (demo) {
                selection = (int) (Math.random() * 3) + 1;
                displayInput(String.valueOf(selection));
            } else {
                selection = input.nextInt();
                input.nextLine();
            }
            selection--;
            myHero.setAffinity(selection);
            System.out.println(myHero.getAffinity() + " selected.\n");

        } while (myHero.getAffinity() == null);

        System.out.println("Welcome " + myHero.getAffinity() + " " + myHero + "!\n");

        Shop shop = new Shop(input, myHero);
        Seasons curSeason = Seasons.getCurSeason(curFloor);
        String in = null;
        String [] demoOptions = { "c", "e", "s", "c", "e", "i", "f" };
        int prevInd = 0;

        do {

            System.out.println("\nCURRENT FLOOR: " + curFloor + ". It is " + curSeason + ".\n");

            System.out.println("What would you like to do? (s)hop, (c)haracter stats, (f)ight, check (e)quipment, season (i)nformation, (q)uit"
                + ((!demo && myHero instanceof OpTestHero) ? ", return to (d)emo" : ""));

            if (demo) {
                if (curFloor == 101) {
                    in = "q";
                } else if (curFloor % 10 == 1) {
                    in = demoOptions[prevInd];
                    prevInd = (prevInd + 1) % demoOptions.length;
                    if (in.equals("f")) {
                        System.out.println("\nPress <ENTER> to continue. Or (d) to leave demo mode");
                        String m = input.nextLine();
                        if (m.equals("d")) {
                            demo = false;
                            in = "leave demo mode";
                        }
                    }
                } else {
                    in = "f";
                }
                displayInput(in);
            } else {
                in = input.nextLine().toLowerCase();
            }

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

                    if (Math.random() < 0.90) {
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
                curSeason = Seasons.getCurSeason(curFloor);
                myHero.addMana(5);
                myHero.checkPotions();
                myHero.usePassive();
            } else if (in.equals("d")) {
                demo = true;
            }


            if (myHero.getExperience() > 1500 && !myHero.isAscended()) {
                do {
                    System.out.println();
                    System.out.println("~~~The Hero has Ascended~~~");
                    System.out.println("Select ascended affinity:");
                    System.out.println((AscendedAffinity.PHANTOM + 1) + ": Phantom \n\tAbilities unknown");
                    System.out.println((AscendedAffinity.SAGE + 1) + ": Sage \n\tAbilities unknown");
                    System.out.println((AscendedAffinity.BERSERKER + 1) + ": Berserker \n\tAbilities unknown");

                    int selection = input.nextInt();
                    input.nextLine();

                    myHero.setAscendedAffinity(--selection);
                } while (!(myHero.getAffinity() instanceof AscendedAffinity));
            }

        } while (!in.equals("q"));
        System.out.println("Goodbye.");
    }

    public static void displayInput(String input) {
        if (true) {
            System.out.println("\nInput: \u001B[32m" + input + "\u001B[0m\n");
        } else {
            System.out.println("\nInput: " + input + "\n");
        }
    }
}
