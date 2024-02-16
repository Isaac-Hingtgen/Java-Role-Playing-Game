package main.java.ser316.rpg.equipment;

public class Chest extends Equipment {

	public static Chest getChestArmour(int level) {
		if (level < 9) return new leather_jerkin();
		else if (level < 21) return new chain_mail();
		else return new plate_armour_chest();
	}
}

class leather_jerkin extends Chest {
	public leather_jerkin() {
		cost = 50;
		defenceBonus = 30;
		evasionBonus = -2;
		weight = 2;
	}
}

class chain_mail extends Chest {
	public chain_mail() {
		cost = 150;
		defenceBonus = 50;
		evasionBonus = -5;
		weight = 7;
	}
}

class plate_armour_chest extends Chest {
	public plate_armour_chest() {
		cost = 320;
		defenceBonus = 120;
		evasionBonus = -12;
		weight = 15;
	}
}