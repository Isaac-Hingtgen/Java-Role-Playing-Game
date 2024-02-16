package main.java.ser316.rpg.consumables;

public class potion_of_strength extends DurationBasedConsumable {
	public potion_of_strength() {
		int bonusAmount = 25;
		description = String.format("Grants %d extra strength for %d floors.", bonusAmount, duration);
		attackBonus = bonusAmount;
		cost = 50;
	}
}
