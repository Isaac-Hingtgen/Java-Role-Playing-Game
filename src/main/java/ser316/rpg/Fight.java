package main.java.ser316.rpg;

import java.util.InputMismatchException;
import java.util.Scanner;

import main.java.ser316.rpg.characters.enemies.Enemy;
import main.java.ser316.rpg.characters.heroes.Hero;


public class Fight {
    private Hero hero = null;
    private Enemy enemy = null;
    private Seasons season = null;
    public Fight(Hero hero, Enemy enemy, Seasons season) {
        this.hero = hero;
        this.enemy = enemy;
        this.season = season;
        hero.setOpponent(enemy);
    }

    public void init(Scanner in) {
        hero.resolveBonuses(season);
        try {
            hero.beginFight();
            System.out.println(hero + " encountered a " + enemy + ".");
            System.out.println("Let the fight begin!\n");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        while(!hero.isDead() && !enemy.isDead()) {
            System.out.println("Select your move:");
            System.out.println("\t1: Physical Attack");
            System.out.println("\t2: Magic Attack");
            System.out.println("\t3: Special Attack");
            System.out.println("\t4: Use Potion");

            try {
                int attack = in.nextInt();
                in.nextLine();
                switch (attack) {
                    case 1: {
                        hero.attack();
                        break;
                    }
                    case 2: {
                        System.out.println("How much mana would you like to use? You currently have " + hero.getCurMana() + " available.");
                        int manaUsage = in.nextInt();
                        hero.magicAttack(manaUsage);
                        break;
                    }
                    case 3: {
                        hero.specialAttack();
                        break;
                    }
                    case 4: {
                        hero.usePotion(in);
                        continue;
                    }
                    default:
                        throw new InputMismatchException();
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Failed to select a valid option. Your turn is forfeited.");
            }

            if(!enemy.isDead()) {
                enemy.displayStatus();
                if (enemy.getCurMana() != 0 && Math.random() > 0.80) enemy.magicAttack(enemy.getCurMana());
                else enemy.attack();
            } else {
                hero.winsFight();
            }

            hero.displayStatus();
            System.out.println("Press <ENTER> to continue.");
            in.nextLine();
        }
    }
}
