package main.java.ser316.rpg.characters.enemies;

import main.java.ser316.rpg.characters.Character;

public abstract class Enemy extends Character {
	public static final int BOSS = 2;
	public static final int MEDIUM = 1;
	public static final int SMALL = 0;

	public int level;
	public int type;

	@Override
	public void displayStatus() {
		if (curHealth < (0.3 * maxHealth)) System.out.println(this + " looks weakened.");
	}

	public void setLevel(int curFloor) {
		level = curFloor;
		maxHealth += (int) Math.round(level * Math.random());
		evasion += (int) Math.round(level * Math.random());
		defence += (int) Math.round(level * Math.random());
		attack += (int) Math.round(level * Math.random());
	}

	public void setType(int type) {
		this.type = type;
	}
}
