package main.java.ser316.rpg.characters.heroes;

import main.java.ser316.rpg.equipment.Weapon;

public class OpTestHero extends Hero {
    public OpTestHero() {
        resetAttributes();
        this.birth();
        weapon = Weapon.getWeapon(50);
    }

    @Override
    public void resetAttributes() {
        attack = 200;
        defence = 20;
        evasion = 1000;
        maxMana = 1000;
        maxHealth = 1000;
        gold = 1000;
    }

    public void usePassive() {
        System.out.println("Blessing of darkness grants 20 mana.");
        addMana(20);
    }
}
