package main.java.ser316.rpg.characters.enemies;

public class Dragon extends Enemy {
	public Dragon() {
		resetAttributes();
		this.birth();
	}

	@Override
	public void resetAttributes() {
		attack = 60;
		defence = 60;
		evasion = 20;
		maxMana = 20;
		maxHealth = 120;
	}
}
