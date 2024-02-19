package main.java.ser316.rpg.characters.heroes;

import main.java.ser316.rpg.characters.Character;

public class Elf extends Hero {

    public static final String PASSIVE = "Lightfooted: greatly increased evasion when using lightweight or no armour";


    public Elf() {
        super();
        resetAttributes();
        this.birth();
    }

    @Override
    public void resetAttributes() {
        attack = 30;
        defence = 30;
        evasion = 30;
        maxMana = 50;
        maxHealth = 160;
    }

    @Override
    public void usePassive() {
        int totalArmourWeight = 0;
        if(chest != null) totalArmourWeight += chest.getWeight();
        if(boots != null) totalArmourWeight += boots.getWeight();
        if(weapon != null) totalArmourWeight += weapon.getWeight();
        if(helmet != null) totalArmourWeight += helmet.getWeight();
        int bonus = 45 - totalArmourWeight;
        if(bonus < 0) bonus = 0;
        evasionBonus += bonus;

        System.out.println(this + " has " + bonus + " increased evasion due to lightfooted passive (increased evasion with less armour).");
    }
}
