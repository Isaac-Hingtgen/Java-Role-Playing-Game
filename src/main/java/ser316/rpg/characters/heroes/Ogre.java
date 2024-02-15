package main.java.ser316.rpg.characters.heroes;


import main.java.ser316.rpg.characters.Character;

public class Ogre extends Hero {
	public Ogre() {
		super();
		resetAttributes();
		this.birth();
	}

	@Override
	public void resetAttributes() {
		evasion = 20;
		attack = 30;
		defence = 30;
		maxMana = 0;
		maxHealth = 200;
	}

	@Override
	public void usePassive() {
		System.out.println(this + " rests to regain 10 health.");
		addHealth(10);
	}
}
