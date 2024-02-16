package main.java.ser316.rpg.consumables;

import main.java.ser316.rpg.Items;
import main.java.ser316.rpg.characters.heroes.Hero;

public abstract class Consumables extends Items {
	protected String description;
	private static final int NUMBER_OF_ITEMS = 7;
	public static final int MAX_POTIONS = 3;

	public static Consumables getRandomConsumable() {
		int num = (int) (Math.random() * NUMBER_OF_ITEMS);
		switch (num) {
			case 0:
				return new small_potion();
			case 1:
				return new medium_potion();
			case 2:
				return new large_potion();
			case 3:
				return new mana_potion();
			case 4:
				return new potion_of_swiftness();
			case 5:
				return new potion_of_strength();
			case 6:
				return new potion_of_thick_skin();
			default:
				return null;
		}
	}

	public String getDescription() {
		return description;
	}

}


