package main.java.ser316.rpg.characters.affinities;

import main.java.ser316.rpg.characters.heroes.Hero;

public abstract class Affinity {
    public String SKILL;
    public static final int ASSASSIN = 0;
    public static final int WARLOCK = 1;
    public static final int WARRIOR = 2;



    protected int manaBonus = 0;
    protected int healthBonus = 0;
    protected int attackBonus = 0;
    protected int evasionBonus = 0;
    protected int defenceBonus = 0;

    public int getManaBonus() {
        return manaBonus;
    }
    public int getHealthBonus() {
        return healthBonus;
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

    public void addAffinityBonuses(Hero hero) {
        hero.addDefenceBonus(this.defenceBonus);
        hero.addAttackBonus(this.attackBonus);
        hero.addEvasionBonus(this.evasionBonus);
        hero.addHealth(this.healthBonus);
        hero.addMana(this.manaBonus);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
