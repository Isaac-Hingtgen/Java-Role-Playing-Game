package main.java.ser316.rpg.characters.heroes;

import main.java.ser316.rpg.characters.Character;
import main.java.ser316.rpg.characters.affinities.Affinity;

public abstract class Hero extends Character {

	public static final int OGRE = 0;
	public static final int ELF = 1;
	public static final int DARK_ELF = 2;
	protected int passiveSkill;
	protected Affinity _affinity;

	public void setAffinity(Affinity affinity) {
		this._affinity = affinity;
	}
}
