package main.java.ser316.rpg.characters.heroes;


import main.java.ser316.rpg.characters.Character;

public class Ogre extends Character {
	public Ogre() {
		evasion = 20;
		attack = 30;
		defence = 30;
		maxMana = 0;
		maxHealth = 120;
		this.birth();
	}


	@Override
	public void specialAttack() {

	}
}
