package main.java.ser316.rpg.characters.affinities;

public class Assassin extends Affinity {

    private static final String NAME = "FLASH STEP";
    public static final String DESCRIPTION = "\tSkill: " + NAME + " electrocutes the opponent with an attack that has a "
        + "high probability of doing a critical strike and low probability of missing. "
        + "\n\tThe opponent becomes shocked and is more likely to miss there next attack.";

    public Assassin() {
        skill = NAME;
        evasionBonus = 90;
    }
}
