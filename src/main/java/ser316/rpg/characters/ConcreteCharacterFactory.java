package main.java.ser316.rpg.characters;

import main.java.ser316.rpg.characters.enemies.*;
import main.java.ser316.rpg.characters.heroes.*;

public class ConcreteCharacterFactory extends CharacterFactory {
	@Override
	public Character createHero(int type) {
		switch (type) {
			case Hero.OGRE:
				return new Ogre();

			case Hero.DARK_ELF:
				return new DarkElf();

			case Hero.ELF:
				return new Elf();

			default:
				return null;
		}
	}

	@Override
	public Enemy getRandomEnemy(int level) {   //todo: create more enemies
		int randomNum = (int) Math.random() * 3;
		switch (level) {
			case Enemy.BOSS: {
				if(randomNum == 0)
					return new Goblin();
				if(randomNum == 1)
					return new Goblin();
				if(randomNum == 2)
					return new Goblin();
			}
			case Enemy.MEDIUM: {
				if(randomNum == 0)
					return new Goblin();
				if(randomNum == 1)
					return new Goblin();
				if(randomNum == 2)
					return new Goblin();
			}
			case Enemy.SMALL: {
				if(randomNum == 0)
					return new Goblin();
				if(randomNum == 1)
					return new Goblin();
				if(randomNum == 2)
					return new Goblin();
			}
			default:
				return null;
		}
	}
}


