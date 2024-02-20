package main.java.ser316.rpg.characters.affinities;

public class Warrior extends Affinity {
    private static final String NAME = "RIGHTEOUS PUNISHMENT";
    public static final String DESCRIPTION = "\tSkill: " + NAME + " summons an ethereal being, "
        + "taking the form of a hammer to perform the initial attack, "
        + "\n\tthen transforms to armour to defend against the opponent's next strike.";


    public Warrior() {
        skill = NAME;
        attackBonus = 50;
        defenceBonus = 50;
    }
}
