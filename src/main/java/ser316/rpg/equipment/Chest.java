package main.java.ser316.rpg.equipment;

public class Chest extends Equipment {

	public static Chest getChestArmour(int level) {
		if (level < 10) return new chain_mail();
		else return new plate_armour_chest();
	}

	static class chain_mail extends Chest {
		public chain_mail() {
			cost = 200;
			defenceBonus = 20;
			evasionBonus = -5;
		}
	}

	static class plate_armour_chest extends Chest {
		public plate_armour_chest() {
			cost = 500;
			defenceBonus = 60;
			evasionBonus = -12;
		}
	}
}
