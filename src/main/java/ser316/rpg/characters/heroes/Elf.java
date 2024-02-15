package main.java.ser316.rpg.characters.heroes;

import main.java.ser316.rpg.characters.Character;

public class Elf extends Hero {

	public Elf() {
		super();
		resetAttributes();
		this.birth();
	}

	@Override
	public void resetAttributes() {
		attack = 20;
		defence = 10;
		evasion = 30;
		maxMana = 50;
		maxHealth = 160;
	}

	@Override
	public void usePassive() {
		//todo: make faster if light or no armour equiped
	}
}
