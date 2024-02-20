package test.java;

import main.java.ser316.rpg.characters.heroes.Hero;
import main.java.ser316.rpg.characters.heroes.OpTestHero;
import main.java.ser316.rpg.equipment.Equipment;
import main.java.ser316.rpg.equipment.Jewelry;
import org.junit.Test;

import static org.junit.Assert.*;

public class EquipmentTest {

    @Test
    public void addBonus() {
        Equipment equipment = Equipment.getRandomEquipment(50);
        Hero c = new OpTestHero();
        equipment.addBonus(c);
        if (!(equipment instanceof Jewelry)) {
            int total = c.getAttackBonus() + c.getDefenceBonus() + c.getEvasionBonus();
            assertNotEquals(0, total);
        }

    }

    @Test
    public void getRandomEquipment() {
        Equipment equipment = null;
        for(int i = 0; i < 50; i++) {
            equipment = Equipment.getRandomEquipment((int) (Math.random() * 50));
            assertNotNull(equipment);
            equipment = null;
        }
    }
}