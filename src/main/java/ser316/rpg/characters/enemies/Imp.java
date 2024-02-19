package main.java.ser316.rpg.characters.enemies;

public class Imp extends Enemy {
    public Imp() {
        resetAttributes();
        this.birth();
    }

    @Override
    public void resetAttributes() {
        attack = 10;
        defence = 20;
        evasion = 20;
        maxMana = 12;
        maxHealth = 70;
    }
}
