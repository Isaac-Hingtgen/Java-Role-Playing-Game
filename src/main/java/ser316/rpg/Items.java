package main.java.ser316.rpg;

import main.java.ser316.rpg.equipment.Equipment;

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

}
