package main.java.ser316.rpg.consumables;

public class large_potion extends Consumables {
	public large_potion() {
		int bonusAmount = 60;
		description = String.format("Heals for %d health.", bonusAmount);
		healthBonus = bonusAmount;
		cost = 100;
	}
}
