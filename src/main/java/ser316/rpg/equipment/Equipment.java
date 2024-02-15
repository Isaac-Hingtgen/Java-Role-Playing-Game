package main.java.ser316.rpg.equipment;

import main.java.ser316.rpg.Items;
import main.java.ser316.rpg.characters.heroes.Hero;

public abstract class Equipment extends Items {

	protected int type;
	protected int defenceBonus = 0;
	protected int attackBonus = 0;
	protected int evasionBonus = 0;
	protected int healthBonus = 0;
	protected int manaBonus = 0;
	protected int weight = 0;

	public static Equipment getRandomEquipment(int level) {
		while(true) {
			int rand = (int) (Math.random() * 5);
			switch (rand) {
				case 0:
					return Chest.getChestArmour(level);
				case 1:
					//return Boots.getBoots(level);
				default:
					return Chest.getChestArmour(level);
			}
		}
	}

	public int getWeight() {
		return weight;
	}

	public void addBonus(Hero hero) {
		hero.addDefenceBonus(defenceBonus);
		hero.addAttackBonus(attackBonus);
		hero.addEvasionBonus(evasionBonus);
		hero.addHealth(healthBonus);
		hero.addMana(manaBonus);
	}
}


