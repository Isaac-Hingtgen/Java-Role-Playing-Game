package main.java.ser316.rpg.characters.enemies;

public class Vampire extends Enemy {
	public Vampire() {
		resetAttributes();
		this.birth();
	}

	@Override
	public void resetAttributes() {
		attack = 20;
		defence = 10;
		evasion = 20;
		maxMana = 80;
		maxHealth = 100;
	}
}
