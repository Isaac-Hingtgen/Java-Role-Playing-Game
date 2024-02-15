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

	public void addBonus(Hero hero) {
		hero.setDefenceBonus(defenceBonus);
		hero.setAttackBonus(attackBonus);
		hero.setEvasionBonus(evasionBonus);
		hero.addHealth(healthBonus);
		hero.addMana(manaBonus);
	}
}


