package main.java.ser316.rpg.characters.heroes;

import main.java.ser316.rpg.Seasons;
import main.java.ser316.rpg.consumables.Consumables;
import main.java.ser316.rpg.consumables.DurationBasedConsumable;
import main.java.ser316.rpg.Items;
import main.java.ser316.rpg.characters.Character;
import main.java.ser316.rpg.characters.affinities.Affinity;
import main.java.ser316.rpg.characters.affinities.AffinityFactory;
import main.java.ser316.rpg.characters.affinities.Warlock;
import main.java.ser316.rpg.characters.enemies.Enemy;
import main.java.ser316.rpg.equipment.*;
import main.java.ser316.rpg.equipment.Boots;
import main.java.ser316.rpg.equipment.Weapon;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Hero extends Character {

	public static final int OGRE = 0;
	public static final int ELF = 1;
	public static final int DARK_ELF = 2;
	public static final int MAX_NUM_POTIONS = 3;


	protected ArrayList<Consumables> consumables = new ArrayList<>();
	protected ArrayList<DurationBasedConsumable> consumablesInEffect = new ArrayList<>();
	protected Chest chest = null;
	protected Boots boots = null;
	protected Helmets helmet = null;
	protected Jewelry jewelry = null;
	protected Weapon weapon = null;
	protected Affinity _affinity = null;

	protected int experience;
	protected int gold;

	public Hero() {
		experience = 0;
		gold = 0;
	}

	public void setAffinity(Affinity affinity) {
		this._affinity = affinity;
	}

	public void specialAttack() {
		if(specialAttackUsed) {
			System.out.println("Special attack already used. Using physical attack instead.");
			attack();
			return;
		}

		_affinity.addAffinityBonuses(this);

		System.out.println("Using " + _affinity.SKILL + "!");

		if(_affinity instanceof Warlock) {
			magicAttack(curMana);
			System.out.println(this + " absorbed " + _affinity.getHealthBonus() + " life with the attack.");
		} else {
			attack();
		}
		specialAttackUsed = true;
	}
	public void setAffinity(int affinity) {
		_affinity = AffinityFactory.getAffinity(affinity);
	}

	public void setAscendedAffinity(int affinity) {
		if(_affinity != null)
			_affinity = AffinityFactory.getAffinity(affinity, _affinity);
		else
			_affinity = AffinityFactory.getAffinity(affinity);
	}

	public void beginFight() throws Exception {
		if(_opponent == null) throw new Exception("Who are you fighting?");
		specialAttackUsed = false;
	}

	public void resolveBonuses(Seasons curSeason) {
		resetBonuses();
		if(chest != null) chest.addBonus(this);
		if(boots != null) boots.addBonus(this);
		if(jewelry != null) jewelry.addBonus(this);
		if(helmet != null) helmet.addBonus(this);
		if(weapon != null) weapon.addBonus(this);
		for(int i = 0; i < consumablesInEffect.size(); i++) {
			DurationBasedConsumable c = consumablesInEffect.get(i);
			c.addBonus(this);
			c.decrementDuration();
			if(c.isExpired()) {
				consumablesInEffect.remove(i);
			}
		}
		curSeason.addStatModifiers(this);
	}

	public void displayStats(Seasons season) {
		resolveBonuses(season);
		displayStatus();
		System.out.println("\tEvasion: " + (evasion) + String.format("(%+d)", evasionBonus));
		System.out.println("\tAttack: " + (attack) + String.format("(%+d)", attackBonus));
		System.out.println("\tDefence: " + (defence) + String.format("(%+d)", defenceBonus));
	}

	public void resetBonuses() {
		attackBonus = 0;
		defenceBonus = 0;
		evasionBonus = 0;
	}

	public void winsFight() {
		Enemy enemy = (Enemy) _opponent;
		int experienceGained = (int)((Math.random() * 0.5 + 0.75) * (2 * enemy.level + enemy.type * enemy.type * 5));
		int goldGained = (int)((Math.random() * 0.5 + 0.75) * (2 * enemy.level + enemy.level * 6 + enemy.type * enemy.type * 9));
		System.out.printf("You have won the fight! %d gold and %d XP gained.\n", goldGained, experienceGained);
		gold += goldGained;
		experience += experienceGained;
		System.out.printf("You now have %d gold and %d XP.\n", gold, experience);
	}

	public abstract void usePassive();



	public int getGold() {
		return gold;
	}

	public void equip(Items item) {
		if (item instanceof Jewelry) {
			jewelry = (Jewelry) item;
		} else if (item instanceof Chest) {
			chest = (Chest) item;
		} else if (item instanceof Boots) {
			boots = (Boots) item;
		} else if (item instanceof Helmets) {
			helmet = (Helmets) item;
		} else if (item instanceof Weapon) {
			weapon = (Weapon) item;
		} else if (item instanceof Consumables) {
			consumables.add((Consumables) item);
		}
	}

	public void displayEquipment() {
		System.out.print("Helmet: ");
		if(helmet != null) System.out.println(helmet.toString());
		else System.out.println("None");
		System.out.print("Chest: ");
		if(chest != null) System.out.println(chest.toString());
		else System.out.println("None");
		System.out.print("Jewelry: ");
		if(jewelry != null) System.out.println(jewelry.toString());
		else System.out.println("None");
		System.out.print("Weapon: ");
		if(weapon != null) System.out.println(weapon.toString());
		else System.out.println("None");
		System.out.print("Boots: ");
		if(boots != null) System.out.println(boots.toString());
		else System.out.println("None");
	}

	public boolean hasInventorySpace() {
		return consumables.size() < MAX_NUM_POTIONS;
	}

	public void removeGold(int gold) {
		this.gold -= gold;
		if(this.gold < 0) this.gold = 0;
	}

	public void usePotion(Scanner in) {
		System.out.println("What potion would you like to use?");
		for (int i = 0; i < consumables.size(); i++) {
			System.out.println("" + (i + 1) + ": " + consumables.get(i).toString());
		}
		System.out.println("0: Cancel.");
	    int choice = in.nextInt();
		choice--;
		in.nextLine();

		if(choice >= 0 && choice < consumables.size()) {
			Consumables s = consumables.get(choice);
			System.out.println(s.toString() + " was used.");
			if(s instanceof DurationBasedConsumable) {
				consumablesInEffect.add((DurationBasedConsumable) s);
			}
			s.addBonus(this);
			displayStatus();
			consumables.remove(choice);
			System.out.println();
		} else {
			System.out.println("Selection cancelled.");
		}
	}

	public Affinity getAffinity() {
		return _affinity;
	}

	public int getExperience() {
		return experience;
	}
}
