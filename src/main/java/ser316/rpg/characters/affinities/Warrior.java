package main.java.ser316.rpg.characters.affinities;

public class Warrior extends Affinity {
    private static String NAME = "RIGHTEOUS PUNISHMENT";
    public static String DESCRIPTION = "\tSkill: " + NAME + " summons an ethereal being, taking the form of a hammer to perform the initial attack, \n\tthen transforms to armour to defend against the opponent's next strike.";


    public Warrior() {
        SKILL = NAME;
        attackBonus = 50;
        defenceBonus = 50;
    }
}
