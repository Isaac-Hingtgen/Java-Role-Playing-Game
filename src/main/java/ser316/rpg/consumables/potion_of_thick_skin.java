package main.java.ser316.rpg.consumables;

public class potion_of_thick_skin extends DurationBasedConsumable {
	public potion_of_thick_skin() {
		int bonusAmount = 55;
		description = String.format("Grants %d extra defense for %d floors.", bonusAmount, duration);
		defenceBonus = bonusAmount;
		cost = 50;
	}
}
