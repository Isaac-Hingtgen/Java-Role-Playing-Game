package main.java.ser316.rpg.characters;


import main.java.ser316.rpg.characters.enemies.*;

public abstract class CharacterFactory
{
	public abstract Character createHero(int type);
	public abstract Enemy getRandomEnemy(int level);
}





