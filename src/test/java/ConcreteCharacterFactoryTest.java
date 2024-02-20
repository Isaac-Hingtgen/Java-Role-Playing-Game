package test.java;

import main.java.ser316.rpg.characters.CharacterFactory;
import main.java.ser316.rpg.characters.ConcreteCharacterFactory;
import main.java.ser316.rpg.characters.enemies.Enemy;
import main.java.ser316.rpg.characters.heroes.Hero;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConcreteCharacterFactoryTest {

    CharacterFactory factory = new ConcreteCharacterFactory();

    @Test
    public void createHero() {
        for (int i = 0; i < 4; i++) {
            assertTrue(factory.createHero(i) instanceof Hero);
        }
    }

    @Test
    public void getRandomEnemy() {
        for (int i = 0; i < 20; i++) {
            assertTrue(factory.getRandomEnemy(i) instanceof Enemy);
        }

        assertEquals(Enemy.MEDIUM, factory.getRandomEnemy(5).type);
        assertEquals(Enemy.BOSS, factory.getRandomEnemy(10).type);
        assertEquals(Enemy.SMALL, factory.getRandomEnemy(1).type);
    }
}