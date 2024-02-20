package test.java;

import main.java.ser316.rpg.Seasons;

import main.java.ser316.rpg.characters.heroes.Hero;
import main.java.ser316.rpg.characters.heroes.OpTestHero;
import org.junit.Test;

import static org.junit.Assert.*;

public class SeasonsTest {
    @Test
    public void getCurSeason() {
        Seasons summer = Seasons.getCurSeason(0);
        assertNotSame(Seasons.getCurSeason(5), summer);

        Seasons autumn = Seasons.getCurSeason(5);
        assertNotSame(Seasons.getCurSeason(9), autumn);

        Seasons winter = Seasons.getCurSeason(9);
        assertNotSame(Seasons.getCurSeason(14), winter);
    }

    @Test
    public void addStatModifiers() {
        Hero h = new OpTestHero();
        int p = h.getEvasionBonus();

        Seasons s = Seasons.getCurSeason(0);
        s.addStatModifiers(h);
        assertTrue(h.getEvasionBonus() > p);
        h.resetBonuses();
        s = Seasons.getCurSeason(5);
        s.addStatModifiers(h);
        assertTrue(h.getEvasionBonus() < p);
        h.resetBonuses();
        s = Seasons.getCurSeason(9);
        s.addStatModifiers(h);
        assertTrue(h.getEvasionBonus() <= p);
        s = Seasons.getCurSeason(14);
        h.resetBonuses();
        s.addStatModifiers(h);
        assertTrue(h.getEvasionBonus() < p);
    }
}