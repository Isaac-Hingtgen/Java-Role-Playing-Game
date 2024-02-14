package main.java.ser316.rpg.characters.enemies;

public class Lizardman extends Enemy {
	public Lizardman() {
		resetAttributes();
		this.birth();
	}

	@Override
	public void resetAttributes() {
		attack = 30;
		defence = 30;
		evasion = 30;
		maxMana = 20;
		maxHealth = 70;
	}
}
