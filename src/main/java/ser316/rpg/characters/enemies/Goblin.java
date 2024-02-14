package main.java.ser316.rpg.characters.enemies;

public class Goblin extends Enemy {
	public Goblin() {
		attack = 10;
		defence = 10;
		evasion = 10;
		maxMana = 0;
		maxHealth = 50;
		this.birth();
	}
	@Override
	public void specialAttack() {

	}
}
