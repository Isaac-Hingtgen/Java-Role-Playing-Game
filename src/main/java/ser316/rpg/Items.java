package main.java.ser316.rpg;

import main.java.ser316.rpg.characters.heroes.Hero;
import main.java.ser316.rpg.consumables.Consumables;
import main.java.ser316.rpg.equipment.Equipment;

// items, consumables, and equipment use State design pattern

public abstract class Items {
	protected int cost;
	protected int healthBonus = 0;
	protected int manaBonus = 0;
	protected int attackBonus = 0;
	protected int evasionBonus = 0;
	protected int defenceBonus = 0;

	protected boolean sold = false;



	public static Items getRandomItem(int level) {
		if(Math.random() > 0.3) {
			return Consumables.getRandomConsumable();
		} else {
			return Equipment.getRandomEquipment(level);
		}
	}

	public String getName() {
		return this.getClass().getSimpleName();
	}

	public int getCost() {
		return cost;
	}

	public boolean isSold() {
		return sold;
	}

	public void setSold(boolean sold) {
		this.sold = sold;
	}

	public void addBonus(Hero hero) {
		hero.addDefenceBonus(defenceBonus);
		hero.addAttackBonus(attackBonus);
		hero.addEvasionBonus(evasionBonus);
		hero.addHealth(healthBonus);
		hero.addMana(manaBonus);
	}

}
