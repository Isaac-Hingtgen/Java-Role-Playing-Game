package main.java.ser316.rpg.consumables;

public class mana_potion extends Consumables {
	public mana_potion() {
		int bonusAmount = 30;
		description = String.format("Grants %d mana.", bonusAmount);
		manaBonus = bonusAmount;
		cost = 50;
	}
}
