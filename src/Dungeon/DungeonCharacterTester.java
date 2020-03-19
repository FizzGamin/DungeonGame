package Dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DungeonCharacterTester {

	@Test
	void testIsAlive() {
		Hero hero1 = HeroFactory.createHero(5);
		Monster monster1 = MonsterFactory.createMonster(1);
		assertTrue(hero1.isAlive());
		assertTrue(monster1.isAlive());
		
		hero1.setHitPoints(0);
		monster1.setHitPoints(0);
		assertFalse(hero1.isAlive());
		assertFalse(monster1.isAlive());
	}
	
	@Test
	void testCompareTo() {
		Hero magician1 = HeroFactory.createHero(5);
		Hero magician2 = HeroFactory.createHero(5);
		Monster gremlin = MonsterFactory.createMonster(2);
		assertEquals(-1, magician1.compareTo(gremlin));
		assertEquals(1, gremlin.compareTo(magician1));
		assertEquals(0, magician1.compareTo(magician2));
	}
	@Test
	void testHeroFallInPit() {
		Hero magician = HeroFactory.createHero(5);
		assertEquals(60, magician.getHitPoints());
		magician.heroFallsIntoPit(-20);
		assertEquals(40, magician.getHitPoints());
	}
	@Test
	void testUseAbility() {
		Hero magician = HeroFactory.createHero(5);
		Hero programmer = HeroFactory.createHero(3);
		Monster gremlin = MonsterFactory.createMonster(2);
		
		//Test Magician Ability
		assertEquals(5, gremlin.getAttackSpeed());
		magician.useAbility(gremlin);
		assertEquals(4, gremlin.getAttackSpeed());
		
		//Test Programmer Ability
		assertEquals(70, gremlin.getHitPoints());
		assertEquals(15, programmer.getHitPoints());
		programmer.useAbility(gremlin);
		assertEquals(15, gremlin.getHitPoints());
		assertEquals(70, programmer.getHitPoints());
	}
}
