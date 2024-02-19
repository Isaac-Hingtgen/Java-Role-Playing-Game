package main.java.ser316.rpg.characters;


import main.java.ser316.rpg.characters.enemies.*;
import main.java.ser316.rpg.characters.heroes.Hero;

public abstract class CharacterFactory
{
    public abstract Hero createHero(int type);
    public abstract Enemy getRandomEnemy(int level);
}





