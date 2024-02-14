package main.java.ser316.rpg.characters.heroes;

import main.java.ser316.rpg.characters.Character;

public class DarkElf extends Character {
	public DarkElf() {
		attack = 30;
		defence = 20;
		evasion = 10;
		maxMana = 50;
		maxHealth = 100;
		this.birth();
	}


	@Override
	public void specialAttack() {

	}
}
