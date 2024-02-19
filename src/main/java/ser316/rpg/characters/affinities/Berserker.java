package main.java.ser316.rpg.characters.affinities;

import main.java.ser316.rpg.characters.heroes.Hero;

public class Berserker extends AscendedAffinity {
	public Berserker(Affinity affinity) {
		super(affinity);
	}

	@Override
	public void addAffinityBonuses(Hero hero) {
		super.addAffinityBonuses(hero);
		hero.addDefenceBonus(-20);
		hero.removeHealth(3);
		hero.addAttackBonus(140);
		SKILL = "SEETHING RAGE";
	}
}
