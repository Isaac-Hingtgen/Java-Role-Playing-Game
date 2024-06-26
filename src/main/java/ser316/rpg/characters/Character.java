package main.java.ser316.rpg.characters;

public abstract class Character {

    protected Character opponent = null;
    protected int maxHealth;
    protected int curHealth;
    protected int maxMana;
    protected int curMana;
    protected int attack;
    protected int defence;
    protected int evasion;

    protected int attackBonus = 0;
    protected int defenceBonus = 0;
    protected int evasionBonus = 0;

    protected boolean specialAttackUsed;


    public void birth() {
        curHealth = maxHealth;
        curMana = maxMana;
    }


    public void setOpponent(Character opponent) {
        this.opponent = opponent;
        if (opponent != null && opponent.getOpponent() == null) {
            opponent.setOpponent(this);
        }
    }

    public Character getOpponent() {
        return opponent;
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
        int opEvasion = opponent.evasion + opponent.evasionBonus;
        int opDefence = opponent.defence + opponent.defenceBonus;
        int myEvasion = evasion + evasionBonus;
        int myAttack = attack + attackBonus;

        String response = "";
        double rand = Math.random();
        double missProbability = 2.0 * rand * (75 + (opEvasion - myEvasion)) / 100.0;
        double criticalProbability = 2.0 * rand * (75 + (myEvasion - opEvasion)) / 100.0;
        double damageMultiplier = 1;

        if (missProbability > 1) {
            return this + "'s attack missed!\n";
        } else if (criticalProbability > 1) {
            response += this + " hit a critical strike!\n";
            damageMultiplier = 2;
        }

        damageMultiplier += (myAttack / 100.0 - opDefence / 100.0);
        if (damageMultiplier < 0) {
            damageMultiplier = 0;
        }

        damage = (int) Math.ceil(damage * damageMultiplier * (Math.random() / 2.0 + 0.75));

        opponent.removeHealth(damage);

        response += this + " hit the " + opponent + " for " + damage + " damage!\n";

        if (opponent.isDead()) {
            response += opponent.toString() + " has been slayed!\n";
        }

        return response;
    }

    public abstract void resetAttributes();

    public int getCurMana() {
        return curMana;
    }

    public void magicAttack(int manaUsed) {
        if (manaUsed <= 0) {
            System.out.println(this + " attempts to some a great bolt of lightening to smite their enemy!!! ...but nothing happens.");
        }

        if (manaUsed > curMana) {
            removeHealth(10);
            System.out.println("You attempted to use more mana than you had available, "
                + "in the process you injured yourself, resulting in the lose of 10 health.");
        } else {
            removeMana(manaUsed);
            System.out.println(this + " sent a molten fireball towards the opponent!\n" + attackHelper(manaUsed));
        }
    }

    public void displayStatus() {
        System.out.println("\tCurrent health: " + curHealth + "/" + maxHealth);
        System.out.println("\tCurrent mana: " + curMana + "/" + maxMana);
    }

    public void removeHealth(int health) {
        curHealth -= health;
        if (curHealth < 0) {
            curHealth = 0;
        }
    }

    public void addHealth(int health) {
        curHealth += health;
        if (curHealth > maxHealth) {
            curHealth = maxHealth;
        }
    }

    public void removeMana(int mana) {
        curMana -= mana;
        if (curMana < 0) {
            curMana = 0;
        }
    }

    public void addMana(int mana) {
        curMana += mana;
        if (curMana > maxMana) {
            curMana = maxMana;
        }
    }

    public void addDefenceBonus(int defenceBonus) {
        this.defenceBonus += defenceBonus;
    }

    public void addAttackBonus(int attackBonus) {
        this.attackBonus += attackBonus;
    }

    public void addEvasionBonus(int evasionBonus) {
        this.evasionBonus += evasionBonus;
    }

    public int getCurHealth() {
        return curHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public int getDefenceBonus() {
        return defenceBonus;
    }

    public int getEvasionBonus() {
        return evasionBonus;
    }
}

