package main.java.ser316.rpg.characters.affinities;

public class Assassin extends Affinity {

    private static String NAME = "FLASH STEP";
    public static String DESCRIPTION = "\tSkill: " + NAME + " electrocutes the opponent with an attack that has a high probability of doing a critical strike and low probability of missing. \n\tThe opponent becomes shocked and is more likely to miss there next attack.";

    public Assassin() {
        SKILL = NAME;
        evasionBonus = 90;
    }
}
