package main.java.ser316.rpg.equipment;

public class Boots extends Equipment {
    public static Boots getBoots(int level) {
        if (level < 7) {
            return new leather_dress_shoes();
        } else if (level < 18) {
            return new boots_of_swiftness();
        } else {
            return new stompity_stompers();
        }
    }
}

class boots_of_swiftness extends Boots {
    public boots_of_swiftness() {
        evasionBonus = 30;
        defenceBonus = 15;
        cost = 75;

    }
}

class leather_dress_shoes extends Boots {
    public leather_dress_shoes() {
        evasionBonus = 5;
        defenceBonus = 10;
        cost = 25;

    }
}

class stompity_stompers extends Boots {
    public stompity_stompers() {
        attackBonus = 60;
        defenceBonus = 30;
        weight = 2;
        cost = 120;
    }
}


