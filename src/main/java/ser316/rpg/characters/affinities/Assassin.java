package main.java.ser316.rpg.characters.affinities;

public class Assassin extends Affinity {

	public Assassin() {
		SKILL = "FLASH STEP";
		evasionBonus = 70;
	}

	public void displayDescription() {
		System.out.println("Skill: " + SKILL + " electrocutes the opponent with an attack that has a high probability of doing a critical strike and low probability of missing. \nThe opponent becomes shocked and is more likely to miss there next attack.");
	}

}
