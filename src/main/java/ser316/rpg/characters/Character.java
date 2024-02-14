package main.java.ser316.rpg.characters;

import main.java.ser316.rpg.characters.affinities.Affinity;
import main.java.ser316.rpg.characters.affinities.AffinityFactory;
import main.java.ser316.rpg.characters.affinities.Warlock;

public abstract class Character {

	protected Character _opponent = null;
	protected int maxHealth;
	protected int curHealth;
	protected int maxMana;
	protected int curMana;
	protected int attack;
	protected int defence;
	protected int evasion;
	protected boolean specialAttackUsed;
	protected boolean specialAttackUsedLastTurn;

	public void birth() {
		curHealth = maxHealth;
		curMana = maxMana;
	}


	public void setOpponent(Character opponent) {
		_opponent = opponent;
		if(opponent.getOpponent() == null) opponent.setOpponent(this);
	}

	public Character getOpponent() {
		return _opponent;
	}

	public void attack() {
		System.out.println(attackHelper(10));
	}


	public boolean isDead() {
		return curHealth <= 0;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

	protected String attackHelper(int damage) {
		if(specialAttackUsedLastTurn) {
			resetAttributes();
			specialAttackUsedLastTurn = false;
		}

		String response = "";
		double rand = Math.random();
		double missProbability = 2.0 * rand * (75 + (_opponent.evasion - this.evasion)) / 100.0;
		double criticalProbability = 2.0 * rand * (75 + (this.evasion - _opponent.evasion)) / 100.0;
		double damageMultiplier = 1;

		if(missProbability > 1) {
			return this + "'s attack missed!\n";
		} else if(criticalProbability > 1) {
			response += this + " hit a critical strike!\n";
			damageMultiplier = 2;
		}

		damageMultiplier += (attack / 100.0 - _opponent.defence / 100.0);
		if(damageMultiplier < 0) damageMultiplier = 0;

		damage = (int) Math.ceil(damage * damageMultiplier);

		_opponent.removeHealth(damage);

		response += this + " hit the " + _opponent + " for " + damage + " damage!\n";

		if(_opponent.isDead()) {
			response += _opponent.toString() + " has been slayed!\n";
		}

		return response;
	}

	public abstract void resetAttributes();


	public int getCurMana() {
		return curMana;
	}

	public void magicAttack(int manaUsed) {
		if(manaUsed <= 0)
			System.out.println(this + " attempts to some a great bolt of lightening to smite their enemy!!! ...but nothing happens.");

		if(manaUsed > curMana) {
			removeHealth(10);
			System.out.println("You attempted to use more mana than you had available, in the process you injured yourself, resulting in the lose of 10 health.");
		} else {
			removeMana(manaUsed);
			System.out.println(this + " sent a molten fireball towards the opponent!\n" + attackHelper(manaUsed));
		}
	}

	public void displayStats() {
		System.out.println("Max health: " + maxHealth);
		System.out.println("Max mana: " + maxMana);
		System.out.println("Evasion: " + evasion);
		System.out.println("Attack: " + attack);
		System.out.println("Defence: " + defence);
	}

	public void displayStatus() {
		System.out.println("\tCurrent health: " + curHealth + "/" + maxHealth);
		System.out.println("\tCurrent mana: " + curMana + "/" + maxMana);
	}

	public void removeHealth(int health) {
		curHealth -= health;
		if(curHealth < 0) curHealth = 0;
	}
	public void addHealth(int health) {
		curHealth += health;
		if(curHealth > maxHealth) curHealth = maxHealth;
	}

	public void removeMana(int mana) {
		curMana -= mana;
		if(curMana < 0) curMana = 0;
	}

	public void addMana(int mana) {
		curMana += mana;
		if(curMana > maxMana) curMana = maxMana;
	}


}

