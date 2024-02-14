package main.java.ser316.rpg.characters.affinities;

public class Warlock extends Affinity {

	public Warlock() {
		SKILL = "VAMPIRIC MANIFEST";
		manaBonus = 20;
		healthBonus = 20;
	}

	public void displayDescription() {
		System.out.println("Skill: " + SKILL + " provides a temporary boost in mana and max mana reserved to perform a powerful attack that also leeches some life. \nDependent on the current mana available. \nUses up all mana reserves.");
	}
}
