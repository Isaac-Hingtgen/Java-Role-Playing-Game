package main.java.ser316.rpg.characters.heroes;

import main.java.ser316.rpg.consumables.Consumables;
import main.java.ser316.rpg.consumables.DurationBasedConsumable;
import main.java.ser316.rpg.Items;
import main.java.ser316.rpg.characters.Character;
import main.java.ser316.rpg.characters.affinities.Affinity;
import main.java.ser316.rpg.characters.affinities.AffinityFactory;
import main.java.ser316.rpg.characters.affinities.Warlock;
import main.java.ser316.rpg.characters.enemies.Enemy;
import main.java.ser316.rpg.consumables.large_potion;
import main.java.ser316.rpg.equipment.*;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Hero extends Character {

	public static final int OGRE = 0;
	public static final int ELF = 1;
	public static final int DARK_ELF = 2;
	public static final int MAX_NUM_CONSUMABLES = 3;

	protected ArrayList<Consumables> consumables = new ArrayList<>();
	protected ArrayList<DurationBasedConsumable> consumablesInEffect = new ArrayList<>();
	protected Chest chest = Chest.getChestArmour(14);
	protected Boots boots = null;
	protected Helmets helmet = null;
	protected Amulets amulets = null;
	protected Weapon weapon = null;
	protected int passiveSkill;
	protected Affinity _affinity;

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

		setAffinityBonuses();

		System.out.println("Using " + _affinity.SKILL + "!");

		if(_affinity instanceof Warlock) {
			magicAttack(curMana);
			System.out.println(this + " absorbed " + _affinity.getHealthBonus() + " life with the attack.");
		} else {
			attack();
		}
		specialAttackUsed = true;
		specialAttackUsedLastTurn = true;
	}
	public void setAffinity(int affinity) {
		_affinity = AffinityFactory.getAffinity(affinity);
	}
	public void setAffinityBonuses() {
		this.attack += _affinity.getAttackBonus();
		this.defence += _affinity.getDefenceBonus();
		this.evasion += _affinity.getEvasionBonus();
		this.curHealth += _affinity.getHealthBonus();
		if(curHealth > maxHealth) curHealth = maxHealth;
		this.curMana += _affinity.getManaBonus();
	}
	public void beginFight() throws Exception {
		if(_opponent == null) throw new Exception("Who are you fighting?");
		specialAttackUsed = false;
		specialAttackUsedLastTurn = false;
	}

	public void resolveBonuses() {
		resetBonuses();
		if(chest != null) chest.addBonus(this);
		if(boots != null) boots.addBonus(this);
		if(amulets != null) amulets.addBonus(this);
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
		if (item instanceof Amulets) {
			amulets = (Amulets) item;
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

	public int getNumberOfConsumables() {
		return consumables.size();
	}

	public void removeGold(int gold) {
		this.gold -= gold;
	}

	public void usePotion(Scanner in) {
		consumables.add(new large_potion());

		System.out.println("What potion would you like to use?");
		for (int i = 0; i < consumables.size(); i++) {
			System.out.println("" + (i + 1) + ": " + consumables.get(i).getName());
		}
		System.out.println("0: Cancel.");
	    int choice = in.nextInt();
		choice--;
		in.nextLine();

		if(choice >= 0 && choice < consumables.size()) {
			Consumables s = consumables.get(choice);
			System.out.println(s.getName() + " was used.");
			if(s instanceof DurationBasedConsumable) {
				consumablesInEffect.add((DurationBasedConsumable) s);
			}
			s.addBonus(this);
			displayStatus();
			System.out.println();
		} else {
			System.out.println("Selection cancelled.");
		}
	}
}
