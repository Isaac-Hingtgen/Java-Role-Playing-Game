package test.java;

import main.java.ser316.rpg.characters.affinities.Affinity;
import main.java.ser316.rpg.characters.enemies.Demon;
import main.java.ser316.rpg.characters.enemies.Dragon;
import main.java.ser316.rpg.characters.enemies.Enemy;
import main.java.ser316.rpg.characters.heroes.OpTestHero;
import main.java.ser316.rpg.consumables.Consumables;
import main.java.ser316.rpg.equipment.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class HeroTest {

    OpTestHero hero;

    @Before
    public void setUp() {
        hero = new OpTestHero();
        hero.setOpponent(new Dragon());
        hero.setAffinity(Affinity.ASSASSIN);
    }

    @Test
    public void specialAttack() {
        hero.specialAttack();
        assertEquals(false, hero.canUseSpecial());
    }


    @Test
    public void beginFight() {
        hero.specialAttack();
        hero.setOpponent(null);
        try {
            hero.beginFight();
            fail("did not throw exception");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        hero.setOpponent(new Demon());
        try {
            hero.beginFight();
            System.out.println("opponent set, fight begins");
        } catch (Exception e) {
            fail("should not throw exception");
        }
        assertEquals(true, hero.canUseSpecial());
    }

    @Test
    public void resolveBonuses() {
        int attackBonus = hero.getAttackBonus();
        int defenceBonus = hero.getDefenceBonus();
        int evasionBonus = hero.getEvasionBonus();
        hero.equip(Chest.getChestArmour(50));
        hero.equip(Boots.getBoots(50));
        hero.equip(Helmets.getHelmets(50));
        hero.equip(Weapon.getWeapon(50));
        hero.equip(Jewelry.getJewelry(50));
        hero.resolveBonuses(null);
        assertNotEquals(attackBonus, hero.getAttackBonus());
        assertNotEquals(defenceBonus, hero.getDefenceBonus());
        assertNotEquals(evasionBonus, hero.getEvasionBonus());
        hero.displayStats(null);
    }

    @Test
    public void resetBonuses() {
        int attackBonus = hero.getAttackBonus();
        int defenceBonus = hero.getDefenceBonus();
        int evasionBonus = hero.getEvasionBonus();
        hero.equip(Chest.getChestArmour(50));
        hero.equip(Boots.getBoots(50));
        hero.equip(Helmets.getHelmets(50));
        hero.equip(Weapon.getWeapon(50));
        hero.equip(Jewelry.getJewelry(50));
        hero.resolveBonuses(null);
        hero.resetBonuses();
        assertEquals(attackBonus, hero.getAttackBonus());
        assertEquals(defenceBonus, hero.getDefenceBonus());
        assertEquals(evasionBonus, hero.getEvasionBonus());
    }

    @Test
    public void winsFight() {
        hero.winsFight();
        Enemy e = new Dragon();
        e.setLevel(30);
        hero.setOpponent(e);
        hero.winsFight();
        assertNotEquals(0, hero.getGold());
        assertNotEquals(0, hero.getExperience());
        assertNull(hero.getOpponent());
    }

    @Test
    public void hasInventorySpace() {
        hero.equip(Consumables.getRandomConsumable());
        hero.equip(Consumables.getRandomConsumable());
        assertTrue(hero.hasInventorySpace());
        hero.equip(Consumables.getRandomConsumable());
        assertFalse(hero.hasInventorySpace());
        hero.equip(Consumables.getRandomConsumable());
        hero.displayEquipment();
    }

    @Test
    public void usePotion() {
        hero.equip(Consumables.getRandomConsumable());
        hero.equip(Consumables.getRandomConsumable());
        hero.equip(Consumables.getRandomConsumable());

        hero.usePotion(new Scanner("1\n"));
        hero.usePotion(new Scanner("1\n"));
        hero.usePotion(new Scanner("1\n"));

        hero.equip(Consumables.getRandomConsumable());
        assertTrue(hero.hasInventorySpace());
    }

    @Test
    public void birth() {
        assertEquals(hero.getCurHealth(), hero.getMaxHealth());
        assertEquals(hero.getCurMana(), hero.getMaxMana());
    }

    @Test
    public void attack() {
        int h = hero.getOpponent().getCurHealth();
        hero.addEvasionBonus(1000);
        hero.attack();
        assertTrue(h > hero.getOpponent().getCurHealth());
    }

    @Test
    public void isDead() {
        assertFalse(hero.isDead());
        hero.removeHealth(hero.getCurHealth());
        assertTrue(hero.isDead());
    }

    @Test
    public void magicAttack() {
        hero.magicAttack(1001);
        assertEquals(hero.getMaxHealth() - 10, hero.getCurHealth());
        assertEquals(hero.getMaxMana(), hero.getCurMana());

        hero.magicAttack(30);
        assertEquals(hero.getMaxMana() - 30, hero.getCurMana());
    }



    @Test
    public void removeHealth() {
        hero.removeHealth(43242431);
        assertEquals(0, hero.getCurHealth());
    }

    @Test
    public void addHealth() {
        hero.addHealth(43242431);
        assertEquals(hero.getMaxHealth(), hero.getCurHealth());
    }

    @Test
    public void removeMana() {
        hero.removeMana(43242431);
        assertEquals(0, hero.getCurMana());
    }

    @Test
    public void addMana() {
        hero.addMana(43242431);
        assertEquals(hero.getMaxMana(), hero.getCurMana());
    }
}