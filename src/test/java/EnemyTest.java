package test.java;

import main.java.ser316.rpg.characters.enemies.Enemy;
import main.java.ser316.rpg.characters.heroes.DarkElf;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class EnemyTest {
    Enemy enemy;

    @Before
    public void setUp() {
        enemy = new EnemyTester();
    }
    @Test
    public void setLevel() {
        enemy.setLevel(50);
        Enemy weakerEnemy = new EnemyTester();
        weakerEnemy.setLevel(2);
        assertTrue(enemy.getMaxHealth() > weakerEnemy.getMaxHealth());
    }
}

class EnemyTester extends Enemy {
    public EnemyTester() {
        resetAttributes();
        this.birth();
    }

    @Override
    public void resetAttributes() {
        attack = 30;
        defence = 30;
        evasion = 30;
        maxMana = 30;
        maxHealth = 30;
    }
}
