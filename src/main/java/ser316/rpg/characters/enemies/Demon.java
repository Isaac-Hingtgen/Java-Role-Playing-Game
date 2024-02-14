package main.java.ser316.rpg.characters.enemies;

public class Demon extends Enemy {
	public Demon() {
		resetAttributes();
		this.birth();
	}

	@Override
	public void resetAttributes() {
		attack = 40;
		defence = 40;
		evasion = 40;
		maxMana = 40;
		maxHealth = 100;
	}
}
