package main.java.ser316.rpg.characters;

public abstract class Character {

	private Character _opponent = null;
	protected int maxHealth;
	protected int curHealth;
	protected int maxMana;
	protected int curMana;
	protected int attack;
	protected int defence;
	protected int evasion;
	protected boolean specialAttackWasUsed;
	public void birth() {
		curHealth = maxHealth;
		curMana = maxMana;
	}

	public void beginFight() throws Exception {
		if(_opponent == null) throw new Exception("Who are you fighting?");
		specialAttackWasUsed = false;
		_opponent.beginFight();
	}

	public void setOpponent(Character opponent) {
		_opponent = opponent;
		if(opponent.getOpponent() == null) opponent.setOpponent(this);
	}

	public Character getOpponent() {
		return _opponent;
	}

	public void attack() {
		// todo: make attack algo
	}
	public abstract void specialAttack();
	public boolean magicAttack() {
		return maxMana != 0;
	}

}

