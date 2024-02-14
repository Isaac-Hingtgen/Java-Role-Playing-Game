package main.java.ser316.rpg.characters.heroes;

import main.java.ser316.rpg.characters.Character;

public class Elf extends Character {

	public Elf() {
		attack = 20;
		defence = 10;
		evasion = 30;
		maxMana = 20;
		maxHealth = 100;
		this.birth();
	}

	@Override
	public void specialAttack() {

	}
}
