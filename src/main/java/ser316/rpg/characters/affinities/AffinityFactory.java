package main.java.ser316.rpg.characters.affinities;

public class AffinityFactory {
	public static Affinity getAffinity(int type) {
		switch (type) {
			case Affinity.ASSASSIN:
				return new Assassin();
			case Affinity.WARLOCK:
				return new Warlock();
			case Affinity.WARRIOR:
				return new Warrior();
			default:
				return null;
		}
	}
}
