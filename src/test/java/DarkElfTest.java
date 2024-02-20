package test.java;
import org.junit.Test;

import main.java.ser316.rpg.characters.enemies.Enemy;
import main.java.ser316.rpg.characters.heroes.DarkElf;

import static org.junit.Assert.*;

public class DarkElfTest {

    @Test
    public void usePassive() {
        DarkElf darkElf = new DarkElf();
        darkElf.resetAttributes();
        darkElf.removeMana(darkElf.getMaxMana());
        darkElf.usePassive();
        assertEquals(10, darkElf.getCurMana());
    }
}


