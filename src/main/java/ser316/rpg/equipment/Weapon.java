package main.java.ser316.rpg.equipment;

public abstract class Weapon extends Equipment {
    public static Weapon getWeapon(int level) {
        Weapon weapon;
        if (level < 8) {
            weapon = new big_stick();
        } else if (level < 15) {
            weapon = new broad_sword();
        } else if (level < 23) {
            weapon = new spiked_shield();
        } else if (level < 31) {
            weapon = new excalibur();
        } else {
            weapon = new dragon_slayer();
        }
        return weapon;
    }
}

class spiked_shield extends Weapon {
    public spiked_shield() {
        attackBonus = 20;
        defenceBonus = 80;
        weight = 8;
        cost = 120;
    }
}

class excalibur extends Weapon {
    public excalibur() {
        attackBonus = 70;
        defenceBonus = 20;
        weight = 5;
        cost = 200;
    }
}

class dragon_slayer extends Weapon {
    public dragon_slayer() {
        attackBonus = 150;
        defenceBonus = 20;
        evasionBonus = -10;
        weight = 40;
        cost = 400;

    }
}

class broad_sword extends Weapon {
    public broad_sword() {
        attackBonus = 50;
        defenceBonus = 10;
        weight = 3;
        cost = 60;
    }
}

class big_stick extends Weapon {
    public big_stick() {
        attackBonus = 20;
        cost = 25;
    }
}

