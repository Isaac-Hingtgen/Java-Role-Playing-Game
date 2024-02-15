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

        int curFloor = 0;

        while(!myHero.isDead()) {
            System.out.println("Currently on floor " + ++curFloor + ".\n");

            System.out.println("Would you like to visit the shop? (y/n)");
            if(input.nextLine().toLowerCase().equals("y")) {
                shop.goToShop(curFloor);
            }

            Enemy myOpponent = characterFactory.getRandomEnemy(curFloor);

            Fight fight = new Fight(myHero, myOpponent);
            fight.init(input);

            if(myHero.isDead()) break;

            myHero.usePassive();
        }
    }

    public int foo(int num) {
        return num;
    }
}
