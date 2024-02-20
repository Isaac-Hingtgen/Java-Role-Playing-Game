package test.java;

import main.java.ser316.rpg.Fight;
import main.java.ser316.rpg.Seasons;
import main.java.ser316.rpg.characters.affinities.Affinity;
import main.java.ser316.rpg.characters.affinities.AscendedAffinity;
import main.java.ser316.rpg.characters.enemies.Enemy;
import main.java.ser316.rpg.characters.enemies.Vampire;
import main.java.ser316.rpg.characters.heroes.Hero;
import main.java.ser316.rpg.characters.heroes.OpTestHero;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class FightTest {

    @Test
    public void init() {
        Seasons curSeason = Seasons.getCurSeason(6);
        Hero hero = new OpTestHero();
        hero.setAffinity(Affinity.ASSASSIN);
        hero.setAscendedAffinity(AscendedAffinity.PHANTOM);
        Enemy enemy = new Vampire();

        Fight fight = new Fight(hero, enemy, curSeason);

        fight.init(new Scanner("4\n 0\n 1\n \n 2\n 3\n \n 3\n \n 1\n \n 1\n\n 1\n\n 1\n\n 2\n 800\n\n 0\n"));

        assertTrue(enemy.isDead());
    }
}