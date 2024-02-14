package main.java.ser316.rpg.characters.enemies;

public class Giant extends Enemy {
	public Giant() {
		resetAttributes();
		this.birth();
	}

	@Override
	public void resetAttributes() {
		attack = 40;
		defence = 20;
		evasion = 0;
		maxMana = 0;
		maxHealth = 100;
	}
}
