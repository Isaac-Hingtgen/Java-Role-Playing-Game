package main.java.ser316.rpg.equipment;

import main.java.ser316.rpg.Items;

public abstract class Equipment extends Items {
	protected int weight = 0;

	public static Equipment getRandomEquipment(int level) {
		while(true) {
			int rand = (int) (Math.random() * 5);
			switch (rand) {
				case 0:
					return Chest.getChestArmour(level);
				case 1:
					return Boots.getBoots(level);
				case 2:
					return Jewelry.getJewelry(level);
				case 3:
					return Weapon.getWeapon(level);
				case 4:
					return Helmets.getHelmets(level);
				default:
					return null;
			}
		}
	}

	public int getWeight() {
		return weight;
	}


}


