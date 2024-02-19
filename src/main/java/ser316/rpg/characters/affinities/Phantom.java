package main.java.ser316.rpg.characters.affinities;

import main.java.ser316.rpg.characters.heroes.Hero;

public class Phantom extends AscendedAffinity {
	public Phantom(Affinity affinity) {
		super(affinity);
	}

	@Override
	public void addAffinityBonuses(Hero hero) {
		super.addAffinityBonuses(hero);
		hero.addEvasionBonus(30);
		hero.addAttackBonus(50);
		SKILL = "SHADOW STRIKE";
	}
}
