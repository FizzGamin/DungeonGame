package Dungeon;

import java.util.Random;

public class Pit implements RoomObject{
	private Hero hero = Hero.getGameHero();
	
	public void fallInPit() {
		Random ran = new Random();
		
		int damage = ran.nextInt(20)+1;
		hero.changeHitPoints(-damage);
	}

	@Override
	public String getName() {
		return "Pit";
	}
}
