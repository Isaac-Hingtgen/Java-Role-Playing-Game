package main.java.ser316.rpg.characters.heroes;

public class OPTestHero extends Hero {
	public OPTestHero() {
		resetAttributes();
		this.birth();
	}

	@Override
	public void resetAttributes() {
		attack = 200;
		defence = 20;
		evasion = 10;
		maxMana = 1000;
		maxHealth = 1000;
	}

	public void usePassive() {
		System.out.println("Blessing of darkness grants 20 mana.");
		addMana(20);
	}
}
