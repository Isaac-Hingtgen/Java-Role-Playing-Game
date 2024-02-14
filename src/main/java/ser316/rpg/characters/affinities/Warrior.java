package main.java.ser316.rpg.characters.affinities;

public class Warrior extends Affinity {

	public Warrior() {
		SKILL = "RIGHTEOUS PUNISHMENT";
		attackBonus = 50;
		defenceBonus = 50;
	}


	public void displayDescription() {
		System.out.println("Skill: " + SKILL + " summons an ethereal being, taking the form of a hammer to perform the initial attack, then transforms to armour to defend against the opponent's next strike.");
	}
}
