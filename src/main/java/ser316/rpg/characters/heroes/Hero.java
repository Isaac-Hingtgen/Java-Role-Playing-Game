package main.java.ser316.rpg.characters.heroes;

import main.java.ser316.rpg.characters.Character;
import main.java.ser316.rpg.characters.affinities.Affinity;
import main.java.ser316.rpg.characters.affinities.AffinityFactory;
import main.java.ser316.rpg.characters.affinities.Warlock;

public abstract class Hero extends Character {

	public static final int OGRE = 0;
	public static final int ELF = 1;
	public static final int DARK_ELF = 2;
	protected int passiveSkill;
	protected Affinity _affinity;

	public void setAffinity(Affinity affinity) {
		this._affinity = affinity;
	}

	public void specialAttack() {
		if(specialAttackUsed) {
			System.out.println("Special attack already used. Using physical attack instead.");
			attack();
			return;
		}

		setAffinityBonuses();

		System.out.println("Using " + _affinity.SKILL + "!");

		if(_affinity instanceof Warlock) {
			magicAttack(curMana);
			System.out.println(this + " absorbed " + _affinity.getHealthBonus() + " life with the attack.");
		} else {
			attack();
		}
		specialAttackUsed = true;
		specialAttackUsedLastTurn = true;
	}
	public void setAffinity(int affinity) {
		_affinity = AffinityFactory.getAffinity(affinity);
	}
	public void setAffinityBonuses() {
		this.attack += _affinity.getAttackBonus();
		this.defence += _affinity.getDefenceBonus();
		this.evasion += _affinity.getEvasionBonus();
		this.curHealth += _affinity.getHealthBonus();
		if(curHealth > maxHealth) curHealth = maxHealth;
		this.curMana += _affinity.getManaBonus();
	}
	public void beginFight() throws Exception {
		if(_opponent == null) throw new Exception("Who are you fighting?");
		specialAttackUsed = false;
		specialAttackUsedLastTurn = false;
	}

	public abstract void usePassive();
}
