package main.java.ser316.rpg.characters.heroes;


/**
 * passive: recover 10 health every floor.
 */
public class Ogre extends Hero {
    private static int healthRecovered = 10;
    public static final String PASSIVE = "Rest: recover " + healthRecovered + " health at the end of each floor";

    public Ogre() {
        super();
        resetAttributes();
        this.birth();
    }

    @Override
    public void resetAttributes() {
        evasion = 20;
        attack = 40;
        defence = 30;
        maxMana = 0;
        maxHealth = 200;
    }

    @Override
    public void usePassive() {
        System.out.printf(this + " rests to regain %d health.\n", healthRecovered);
        addHealth(healthRecovered);
    }
}
