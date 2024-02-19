package main.java.ser316.rpg.characters.affinities;

import javax.print.attribute.standard.MediaSize;

public class Warlock extends Affinity {

    private static String NAME = "VAMPIRIC MANIFEST";
    public static String DESCRIPTION = "\tSkill: " + NAME + " provides a temporary boost in mana and max mana reserved to perform a powerful attack that also leeches some life. \n\tDependent on the current mana available. Uses up all mana reserves.";

    public Warlock() {
        this.SKILL = NAME;
        manaBonus = 10;
        healthBonus = 5;
    }
}
