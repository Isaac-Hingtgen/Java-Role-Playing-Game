package test.java;

import main.java.ser316.rpg.characters.heroes.Ogre;
import org.junit.Test;

import static org.junit.Assert.*;

public class OgreTest {

	@Test
	public void usePassive() {
		Ogre ogre = new Ogre();
		ogre.resetAttributes();
		ogre.removeHealth(20);
		ogre.usePassive();
		assertEquals(ogre.getMaxHealth() - 10, ogre.getCurHealth());
	}
}