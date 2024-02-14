package main.java.ser316.rpg.characters.enemies;

import main.java.ser316.rpg.characters.Character;

public abstract class Enemy extends Character {
	public static final int BOSS = 0;
	public static final int MEDIUM = 1;
	public static final int SMALL = 2;

	@Override
	public void displayStatus() {
		if (curHealth < (0.3 * maxHealth)) System.out.println(this + " looks weakened.");
	}
}
