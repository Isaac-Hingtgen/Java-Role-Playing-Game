package main.java.ser316.rpg;

import main.java.ser316.rpg.characters.Character;

public class Seasons {
    public static final int NUM_SEASONS = 4;
    private boolean day = true;
    private int seasonCounter = 0;
    protected String description;
    private String nightDescription = "Nighttime reduces the hero's striking, dodging, and defending ability. (-3 attack, -3 evasion, -3 defence)";
    protected int defenceBonus;
    protected int attackDebuff;
    protected int evasionDebuff;
    protected int healthDebuff;
    protected int manaDebuff;
    protected int evasionBonus;
    protected int attackBonus;
    public Seasons() {
    }

    public String toString() {
        return ((day) ? "daytime" : "nighttime") + " in " + this.getClass().getSimpleName();
    }

    public Seasons getCurSeason(int level) {
        Seasons curSeason = null;

        if(level % 4 == 0) {
            seasonCounter = (seasonCounter + 1) % NUM_SEASONS;
        }

        switch (seasonCounter) {
            case 1:
                curSeason = new Autumn();
                break;
            case 2:
                curSeason = new Winter();
                break;
            case 3:
                curSeason = new Spring();
                break;
            default:
                curSeason = new Summer();
                break;
        }

        if(Math.random() > 0.4) {
            curSeason.day = true;
        } else {
            curSeason.day = false;
        }
        return curSeason;
    }

    public void addStatModifiers(Character character) {
        character.addAttackBonus(-1 * attackDebuff);
        character.addEvasionBonus(-1 * evasionDebuff);
        character.addEvasionBonus(evasionBonus);
        character.addDefenceBonus(defenceBonus);
        character.addAttackBonus(attackBonus);
        character.removeHealth(healthDebuff);
        character.removeMana(manaDebuff);

        if(!day) {
            character.addEvasionBonus(-3);
            character.addDefenceBonus(-3);
            character.addAttackBonus(-3);
        }
    }

    public String getDescription() {
        return description + ((!day) ? "\n" + nightDescription : "");
    }


    class Autumn extends Seasons {
        public Autumn() {
            manaDebuff = 3;
            evasionDebuff = 5;
            defenceBonus = 5;
            description = "Autumn is the time of Thanksgiving and relaxation," +
                    "\nhowever too many pumpkin pies and pumpkin spiced lattes have made the hero sluggish and stupid. (-5 evasion, -3 mana per turn)" +
                    "\nFortunately, do to the extra weight gained, they now have greater defence capabilities. (+5 defence)";
        }
    }

    class Summer extends Seasons {
        public Summer() {
            evasionBonus = 5;
            attackBonus = 5;
            description = "The summer is the best time of the year for fighting," +
                    "\nthe hero's body feels light and flexible, granting them increased evasion and attack power. (+5 evasion, +5 attack)";
        }
    }

    class Winter extends Seasons {
        public Winter() {
            attackDebuff = 10;
            healthDebuff = 1;
            description = "The sub-freezing temperatures freezes the hero's hands, " +
                    "\nmaking swinging the sword difficult and painful. (-10 attack, -1 health per turn)";
        }
    }

    class Spring extends Seasons {
        public Spring() {
            evasionDebuff = 10;
            description = "The melting snow from the winter causes the hero to slip when attacking and dodging. (-10 evasion)";
        }
    }
}
