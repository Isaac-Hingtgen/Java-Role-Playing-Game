package main.java.ser316.rpg;

import main.java.ser316.rpg.characters.Character;
import main.java.ser316.rpg.characters.enemies.Enemy;
import main.java.ser316.rpg.characters.heroes.Hero;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Fight {
	Hero hero = null;
	Enemy enemy = null;
	public Fight(Hero hero, Enemy enemy) {
		this.hero = hero;
		this.enemy = enemy;
		hero.setOpponent(enemy);
	}

	public void init(Scanner in) {
		try {
			hero.beginFight();
			System.out.println(hero + " encountered a " + enemy + ".");
			System.out.println("Let the fight begin!\n");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		while(!hero.isDead() && !enemy.isDead()) {
			System.out.println("Select your attack:");
			System.out.println("1: Physical Attack");
			System.out.println("2: Magic Attack");
			System.out.println("3: Special Attack");

			try {
				//int attack = in.nextInt();
				int attack = 3;
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
			}

			hero.displayStatus();
			System.out.println("Press <ENTER> to continue.");
			in.nextLine();
			in.nextLine();
		}

	}
}
