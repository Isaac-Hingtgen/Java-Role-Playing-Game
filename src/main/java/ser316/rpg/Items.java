package main.java.ser316.rpg;

import main.java.ser316.rpg.characters.heroes.Hero;
import main.java.ser316.rpg.consumables.Consumables;
import main.java.ser316.rpg.equipment.*;

// items, consumables, and equipment use State design pattern

public abstract class Items {
    protected int cost;
    protected String description = "";

    protected int healthBonus;
    protected int manaBonus;
    protected int attackBonus;
    protected int evasionBonus;
    protected int defenceBonus;

    protected boolean sold = false;



    public static Items getRandomItem(int level) {
        if(Math.random() > 0.3) {
            return Consumables.getRandomConsumable();
        } else {
            return Equipment.getRandomEquipment(level);
        }
    }

    public abstract String getDescription();
    public String toString() {
        return getName() + getDescription();
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public int getCost() {
        return cost;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public void addBonus(Hero hero) {
        hero.addDefenceBonus(this.defenceBonus);
        hero.addAttackBonus(this.attackBonus);
        hero.addEvasionBonus(this.evasionBonus);
        hero.addHealth(this.healthBonus);
        hero.addMana(this.manaBonus);
    }

}
