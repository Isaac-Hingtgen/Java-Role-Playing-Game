package main.java.ser316.rpg.characters;

import main.java.ser316.rpg.characters.enemies.*;
import main.java.ser316.rpg.characters.heroes.*;

public class ConcreteCharacterFactory extends CharacterFactory {
    @Override
    public Hero createHero(int type) {
        switch (type) {
            case Hero.OGRE:
                return new Ogre();

            case Hero.DARK_ELF:
                return new DarkElf();

            case Hero.ELF:
                return new Elf();

            case 3:
                return new OpTestHero();

            default:
                return null;
        }
    }

    @Override
    public Enemy getRandomEnemy(int curFloor) {
        int enemyType = Enemy.SMALL;
        if (curFloor % 5 == 0) {
            enemyType = Enemy.MEDIUM;
        }
        if (curFloor % 10 == 0) {
            enemyType = Enemy.BOSS;
        }

        int randomNum = (int) (Math.random() * 3);

        Enemy enemy = null;
        switch (enemyType) {
            case Enemy.BOSS:
                if (randomNum == 0) {
                    enemy = new Demon();
                }
                if (randomNum == 1) {
                    enemy = new Dragon();
                }
                if (randomNum == 2) {
                    enemy = new Vampire();
                }
                break;
            case Enemy.MEDIUM:
                if (randomNum == 0) {
                    enemy = new Giant();
                }
                if (randomNum == 1) {
                    enemy = new Golem();
                }
                if (randomNum == 2) {
                    enemy = new Lizardman();
                }
                break;
            case Enemy.SMALL:
                if (randomNum == 0) {
                    enemy = new Goblin();
                }
                if (randomNum == 1) {
                    enemy = new Imp();
                }
                if (randomNum == 2) {
                    enemy = new Treant();
                }
                break;
            default:
                return null;
        }
        if (enemy != null) {
            enemy.setType(enemyType);
            enemy.setLevel(curFloor);
        }
        return enemy;
    }
}


