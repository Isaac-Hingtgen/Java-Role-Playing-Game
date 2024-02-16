package main.java.ser316.rpg.consumables;

public class small_potion extends Consumables {
	public small_potion() {
		int bonusAmount = 15;
		description = String.format("Heals for %d health.", bonusAmount);
		healthBonus = bonusAmount;
		cost = 30;
	}
}
