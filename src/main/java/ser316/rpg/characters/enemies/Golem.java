package main.java.ser316.rpg.characters.enemies;

public class Golem extends Enemy {
	public Golem() {
		resetAttributes();
		this.birth();
	}

	@Override
	public void resetAttributes() {
		attack = 25;
		defence = 40;
		evasion = 0;
		maxMana = 0;
		maxHealth = 120;
	}
}
