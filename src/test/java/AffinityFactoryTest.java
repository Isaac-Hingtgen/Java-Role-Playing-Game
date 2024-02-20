package test.java;

import main.java.ser316.rpg.characters.affinities.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class AffinityFactoryTest {

    @Test
    public void getAffinity() {
        Affinity a = AffinityFactory.getAffinity(Affinity.ASSASSIN);
        assertTrue(a instanceof Assassin);
        Affinity b = AffinityFactory.getAffinity(Affinity.WARLOCK);
        assertTrue(b instanceof Warlock);
        Affinity c = AffinityFactory.getAffinity(Affinity.WARRIOR);
        assertTrue(c instanceof Warrior);
        Affinity d = AffinityFactory.getAffinity(AscendedAffinity.PHANTOM, a);
        assertTrue(d instanceof Phantom);
        d = AffinityFactory.getAffinity(AscendedAffinity.SAGE, b);
        assertTrue(d instanceof Sage);
        d = AffinityFactory.getAffinity(AscendedAffinity.BERSERKER, c);
        assertTrue(d instanceof Berserker);
    }
}