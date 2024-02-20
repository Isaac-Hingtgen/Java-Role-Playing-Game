package main.java.ser316.rpg.characters.affinities;

public class Warlock extends Affinity {

    private static final String NAME = "VAMPIRIC MANIFEST";
    public static final String DESCRIPTION = "\tSkill: " + NAME + " provides a temporary boost in mana and max mana "
        + "reserved to perform a powerful attack that also leeches some life. "
        + "\n\tDependent on the current mana available. Uses up all mana reserves.";

    public Warlock() {
        this.skill = NAME;
        manaBonus = 10;
        healthBonus = 5;
    }
}
