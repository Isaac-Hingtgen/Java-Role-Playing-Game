package main.java.ser316.rpg.characters.affinities;

import main.java.ser316.rpg.characters.heroes.Hero;

public class Sage extends AscendedAffinity {
	public Sage(Affinity affinity) {
		super(affinity);
	}

	@Override
	public void addAffinityBonuses(Hero hero) {
		super.addAffinityBonuses(hero);
		hero.addDefenceBonus(60);
		hero.addHealth(8);
		SKILL = "RECOVERY SHIELD";
	}
}
