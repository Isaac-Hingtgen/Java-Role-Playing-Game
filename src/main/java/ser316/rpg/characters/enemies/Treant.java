package main.java.ser316.rpg.characters.enemies;

public class Treant extends Enemy {
	public Treant() {
		resetAttributes();
		this.birth();
	}

	@Override
	public void resetAttributes() {
		attack = 12;
		defence = 10;
		evasion = 10;
		maxMana = 20;
		maxHealth = 80;
	}
}
