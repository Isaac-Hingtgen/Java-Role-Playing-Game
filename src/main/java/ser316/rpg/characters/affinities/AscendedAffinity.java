package main.java.ser316.rpg.characters.affinities;

import main.java.ser316.rpg.characters.heroes.Hero;

// AscendedAffinity if DecoratorBase and Affinity is ComponentBase, each class that inherits from
// AscendedAffinity is a ConcreteDecorator
public abstract class AscendedAffinity extends Affinity {
    public static final int PHANTOM = 0;
    public static final int SAGE = 1;
    public static final int BERSERKER = 2;
    protected Affinity affinity;

    public AscendedAffinity(Affinity affinity) {
        this.affinity = affinity;
    }

    @Override
    public void addAffinityBonuses(Hero hero) {
        affinity.addAffinityBonuses(hero);
    }

}
