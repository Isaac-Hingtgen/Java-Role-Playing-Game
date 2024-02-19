package main.java.ser316.rpg.characters.heroes;

import main.java.ser316.rpg.characters.Character;

public class DarkElf extends Hero {
    private static int bonusMana = 10;
    public static final String PASSIVE = "Blessing of darkness: generate " + bonusMana + " mana at the end of each floor";

    public DarkElf() {
        super();
        resetAttributes();
        this.birth();
    }

    @Override
    public void resetAttributes() {
        attack = 30;
        defence = 20;
        evasion = 10;
        maxMana = 60;
        maxHealth = 180;
    }

    public void usePassive() {
        System.out.printf("Blessing of darkness grants %d mana.\n", bonusMana);
        addMana(bonusMana);
    }
}
