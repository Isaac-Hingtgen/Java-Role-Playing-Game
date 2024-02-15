package main.java.ser316.rpg.equipment;

public class Amulets extends Equipment {

	class amulet_of_vitality extends Amulets {
		public amulet_of_vitality() {
			healthBonus = 5;
		}
	}

	class amulet_of_intelligence extends Amulets {
		public amulet_of_intelligence() {
			manaBonus = 10;
		}
	}

}
