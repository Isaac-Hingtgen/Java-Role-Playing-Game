package main.java.ser316.rpg.consumables;

public class potion_of_swiftness extends DurationBasedConsumable {
	public potion_of_swiftness() {
		int bonusAmount = 15;
		description = String.format("Grants %d extra evasion for %d floors.", bonusAmount, duration);
		evasionBonus = bonusAmount;
		cost = 50;
	}
}
