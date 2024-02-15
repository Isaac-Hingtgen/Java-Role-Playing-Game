package main.java.ser316.rpg;

public abstract class Consumables extends Items {
	protected String description;
	private static final int NUMBER_OF_ITEMS = 7;
	public static final int MAX_POTIONS = 4;

	public int duration = 0;

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

class small_potion extends Consumables {
	public small_potion() {
		int bonusAmount = 15;
		description = String.format("Heals for %d health.", bonusAmount);
		healthBonus = bonusAmount;
		cost = 30;
	}
}
class mana_potion extends Consumables {
	public mana_potion() {
		int bonusAmount = 30;
		description = String.format("Grants %d mana.", bonusAmount);
		manaBonus = bonusAmount;
		cost = 50;
	}
}
class medium_potion extends Consumables {
	public medium_potion() {
		int bonusAmount = 35;
		description = String.format("Heals for %d health.", bonusAmount);
		healthBonus = bonusAmount;
		cost = 60;
	}
}
class large_potion extends Consumables {
	public large_potion() {
		int bonusAmount = 60;
		description = String.format("Heals for %d health.", bonusAmount);
		healthBonus = bonusAmount;
		cost = 100;
	}
}
class potion_of_swiftness extends Consumables {
	public potion_of_swiftness() {
		int bonusAmount = 15;
		int duration = 3;
		description = String.format("Grants %d extra evasion for %d floors.", bonusAmount, duration);
		evasionBonus = bonusAmount;
		this.duration = duration;
		cost = 50;
	}
}

class potion_of_strength extends Consumables {
	public potion_of_strength() {
		int bonusAmount = 25;
		int duration = 3;
		description = String.format("Grants %d extra strength for %d floors.", bonusAmount, duration);
		attackBonus = bonusAmount;
		this.duration = duration;
		cost = 50;
	}
}

class potion_of_thick_skin extends Consumables {
	public potion_of_thick_skin() {
		int bonusAmount = 25;
		int duration = 3;
		description = String.format("Grants %d extra defense for %d floors.", bonusAmount, duration);
		defenceBonus = bonusAmount;
		this.duration = duration;
		cost = 50;
	}
}


