package main.java.ser316.rpg.consumables;

import main.java.ser316.rpg.Items;

public abstract class Consumables extends Items {
    private static final int NUMBER_OF_ITEMS = 4;

    public static Consumables getRandomConsumable() {
        int num = (int) (Math.random() * (NUMBER_OF_ITEMS + DurationBasedConsumable.NUMBER_OF_ITEMS));
        if (num > 3 && num < 7) {
            return DurationBasedConsumable.getConsumable(num);
        }
        switch (num) {
            case 0:
                return new small_potion();
            case 1:
                return new medium_potion();
            case 2:
                return new large_potion();
            case 3:
                return new mana_potion();
            default:
                return null;
        }
    }

    @Override
    public String getDescription() {
        return description;
    }

    public String getBonusesDescription() {
        return ((evasionBonus == 0) ? "" : String.format(" (Evasion: %+d) ", evasionBonus))
            + ((attackBonus == 0) ? "" : String.format(" (Attack: %+d) ", attackBonus))
            + ((defenceBonus == 0) ? "" : String.format(" (Defence: %+d) ", defenceBonus))
            + ((healthBonus == 0) ? "" : String.format(" (Heath gain per floor: %+d) ", healthBonus))
            + ((manaBonus == 0) ? "" : String.format(" (Mana gain per floor: %+d) ", manaBonus));
    }
}

class large_potion extends Consumables {
    public large_potion() {
        int bonusAmount = 60;
        description = String.format("Heals for %d health.", bonusAmount);
        healthBonus = bonusAmount;
        cost = 100;
    }
}

class mana_potion extends Consumables {
    public mana_potion() {
        int bonusAmount = 30;
        description = String.format("Grants %d mana.", bonusAmount);
        manaBonus = bonusAmount;
        cost = 50;
    }
}

class medium_potion extends Consumables {
    public medium_potion() {
        int bonusAmount = 35;
        description = String.format("Heals for %d health.", bonusAmount);
        healthBonus = bonusAmount;
        cost = 60;
    }
}

class small_potion extends Consumables {
    public small_potion() {
        int bonusAmount = 15;
        description = String.format("Heals for %d health.", bonusAmount);
        healthBonus = bonusAmount;
        cost = 30;
    }
}


