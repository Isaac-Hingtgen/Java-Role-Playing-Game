package test.java;

import main.java.ser316.rpg.characters.Character;
import main.java.ser316.rpg.characters.heroes.Elf;
import main.java.ser316.rpg.characters.heroes.Hero;
import main.java.ser316.rpg.equipment.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElfTest {

	@Test
	public void usePassive() {
		Elf elf = new Elf();
		elf.usePassive();

		assertEquals(45, elf.getEvasionBonus());

		elf.resetBonuses();
		elf.equip(Chest.getChestArmour(50));
		elf.equip(Boots.getBoots(50));
		elf.equip(Helmets.getHelmets(50));
		elf.equip(Weapon.getWeapon(30));
		elf.equip(Jewelry.getJewelry(50));
		elf.usePassive();

		assertEquals(45 - 27, elf.getEvasionBonus());
	}
}