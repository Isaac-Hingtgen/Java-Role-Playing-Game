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

    public static Affinity getAffinity(int type, Affinity prevAffinity) {
        switch (type) {
            case AscendedAffinity.PHANTOM:
                return new Phantom(prevAffinity);
            case AscendedAffinity.BERSERKER:
                return new Berserker(prevAffinity);
            case AscendedAffinity.SAGE:
                return new Sage(prevAffinity);
            default:
                return null;
        }
    }
}
