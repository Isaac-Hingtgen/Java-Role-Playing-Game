package main.java.ser316.rpg.consumables;

public abstract class DurationBasedConsumable extends Consumables {
	protected int duration = 3;

	public static final int NUMBER_OF_ITEMS = 3;

	public static Consumables getConsumable(int num) {
		switch (num) {
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

	public void decrementDuration() {
		this.duration--;
	}

	public boolean isExpired() {
		return duration <= 0;
	}
}

class potion_of_strength extends DurationBasedConsumable {
	public potion_of_strength() {
		int bonusAmount = 50;
		description = String.format("Grants %d extra strength for %d floors.", bonusAmount, duration);
		attackBonus = bonusAmount;
		cost = 50;
	}
}

class potion_of_swiftness extends DurationBasedConsumable {
	public potion_of_swiftness() {
		int bonusAmount = 45;
		description = String.format("Grants %d extra evasion for %d floors.", bonusAmount, duration);
		evasionBonus = bonusAmount;
		cost = 50;
	}
}

class potion_of_thick_skin extends DurationBasedConsumable {
	public potion_of_thick_skin() {
		int bonusAmount = 55;
		description = String.format("Grants %d extra defense for %d floors.", bonusAmount, duration);
		defenceBonus = bonusAmount;
		cost = 50;
	}
}
