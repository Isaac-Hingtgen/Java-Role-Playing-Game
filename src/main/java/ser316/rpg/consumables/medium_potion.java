package main.java.ser316.rpg.consumables;

public class medium_potion extends Consumables {
	public medium_potion() {
		int bonusAmount = 35;
		description = String.format("Heals for %d health.", bonusAmount);
		healthBonus = bonusAmount;
		cost = 60;
	}
}
