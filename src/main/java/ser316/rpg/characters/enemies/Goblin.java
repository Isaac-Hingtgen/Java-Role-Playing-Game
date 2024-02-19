package main.java.ser316.rpg.characters.enemies;

public class Goblin extends Enemy {
    public Goblin() {
        resetAttributes();
        this.birth();
    }

    @Override
    public void resetAttributes() {
        attack = 15;
        defence = 30;
        evasion = 10;
        maxMana = 0;
        maxHealth = 50;
    }
}
