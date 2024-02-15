package main.java.ser316.rpg.characters.heroes;

import main.java.ser316.rpg.characters.Character;

public class DarkElf extends Hero {
	public DarkElf() {
		super();
		resetAttributes();
		this.birth();
	}

	@Override
	public void resetAttributes() {
		attack = 30;
		defence = 20;
		evasion = 10;
		maxMana = 60;
		maxHealth = 180;
	}

	public void usePassive() {
		System.out.println("Blessing of darkness grants 20 mana.");
		addMana(20);
	}
}
