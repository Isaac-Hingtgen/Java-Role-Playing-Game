package main.java.ser316.rpg.equipment;

public class Helmets extends Equipment {

    public static Helmets getHelmets(int level) {
        if(level < 15) {
            return new helmet_of_illumination();
        } else {
            return new metal_pot();
        }
    }
}

class helmet_of_illumination extends Helmets {
    public helmet_of_illumination() {
        defenceBonus = 20;
        evasionBonus = 15;
        weight = 3;
        cost = 55;

    }
}

class metal_pot extends Helmets {
    public metal_pot() {
        defenceBonus = 80;
        weight = 5;
        cost = 90;
    }
}
