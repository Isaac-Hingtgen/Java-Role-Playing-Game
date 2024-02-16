package main.java.ser316.rpg.equipment;

public class Jewelry extends Equipment {

	public static Jewelry getJewelry(int level) {
		int rand = (int) (Math.random() * 5);
		switch (rand) {
			case 0:
				return new sharktooth_necklace();
			case 1:
				return new amulet_of_protection();
			case 2:
				return new lucky_bracelet();
			case 3:
				return new amulet_of_vitality();
			case 4:
				return new amulet_of_intelligence();
			default:
				return null;
		}
	}
}

class sharktooth_necklace extends Jewelry {
	public sharktooth_necklace() {
		attackBonus = 20;
		cost = 50;
	}
}

class amulet_of_protection extends Jewelry {
	public amulet_of_protection() {
		defenceBonus = 20;
		cost = 50;

	}
}

class lucky_bracelet extends Jewelry {
	public lucky_bracelet() {
		evasionBonus = 20;
		cost = 50;

	}
}

class amulet_of_vitality extends Jewelry {
	public amulet_of_vitality() {
		healthBonus = 5;
		cost = 75;
	}
}

class amulet_of_intelligence extends Jewelry {
	public amulet_of_intelligence() {
		manaBonus = 10;
		cost = 75;
	}
}