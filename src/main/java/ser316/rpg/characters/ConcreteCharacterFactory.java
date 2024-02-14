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

			default:
				return null;
		}
	}

	@Override
	public Enemy getRandomEnemy(int level) {   //todo: create more enemies
		int randomNum = (int) (Math.random() * 3);
		switch (level) {
			case Enemy.BOSS: {
				if(randomNum == 0)
					return new Demon();
				if(randomNum == 1)
					return new Dragon();
				if(randomNum == 2)
					return new Vampire();
			}
			case Enemy.MEDIUM: {
				if(randomNum == 0)
					return new Giant();
				if(randomNum == 1)
					return new Golem();
				if(randomNum == 2)
					return new Lizardman();
			}
			case Enemy.SMALL: {
				if(randomNum == 0)
					return new Goblin();
				if(randomNum == 1)
					return new Imp();
				if(randomNum == 2)
					return new Treant();
			}
			default:
				return null;
		}
	}
}


